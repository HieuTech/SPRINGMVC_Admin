package rikkei.ss20_addtocart_session.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rikkei.ss20_addtocart_session.dao.ICategoryDao;
import rikkei.ss20_addtocart_session.dto.response.CategoryResponse;
import rikkei.ss20_addtocart_session.entity.Category;

import java.util.List;

@Repository
public class CategoryDaoHibernate implements ICategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getAllCategory() {
        Session session = sessionFactory.openSession();

        try {
            List<Category> list = session.createQuery("from Category").list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Category findById(Integer categoryId) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Category.class, categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
