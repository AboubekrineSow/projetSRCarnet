package ma.iao.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.apache.tomcat.util.http.parser.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ma.iao.entities.Carnet;
import ma.iao.entities.CarnetId;
import ma.iao.repository.CarnetRepository;
import ma.iao.services.CarnetServices;

@RestController 
@RequestMapping("/carnet")
@AllArgsConstructor
public class CarnetController {
	
    @Autowired
    private CarnetServices carnetService;
    
    @Autowired
    private CarnetRepository carnetRepository;
    

   
    
    
    
    
    // Opération de création (create)

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Carnet createCarnet(@RequestBody Carnet carnet) {
        return carnetService.createCarnet(carnet);
    }

    @GetMapping(value="/{idClient}/{idSport}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Optional<Carnet> getCarnetById(@PathVariable Integer idClient, @PathVariable Integer idSport) {
        CarnetId id = new CarnetId(idClient, idSport);
        return carnetService.getCarnetById(id);
    }

    
	/* format PDF
	 * @GetMapping("re/{idClient}/{idSport}") public void
	 * getCarnetById(@PathVariable Integer idClient, @PathVariable Integer idSport,
	 * HttpServletResponse response) { CarnetId id = new CarnetId(idClient,
	 * idSport); Optional<Carnet> carnet = carnetService.getCarnetById(id);
	 * 
	 * response.setContentType(MediaType.APPLICATION_PDF_VALUE); // autres
	 * instructions pour gérer la réponse ici...
	 * 
	 * }
	 */
    
    // Opération de lecture (read)
	/*
	 * ERROR
	 * @GetMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
	 * produces = MediaType.APPLICATION_JSON_VALUE) public Optional<Carnet>
	 * getCarnetById(@PathVariable CarnetId id) { return
	 * carnetService.getCarnetById(id); }
	 */
    
    
	/*
	 * CORRECTLY
	 * 
	 * @GetMapping(value="/{idClient}/{idSport}", consumes =
	 * MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_PDF_VALUE)
	 * public Optional<Carnet> getCarnetById(@PathVariable Integer
	 * idClient, @PathVariable Integer idSport) { CarnetId id = new
	 * CarnetId(idClient, idSport); return carnetService.getCarnetById(id); }
	 */

    @GetMapping(value = "/all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

    

    
    
        @PostMapping(value="/carnets/{idClient}/{idSport}/buy")
        public ResponseEntity<Carnet> buyTicket(@PathVariable Integer idClient, @PathVariable Integer idSport, @RequestBody Integer quantity) {
            CarnetId id = new CarnetId(idClient, idSport);
            Optional<Carnet> carnet = carnetRepository.findById(id);
            if (carnet.isPresent()) {
                Carnet c = carnet.get();
                if (c.getNombreEntrees() >= quantity) {
                    // Il y a assez de tickets dans le carnet, on peut effectuer l'achat
                    c.setNombreEntrees(c.getNombreEntrees() - quantity);
                    carnetRepository.save(c);
                    return ResponseEntity.ok(c);
                } else {
                    // Il n'y a pas assez de tickets dans le carnet
                    return ResponseEntity.badRequest().build();
                }
            } else {
                // Carnet non trouvé
                return ResponseEntity.notFound().build();
            }
        }

    
        
        
		/*
		 * @PostMapping("/acheter") public void acheterTicket(@RequestBody CarnetId
		 * id, @RequestBody int nombre) { carnetService.acheterTicket(id, nombre); }
		 */
        
        
        
        
        
        
        
        
    
	/*4
	 * @GetMapping public ResponseEntity<List<Carnet>> getAllCarnets() { return
	 * ResponseEntity.ok(carnetServices.getAllCarnets()); }
	 * 
	 * @PostMapping public ResponseEntity<String> saveClient(@RequestBody Carnet
	 * carnet) { carnetServices.saveCarnet(carnet); return
	 * ResponseEntity.ok("done"); }
	 * ---------------------------------------------
	 * 
	 * @GetMapping("/carnets/{idClient}/{idSport}")
	public ResponseEntity<Carnet> getCarnetById(@PathVariable Integer idClient, @PathVariable Integer idSport) {
    CarnetId id = new CarnetId(idClient, idSport);
    Optional<Carnet> carnet = carnetRepository.findById(id);
    if (carnet.isPresent()) {
        return ResponseEntity.ok(carnet.get());
    } else {
        return ResponseEntity.notFound().build();
    }
    
    
}
   
	
	 *
	 *
	 *-----------------------------
	 *@PostMapping("/carnets/{idClient}/{idSport}/buy")
public ResponseEntity<Carnet> buyTicket(@PathVariable Integer idClient, @PathVariable Integer idSport, @RequestBody Integer quantity) {
    CarnetId id = new CarnetId(idClient, idSport);
    Optional<Carnet> carnet = carnetRepository.findById(id);
    if (carnet.isPresent()) {
        Carnet c = carnet.get();
        if (c.getNombreEntrees() >= quantity) {
            c.setNombreEntrees(c.getNombreEntrees() - quantity);
            carnetRepository.save

	 *-----------------------------------
	 *CarnetId id = new CarnetId(idClient, idSport);
Carnet carnet = carnetRepository.findById(id);
if (carnet == null) {
    // Carnet non trouvé
    return ResponseEntity.notFound().build();
} else {
    // Carnet trouvé, vous pouvez continuer à mettre à jour le carnet
}





	 */

}
