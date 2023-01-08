package ma.iao.repository;

import ma.iao.entities.Client;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Override
    List<Client> findAll();
    @Override
    Client save(Client client);
   
	/*
	 * @Override Optional<Client> findById(Integer id);
	 */}
