package epam.intoductoinjava.library.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {


    @GetMapping("/")
    public String home ( Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @PostMapping
    public String start (Model model) {
        return "redirect:/book";
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "login";
    }

}
