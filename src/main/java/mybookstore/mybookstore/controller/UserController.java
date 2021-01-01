package mybookstore.mybookstore.controller;

import lombok.RequiredArgsConstructor;
import mybookstore.mybookstore.model.User;
import mybookstore.mybookstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserService loginService;

    @PostMapping(value = "/register")
    public String register(@ModelAttribute @Valid User user){
        loginService.register(user);
        return "home";
    }

    @PostMapping(value = "/login")
    public String login(@NotNull @RequestParam("email") String email,
                        @NotNull @RequestParam("password") String password){
        System.out.println(email + " " + password);
        loginService.login(email, password);
        return "home";
    }


}
