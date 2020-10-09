let flag:boolean;
flag = false;

function palabrasSonIguales(primerPalabra:string, segundaPalabra:string):boolean{
    return primerPalabra == segundaPalabra;
}

let cualquierCosa : any;

cualquierCosa = "Hola";
cualquierCosa = 3;

let arrayNombres : Array<String> = ["Pepe", "Carlos", "Lucas"];

var arrayNumeros2 = new Array < number > (3);
arrayNumeros2[0] = 1;
arrayNumeros2[1] = 2;
arrayNumeros2[2] = 3;

arrayNombres.forEach(e => console.log(e));
arrayNumeros2.forEach(e => console.log(e));

enum DiaSemana {Lunes, Martes, Miercoles, Jueves, Viernes};
enum Permisos {LOGIN = 1, AMBC_USER = 100};

var hoy: DiaSemana = DiaSemana.Lunes;
var otroDiaNumero: DiaSemana = 3;

console.log(DiaSemana[hoy]);
console.log(DiaSemana[otroDiaNumero]);