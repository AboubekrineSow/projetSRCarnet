package ma.iao.services;

import ma.iao.entities.Sport;
import ma.iao.repository.SportRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SportServices {
    @Autowired
    private SportRepository sportRepository;

    public List<Sport> getAllSport(){
        return sportRepository.findAll();
    }
    public void saveSport(Sport sport){
        sportRepository.save(sport);
    }
    
}
