function OnFilmSelectionChange(selectObject) {
    let value = selectObject.value;
    console.log(value);
    let newHref = new URL('http://localhost:8080/choiceFilm');
    newHref.searchParams.set("genre", value);
    window.location.href = newHref;
}
function OnSerialSelectionChange(selectObject) {
    let value = selectObject.value;
    console.log(value);
    let newHref = new URL('http://localhost:8080/choiceSerial');
    newHref.searchParams.set("genre", value);
    window.location.href = newHref;
}