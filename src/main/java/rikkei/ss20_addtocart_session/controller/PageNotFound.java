package rikkei.ss20_addtocart_session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/NotFound")
public class PageNotFound {
    @GetMapping()
    public String notFound(){
        return "404-NotFound";
    }
}
