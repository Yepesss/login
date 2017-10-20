var voornaam;
var tussenvoegsel;
var achternaam;
var dag;
var maand;
var jaar;
var email;
var land;
var gebruikersnaam;
var wachtwoord;
var wachtwoordRepeat;

function ophalenGegevens(){
	
	voornaam = document.getElementById("voornaam").value;
	tussenvoegsel = document.getElementById("tussenvoegsel").value;
	achternaam = document.getElementById("achternaam").value;
	dag = document.getElementById("dag").value;
	maand = document.getElementById("maand").value;
	jaar = document.getElementById("jaar").value;
	email = document.getElementById("email").value;
	land = document.getElementById("land").value;
	gebruikersnaam = document.getElementById("gebruikersnaam").value;
	wachtwoord = document.getElementById("wachtwoord").value;
	wachtwoordRepeat = document.getElementById("wachtwoordRepeat").value;
	
	toDatabase();
}

function toDatabase(){
	alert("jo");
	var gebruikerGegevens = '{"voornaam": "' +voornaam+ '","tussenvoegsel": "'
	+tussenvoegsel+'","achternaam": "'+achternaam+'","email": "'+email+'","dag": "'
	+dag+'","maand": "'+maand+'","jaar": "'+jaar+'","land": "'+land+'","gebruikersnaam": "'
	+gebruikersnaam+'","wachtwoord": "'+wachtwoord+'"}'; 
	
	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		   if (this.readyState == 4 && this.status == 200) {
			   alert(this.responseText);
			}
		};
		
	xhttp.open("POST", "http://localhost:8080/registreer", true);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send(gebruikerGegevens);
}