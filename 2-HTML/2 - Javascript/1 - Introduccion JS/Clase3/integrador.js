var arreglo = [1, 2, 3, 4];
var empleados = [
    { nombre: "Juan", apellido: "Pedro", edad: 40 },
    { nombre: "Ana", apellido: "García", edad: 25 },
    { nombre: "Maria", apellido: "Zarate", edad: 34 }
];
var usuario;
function ejercicio01() {
    document.querySelector("#ejercicio01").innerHTML = arreglo;
}

function ejercicio02() {
    arreglo.push(5);
    document.querySelector("#ejercicio02").innerHTML = arreglo;
}

function ejercicio03() {
    var dato = prompt("Ingrese dato a agregar al arreglo:");
    arreglo.push(dato);
    document.querySelector("#ejercicio03").innerHTML = arreglo;
}

function login(){
    var rol = prompt("Ingrese su rol");
    var acceso = false;
    if(rol == "admin"){
        usuario = prompt("Ingrese su usuario");
        var clave = prompt("Ingrese su clave");
        if(usuario == "pepe" && clave == "123"){
            acceso = true;
        }
    }
    return acceso;
}

function integrador(){
    var acceso = login();
    if(!acceso){
        window.location = "error.html";
    }
    var mensaje = "<p>Hola " + usuario + " bienvenido a nuestra aplicación.</p><br>";
    mensaje += armarTabla();
    document.querySelector("#integrador").innerHTML = mensaje;
}

function armarTabla(){
    var tabla = "<table><tr><th>Nombre</th><th>Apellido</th><th>Edad</th></tr>";
    empleados.forEach(empleado => {
        tabla += "<tr><td>" + empleado.nombre + "</td><td>" + empleado.apellido + "</td><td>" + empleado.edad + "</td></tr>";
    });

    return tabla;
}