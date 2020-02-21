var arreglo = [1, 2, 3, 4];
var usuario;
function ejercicio01() {
    document.querySelector("#ejercicio01").innerHTML = arreglo;
}

function ejercicio02() {
    arreglo.push(5);
    document.querySelector("#ejercicio02").innerHTML = arreglo;
}

function ejercicio03() {
    var dato = prompt("Ingrese dato a agregar al arreglo:");
    arreglo.push(dato);
    document.querySelector("#ejercicio03").innerHTML = arreglo;
}