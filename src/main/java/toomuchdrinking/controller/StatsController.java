package toomuchdrinking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toomuchdrinking.service.DrinkStatsService;

@Controller
public class StatsController {

    @Autowired
    private DrinkStatsService service;

    @RequestMapping("/stats")
    public String stats(final Model model) {
        model.addAttribute("max", service.maximums());
        return "stats";
    }

}
