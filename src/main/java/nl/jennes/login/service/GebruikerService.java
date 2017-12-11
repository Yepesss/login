package nl.jennes.login.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.jennes.login.Gebruiker;
import nl.jennes.login.SendEmail;
import nl.jennes.login.endpoint.Endpoint;
import nl.jennes.login.repository.GebruikerRepository;

@Service
@Transactional
public class GebruikerService {

	@Autowired
	private GebruikerRepository gebruikerRepository;
	@Autowired
	private Endpoint endpoint;
	
	List<Gebruiker> gebruikerBestaat;
	List<Gebruiker> gebruikerGegevens;

	public void registreren(Gebruiker gebruiker) {
		gebruikerBestaat = gebruikerRepository.findByGebruikersnaam(gebruiker.getGebruikersnaam());
		
		if(gebruiker.getVoornaam() != "" && gebruiker.getAchternaam() != "" && gebruiker.getEmail() != "" && gebruiker.getLand() != "" && gebruiker.getDag() != 0 && gebruiker.getMaand() != 0 && gebruiker.getJaar() != 0 && gebruiker.getGebruikersnaam() != "" && gebruiker.getWachtwoord() != "" && gebruiker.getWachtwoordRepeat() != "") {
			if(gebruiker.getVoornaam().matches("[a-zA-Z]*") && gebruiker.getAchternaam().matches("[a-zA-Z]*") && (gebruiker.getTussenvoegsel().matches("[a-zA-Z]*") || gebruiker.getTussenvoegsel() == "")) {
				if(gebruiker.getGebruikersnaam().matches("[a-zA-Z0-9]*")) {
					if(gebruiker.getWachtwoord().equals(gebruiker.getWachtwoordRepeat())) {
						if(gebruikerBestaat.isEmpty()) {
							endpoint.message = "U bent geregistreerd!";
							gebruikerRepository.save(gebruiker);
							SendEmail.mail(gebruiker.getEmail(), gebruiker.getActivatiecode());
						}else {
							endpoint.message = "Gebruikersnaam bestaat al.";
						}
					}else {
						endpoint.message = "Wachtwoorden komen niet overeen.";
					}
				}else {
					endpoint.message = "Gebruikersnaam mag alleen letters of cijfers bevatten.";
				}
			}else {
				endpoint.message = "Voornaam, tussenvoegsel en achtenaam mogen alleen letters bevatten.";
			}
		}else {
			endpoint.message = "Alle verplichte velden moeten worden ingevuld.";
		}
	}
	
	public void inloggen(Gebruiker gebruiker) {
		gebruikerBestaat = gebruikerRepository.findByGebruikersnaam(gebruiker.getGebruikersnaam());
		
		if(gebruiker.getGebruikersnaam() != "" && gebruiker.getWachtwoord() != "") {
			for(Gebruiker s : gebruikerBestaat) {
				if(s.getWachtwoord().equals(gebruiker.getWachtwoord())) {
					if(s.getActivated() == 1) {
						endpoint.message = "Ingelogd";
					}else {
						endpoint.message = "Je account is nog niet geactiveerd";
					}
				}else {
					endpoint.message = "Verkeerd wachtwoord";
				}
			}
		}else {
			endpoint.message = "Vul beide velden in";
		}
	}
	
	public void activeren(Gebruiker gebruiker) {
		gebruikerBestaat = gebruikerRepository.findByGebruikersnaam(gebruiker.getGebruikersnaam());
		
		if(gebruiker.getGebruikersnaam() != "") {
			for(Gebruiker s : gebruikerBestaat) {
				if(s.getActivatiecode().equals(gebruiker.getActivatiecode())) {
					s.setActivated(1);
					endpoint.message = "Code klopt.";
				}else {
					endpoint.message = "Code klopt niet.";
				}
			}
		}else {
			endpoint.message = "Vul uw gebruikersnaam in.";
		}
	}
}