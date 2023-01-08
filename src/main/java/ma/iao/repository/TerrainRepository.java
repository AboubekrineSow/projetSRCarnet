package ma.iao.repository;

import ma.iao.entities.Terrain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TerrainRepository extends JpaRepository<Terrain, Integer> {
	
	 @Override
	    List<Terrain> findAll();
	    @Override
	    Terrain save(Terrain terrain);
}
