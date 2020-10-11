var flag;
flag = false;
function palabrasSonIguales(primerPalabra, segundaPalabra) {
    return primerPalabra == segundaPalabra;
}
var cualquierCosa;
cualquierCosa = "Hola";
cualquierCosa = 3;
var arrayNombres = ["Pepe", "Carlos", "Lucas"];
var arrayNumeros2 = new Array(3);
arrayNumeros2[0] = 1;
arrayNumeros2[1] = 2;
arrayNumeros2[2] = 3;
arrayNombres.forEach(function (e) { return console.log(e); });
arrayNumeros2.forEach(function (e) { return console.log(e); });
var DiaSemana;
(function (DiaSemana) {
    DiaSemana[DiaSemana["Lunes"] = 0] = "Lunes";
    DiaSemana[DiaSemana["Martes"] = 1] = "Martes";
    DiaSemana[DiaSemana["Miercoles"] = 2] = "Miercoles";
    DiaSemana[DiaSemana["Jueves"] = 3] = "Jueves";
    DiaSemana[DiaSemana["Viernes"] = 4] = "Viernes";
})(DiaSemana || (DiaSemana = {}));
;
var hoy = DiaSemana.Lunes;
var otroDiaNumero = 3;
console.log(DiaSemana[hoy]);
console.log(DiaSemana[otroDiaNumero]);
