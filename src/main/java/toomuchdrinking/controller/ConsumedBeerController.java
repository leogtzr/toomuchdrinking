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

    /*
    @PostMapping("/add")
    public BeersResponse add(final @RequestParam("beer") String need) {
        final BeersResponse resp = new BeersResponse();
        resp.setOk(true);

        try {
            repository.save(new Date().toString(), need);
        } catch (final SQLException ex) {
            resp.setOk(false);
        }

        return resp;
    }
    */

    @GetMapping("/beers")
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
