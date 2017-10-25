function getCookie(){
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			if(this.responseText != ""){
				document.getElementById("welkom").innerHTML = "Welkom "+this.responseText;
			}else{
				window.location.assign("http://localhost:8080");
			}
		}
	};
	xhttp.open("GET", "http://localhost:8080/getCookie");
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send();
}

function deleteCookie(){
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			window.location.assign("http://localhost:8080");
		}
	};
	xhttp.open("GET", "http://localhost:8080/deleteCookie");
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send();
}
