package rikkei.ss20_addtocart_session.dao;

import rikkei.ss20_addtocart_session.dto.request.AuthenRequest;
import rikkei.ss20_addtocart_session.dto.response.AuthenResponse;
import rikkei.ss20_addtocart_session.dto.response.UserResponse;


public interface IAuthenDao {

    public boolean register(AuthenRequest request);
    public UserResponse login(AuthenRequest request);
    public void logout();
}
