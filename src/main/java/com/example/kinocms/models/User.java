package com.example.kinocms.models;


import com.example.kinocms.enums.Gender;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Data

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
    String password;

    @Column
    boolean active;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Gender gender;

    @Column
    private String email;

    @Column
    private String phone;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column
    private String city;

    @Column
    private String address;
}
