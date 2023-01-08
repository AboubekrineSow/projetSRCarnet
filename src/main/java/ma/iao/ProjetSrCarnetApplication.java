package ma.iao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.iao.repository.SportRepository;
import ma.iao.services.CarnetServices;

@SpringBootApplication
public class ProjetSrCarnetApplication/* implements CommandLineRunner */{
	
	/*
	 * @Autowired private CarnetServices carnetServices;
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProjetSrCarnetApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * carnetServices.initcarnet(); }
	 */
}
