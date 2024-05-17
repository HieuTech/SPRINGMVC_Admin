package rikkei.ss20_addtocart_session.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.ss20_addtocart_session.dao.impl.ProductDaoHibernate;
import rikkei.ss20_addtocart_session.dao.impl.ShoppingCartDaoHibernate;
import rikkei.ss20_addtocart_session.dto.request.ShoppingCartRequest;
import rikkei.ss20_addtocart_session.dto.response.ShoppingCartResponse;
import rikkei.ss20_addtocart_session.entity.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceHibernate {
    @Autowired
    private ShoppingCartDaoHibernate shoppingCartDaoHibernate;
    @Autowired
    private ProductDaoHibernate productDaoHibernate;

    public List<ShoppingCartResponse> findAllCartByUserId(Integer userId){
        List<ShoppingCartResponse> list = new ArrayList<>();

        for (ShoppingCart cart: shoppingCartDaoHibernate.showAllCartByUserId(userId)){
            list.add(ShoppingCartResponse.builder()
                    .productId(cart.getId())
                    .productName(cart.getProducts().getName())
                    .productPrice(cart.getProducts().getPrice())
                    .quantity(cart.getQuantity())
                    .build());
        }
        return list;
    }

    public boolean updateCart(ShoppingCartRequest request){
        return shoppingCartDaoHibernate.updateCart(request);
    }

    public boolean addToCart(ShoppingCartRequest req){
        return shoppingCartDaoHibernate.addToCart(req);
    }
}
