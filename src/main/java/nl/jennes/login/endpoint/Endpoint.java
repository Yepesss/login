package nl.jennes.login.endpoint;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String inloggen(@RequestBody Gebruiker gebruiker, HttpSession session) {
		gebruikerService.inloggen(gebruiker);
		session.setAttribute("gebruikersnaam", gebruiker.getGebruikersnaam());
		return message;
	}
	
	@PostMapping("/activerenaccount")
	public String activeren(@RequestBody Gebruiker gebruiker) {
		gebruikerService.activeren(gebruiker);
		return message;
	}
	
	@GetMapping("/getCookie")
	public Object getCookie(HttpSession session){
		Object gebruikersnaam = session.getAttribute("gebruikersnaam");
		return gebruikersnaam;
	}
	
	@GetMapping("/deleteCookie")
	public void deleteCookie(HttpSession session){
		session.invalidate();
	}
}
