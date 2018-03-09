package toomuchdrinking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import toomuchdrinking.bean.*;
import toomuchdrinking.model.Drink;
import toomuchdrinking.model.DrinkType;
import toomuchdrinking.repository.DrinkRepository;
import toomuchdrinking.repository.DrinkTypeRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class ConsumedBeerController {
	private static final Calendar CALENDAR = Calendar.getInstance();

	@Autowired
	private DrinkTypeRepository drinkTypeRepository;
	
	@Autowired
	private DrinkRepository drinkRepository;

    @PostMapping("/add")
    public BeersResponse add(
            final @RequestParam("drinkName") String drinkName,
            final @RequestParam("type") int type,
            final @RequestParam("qty") int qty,
            final @RequestParam("ml") int ml,
            final @RequestParam("abv") double abv
    ) {
        final BeersResponse resp = new BeersResponse();
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
    public @ResponseBody BeersResponse beers() {

        System.out.println(System.getenv("JDBC_DATABASE_URL"));
        System.out.println(System.getenv("JDBC_DATABASE_USERNAME"));
        System.out.println(System.getenv("JDBC_DATABASE_PASSWORD"));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(System.getenv("SPRING_JDBC_DATABASE_URL"));
        System.out.println(System.getenv("SPRING_JDBC_DATABASE_USERNAME"));
        System.out.println(System.getenv("SPRING_JDBC_DATABASE_PASSWORD"));

        final BeersResponse resp = new BeersResponse();
        final List<Drink> drinks = new ArrayList<>();
        resp.setOk(true);
        
		drinkRepository.findAll().forEach(dt -> drinks.add(dt));
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

}
