function OnFilmGenreChange(selectObject) {
    let value = selectObject.value;
    console.log(value);
    let newHref = new URL('http://localhost:8080/choiceFilm');
    newHref.searchParams.set("genre", value);
    window.location.href = newHref;
}
function OnSerialGenreChange(selectObject) {
    let value = selectObject.value;
    console.log(value);
    let newHref = new URL('http://localhost:8080/choiceSerial');
    newHref.searchParams.set("genre", value);
    window.location.href = newHref;
}
// function OnFilmYearChange(selectObject) {
//     let value = selectObject.value;
//     console.log(value);
//     let newHref = new URL('http://localhost:8080/choiceFilm');
//     newHref.searchParams.set("year", value);
//     window.location.href = newHref;
// }
let show = true;

function showCheckboxes() {
    let checkboxes =
        document.getElementById("checkBoxes");

    if (show) {
        checkboxes.style.display = "block";
        show = false;
    } else {
        checkboxes.style.display = "none";
        show = true;
    }
}