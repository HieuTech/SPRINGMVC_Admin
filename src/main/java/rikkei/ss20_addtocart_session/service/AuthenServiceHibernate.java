package rikkei.ss20_addtocart_session.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.ss20_addtocart_session.dao.impl.AuthenDaoHibernate;
import rikkei.ss20_addtocart_session.dao.impl.UserDaoHibernate;
import rikkei.ss20_addtocart_session.dto.request.AuthenRequest;
import rikkei.ss20_addtocart_session.dto.response.AuthenResponse;

import javax.servlet.http.HttpSession;

@Service
public class AuthenServiceHibernate {
    @Autowired
    private AuthenDaoHibernate authenDaoHibernate;
    @Autowired
    private UserDaoHibernate userDaoHibernate;

    @Autowired
    HttpSession session;

    public boolean register(AuthenRequest request) {
        if (userDaoHibernate.findByEmail(request.getEmail()) != null) {
            return false;
        } else {
            return authenDaoHibernate.register(request);
        }
    }

    public AuthenResponse login(AuthenRequest request) {

        session.setAttribute("user", authenDaoHibernate.login(request));

        return new AuthenResponse(session, true);
    }

    public void logout() {

        session.removeAttribute("user");
    }


}
