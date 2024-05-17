package rikkei.ss20_addtocart_session.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rikkei.ss20_addtocart_session.dao.IAuthenDao;
import rikkei.ss20_addtocart_session.dto.request.AuthenRequest;
import rikkei.ss20_addtocart_session.dto.response.AuthenResponse;
import rikkei.ss20_addtocart_session.dto.response.UserResponse;
import rikkei.ss20_addtocart_session.entity.Users;

import java.util.Date;
import java.util.List;

@Repository
public class AuthenDaoHibernate implements IAuthenDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    UserDaoHibernate userDaoHibernate;

    public boolean register(AuthenRequest request) {


        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String password = BCrypt.withDefaults().hashToString(10, request.getPassword().toCharArray());
            session.save(Users.builder().
                    email(request.getEmail())
                    .password(password).
                            dob(new Date()).
                            avatar("https://cdn.iconscout.com/icon/free/png-512/free-avatar-370-456322.png?f=webp&w=256").
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
    public UserResponse login(AuthenRequest request) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Users users = userDaoHibernate.findByEmail(request.getEmail());
            if (users != null) {
                BCrypt.Result result = BCrypt.verifyer().verify(request.getPassword().toCharArray(), users.getPassword());
                System.out.println("result" + result);
                if (result.verified) {
                    return UserResponse.builder()
                            .email(users.getEmail())
                            .dob(users.getDob())
                            .avatar(users.getAvatar())
                            .build();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void logout() {

    }
}
