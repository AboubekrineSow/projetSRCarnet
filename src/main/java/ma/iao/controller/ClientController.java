package ma.iao.controller;

import ma.iao.entities.Client;
//import ma.iao.services.CarnetServices;
import ma.iao.services.ClientServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientServices clientServices;
	
    /*
	 * @Autowired private CarnetServices carnetServices;
	 * 
	 * @GetMapping("/carnet")
	 * 
	 * @ResponseBody public String list(@PathVariable()) { return " test reussi "; }
	 */
    
    
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientServices.getAllClient());
    }

    //@PostMapping

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> saveClient(@RequestBody Client client) {
        clientServices.saveClient(client);
        return ResponseEntity.ok("done");
    }
}
