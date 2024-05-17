package rikkei.ss20_addtocart_session.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShoppingCartRequest {
     Integer id;
     Integer productId;
     Integer userId;

     Integer quantity;


}
