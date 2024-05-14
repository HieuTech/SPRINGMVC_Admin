package rikkei.ss20_addtocart_session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rikkei.ss20_addtocart_session.service.ShoppingCartService;

@Controller
@RequestMapping("/Cart")
public class CartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

//    @GetMapping()
//    public String getAllCart(ModelMap modelMap){
//        modelMap.addAttribute()
//
//    }
}
