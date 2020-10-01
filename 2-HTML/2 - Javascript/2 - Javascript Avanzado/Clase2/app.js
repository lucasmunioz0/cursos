/*
    document.querySelector
    document.querySelectorAll
    document.getElementById
    document.getElementByTagName
    document.getElementByClassName
*/

var lista = document.querySelector("ul");


for (var i = 0; i < 10; i++) {
    var itemNuevo = document.createElement("li");
    var saltoLinea = document.createElement("br");
    itemNuevo.innerHTML = "Item agregado desde JS " + i;
    lista.appendChild(itemNuevo);
    lista.appendChild(saltoLinea);
}

function clickPrimerBoton() {
    console.log("Click en el primer botón");
}

var botonAzul = document.getElementById("btn_selector");
botonAzul.onclick = clickSegundoBoton;

function clickSegundoBoton() {
    console.log("Click en el segundo botón");
}

var botonWarning = document.querySelector(".btn-warning");
botonWarning.addEventListener("click", clickTercerBoton);

function clickTercerBoton(e) {
    var id = e.target.id;
    console.log("Click en el boton con id: " + id);
}

function foo(e) { console.log(e.target, e.currentTarget) }
document.querySelector("#uno").addEventListener("click", foo)
document.querySelector("#dos").addEventListener("click", foo)
document.querySelector("#tres").addEventListener("click", foo)