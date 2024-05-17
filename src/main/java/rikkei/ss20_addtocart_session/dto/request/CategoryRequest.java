package rikkei.ss20_addtocart_session.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequest {
    int id;
    String categoryName;
    String description;
}
