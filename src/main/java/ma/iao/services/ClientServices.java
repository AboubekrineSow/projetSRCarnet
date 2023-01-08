package ma.iao.services;

import ma.iao.entities.Client;

import ma.iao.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServices {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }
    public void saveClient(Client client){
        clientRepository.save(client);
    }
    
	/*
	 * public void deleteClient(Client client) {
	 * clientRepository.deleteById(client.getId()); }
	 */
    
}
