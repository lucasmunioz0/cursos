var edad = document.querySelector("#edad");
var numeros = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"];

edad.addEventListener('keypress', function(evento) {
    var key = evento.key;
    console.log(key);

    if (numeros.includes(key)) {
        console.log(key);
    } else {
        evento.preventDefault();
        console.log("No es un numero");
    }
});

var form = document.getElementById("form");

form.addEventListener("submit", evento => {
    evento.preventDefault();
    var color = document.querySelector("#color");
    var valido = true;

    console.log(color.value.length.trim);
    if (color.value.trim() === '') {
        color.className = 'error';
        valido = false;
    } else {
        color.classList.remove("error");
    }

    var comentarios = document.getElementById("comentarios");
    if (comentarios.value.trim() == '' || comentarios.value.length > 120) {
        comentarios.classList.add("error");
        valido = false;
    } else {
        comentarios.classList.remove("error");
    }

    var regEmail = /^[a-zA-z]+([\.\-_]?\w+)*@[a-zA-z]+([\-_]?\w+)*(\.[a-zA-Z]{2,7})+$/;
    var email = document.getElementById("email");
    if (!email.value.trim().match(regEmail)) {
        email.classList.add("error");
        valido = false;
    } else {
        email.classList.remove("error");
    }


    if (valido) {
        form.submit();
    }
});


var saludo = "hola";

if (saludo == "Hola") {
    console.log("Son iguales");
} else {
    console.log("No son iguales");
}

/*
Función match => strings (entre comillas)
Función test => expresión regular (entre //)
*/
var exp1 = /[Jj]avascript/;
var cadena = "Javascript";
if (exp1.test(cadena)) {
    console.log("La cadena cumple con el patrón definido por la expresión regular");
} else {
    console.error("La cadena no cumple con el patrón definido por la expresión regular");
}

if (cadena.match(exp1)) {
    console.log("La cadena cumple con el patrón definido por la expresión regular");
} else {
    console.error("La cadena no cumple con el patrón definido por la expresión regular");
}

/*
  \w => letras [A-Za-z]
  \d => números [0-9]
  * => equivale a 0 o mas veces
  + => equivale a 1 o mas veces
  ? => equivale a 0 o 1 vez
  . => equivale a un caracter

  https://www.atareao.es/tutorial/terminal/comodines-y-expresiones-regulares/
*/

var exp2 = /\d/;
console.log(exp2.test("aa2bb"));

var exp3 = /\d{1,3}/;
var exp4 = /\d+/;
var exp5 = /a\d+a/;
console.log(exp3.test("aa2bb2"));
console.log(exp3.test("aa243bb2"));
console.log(exp3.test("aa243234234234234234bb2"));
console.clear();
console.log(exp5.test("a2222a"));
console.log(exp5.test("aa"));

var exp6 = /a\d*a/;
console.log(exp6.test("a2222a"));
console.log(exp6.test("aa"));

//validar email: lucas.munioz@hotmail.com