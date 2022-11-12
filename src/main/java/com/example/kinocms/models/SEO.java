package com.example.kinocms.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "seo")
public class SEO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    String url;

    @Column
    String title;

    @Column
    String keywords;

    @Column
    String descriptions;
}
