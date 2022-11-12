package com.example.kinocms.models;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "banner_carousel")
public class BannerCarousel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private Boolean active;

    @Column
    private String url;

    @Column
    private String text;

    @Column
    private int speed;

    @Column
    private String image;
}
