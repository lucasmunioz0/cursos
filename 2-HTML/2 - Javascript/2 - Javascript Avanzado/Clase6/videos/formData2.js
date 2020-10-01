let form = document.querySelector("form");

var botton = document.getElementById("btnForm2");
let data;
let keys;
botton.addEventListener("click", (e) => {
    data = new FormData();

    for (var i = 0; i < 10; i++) {
        data.append(`param[${i}]`, i);
    }

    valores = data.values();
    keys = data.keys();
    console.log(data);
    console.log(valores);
});