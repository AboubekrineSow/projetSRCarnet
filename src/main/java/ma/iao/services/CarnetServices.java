package ma.iao.services;

import ma.iao.entities.Carnet;
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
    
    public List<Carnet> getAllCarnets(){
    	return carnetRepository.findAll();
    }
   
    public void saveCarnet(Carnet carnet){
        carnetRepository.save(carnet);
    }
    
	/*
	 * public void updateCarnet(Carnet carnet){
	 * carnetRepository.updateCarnets(carnet); }
	 */
    
    public void deleteCarnet(int id) {
    	carnetRepository.deleteById(id);
    }
    
	/*
	 * public Carnet getCarnet(int id) { return carnetRepository.findById(id).get();
	 * }
	 */
   
    
    
    
    
    
}
