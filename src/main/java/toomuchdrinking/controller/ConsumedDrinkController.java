package toomuchdrinking.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import toomuchdrinking.bean.*;
import toomuchdrinking.model.Drink;
import toomuchdrinking.model.DrinkType;
import toomuchdrinking.repository.DrinkRepository;
import toomuchdrinking.repository.DrinkTypeRepository;
import toomuchdrinking.service.DrinkStatsService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ConsumedDrinkController {

    private static final Calendar CALENDAR = Calendar.getInstance();

    @Autowired
    private DrinkTypeRepository drinkTypeRepository;

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private DrinkStatsService drinkStatsService;

    @ApiOperation(
            value = "Adds a drink",
            notes = "Adds a drink",
            response = DrinkResponse.class,
            responseContainer = "DrinkResponse",
            produces = "application/json"
    )
    @PostMapping("/add")
    public DrinkResponse add(
            final @RequestParam("drinkName") String drinkName,
            final @RequestParam("type") int type,
            final @RequestParam("qty") int qty,
            final @RequestParam("ml") int ml,
            final @RequestParam("abv") double abv
    ) {
        final DrinkResponse resp = new DrinkResponse();
        resp.setOk(true);

        final DrinkType drinkType = drinkTypeRepository.findOne((long)type);
        if (drinkType == null) {
            //drinkType does not exist
            resp.setOk(false);
        } else {
            final Drink drink = new Drink(abv, new Date(CALENDAR.getTime().getTime()), drinkName, qty, ml, drinkType);
            drinkRepository.save(drink);
        }

        return resp;
    }


    @GetMapping("/drinks")
    public @ResponseBody DrinkResponse beers() {

        final DrinkResponse resp = new DrinkResponse();
        final List<Drink> drinks = new ArrayList<>();
        resp.setOk(true);

        drinkRepository.findAll().forEach(drinks::add);
        resp.setDrinks(drinks);

        return resp;
    }

    @GetMapping("/mlsperday")
    public @ResponseBody MillilitersPerDayResponse mlsPerDay() {
        final MillilitersPerDayResponse resp = new MillilitersPerDayResponse();
        resp.setOk(true);
        resp.setMls(drinkRepository.getMillilitersPerDay());

        return resp;
    }

    @GetMapping("/maximums")
    public @ResponseBody Map<DailyMaxKey, List<DailyMaximumDrinks>> maximums() {
        return drinkStatsService.maximums();
    }

    @GetMapping("/drinktypes")
    public @ResponseBody List<String> drinkTypes() throws SQLException {
        return drinkTypeRepository.types();
    }

}
