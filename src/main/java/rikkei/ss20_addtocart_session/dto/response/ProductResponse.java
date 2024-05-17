package rikkei.ss20_addtocart_session.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;
import rikkei.ss20_addtocart_session.entity.Category;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Integer id;
    Category category;
    String name;
    Double price;
    Integer stock;
    Boolean status;
    String image;


}
