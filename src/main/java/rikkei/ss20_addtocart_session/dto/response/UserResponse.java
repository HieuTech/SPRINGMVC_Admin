package rikkei.ss20_addtocart_session.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Integer id;
    String email;
    String password;
    String userName;
    String phone;
    String address;
    String avatar;
    Date dob;
    Boolean status;



}
