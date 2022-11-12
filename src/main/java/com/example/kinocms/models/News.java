package com.example.kinocms.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private Boolean active;

    @Column
    private String name;

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column
    private String descriptions;

    @Column
    private String link;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "seo_id", referencedColumnName = "id", nullable = false)
    private SEO seo;

//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "main_image_id", referencedColumnName = "id", nullable = false)
//    private MainImage main_image;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "news_image_id", referencedColumnName = "id")
//    private List<GalleryImage> gallery_images;

    @Column
    private String main_image;

    @ElementCollection
    @Column(name = "image")
    @CollectionTable(name = "news_images", joinColumns = @JoinColumn(name = "news_id"))
    private List<String> gallery_images;
}
