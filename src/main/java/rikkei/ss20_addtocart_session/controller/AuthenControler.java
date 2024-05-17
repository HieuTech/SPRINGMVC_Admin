package rikkei.ss20_addtocart_session.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rikkei.ss20_addtocart_session.dto.request.AuthenRequest;
import rikkei.ss20_addtocart_session.dto.response.UserResponse;
import rikkei.ss20_addtocart_session.service.AuthenServiceHibernate;
import rikkei.ss20_addtocart_session.service.ProductServiceHibernate;
import rikkei.ss20_addtocart_session.service.UserServiceHibernate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/authen")

public class AuthenControler {
    @Autowired
    private AuthenServiceHibernate authenService;

    @Autowired
    private ProductServiceHibernate productService;
    @Autowired
    private HttpSession session;

    @GetMapping("/logout")
    public String logout() {
        this.authenService.logout();
        return "redirect:/authen/login";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("AuthenRequest") @Valid AuthenRequest request,
                               BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "authen/register";
        } else if (!authenService.register(request)) {
            model.addAttribute("registrationError", "Email Is Exist.");
            return "authen/register";
        } else {
            return "redirect:/authen/login";

        }


    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("AuthenRequest", new AuthenRequest());
        return "authen/register";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute() AuthenRequest request, Model model) {

        if (this.authenService.login(request).isStatusAuthen()) {
            model.addAttribute("productList", this.productService.findAll());
            return "redirect:/Products";
        } else {
            return "redirect:/authen/login";
        }
    }

    @GetMapping("/login")
    public String toLoginPage(Model model) {

        model.addAttribute("AuthenRequest", new AuthenRequest());
        return "authen/login";
    }
}
