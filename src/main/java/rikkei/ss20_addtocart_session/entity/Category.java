package rikkei.ss20_addtocart_session.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "category_id")
    int id;

    @NotNull
    @Column(name = "category_name")
    String categoryName;

    @Column(name = "status", columnDefinition = "boolean default true")
    Boolean status;

    String description;


}
