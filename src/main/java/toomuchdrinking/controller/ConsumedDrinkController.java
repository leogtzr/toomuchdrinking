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

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class ConsumedDrinkController {

    private static final Calendar CALENDAR = Calendar.getInstance();
    private static final DateFormat DRINK_DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

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
            resp.setOk(false);
        } else {
            final Drink drink =
                    new Drink(abv, new java.sql.Date(CALENDAR.getTime().getTime()), drinkName, qty, ml, drinkType);
            resp.setDrinks(Arrays.asList(drink));
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

    @GetMapping("/drinkByDate")
    public @ResponseBody DrinkResponse getDrinkByDate(final @RequestParam("drinkDate") String drinkDate) {

        final DrinkResponse response = new DrinkResponse();
        response.setOk(false);

        try {
            final java.util.Date parsed = DRINK_DATE_FORMATTER.parse(drinkDate);
            final java.sql.Date date = new java.sql.Date(parsed.getTime());
            final List<Drink> drinks = drinkRepository.findByDrinkDate(date);
            response.setDrinks(drinks);
            response.setOk(true);
        } catch (final ParseException ex) {
            response.setOk(false);
        }
        return response;
    }

}
