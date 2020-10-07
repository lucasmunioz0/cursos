// // /*
// // Formas de crear un objeto
// // //Funciones constructoras
// // //Create
// // //Literal
// // */


// // let a = {};

// // let prototipo = {
// //     saludo: function() {
// //         console.log("Hola");
// //     }
// // };

// // let b = Object.create(prototipo);

// // let c = {
// //     x: 1
// // }

// // // Configuraciones de un objeto
// // // value - writable - enumerable - configurable
// // let d = Object.create(null, {
// //     x: {
// //         value: 1, // su valor real
// //         writable: false, // admite escritura
// //         enumerable: false, //admite iterabilidad
// //         configurable: false // admite borrado
// //     }
// // });

// // let e = {
// //     nombre: "Lucas",
// //     get nombreCompleto() {
// //         return this.nombre;
// //     },
// //     set name(data) {
// //         this.nombre = data;
// //     },
// // };

// // function Range(from, to) {
// //     this.from = from;
// //     this.to = to;
// // }

// // Range.prototype = {
// //     includes: function(x) {
// //         return x >= this.from && x <= this.to;
// //     }
// // }

// // let test = new Range(10, 20);
// // console.log(test.includes(3));

// // function foo() {
// //     console.log(this);
// // }

// // foo();

// // var persona = {
// //     nombre: "Lucas",
// //     saludo: function() {
// //         console.log(this);
// //     }
// // }

// // persona.saludo();

// // function ctx() {
// //     console.log(this);
// // }

// // ctx(); //window{...}
// // ctx.apply(); // window{...}
// // ctx.call(); //window {...}
// // ctx.apply({ x: 1 }) // {x: 1}
// // ctx.call({ x: 1 }) // {x: 1}

// function Persona(nombre, edad) {
//     this.nombre = nombre;
//     this.edad = edad;
// }

// var juan = new Persona("Juan", 20);
// var maria = new Persona("Maria", 30);

// function persona(nombre, edad) {
//     var p = {
//         nombre: nombre,
//         edad: edad
//     }

//     return p;
// }

// var pepe = persona("Pepe", 20);
// var marta = persona("Marta", 30);

var productoID;

redefinirProducto(5);

console.log(productoID);

function redefinirProducto(ID) {

    var productoID = ID;

}