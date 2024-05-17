package rikkei.ss20_addtocart_session.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rikkei.ss20_addtocart_session.dao.IShoppingCartDAO;
import rikkei.ss20_addtocart_session.dto.request.ShoppingCartRequest;
import rikkei.ss20_addtocart_session.entity.ShoppingCart;

import java.util.List;

@Repository
public class ShoppingCartDaoHibernate implements IShoppingCartDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserDaoHibernate userDaoHibernate;
    @Autowired
    private ProductDaoHibernate productDaoHibernate;

    @Override
    public List<ShoppingCart> showAllCartByUserId(Integer userId) {
        Session session = sessionFactory.openSession();
        try{
            String hql = "SELECT s from ShoppingCart s where s.user.id = :userId";
            List<ShoppingCart> shoppingCarts =(List<ShoppingCart>) session.createQuery(hql).setParameter("userId",userId);
            return shoppingCarts;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean updateCart(ShoppingCartRequest req) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();

            session.save(ShoppingCart.builder().
                    id(req.getId()).user(userDaoHibernate.findById(req.getId())).products(productDaoHibernate.getProductById(req.getProductId()))
                            .quantity(req.getQuantity()).
                    build());
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean addToCart(ShoppingCartRequest req) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();


            session.save(ShoppingCart.builder()
                    .user(userDaoHibernate.findById(req.getId()))
                    .products(productDaoHibernate.getProductById(req.getProductId()))
                    .quantity(req.getQuantity())

                    .build());

            session.getTransaction().commit();
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return true;
    }


}
