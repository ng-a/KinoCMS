package com.example.kinocms.models;


import com.example.kinocms.enums.FilmType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "films")
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

//    @ElementCollection
//    @Enumerated(EnumType.STRING)
//    @CollectionTable(joinColumns=@JoinColumn(name="id"))

//    @Enumerated(EnumType.STRING)
//    @ElementCollection
//    @CollectionTable(name = "film_tipe", joinColumns = @JoinColumn(name = "user_id"))
//    private Set<FilmType> film_type;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = FilmType.class)
    @CollectionTable(name = "film_type", joinColumns = @JoinColumn(name = "film_id"))
    private Set <FilmType> types;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "seo_id", referencedColumnName = "id", nullable = false)
    private SEO seo;

    @Column
    private String main_image;

    @ElementCollection
    @Column(name = "image")
    @CollectionTable(name = "films_images", joinColumns = @JoinColumn(name = "film_id"))
    private List<String> gallery_images;
}
