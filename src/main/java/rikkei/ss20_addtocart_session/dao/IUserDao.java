package rikkei.ss20_addtocart_session.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rikkei.ss20_addtocart_session.dto.request.UserRequest;
import rikkei.ss20_addtocart_session.entity.Users;

import java.util.List;

@Repository
public interface IUserDao {

    List<Users> findAllUser();

    Users findById(Integer id);

    boolean insertUser(UserRequest request);

    boolean updateUser(UserRequest request);

    boolean deleteUser(UserRequest request);

    List<Users> findByUserName(String name);

    Users findByEmail(String email);
}
