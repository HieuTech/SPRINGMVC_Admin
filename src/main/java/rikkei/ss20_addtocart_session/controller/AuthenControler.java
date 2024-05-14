package rikkei.ss20_addtocart_session.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rikkei.ss20_addtocart_session.dto.request.AuthenRequest;
import rikkei.ss20_addtocart_session.dto.response.UserResponse;
import rikkei.ss20_addtocart_session.models.Users;
import rikkei.ss20_addtocart_session.service.AuthenService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/authen")

public class AuthenControler {
    @Autowired
    private AuthenService authenService;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute() AuthenRequest request) {

        if (authenService.register(request)) {
            return "redirect:/authen/login";
        } else {
            return "redirect:/NotFound";
        }
    }

    @GetMapping("/register")
    public String register() {
        return "authen/register";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute() AuthenRequest request) {

        if (this.authenService.login(request).isStatusAuthen()) {


            return "redirect:/Products";
        } else {
            return "redirect:/authen/login";
        }
    }

    @GetMapping("/login")
    public String toLoginPage() {
        return "authen/login";
    }
}
