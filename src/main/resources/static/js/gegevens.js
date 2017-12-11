var gebruikerGegevens;

getGebruikerGegevens();

function getGebruikerGegevens() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			gebruikerGegevens = JSON.parse(this.responseText);
			showGebruikerGegevens(gebruikerGegevens);
		}
	};
	xhttp.open("GET", "http://localhost:8080/gebruikergegevens");
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send();
}

function showGebruikerGegevens(gebruikerGegevens){
	
	for(i=0; i < gebruikerGegevens.length; i++){
		document.getElementById("gebruikerGegevens").innerHTML = "<tr><td>Voornaam: </td><td>"+gebruikerGegevens[i].voornaam+"</td></tr>"
		+ "<tr><td>Tussenvoegsel: </td><td>"+gebruikerGegevens[i].tussenvoegsel+"</td></tr>"
		+ "<tr><td>Achternaam: </td><td>"+gebruikerGegevens[i].achternaam+"</td></tr>"
		+ "<tr><td>Email: </td><td>"+gebruikerGegevens[i].email+"</td></tr>"
		+ "<tr><td>Land: </td><td>"+gebruikerGegevens[i].land+"</td></tr>"
		+ "<tr><td>Geboortedatum: </td><td>"+gebruikerGegevens[i].dag+"-"+gebruikerGegevens[i].maand+"-"+gebruikerGegevens[i].jaar+"</td></tr>";
	}
}
function updateGegevens(){

}