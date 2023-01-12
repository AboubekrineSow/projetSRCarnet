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
import org.springframework.web.bind.annotation.RequestHeader;
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
    

    

    


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Carnet createCarnet(@RequestBody Carnet carnet) {
        return carnetService.createCarnet(carnet);
    }
 
    @PutMapping
    public Carnet updateCarnet(@RequestBody Carnet carnet) {
        return carnetService.updateCarnet(carnet);
    }
    
        
    @GetMapping(value="/{idClient}/{idSport}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Optional<Carnet> getCarnetById(@PathVariable Integer idClient, @PathVariable Integer idSport) {
        CarnetId id = new CarnetId(idClient, idSport);
        return carnetService.getCarnetById(id);
    }

    
	

    @GetMapping(value = "/all") 
    public ResponseEntity<List<Carnet>> getAllCarnets() {
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(carnetService.getAllCarnets()); }
    
  
   
  
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

    
    @PostMapping(value="/{idClient}/{idSport}/buy")
    public ResponseEntity<Carnet> buyTicket(@PathVariable Integer idClient, @PathVariable Integer idSport, @RequestBody Integer nombres) {
        Carnet carnet = carnetService.buyTicket(idClient, idSport, nombres);
        if(carnet != null) {
            return ResponseEntity.ok(carnet);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
    
    
    
    
    
    //Methode accept marche avec  v5.0 de spring 
	/*
	 * @GetMapping public ResponseEntity<List<Carnet>> getAllCarnets(
	 * 
	 * @RequestHeader(value="Accept", defaultValue="*") String acceptHeader,
	 * 
	 * @RequestHeader(value="Content-Type", defaultValue="application/json") String
	 * contentTypeHeader) {
	 * 
	 * List<Carnet> carnets = carnetService.getAllCarnets();
	 * 
	 * MediaType accept = MediaType.parseMediaType(acceptHeader); MediaType
	 * contentType = MediaType.parseMediaType(contentTypeHeader);
	 * 
	 * 
	 * return ResponseEntity .ok() .contentType(contentType) .accept(accept)
	 * .body(carnets); }
	 */
    


}
