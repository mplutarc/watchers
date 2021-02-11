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
    newHref.searchParams.set("year", valYear);
    window.location.href = newHref;
}