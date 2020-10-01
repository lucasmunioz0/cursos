var f1 = () => {
    console.log("Soy la función uno.")
};

var f2 = () => {
    console.log("Soy la función uno.")
};

function foo(item, callback) {
    console.log(item);
    callback();
}

// foo("Hola", f1);

var uno = document.getElementById("uno");
var dos = document.getElementById("dos");
var tres = document.getElementById("tres");

tres.addEventListener("click", function(e) {
    console.log("click 3");
    //e.stopPropagation();
});

uno.addEventListener("click", function(e) {
    console.log("click 1");
});

var estatico = document.getElementById("estatico");

estatico.addEventListener("click", function() {
    var dinamico = document.createElement("button");
    dinamico.innerHTML = "Dinamico";
    dinamico.id = "dinamico";
    document.body.appendChild(dinamico);
});

document.addEventListener("click", function(e) {
    console.log(e.target.id);
    if (e.target.id === "dinamico") {
        console.log("Esto no tira error");
    }
});

// var dinamico = document.getElementById("dinamico");
// dinamico.addEventListener("click", function(){
//     console.log("Esto tira error");
// });

var parrafo = document.getElementById("parrafo");

window.addEventListener("resize", function() {
    console.log("Cambio el tamaño.");
    parrafo.innerText = `El tamaño del navegador es de: ${window.outerWidth}px de alto * ${window.outerWidth}px y de ancho`;
});

var link = document.getElementById("link");

link.addEventListener("click", function(e) {
    e.preventDefault();

    var flag = confirm("Desea ir al link seleccionado?");
    if (flag) {
        window.location.href = e.target.href;
    }
});