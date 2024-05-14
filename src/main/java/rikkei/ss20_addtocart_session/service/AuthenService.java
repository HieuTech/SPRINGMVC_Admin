package rikkei.ss20_addtocart_session.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.ss20_addtocart_session.dao.AuthenDao;
import rikkei.ss20_addtocart_session.dto.request.AuthenRequest;
import rikkei.ss20_addtocart_session.dto.response.AuthenResponse;
import rikkei.ss20_addtocart_session.dto.response.UserResponse;
import rikkei.ss20_addtocart_session.models.Users;

import javax.servlet.http.HttpSession;

@Service
public class AuthenService {
    @Autowired
    private AuthenDao authenDao;

@Autowired
HttpSession session;

    public boolean register(AuthenRequest request) {

        return authenDao.register(request);
    }

    public AuthenResponse login(AuthenRequest request) {
        session.setAttribute("user",authenDao.login(request));
        return new AuthenResponse(session,true);
    }


}
