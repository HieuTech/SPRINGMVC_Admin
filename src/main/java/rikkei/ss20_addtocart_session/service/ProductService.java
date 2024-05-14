package rikkei.ss20_addtocart_session.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.ss20_addtocart_session.dao.ProductDao;
import rikkei.ss20_addtocart_session.dto.request.ProductRequest;
import rikkei.ss20_addtocart_session.dto.response.ProductResponse;
import rikkei.ss20_addtocart_session.models.Products;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public void saveProduct(ProductRequest request){

        Products products = new Products(request.getId(), request.getCategoryId(), request.getName(), request.getPrice(), request.getStock(), request.getStatus(), request.getImage());

        productDao.saveProduct(products);
    }
    public List<ProductResponse> findAllProduct(){
        return productDao.findAllProduct();
    }
    public ProductResponse findById(Integer id){
        return productDao.findById(id);
    }

    public void deleteById(Integer id){
        productDao.deleteById(id);
    }
}
