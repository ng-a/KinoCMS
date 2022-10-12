package com.example.kinocms.models;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Builder
@Getter
@Setter

@Entity
@Table(name = "new_table")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    String name;

    @Column(name = "descriptions")
    String descriptions;

    @Column(name = "data")
    LocalDate data;

    @Column(name = "trailer")
    String trailer;

    @Column(name = "type")
    String type;

    public Test() {}

    public Test(String name, String describe, LocalDate data, String trailer, String type) {
        this.name = name;
        this.descriptions = describe;
        this.data = data;
        this.trailer = trailer;
        this.type = type;
    }

    public Test(Long id, String name, String describe, LocalDate data, String trailer, String type) {
        this.id = id;
        this.name = name;
        this.descriptions = describe;
        this.data = data;
        this.trailer = trailer;
        this.type = type;
    }
}
