var gebruikersnaam;
var wachtwoord;
var message;

function ophalenGegevens() {
	gebruikersnaam = document.getElementById("gebruikersnaam").value;
	wachtwoord = document.getElementById("wachtwoord").value;

	toDatabase();
}

function toDatabase() {
	
	var gebruikerGegevens = '{"gebruikersnaam": "' + gebruikersnaam + '","wachtwoord": "' + wachtwoord + '"}';

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			message = this.responseText;
			alert(message);
		}
	};

	xhttp.open("POST", "http://localhost:8080/inloggen", true);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send(gebruikerGegevens);
}
