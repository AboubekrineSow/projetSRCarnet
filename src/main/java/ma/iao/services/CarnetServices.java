package ma.iao.services;

import ma.iao.entities.Carnet;
import ma.iao.entities.CarnetId;
import ma.iao.entities.Sport;
import ma.iao.repository.CarnetRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CarnetServices {
    @Autowired
    private CarnetRepository carnetRepository;
    
    
    //3
    
    // Opération de création (create)
    public Carnet createCarnet(Carnet carnet) {
        return carnetRepository.save(carnet);
    }

    // Opération de lecture (read)
    public Optional<Carnet> getCarnetById(CarnetId id) {
        return carnetRepository.findById(id);
    }
    public List<Carnet> getAllCarnets() {
        return carnetRepository.findAll();
    }

    // Opération de mise à jour (update)
    public Carnet updateCarnet(Carnet carnet) {
        return carnetRepository.saveAndFlush(carnet);
    }

    // Opération de suppression (delete)
    public void deleteCarnetById(CarnetId id) {
        carnetRepository.deleteById(id);
    }
    public void deleteCarnet(Carnet carnet) {
        carnetRepository.delete(carnet);
    }
    public void deleteAllCarnets() {
        carnetRepository.deleteAll();
    }
    
    
    
    
    
    
    //5
  
        

        public void acheterTicket(CarnetId id, int nombre) {
            Carnet carnet = getCarnetById(id).orElseThrow(() -> new RuntimeException("Carnet introuvable"));
            Sport sport = carnet.getIdSport();
            double tarif = sport.getTarif();
            carnet.setNombreEntrees(carnet.getNombreEntrees() - nombre);
            updateCarnet(carnet);
        }
    }

    
    
    
	/*3
	 * public List<Carnet> getAllCarnets(){ return carnetRepository.findAll(); }
	 * 
	 * public void saveCarnet(Carnet carnet){ carnetRepository.save(carnet); }
	 * 
	 * 
	 * 
	 * public void deleteCarnet(int id) { carnetRepository.deleteById(id); }
	 */
    
    
    
    
	/*
	 * @Autowired private SportRepository sportRepository;
	 * 
	 * @Autowired private ClientRepository clientRepository;
	 * 
	 * public void initcarnet() {
	 * 
	 * clientRepository.findAll().forEach(client->{
	 * sportRepository.findAll().forEach(sport->{
	 * 
	 * Carnet carnet = new Carnet(); carnet.setIdClient(client);
	 * carnet.setIdSport(sport); carnet.setNombreEntrees(9);
	 * 
	 * saveCarnet(carnet); });
	 * 
	 * });
	 * 
	 * }
	 */
    
	/*
	 * public Carnet getCarnet(int id) { return carnetRepository.findById(id).get();
	 * }
	 */
	/*
	 * public void updateCarnet(Carnet carnet){
	 * carnetRepository.updateCarnets(carnet); }
	 */
   
    
    
    
    
    

