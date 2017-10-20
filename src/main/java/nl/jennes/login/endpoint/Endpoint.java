package nl.jennes.login.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import nl.jennes.login.Gebruiker;
import nl.jennes.login.repository.GebruikerRepository;


@RestController
public class Endpoint {
	
	@Autowired
	private GebruikerRepository gebruikerRepository;
	
	@PostMapping("/registreer")
	public void registeren(@RequestBody Gebruiker gebruiker) {
		gebruikerRepository.save(gebruiker);
	}
}
