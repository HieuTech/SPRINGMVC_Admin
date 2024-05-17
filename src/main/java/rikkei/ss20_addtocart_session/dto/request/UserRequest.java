package rikkei.ss20_addtocart_session.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    Integer id;
    String email;
    String userName;

    String password;

    String phone;

    String address;

    String avatar;
    Date dob;

}
