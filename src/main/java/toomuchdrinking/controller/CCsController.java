package toomuchdrinking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CCsController {

    @GetMapping(value = {"/cc", "/ccs"})
    public String ccInfo() {
        return "cc";
    }

}
