package toomuchdrinking.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class AboutController {

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

}
