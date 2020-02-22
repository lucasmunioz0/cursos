function login(){
    var rol = document.querySelector("#rol").value;
    var usuario = document.querySelector("#usuario").value;
    var clave = document.querySelector("#clave").value;
    var acceso = false;
    if(rol == "admin" && usuario == "pepe" && clave == "123"){
        alert("Hola " + usuario + " bienvenido al sistema");
        window.location = "paginas/empleados.html";
    }else{
        window.location = "paginas/error.html";
    }
}