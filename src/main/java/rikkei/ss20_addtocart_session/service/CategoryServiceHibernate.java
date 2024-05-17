package rikkei.ss20_addtocart_session.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.ss20_addtocart_session.dao.impl.CategoryDaoHibernate;
import rikkei.ss20_addtocart_session.dto.response.CategoryResponse;
import rikkei.ss20_addtocart_session.entity.Category;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceHibernate {
    @Autowired
    private CategoryDaoHibernate categoryDaoHibernate;

    public List<Category> findAll(){
        return categoryDaoHibernate.getAllCategory();
    }

    public Category findById(Integer cateId){
        return categoryDaoHibernate.findById(cateId);
    }
}
