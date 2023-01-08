package ma.iao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ma.iao.entities.Carnet;
import ma.iao.services.CarnetServices;

@RestController 
@RequestMapping("/carnet")
@AllArgsConstructor
public class CarnetController {
	
    @Autowired
    private CarnetServices carnetServices;


   @GetMapping
    public ResponseEntity<List<Carnet>> getAllCarnets() {
        return ResponseEntity.ok(carnetServices.getAllCarnets());
    }
   
    @PostMapping
    public ResponseEntity<String> saveClient(@RequestBody  Carnet carnet) {
        carnetServices.saveCarnet(carnet);
        return ResponseEntity.ok("done");
    }


}
