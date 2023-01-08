package ma.iao.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code_postal", nullable = false)
    private Integer codePostal;

    @Column(name = "rue", nullable = false)
    private String rue;

    @Column(name = "ville", nullable = false, length = 45)
    private String ville;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "mot_de_passe", nullable = false, length = 100)
    private String motDePasse;

    @Column(name = "nom", nullable = false, length = 45)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 45)
    private String prenom;

    public Client(Integer codePostal, String rue, String ville, String email, String motDePasse, String nom, String prenom) {
        this.codePostal = codePostal;
        this.rue = rue;
        this.ville = ville;
        this.email = email;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
    }
}