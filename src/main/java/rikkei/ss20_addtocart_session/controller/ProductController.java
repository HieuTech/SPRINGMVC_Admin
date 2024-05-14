package rikkei.ss20_addtocart_session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rikkei.ss20_addtocart_session.dto.response.AuthenResponse;
import rikkei.ss20_addtocart_session.service.ProductService;

@Controller
@RequestMapping("/Products")
public class ProductController {
    @Autowired
    private ProductService productService;



    @GetMapping()
    public String listProduct(ModelMap modelMap) {

        modelMap.addAttribute("productList",productService.findAllProduct());
        return "products/listProduct";
    }

    @GetMapping("/add")
    public String formAddProduct(){
        return "products/addProduct";
    }
    @GetMapping("/edit/{id}")
    public String formUpdateProduct(){
        return "products/editProduct";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(){
        return "redirect:/Products";
    }
}
