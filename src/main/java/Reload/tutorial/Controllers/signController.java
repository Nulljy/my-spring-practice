package Reload.tutorial.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class signController {

    @GetMapping("/sign")
    public String GetSign() {
        return "/sign";
    }
}
