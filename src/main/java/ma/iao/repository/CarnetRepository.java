package ma.iao.repository;

import ma.iao.entities.Carnet;
import ma.iao.entities.CarnetId;
import ma.iao.entities.Client;
import ma.iao.entities.Sport;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
//@Resource
@Transactional
public interface CarnetRepository extends JpaRepository<Carnet, CarnetId> {
	
	
	// les operations de crud
	
	@Override
	List<Carnet> findAll();
	@Override
	Carnet save(Carnet carnet); 
	
	/* Carnet updateCarnets(Carnet carnet); */
	void deleteById(Integer id);
	
	// methodes de recherche
	/*
	 * Optional<Carnet> findById(int id); List<Carnet> findByNombreEntrees(Integer
	 * nombreEntrees); List<Carnet> findByIdClient(Client idClient); List<Carnet>
	 * findByIdSport(Sport idSport);
	 */

	
	
	
	
	
}
