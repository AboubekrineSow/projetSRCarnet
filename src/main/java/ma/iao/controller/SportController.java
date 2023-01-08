package ma.iao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.iao.entities.Sport;
import ma.iao.services.SportServices;


@RestController
@RequiredArgsConstructor
@RequestMapping("/sport")
public class SportController {
    @Autowired
    private SportServices sportServices;
    @GetMapping
    public ResponseEntity<List<Sport>> getAllSport() {
        return ResponseEntity.ok(sportServices.getAllSport());
    }

    //@PostMapping

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> saveSport(@RequestBody Sport sport) {
    	sportServices.saveSport(sport);
        return ResponseEntity.ok("done");
    }

}
