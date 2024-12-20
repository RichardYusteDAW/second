package fpmislata.examen.d_persistence.zdao.impl.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Movie")
@Data
@NoArgsConstructor
public class MovieDaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TitleEn")
    private String titleEn;

    @Column(name = "TitleEs")
    private String titleEs;

    @Column(name = "DescriptionEn")
    private String descriptionEn;

    @Column(name = "DescriptionEs")
    private String descriptionEs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Director_Id")
    private DirectorDaoModel directorDaoModel;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Movie_Actor", joinColumns = @JoinColumn(name = "Movie_Id"), inverseJoinColumns = @JoinColumn(name = "Actor_Id"))
    private List<ActorDaoModel> actorDaoModelList;
}