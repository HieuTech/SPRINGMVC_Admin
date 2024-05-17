package rikkei.ss20_addtocart_session.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AuthenRequest {

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Email should be valid")
    @NotNull(message = "Email cannot be null")
    private String email;

    @Size(min = 5, message = "Password must be at least 5 characters long")
    private String password;

    public AuthenRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthenRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
