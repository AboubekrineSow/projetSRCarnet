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
    
   
    public Carnet createCarnet(Carnet carnet) {
        return carnetRepository.save(carnet);
    }


    public Optional<Carnet> getCarnetById(CarnetId id) {
        return carnetRepository.findById(id);
    }
    public List<Carnet> getAllCarnets() {
        return carnetRepository.findAll();
    }

    public Carnet updateCarnet(Carnet carnet) {
        return carnetRepository.saveAndFlush(carnet);
    }

    public void deleteCarnetById(CarnetId id) {
        carnetRepository.deleteById(id);
    }
    public void deleteCarnet(Carnet carnet) {
        carnetRepository.delete(carnet);
    }
    public void deleteAllCarnets() {
        carnetRepository.deleteAll();
    }
    
    
    public Carnet buyTicket(Integer idClient, Integer idSport, Integer nombres) {
        CarnetId id = new CarnetId(idClient, idSport);
        Optional<Carnet> carnet = carnetRepository.findById(id);
        if (carnet.isPresent()) {
            Carnet c = carnet.get();
            if (c.getNombreEntrees() >= nombres) {
                // Il y a assez de tickets dans le carnet, on peut effectuer l'achat
                c.setNombreEntrees(c.getNombreEntrees() - nombres);
                carnetRepository.save(c);
                return c;
            } else {
                // Il n'y a pas assez de tickets dans le carnet
                return null;
            }
        } else {
            // Carnet non trouvé
            return null;
        }
    }
    
  


        
      

            
        
}



    

