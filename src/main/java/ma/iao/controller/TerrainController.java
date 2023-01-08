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
import ma.iao.entities.Terrain;
import ma.iao.services.TerrainServices;

@RestController
@RequiredArgsConstructor
@RequestMapping("/terrain")
public class TerrainController {

	@Autowired
    private TerrainServices terrainServices;
	
	@GetMapping
    public ResponseEntity<List<Terrain>> getAllTerrain() {
        return ResponseEntity.ok(terrainServices.getAllTerrain());
    }

    //@PostMapping

    @PostMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> saveTerrain(@RequestBody Terrain terrain) {
    	terrainServices.saveTerrain(terrain);
        return ResponseEntity.ok("done");
    }
	
}
