"use strict";
var suma = function (a, b) {
    return a + b;
};
//Función Flecha
//let sumaFlecha = (a: number, b: number) => {return a + b };
//En caso de que el cuerpo tenga una sola linea, es posible omitir las llaves y la palabra "return"
var sumaFlecha = function (a, b) { return a + b; };
var obtenerNombre = function () {
    return "Juan Perez";
};
//Ejemplo 2
var obtenerNombreFlecha = function () { return "Juan Perez"; };
//Ejecución
console.log(suma(5, 3));
console.log(sumaFlecha(3, 2));
console.log(obtenerNombreFlecha());
