package rikkei.ss20_addtocart_session.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShoppingCartResponse {
    Integer productId;
    String productName;
    String productImg;
    Double productPrice;

    Integer quantity;



}