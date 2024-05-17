package rikkei.ss20_addtocart_session.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Integer id;
    @Column(name = "user_name")
    String userName;

    @Column(name = "email", nullable = false, unique = true)

    String email;

    @Column(name = "password")

    String password;
    @Column(name = "phone")

    String phone;
    @Column(name = "address")


    String address;
    @Column(name = "avatar")
    String avatar;

    @Column(name = "status", columnDefinition = "boolean default true")
    Boolean status;

    @Column(name = "dob", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dob;

}
