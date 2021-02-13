function setTheme(){
    let currTheme = localStorage.getItem('theme');
    console.log('set theme =' + currTheme);
    link.setAttribute("href", currTheme);
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
    let theme = "";

    if(currTheme === lightTheme)
    {
        currTheme = darkTheme;
        theme = "dark";
    }
    else
    {
        currTheme = lightTheme;
        theme = "light";
    }
    localStorage.setItem('theme', currTheme);
    link.setAttribute("href", currTheme);
}

function OnFilmChange() {
    let valGenre = document.getElementById("genreFilmChange").value;
    let valYear = document.getElementById("yearFilmChange").value;
    let newHref = new URL('http://localhost:8080/choiceFilm');
    newHref.searchParams.set("genre", valGenre);
    newHref.searchParams.set("year", valYear);
    window.location.href = newHref;
}
function OnSerialChange() {
    let valGenre = document.getElementById("genreSerialChange").value;
    let valYear = document.getElementById("yearSerialChange").value;
    let newHref = new URL('http://localhost:8080/choiceSerial');
    newHref.searchParams.set("genre", valGenre);
    newHref.searchParams.set("hui", valYear);
    window.location.href = newHref;
}
