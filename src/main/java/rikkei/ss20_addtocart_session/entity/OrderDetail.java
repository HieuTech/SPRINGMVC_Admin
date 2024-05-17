package rikkei.ss20_addtocart_session.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
           @Column(name = "od_id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Products products;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Orders orders;


}
