package ma.iao.entities;

import java.io.Serializable;

// import javax.persistence.Table;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "carnets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Carnet implements Serializable{

    @EmbeddedId 
    private CarnetId id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_client",nullable = false,insertable=false, updatable=false)
    @ToString.Exclude
    private Client idClient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_sport", nullable = false,insertable=false, updatable=false)
    @ToString.Exclude
    private Sport idSport;

    @Column(name = "nombre_entrees", nullable = false)
    private Integer nombreEntrees;

}