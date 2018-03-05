package toomuchdrinking.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class StatsController {

    @RequestMapping("/stats")
    public String welcome() {
        return "stats";
    }

}
