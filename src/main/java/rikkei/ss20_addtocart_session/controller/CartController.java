package rikkei.ss20_addtocart_session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import rikkei.ss20_addtocart_session.dto.request.ShoppingCartRequest;
import rikkei.ss20_addtocart_session.dto.response.UserResponse;
import rikkei.ss20_addtocart_session.service.ShoppingCartServiceHibernate;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Cart")
public class CartController {
    @Autowired
    private ShoppingCartServiceHibernate cartService;

   @Autowired
    HttpSession session;

    @GetMapping()
    public String getAllCart( ModelMap modelMap){
        UserResponse userResponse = (UserResponse) session.getAttribute("user");
        modelMap.addAttribute("cartList",this.cartService.findAllCartByUserId(userResponse.getId()));
        return "cart/listCart";

    }

    @GetMapping("/add/{productId}")
    public String addToCart(@PathVariable("productId") Integer productId){
        UserResponse userResponse = (UserResponse) session.getAttribute("user");
        //neu ton tai productId trong gio hang roi thi thong bao da ton tai.
        if(this.cartService.findAllCartByUserId(userResponse.getId()).stream().anyMatch(cart -> cart.getProductId().equals(productId))){
            return "redirect:/Products";
        }else{

            this.cartService.addToCart(ShoppingCartRequest.builder()
                            .productId(productId).userId(userResponse.getId()).quantity(1)
                    .build());
            return "redirect:/Products";
        }


    }

//    @GetMapping("/plus/{productId}")
//    public String plusProduct(@PathVariable("productId") Integer productId ){
//        //neu ton tai productId trong gio hang roi thi thong bao da ton tai.
//
//        AuthenResponse authenResponse = new AuthenResponse();
//        UserResponse userResponse =(UserResponse) authenResponse.getHttpSession().getAttribute("user");
//        ShoppingCartRequest shoppingCartRequest = new ShoppingCartRequest(productId, userResponse.getId(), 1);
//        this.shoppingCartService.addToCart(shoppingCartRequest);
//        return "products/listProduct";
//    }
//
//    @GetMapping("/minus/{productId}")
//    public String removeProduct(@PathVariable("productId") Integer productId ){
//        AuthenResponse authenResponse = new AuthenResponse();
//        UserResponse userResponse =(UserResponse) authenResponse.getHttpSession().getAttribute("user");
//        ShoppingCartRequest shoppingCartRequest = new ShoppingCartRequest(productId, userResponse.getId(), 1);
//        this.shoppingCartService.removeProduct(shoppingCartRequest);
//        return "products/listProduct";
//    }


}
