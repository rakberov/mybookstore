package mybookstore.mybookstore.controller;

import lombok.RequiredArgsConstructor;
import mybookstore.mybookstore.model.User;
import mybookstore.mybookstore.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @PostMapping(value = "/register")
    public String register(@ModelAttribute User user){
        loginService.register(user);
        return "temp";
    }


}
