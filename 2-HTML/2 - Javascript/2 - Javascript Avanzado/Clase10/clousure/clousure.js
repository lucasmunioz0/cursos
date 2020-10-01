function crearSumador(x) {
    return function(y) {
        return x + y;
    };
};

var suma5 = crearSumador(5);
var suma10 = crearSumador(10);

document.getElementById("sumador5").innerHTML = suma5(4);
document.getElementById("sumador10").innerHTML = suma10(9);

function identificador() {
    var id = 999;

    return {
        getId: function() { return id },
        setId: function(nuevoId) {
            if (nuevoId > 100 || nuevoId < 10 || typeof nuevoId !== "number") {
                return false;
            } else {
                id = nuevoId;
            }
        }
    }
}

var myId = identificador();