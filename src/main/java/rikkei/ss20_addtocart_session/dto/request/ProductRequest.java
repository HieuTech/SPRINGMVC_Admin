package rikkei.ss20_addtocart_session.dto.request;


import com.google.protobuf.Internal;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;
import rikkei.ss20_addtocart_session.entity.Category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

  Integer id;
  @NotNull(message = "Product Name Is Empty!")

  String name;

  @NotNull(message = "Category Is Empty")
  Integer categoryId;

  @NotNull(message = "Product Price Is Empty!")
  @Positive(message = "Price must greater than 0")
  Double price;


  @NotNull(message = "Stock Is Empty")
  @Positive(message = "Stock must greater than 0")
  Integer stock;

  Boolean status;

  MultipartFile file;


}