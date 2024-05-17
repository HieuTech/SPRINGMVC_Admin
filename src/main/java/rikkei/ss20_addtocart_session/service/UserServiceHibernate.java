package rikkei.ss20_addtocart_session.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.ss20_addtocart_session.dao.impl.UserDaoHibernate;
import rikkei.ss20_addtocart_session.dto.request.UserRequest;
import rikkei.ss20_addtocart_session.dto.response.UserResponse;
import rikkei.ss20_addtocart_session.entity.Users;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceHibernate {
    @Autowired
    private UserDaoHibernate userDaoHibernate;

    public List<UserResponse> findAllUser(){
        List<UserResponse> list = new ArrayList<>();
        for (Users users : userDaoHibernate.findAllUser()){
            list.add(UserResponse.builder()
                    .id(users.getId())
                    .email(users.getEmail())
                    .dob(users.getDob())
                    .status(users.getStatus())
                    .userName(users.getUserName())
                    .avatar(users.getAvatar())
                    .phone(users.getPhone())
                    .address(users.getAddress())
                    .build());
        }
        return list;
    }

    public UserResponse findById(Integer userId){
        Users users = userDaoHibernate.findById(userId);
        if(users != null){
            return UserResponse.builder()
                    .id(users.getId())
                    .email(users.getEmail())
                    .dob(users.getDob())
                    .status(users.getStatus())
                    .userName(users.getUserName())
                    .avatar(users.getAvatar())
                    .phone(users.getPhone())
                    .address(users.getAddress())
                    .build();
        }else {
            return null;
        }

    }

    public UserResponse findUserByEmail(String email){
        Users users = this.userDaoHibernate.findByEmail(email);
        if(users != null){
            return UserResponse.builder()
                    .id(users.getId())
                    .email(users.getEmail())
                    .dob(users.getDob())
                    .status(users.getStatus())
                    .userName(users.getUserName())
                    .avatar(users.getAvatar())
                    .phone(users.getPhone())
                    .address(users.getAddress())
                    .build();
        }else{
            return null;
        }
    }

    public boolean updateUser(UserRequest request){
        this.userDaoHibernate.updateUser(request);
        return true;
    }



    public boolean deleteUserById(UserRequest request){
        this.userDaoHibernate.deleteUser(request);
         return true;
    }

}
