package rikkei.ss20_addtocart_session.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rikkei.ss20_addtocart_session.dao.IProductDAO;
import rikkei.ss20_addtocart_session.dto.request.ProductRequest;
import rikkei.ss20_addtocart_session.entity.Products;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDaoHibernate implements IProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CategoryDaoHibernate categoryDao;

    @Override
    public List<Products> getAllProduct() {
        Session session = sessionFactory.openSession();

        try{
            List<Products> list = session.createQuery("from Products").list();
            return list;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Products getProductById(Integer productId) {
        Session session = sessionFactory.openSession();

        try{
            return session.get(Products.class, productId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean insertProduct(Products product) {
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){

            e.printStackTrace();
            //neu that bai phai khoi phuc lai du lieu
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Products req) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(req);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Integer productId) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(this.getProductById(productId));
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Products> findProductByName(String productName) {
        Session session = sessionFactory.openSession();
        try {


            if(productName == null || productName.isEmpty()){
                productName = "%";
            }else{

                productName = "%" + productName + "%";
                List<Products> productsList = session.createQuery("from Products where name like : proName")
                        .setParameter("proName",productName)
                        .list();
                return productsList;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
