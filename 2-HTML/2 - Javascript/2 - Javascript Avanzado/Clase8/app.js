var objeto = {
    propiedad1: 'valor',
    propiedad2: 322143,
    propiedad3: [1, 'hola', true],
    propiedad4: false,
    propiedad5: function() {
        console.log('Hola!')
    },
    propiedad6: {
        innerPropiedad1: 'Hola',
        innerPropiedad2: 2323
    }
};


objeto.propiedad3.forEach(item => console.log(item));

console.clear();
var alterEgo = "Alter ego";

var superman = {
    nombreCompleto: "Clark Kent",
    alterEgo: "Superman",
    presentarse: function() {
        var alterEgo = "pepe";

        return `Hola yo soy ${alterEgo} o con this ${this.alterEgo} pero vivo bajo el seudónimo de ${this["nombre completo"]}`
    },
    imprimirAlcance: function() {
        return this;
    }
};

function villano() {
    console.log(this.alterEgo);
}

function Mago(nombre, color, esBueno) {
    this.nombre = nombre;
    this.color = color;
    this.esBueno = esBueno;
}

var gandalf = new Mago("Gandalf", "Gris", true)
var gandalf = new Mago("Saruman", "Blanco", false)

var variableLoca = "kajajaajaja";

let variableNoTanLoca = "jajaja";
const variableQueNoEsVariable = 23234234234;

function funcionLocal() {
    console.log(this);
}

var Persona = Object.create({});

var Estudiante = new Object();

/*
---- DATA DESCRIPTORS ----
1 - Configurable: true/false (borrar o no la propiedad)
2 - Enumerable: true/false (Establecemos si se muestra cada vez que enumeremos las propiedades del objeto)
3 - Value: Es el valor asociado a una propiedad, puede ser de cualquier tipo soportado por JS.
4 - Writable: true/false (Capacidad de cambiar el valor almacenado en el atributo)

--- ACCESS DESCRIPTORS ----
1 - get
2 - set
*/

var superHeroe = {};
var superHeroe2 = {};

Object.defineProperty(superHeroe, "nombre", {
    value: "Batman",
    writable: true,
    enumerable: true,
    configurable: true
});

Object.defineProperty(superHeroe, "nombreCompleto", {
    value: "Brus Wayne",
    writable: false,
    enumerable: true,
    configurable: true
});
Object.defineProperty(superHeroe2, "nombre", {
    value: "Batman",
    writable: true,
    enumerable: true,
    configurable: true
});

Object.defineProperty(superHeroe2, "nombreCompleto", {
    value: "Brus Wayne",
    writable: false,
    enumerable: true,
    configurable: true
});

superHeroe.nombreCompleto = "Diana Prince";

var villano = "Oswald Cabblepot";
Object.defineProperty(superHeroe, "villano", {
    get() {
        return villano;
    },
    set(nuevoVillano) {
        if (nuevoVillano === 'Lex Luthor') {
            return false;
        }
        villano = nuevoVillano;
    }
});

var numero1 = "lele";
var numero2 = numero1;

var objetoClon1 = {
    propiedad: "Hola"
};

var objetoClon2 = Object.assign({}, objetoClon1);