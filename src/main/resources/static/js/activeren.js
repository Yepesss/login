var code;
var gebruikersnaam;
var message;
var url = "http://localhost:8080/";

function ophalenGegevens() {
	gebruikersnaam = document.getElementById("gebruikersnaam").value;
	code = document.getElementById("code").value;

	toDatabase();
}

function toDatabase() {
	
	var gebruikerGegevens = '{"gebruikersnaam": "' + gebruikersnaam + '","activatiecode": "' + code + '"}';

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			message = this.responseText;
			alert(message);
			if(message == "Code klopt"){
				window.location.replace(url);
			}
		}
	};

	xhttp.open("POST", "http://localhost:8080/activerenaccount", true);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send(gebruikerGegevens);
}
