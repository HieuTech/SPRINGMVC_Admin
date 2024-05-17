package rikkei.ss20_addtocart_session.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.servlet.http.HttpSession;


@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenResponse {

    HttpSession httpSession;
    boolean statusAuthen;


}
