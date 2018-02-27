package toomuchdrinking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import toomuchdrinking.bean.Response;
import toomuchdrinking.repository.ConsumedBeersRepository;

import java.sql.SQLException;
import java.util.Date;

@RestController
public class ConsumedBeerController {

    @Autowired
    private ConsumedBeersRepository repository;

    @PostMapping("/add")
    public Response add(final @RequestParam("beer") String need) {
        final Response resp = new Response();
        resp.setOk(true);

        try {
            repository.save(new Date().toString(), need);
        } catch (final SQLException ex) {
            resp.setOk(false);
        }

        return resp;
    }

    @GetMapping("/beers")
    public @ResponseBody Response beers() {
        final Response resp = new Response();
        resp.setOk(true);
        try {
            resp.setNeeds(repository.findAll());
        } catch (final SQLException ex) {
            resp.setOk(false);
        }

        return resp;
    }

}
