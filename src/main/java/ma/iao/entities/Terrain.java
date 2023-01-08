package ma.iao.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "terrains")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Terrain {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "surface", nullable = false, length = 45)
    private String surface;
}