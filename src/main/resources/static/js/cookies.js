var url = "http://localhost:8080/";

function setCookie(gebruiker, gebruikersnaam, dag) {
	var datum = new Date();
	datum.setTime(datum.getTime() + (dag * 1 * 60 * 60 * 1000));
	var expires = "expires=" + datum.toGMTString();
	document.cookie = gebruiker + "=" + gebruikersnaam + ";" + expires + ";path=/";
}

function getCookie(gebruiker) {
	var naam = gebruiker + "=";
	var decodedCookie = decodeURIComponent(document.cookie);
	var split = decodedCookie.split(';');
	for (var i = 0; i < split.length; i++) {
		var c = split[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(naam) == 0) {
			return c.substring(naam.length, c.length);
		}
	}
	return "";
}

function checkCookie() {
	var gebruiker = getCookie("gebruiker");
	if (gebruiker != "") {
		document.getElementById("welkom").innerHTML = "Welkom "+ gebruiker;
	} else {
		window.location.replace(url);
	}
}

function deleteCookie(){
	document.cookie = "gebruiker=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	window.location.replace(url);
}