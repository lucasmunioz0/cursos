class Persona {
    nombre;
    apellido;
    dni;

    constructor(nombre, apellido, dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    saludar() {
        return `Hola mi nombre es ${this.nombre} ${this.apellido} - DNI: ${this.dni}`;
    }
}

class Estudiante extends Persona {
    materia;

    constructor(nombre, apellido, dni, materia) {
        super(nombre, apellido, dni);
        this.materia = materia;
    }

    saludar() {
        return `${super.saludar()} y esta estudiando: ${this.materia}`
    }
}

var variable = "Soy una variable 1";

function saludo() {
    var saludoString = "Hola";

    console.log(this.saludoString);
}

function Auto() {
    this.marca = "Renault";
    console.log(this.marca);
}


var superheroeECS5 = {
    nombre: "",
    apellido: "",
    alterEgo: ""
}

var superman = {};

superman.__proto__ = superheroeECS5;

function Mago(nombre, color) {
    this.nombre = nombre;
    this.color = color;
}

var mago = new Mago("Gandalf", "Gris");

var magogris = {};

magogris.__proto__ = Mago;

var gandalf = new magogris.prototype.constructor("Gandalf", "Gris");