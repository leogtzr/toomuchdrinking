package toomuchdrinking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import toomuchdrinking.repository.ConsumedBeersRepository;

import java.sql.SQLException;

@Controller
public class HomeController {

    @Autowired
    private ConsumedBeersRepository repository;

    @GetMapping("/")
    String index(final Model model) throws SQLException {
        model.addAttribute("types", repository.drinkTypes());
        return "index";
    }

}
