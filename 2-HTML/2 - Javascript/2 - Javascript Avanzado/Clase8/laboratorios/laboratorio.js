/*Ejercicio 1: Crear un objeto literal bajo la variable usuario que contenga un método que va a ser compartido
por todos los objetos que se creen a partir de esa interfaz
*/
var usuarioTemplate = {
    login: function() {
        console.log("Logeado");
    },
    /* 
    Ejercicio 3: Crear dos métodos adicionales en el objeto usuario que se llamen crear y extender. Cada
    función debe retornar una instancia de un objeto nuevo vacío cuyo prototipo sea el contexto de
    la misma función.
    */
    crear: function() {
        return Object.create(this.__proto__);
    },
    extender: function(propiedades) {
        return Object.create(this.__proto__);
    }
}

/* 
Ejercicio 2: Usar el método create del objeto Object para crear dos objetos cuyo prototipo sea un usuario
*/
var usuario1 = Object.create(usuarioTemplate);
var usuario2 = Object.create(usuarioTemplate);