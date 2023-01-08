package ma.iao.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "sports")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sport {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 45)
    private String nom;

    @Column(name = "nombre_joueurs", nullable = false)
    private Integer nombreJoueurs;

    @Column(name = "sports_terrain", nullable = false)
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Terrain> terrains = new ArrayList<>();

 // 1
    @Column(name = "tarif", nullable = false)
    private double tarif;


}