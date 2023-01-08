package ma.iao.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "preferences")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Preference implements Serializable {
    @EmbeddedId
    private PreferenceId id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_client", nullable = false)
    private Client idClient;
    @Column(name = "langue", nullable = false, length = 45)
    private String langue;

    @Column(name = "theme", nullable = false, length = 45)
    private String theme;

}