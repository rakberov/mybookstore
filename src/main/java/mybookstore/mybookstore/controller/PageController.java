package mybookstore.mybookstore.controller;

import mybookstore.mybookstore.model.Book;
import mybookstore.mybookstore.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PageController {

    @GetMapping(value = {"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping(value = {"/registerForm"})
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "userRegister";
    }

    @GetMapping(value = {"/loginForm"})
    public String login() {
        return "userLogin";
    }

    @GetMapping(value = {"/bookCreate"})
    public String bookCreate(Model model) {
        model.addAttribute("book", new Book());
        return "bookCreate";
    }
}
