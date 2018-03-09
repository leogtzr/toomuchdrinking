package toomuchdrinking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import toomuchdrinking.model.Drink;
import toomuchdrinking.model.DrinkType;
import toomuchdrinking.repository.DrinkRepository;
import toomuchdrinking.repository.DrinkTypeRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private DrinkTypeRepository drinkTypeRepository;

    @Autowired
    private DrinkRepository drinkRepository;

    @GetMapping("/")
    String index(final Model model) throws SQLException {
        final List<DrinkType> drinkTypes = new ArrayList<>();
        drinkTypeRepository.findAll().forEach(drinkTypes::add);
        model.addAttribute("drinkTypes", drinkTypes);

        final List<Drink> latestDrinks = drinkRepository.latestDrinks();
        model.addAttribute("latestDrinks", latestDrinks);

        return "index";
    }

}
