function setTheme(){
	const userPrefersDark = window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches;
	const userPrefersLight = window.matchMedia && window.matchMedia('(prefers-color-scheme: light)').matches;


	let currTheme;
	if(localStorage.getItem('theme'))
		currTheme = localStorage.getItem('theme');
	else if(userPrefersLight)
		currTheme = "/css/dark.css";
	else if(userPrefersDark)
		currTheme = "/css/light.css";
	console.log('set theme =' + currTheme);
	link.setAttribute("href", currTheme);
	if(localStorage.getItem('filmGenre') != null){
		document.getElementById("genreFilmChange").value = localStorage.getItem('filmGenre');
	}
	if(localStorage.getItem('filmYear') != null){
		document.getElementById("yearFilmChange").value = localStorage.getItem('filmYear');
	}
	if(localStorage.getItem('serialGenre') != null){
		document.getElementById("genreSerialChange").value = localStorage.getItem('serialGenre');
	}
	if(localStorage.getItem('serialYear') != null){
		document.getElementById("yearSerialChange").value = localStorage.getItem('serialYear');
	}
}

let btn = document.getElementById("theme-button");
let link = document.getElementById("theme-link");

btn.addEventListener("click", function () { ChangeTheme(); });

function ChangeTheme()
{
	let lightTheme = "/css/light.css";
	let darkTheme = "/css/dark.css";

	let currTheme = link.getAttribute("href");
	console.log('currTheme ' + currTheme);
	if(currTheme === lightTheme)
	{
		currTheme = darkTheme;
	}
	else
	{
		currTheme = lightTheme;
	}
	localStorage.setItem('theme', currTheme);
	link.setAttribute("href", currTheme);
	return(localStorage.getItem('theme'));
}


function OnFilmChange() {
	let valGenre = document.getElementById("genreFilmChange").value;
	let valYear = document.getElementById("yearFilmChange").value;
	let newHref = new URL('http://localhost:8080/choiceFilm');
	newHref.searchParams.set("genre", valGenre);
	newHref.searchParams.set("year", valYear);
	localStorage.setItem('filmGenre', valGenre);
	localStorage.setItem('filmYear', valYear);

	window.location.href = newHref;
}
function OnSerialChange() {
	let valGenre = document.getElementById("genreSerialChange").value;
	let valYear = document.getElementById("yearSerialChange").value;
	let newHref = new URL('http://localhost:8080/choiceSerial');
	newHref.searchParams.set("genre", valGenre);
	newHref.searchParams.set("hui", valYear);
	localStorage.setItem('serialGenre', valGenre);
	localStorage.setItem('serialYear', valYear);

	window.location.href = newHref;
}

function clearFilm(){
	localStorage.removeItem('filmGenre');
	localStorage.removeItem('filmYear');
	document.location = '/choiceFilm';
}
function clearSerial(){
	localStorage.removeItem('serialGenre');
	localStorage.removeItem('serialYear');
	document.location = '/choiceSerial';
}

function sortTable(n) {
	let table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
	table = document.getElementById("sortTable");
	switching = true;
	dir = "asc";
	while (switching) {
		switching = false;
		rows = table.getElementsByTagName("TR");
		for (i = 1; i < (rows.length - 1); i++) {
			shouldSwitch = false;
			x = rows[i].getElementsByTagName("TD")[n];
			y = rows[i + 1].getElementsByTagName("TD")[n];
			if (dir === "asc") {
				if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
					shouldSwitch = true;
					break;
				}
			} else if (dir === "desc") {
				if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
					shouldSwitch = true;
					break;
				}
			}
		}
		if (shouldSwitch) {
			rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
			switching = true;
			switchcount++;
		} else {
			if (switchcount === 0 && dir === "asc") {
				dir = "desc";
				switching = true;
			}
		}
	}
}