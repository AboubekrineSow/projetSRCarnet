package ma.iao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ma.iao.entities.Carnet;
import ma.iao.entities.CarnetId;
import ma.iao.services.CarnetServices;

@RestController 
@RequestMapping("/carnet")
@AllArgsConstructor
public class CarnetController {
	
    @Autowired
    private CarnetServices carnetService;

   
    
    // Opération de création (create)
    @PostMapping
    public Carnet createCarnet(@RequestBody Carnet carnet) {
        return carnetService.createCarnet(carnet);
    }

    // Opération de lecture (read)
    @GetMapping("/{id}")
    public Optional<Carnet> getCarnetById(@PathVariable CarnetId id) {
        return carnetService.getCarnetById(id);
    }
    @GetMapping
    public List<Carnet> getAllCarnets() {
        return carnetService.getAllCarnets();
    }

    // Opération de mise à jour (update)
    @PutMapping
    public Carnet updateCarnet(@RequestBody Carnet carnet) {
        return carnetService.updateCarnet(carnet);
    }
    
    // Opération de suppression (delete)
    @DeleteMapping("/{id}")
    public void deleteCarnetById(@PathVariable CarnetId id) {
        carnetService.deleteCarnetById(id);
    }
    @DeleteMapping
    public void deleteCarnet(@RequestBody Carnet carnet) {
        carnetService.deleteCarnet(carnet);
    }
    @DeleteMapping("/all")
    public void deleteAllCarnets() {
        carnetService.deleteAllCarnets();
    }


        @PostMapping("/acheter")
        public void acheterTicket(@RequestBody CarnetId id, @RequestBody int nombre) {
            carnetService.acheterTicket(id, nombre);
        }
    

    
    
    
    
    
    
    
    
    
    
	/*4
	 * @GetMapping public ResponseEntity<List<Carnet>> getAllCarnets() { return
	 * ResponseEntity.ok(carnetServices.getAllCarnets()); }
	 * 
	 * @PostMapping public ResponseEntity<String> saveClient(@RequestBody Carnet
	 * carnet) { carnetServices.saveCarnet(carnet); return
	 * ResponseEntity.ok("done"); }
	 */

}
