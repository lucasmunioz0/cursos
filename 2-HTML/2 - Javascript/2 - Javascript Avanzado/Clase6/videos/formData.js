let form = document.querySelector("form");
let valores;

form.addEventListener("submit", (e) => {
    e.preventDefault();
    let data = new FormData(form);
    valores = data.values();
    console.log(valores);
});