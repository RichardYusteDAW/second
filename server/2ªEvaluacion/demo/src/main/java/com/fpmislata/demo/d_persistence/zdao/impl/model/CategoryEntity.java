package com.fpmislata.demo.d_persistence.zdao.impl.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_es")
    private String nameEs;
    @Column(name = "name_en")
    private String nameEn;
    private String slug;
}