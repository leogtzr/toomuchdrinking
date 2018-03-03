package toomuchdrinking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import toomuchdrinking.bean.BeersResponse;
import toomuchdrinking.repository.ConsumedBeersRepository;

import java.sql.SQLException;

@RestController
public class ConsumedBeerController {

    @Autowired
    private ConsumedBeersRepository repository;

    @PostMapping("/add")
    public BeersResponse add(
            final @RequestParam("drinkName") String drinkName,
            final @RequestParam("type") String type,
            final @RequestParam("qty") int qty,
            final @RequestParam("ml") int ml,
            final @RequestParam("abv") double abv
    ) {
        final BeersResponse resp = new BeersResponse();
        resp.setOk(true);

        System.out.println(String.format("Receiving: %s, %s, %d, %d and %f", drinkName, type, qty, ml, abv));

        try {
            // void save(String type, int qty, int milliliters, double abv, String description) throws SQLException;
            repository.save(type, qty, ml, abv, drinkName);
        } catch (final SQLException ex) {
            resp.setOk(false);
        }

        return resp;
    }


    @GetMapping("/drinks")
    public @ResponseBody BeersResponse beers() {
        final BeersResponse resp = new BeersResponse();
        resp.setOk(true);
        try {
            resp.setDrinks(repository.findAll());
        } catch (final SQLException ex) {
            resp.setOk(false);
        }

        return resp;
    }

}
