var empleados = [
    { nombre: "Juan", apellido: "Pedro", edad: 40 },
    { nombre: "Ana", apellido: "García", edad: 25 },
    { nombre: "Maria", apellido: "Zarate", edad: 34 }
];

function armarTabla(){
    var tabla = "<table border='1'><thead><tr><th>Nombre</th><th>Apellido</th><th>Edad</th></tr></thead><tbody>";
    empleados.forEach(empleado => {
        tabla += "<tr><td>" + empleado.nombre + "</td><td>" + empleado.apellido + "</td><td>" + empleado.edad + "</td></tr>";
    });
    tabla += "</tbody></table>";
    document.querySelector("#tableEmpleados").innerHTML = tabla;
    return tabla;
}

function agregar(){
    var nombre = document.querySelector("#nombre").value;
    var apellido = document.querySelector("#apellido").value;
    var edad = document.querySelector("#edad").value;
    
    if(nombre == "" || apellido == "" || edad == ""){
        document.querySelector("#error").innerHTML = "Datos incorrectos.";
        return;
    }
    var empleado = {nombre: nombre, apellido : apellido, edad : edad};
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