package com.example.kinocms.models;


import com.example.kinocms.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    String card;

    @Column
    private String nickname;

    @Column
    private String password;

    @Column
    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    private Boolean active;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column
    private String city;

    @Column
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
