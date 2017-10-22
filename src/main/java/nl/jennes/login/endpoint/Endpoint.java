package nl.jennes.login.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import nl.jennes.login.Gebruiker;
import nl.jennes.login.service.GebruikerService;


@RestController
public class Endpoint {
	
	@Autowired
	private GebruikerService gebruikerService;
	
	public String message = "";
	
	@PostMapping("/registreer")
	public String registeren(@RequestBody Gebruiker gebruiker) {
		gebruikerService.registreren(gebruiker);
		return message;
	}
	
	@PostMapping("/inloggen")
	public String inloggen(@RequestBody Gebruiker gebruiker) {
		gebruikerService.inloggen(gebruiker);
		return message;
	}
	
	@PostMapping("/activerenaccount")
	public String activeren(@RequestBody Gebruiker gebruiker) {
		gebruikerService.activeren(gebruiker);
		return message;
	}
}
