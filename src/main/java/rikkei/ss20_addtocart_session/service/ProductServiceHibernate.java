package rikkei.ss20_addtocart_session.service;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import rikkei.ss20_addtocart_session.dao.impl.CategoryDaoHibernate;
import rikkei.ss20_addtocart_session.dao.impl.ProductDaoHibernate;
import rikkei.ss20_addtocart_session.dto.request.ProductRequest;
import rikkei.ss20_addtocart_session.dto.response.ProductResponse;
import rikkei.ss20_addtocart_session.entity.Products;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceHibernate {
    ProductDaoHibernate productDaoHibernate;

    CategoryDaoHibernate categoryDaoHibernate;
    public List<ProductResponse> findAll() {
        List<ProductResponse> productResponseList = new ArrayList<>();
        for (Products p : productDaoHibernate.getAllProduct()) {
            productResponseList.add(ProductResponse.builder()
                    .id(p.getId())
                    .name(p.getName())
                    .stock(p.getStock())
                    .image(p.getImage())
                    .status(p.getStatus())
                    .category(p.getCategory())
                    .price(p.getPrice())
                    .build());
        }
        return productResponseList;
    }

    public Products findById(Integer productId) {

        return this.productDaoHibernate.getProductById(productId);

    }

    public boolean insertProduct(ProductRequest request, String fileName, Integer categoryId) {
        return this.productDaoHibernate.insertProduct(Products.builder().
                image(fileName).name(request.getName()).category(categoryDaoHibernate.findById(categoryId)).price(request.getPrice())
                        .status(true).stock(request.getStock()).
                build());
    }

    public boolean updateProduct(ProductRequest req, Integer categoryId, String fileName) {

        return this.productDaoHibernate.updateProduct(Products.builder().
                        id(req.getId()).
                image(fileName).price(req.getPrice())
                .name(req.getName())
                .status(req.getStatus()).stock(req.getStock()).category(categoryDaoHibernate.findById(categoryId)).
                build());
    }

    public boolean deleteProduct(Integer productId) {
        return this.productDaoHibernate.deleteProduct(productId);
    }

    public List<ProductResponse> findProductByName(String productName) {
        List<ProductResponse> productResponseList = new ArrayList<>();
        for (Products p : productDaoHibernate.findProductByName(productName)) {
            productResponseList.add(ProductResponse.builder()
                    .id(p.getId())
                    .name(p.getName())
                    .stock(p.getStock())
                    .image(p.getImage())
                    .status(p.getStatus())
                    .category(p.getCategory())
                    .price(p.getPrice())
                    .build());
        }
        return productResponseList;
    }
}
