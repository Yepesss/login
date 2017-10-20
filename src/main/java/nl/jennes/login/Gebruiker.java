package nl.jennes.login;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Gebruiker {
	@Id
	@GeneratedValue
	private Long id;
	private String voornaam;
	private String tussenvoegsel;
	private String achternaam;
	private String land;
	private String email;
	private int dag;
	private int maand;
	private int jaar;
	private String gebruikersnaam;
	private String wachtwoord;
	
	public Gebruiker() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDag() {
		return dag;
	}
	public void setDag(int dag) {
		this.dag = dag;
	}
	public int getMaand() {
		return maand;
	}
	public void setMaand(int maand) {
		this.maand = maand;
	}
	public int getJaar() {
		return jaar;
	}
	public void setJaar(int jaar) {
		this.jaar = jaar;
	}
	public String getGebruikersnaam() {
		return gebruikersnaam;
	}
	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}
	public String getWachtwoord() {
		return wachtwoord;
	}
	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
}

