package Reload.tutorial.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {

    @GetMapping("/login")
    public String getLogin() {
        return "/login";
    }
}
