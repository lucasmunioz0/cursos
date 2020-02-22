var empleados = [
    { nombre: "Juan", apellido: "Pedro", edad: 40, imagen:"../images/empleado01" },
    { nombre: "Ana", apellido: "García", edad: 25, imagen: "../images/empleado02"},
    { nombre: "Maria", apellido: "Zarate", edad: 34, imagen: "../images/empleado04"}
];
var tabla = true;

function armarTabla(){
    var tabla = "<table border='1'><thead><tr><th>Foto</th><th>Nombre</th><th>Apellido</th><th>Edad</th></tr></thead><tbody>";
    empleados.forEach(empleado => {
        tabla += "<tr><td><a data-lightbox='" + empleado.nombre + "' href='" + empleado.imagen  + "-grande.png'><img src='" + empleado.imagen + ".png'></a></td><td>" + empleado.nombre + "</td><td>" + empleado.apellido + "</td><td>" + empleado.edad + "</td></tr>";
    });
    tabla += "</tbody></table>";
    document.querySelector("#tableEmpleados").innerHTML = tabla;
}

function agregar(){
    var nombre = document.querySelector("#nombre").value;
    var apellido = document.querySelector("#apellido").value;
    var edad = document.querySelector("#edad").value;
    var imagen = $("select").val();
    
    if(nombre == "" || apellido == "" || edad == ""){
        document.querySelector("#error").innerHTML = "Datos incorrectos.";
        return;
    }
    var empleado = {nombre: nombre, apellido : apellido, edad : edad, imagen: imagen};
    empleados.push(empleado);
    armarTabla();
    limpiarDatos();
}

function limpiarDatos(){
    document.querySelector("#nombre").value = "";
    document.querySelector("#apellido").value = "";
    document.querySelector("#edad").value = "";
    document.querySelector("#error").innerHTML = "";
}

function mostrarTabla(){
    if(tabla){
        $("#fieldsetEmpleados").hide();
        $("#btnMostrarTabla").val("Mostrar tabla");
        tabla = false;
    }else{
        $("#fieldsetEmpleados").show();
        $("#btnMostrarTabla").val("Ocultar tabla");
        tabla = true;
    }    
}

armarTabla();