let suma = function (a: number, b: number) {
    return a + b;
};
//Función Flecha
//let sumaFlecha = (a: number, b: number) => {return a + b };
//En caso de que el cuerpo tenga una sola linea, es posible omitir las llaves y la palabra "return"
let sumaFlecha = (a: number, b: number) => a + b ;

var obtenerNombre = function(){
    return "Juan Perez";
}
//Ejemplo 2
var obtenerNombreFlecha = () => "Juan Perez";

//Ejecución
console.log(suma(5, 3));
console.log(sumaFlecha(3, 2));
console.log(obtenerNombreFlecha());