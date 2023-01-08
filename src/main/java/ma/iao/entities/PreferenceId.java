package ma.iao.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class PreferenceId implements Serializable {
    @Column(name = "id_client", nullable = false)
    private Integer idClient;
}
