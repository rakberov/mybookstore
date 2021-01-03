package mybookstore.mybookstore.controller;

import lombok.RequiredArgsConstructor;
import mybookstore.mybookstore.model.Book;
import mybookstore.mybookstore.model.User;
import mybookstore.mybookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
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

    @GetMapping(value = {"/bookUpdate"})
    public String bookUpdate(Model model) {
        model.addAttribute("book", new Book());
        return "bookUpdate";
    }
}
