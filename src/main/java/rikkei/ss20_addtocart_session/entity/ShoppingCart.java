package rikkei.ss20_addtocart_session.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "cart_id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id" )
    Products products;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users user;

    @Column(name = "quantity")
    @NotNull
    @Min(1)
    @Max(5)
    Integer quantity;

}
