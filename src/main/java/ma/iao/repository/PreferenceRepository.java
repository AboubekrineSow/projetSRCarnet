package ma.iao.repository;

import ma.iao.entities.Client;
import ma.iao.entities.Preference;
import ma.iao.entities.PreferenceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface PreferenceRepository extends JpaRepository<Preference, PreferenceId> {

}