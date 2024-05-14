package rikkei.ss20_addtocart_session.dto.response;

import javax.servlet.http.HttpSession;

public class AuthenResponse {

    private HttpSession httpSession;
    private boolean statusAuthen;

    public AuthenResponse() {
    }

    public AuthenResponse(HttpSession httpSession, boolean statusAuthen) {
        this.httpSession = httpSession;
        this.statusAuthen = statusAuthen;
    }

    public HttpSession getHttpSession() {
        return httpSession;
    }

    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public boolean isStatusAuthen() {
        return statusAuthen;
    }

    public void setStatusAuthen(boolean statusAuthen) {
        this.statusAuthen = statusAuthen;
    }
}
