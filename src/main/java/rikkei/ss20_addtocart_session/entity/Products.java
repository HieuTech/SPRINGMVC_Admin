package rikkei.ss20_addtocart_session.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "products")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "product_id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    Double price;


    @Column(name = "stock")
    Integer stock;

    @Column(name = "status",columnDefinition = "boolean default true")
    Boolean status;

    @Column(name = "image")
    String image;


}
