package toomuchdrinking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import toomuchdrinking.model.DrinkType;
import toomuchdrinking.repository.DrinkTypeRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	
	@Autowired
	private DrinkTypeRepository drinkTypeRepository;

    @GetMapping("/")
    String index(final Model model) throws SQLException {
    	final List<DrinkType> drinkTypes = new ArrayList<>();
    	drinkTypeRepository.findAll().forEach(dt -> drinkTypes.add(dt));
    	
        model.addAttribute("drinkTypes", drinkTypes);
        return "index";
    }

}
