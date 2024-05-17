package rikkei.ss20_addtocart_session.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "role_user")
public class Role_User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "role_user_id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users users;

}
