package com.fpmislata.demo.d_persistence.zdao.impl.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "genres")
@Data
@NoArgsConstructor
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_es")
    private String nameEs;
    @Column(name = "name_en")
    private String nameEn;
    private String slug;
}