package rikkei.ss20_addtocart_session.dao;


import rikkei.ss20_addtocart_session.dto.request.ProductRequest;
import rikkei.ss20_addtocart_session.dto.response.ProductResponse;
import rikkei.ss20_addtocart_session.entity.Products;

import java.util.List;

public interface IProductDAO {
    List<Products> getAllProduct();
    Products getProductById(Integer productId);
    boolean insertProduct(Products products);
    boolean updateProduct(Products products);
    boolean deleteProduct(Integer productId);
    List<Products> findProductByName(String productName);



}
