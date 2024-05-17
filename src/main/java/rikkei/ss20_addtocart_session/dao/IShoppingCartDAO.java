package rikkei.ss20_addtocart_session.dao;

import rikkei.ss20_addtocart_session.dto.request.ShoppingCartRequest;
import rikkei.ss20_addtocart_session.entity.ShoppingCart;

import java.util.List;

public interface IShoppingCartDAO {

    List<ShoppingCart> showAllCartByUserId(Integer userId);
    boolean updateCart(ShoppingCartRequest req);

    boolean addToCart(ShoppingCartRequest req);



}
