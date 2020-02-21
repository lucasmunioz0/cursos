function ejercicio01() {
    var fecha = new Date();
    var dia = fecha.getDay();
    switch (dia) {
        case 0:
            alert("Hoy es: domingo!");
            break;
        case 1:
            alert("Hoy es: lunes!");
            break;
        case 2:
            alert("Hoy es: martes!");
            break;
        case 3:
            alert("Hoy es: miercoles!");
            break;
        case 4:
            alert("Hoy es: jueves!");
            break;
        case 5:
            alert("Hoy es: viernes!");
            break;
        case 6:
            alert("Hoy es: sabado!");
            break;
    }
}

function integrador() {
    var error = false;
    var rol = prompt("¿Cuál es su rol?");
    if (rol == "dev") {
        var clave = prompt("¿Cuál es su clave?");
        var usuario = prompt("¿Cuál es su nombre de usuario?");
        if (usuario != "pepe" && clave != "123") {
            error = true;
        }
    } else {
        error = true;
    }

    var titulo = document.getElementById("saludo");
    var errorMsg = document.getElementById("error");
    if (error) {        
        errorMsg.innerHTML = "A habido un error, pregunte a su supervisor rol y contraseña correctas";
        titulo.innerHTML = "";
    } else {
        titulo.innerHTML = "Hola " + usuario + " bienvenido a nuestra aplicación.";
        errorMsg.innerHTML = "";
    }
}
