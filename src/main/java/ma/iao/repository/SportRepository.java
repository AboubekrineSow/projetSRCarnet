package ma.iao.repository;

import ma.iao.entities.Sport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SportRepository extends JpaRepository<Sport, Integer> {
	 @Override
	    List<Sport> findAll();
	    @Override
	    Sport save(Sport sport);
}
