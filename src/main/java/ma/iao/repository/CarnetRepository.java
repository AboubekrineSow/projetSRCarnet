package ma.iao.repository;

import ma.iao.entities.Carnet;
import ma.iao.entities.CarnetId;
import ma.iao.entities.Client;
import ma.iao.entities.Sport;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Resource

@Repository
@Transactional
public interface CarnetRepository extends JpaRepository<Carnet, CarnetId> {
	
	
	
	//2

	    // Opération de création (create)
	    <S extends Carnet> S save(S carnet);

	    // Opération de lecture (read)
	    Optional<Carnet> findById(CarnetId id);
	    List<Carnet> findAll();

	    // Opération de mise à jour (update)
	    <S extends Carnet> S saveAndFlush(S carnet);

	    // Opération de suppression (delete)
	    void deleteById(CarnetId id);
	    void delete(Carnet carnet);
	    void deleteAll();
	
	
	
	
	
	
	/* 2
	 * @Override List<Carnet> findAll();
	 * 
	 * @Override Carnet save(Carnet carnet);
	 * 
	 * 
	 * void deleteById(Integer id);
	 */	
	// les operations de crud
	
	
	// methodes de recherche
	/*
	 * Optional<Carnet> findById(int id); List<Carnet> findByNombreEntrees(Integer
	 * nombreEntrees); List<Carnet> findByIdClient(Client idClient); List<Carnet>
	 * findByIdSport(Sport idSport);
	 */
	/* Carnet updateCarnets(Carnet carnet); */
	
	
	
	
	
}
