function OnSelectionChange(selectObject) {
    let value = selectObject.value;
    console.log(value);
    let newHref = new URL('http://localhost:8080/choice');
    newHref.searchParams.set("genre", value);
    window.location.href = newHref;
}