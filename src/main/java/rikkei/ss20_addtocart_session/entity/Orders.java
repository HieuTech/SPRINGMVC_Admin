package rikkei.ss20_addtocart_session.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "order_id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users users;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Date createAt;

    @Column(name = "status", columnDefinition = "boolean default true")
    Boolean status;

}
