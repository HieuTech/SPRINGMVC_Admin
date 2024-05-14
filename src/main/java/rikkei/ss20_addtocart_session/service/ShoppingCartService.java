package rikkei.ss20_addtocart_session.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.ss20_addtocart_session.dao.ProductDao;
import rikkei.ss20_addtocart_session.dao.ShoppingCartDao;
import rikkei.ss20_addtocart_session.dto.request.ShoppingCartRequest;
import rikkei.ss20_addtocart_session.dto.response.ShoppingCartResponse;
import rikkei.ss20_addtocart_session.models.Products;
import rikkei.ss20_addtocart_session.models.ShoppingCart;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Autowired
    private ProductDao productDao;

    public void saveCart(ShoppingCartRequest request){
        ShoppingCart shoppingCart = new ShoppingCart(request.getId(), request.getUserId(), request.getProductId(), request.getQuantity());
        shoppingCartDao.saveProduct(shoppingCart);
    }

    public List<ShoppingCartResponse> findAllCart(){
        return shoppingCartDao.findAllShoppingCart();
    }

    public  List<ShoppingCartResponse> findByUserId(Integer userId){
        return shoppingCartDao.findByUserId(userId);
    }

    public void clearCart(Integer userId){
        shoppingCartDao.deleteByUserId(userId);
    }



}
