package rikkei.ss20_addtocart_session.dao;


import rikkei.ss20_addtocart_session.entity.Category;

import java.util.List;

public interface ICategoryDao {


    List<Category> getAllCategory();
    Category findById(Integer categoryId);
}
