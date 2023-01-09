package ma.iao.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class CarnetId implements Serializable {
    @Serial
    private static final long serialVersionUID = 6934162338657067693L;
    @Column(name = "id_client", nullable = false)
    private Integer idClient;

    @Column(name = "id_sport", nullable = false)
    private Integer idSport;
    
    //  6
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarnetId carnetId = (CarnetId) o;
        return Objects.equals(idClient, carnetId.idClient) &&
                Objects.equals(idSport, carnetId.idSport);
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(idClient, idSport);
    }

}
