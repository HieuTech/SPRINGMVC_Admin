package rikkei.ss20_addtocart_session.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rikkei.ss20_addtocart_session.dao.IUserDao;
import rikkei.ss20_addtocart_session.dto.request.UserRequest;
import rikkei.ss20_addtocart_session.entity.Users;

import java.util.List;

@Repository
public class UserDaoHibernate implements IUserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Users> findAllUser() {
        Session session = sessionFactory.openSession();
        try {

            List<Users> list = session.createQuery("from Users ").list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Users findById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Users.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean insertUser(UserRequest request) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hashPw = BCrypt.withDefaults().hashToString(10, request.getPassword().toCharArray());

            session.save(Users.builder()
                    .phone(request.getPhone())
                    .address(request.getAddress())
                    .avatar(request.getAvatar())
                    .userName(request.getUserName())

                    .email(request.getEmail())
                    .password(hashPw)
                    .build());
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateUser(UserRequest request) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hashPw = BCrypt.withDefaults().hashToString(10, request.getPassword().toCharArray());
            session.update(Users.builder().
                    id(request.getId()).phone(request.getPhone()).avatar(request.getAvatar())
                            .userName(request.getUserName())
                    .address(request.getAddress()).email(request.getEmail())
                    .password(hashPw).
                    status(true).
                    build());
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return false;
    }

    @Override
    public boolean deleteUser(UserRequest request) {
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();
            String hashPw = BCrypt.withDefaults().hashToString(10, request.getPassword().toCharArray());
            session.update(Users.builder().
                    id(request.getId()).phone(request.getPhone()).avatar(request.getAvatar())
                    .userName(request.getUserName())
                    .address(request.getAddress()).email(request.getEmail())
                    .password(hashPw).
                            status(false).
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
    public List<Users> findByUserName(String userName) {
            Session session = sessionFactory.openSession();
            try{
                    String hql = "SELECT u from Users u where u.userName like :userName";
                List<Users> list =(List<Users>) session.createQuery(hql).setParameter("userName",userName);
                return list;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                session.close();
            }

        return null;
    }

    @Override
    public Users findByEmail(String email){
        Session session = sessionFactory.openSession();
        try{
            String hql = "SELECT u from Users u where u.email like :email";
            return (Users) session.createQuery(hql).setParameter("email",email).uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return null;
    }

}
