package com.example.kinocms.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "banner_news")
public class BannerNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private int speed;

    @Column
    private Boolean active;

    @Column
    private String url;

    @Column
    private String image;
}
