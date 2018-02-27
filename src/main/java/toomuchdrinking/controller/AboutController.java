package toomuchdrinking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class AboutController {

    @RequestMapping("/about")
    public String welcome(final Map<String, Object> model) {
        return "about";
    }

}
