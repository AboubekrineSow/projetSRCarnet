package ma.iao.services;

import ma.iao.entities.Terrain;
import ma.iao.repository.TerrainRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TerrainServices {
    @Autowired
    private TerrainRepository terrainRepository;
    
    public List<Terrain> getAllTerrain(){
        return terrainRepository.findAll();
    }
    public void saveTerrain(Terrain terrain){
    	terrainRepository.save(terrain);
    }
}
