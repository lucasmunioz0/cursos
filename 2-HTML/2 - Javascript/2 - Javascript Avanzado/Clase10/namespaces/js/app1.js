var MI_APLICACION = MI_APLICACION || {};

MI_APLICACION.profesor = {
    nombre: "Lucas",
    apellido: "Muñoz"
}

MI_APLICACION.materia = "Javascript Avanzado";

MI_APLICACION.campos = {
    documento: document.getElementById("documento"),
    nombre: document.getElementById("nombre"),
    apellido: document.getElementById("apellido")
}

MI_APLICACION.estudiante = function(documento, nombre, apellido) {
    this.documento = documento;
    this.nombre = nombre;
    this.apellido = apellido;
}

MI_APLICACION.estudiantes = [];

MI_APLICACION.ingresarEstudiante = function(documento, nombre, apellido) {
    var estudiante = new MI_APLICACION.estudiante(documento, nombre, apellido);
    MI_APLICACION.estudiantes.push(estudiante);
}

MI_APLICACION.mostrarEstudiantes = function() {
    var tbody = document.getElementById("tbody");
    var tabla = "";

    this.estudiantes.forEach(element => {
        var fila = `<tr><td>${element.documento}</td><td>${element.nombre}</td><td>${element.apellido}</td>`;
        tabla += fila;
    });
    tbody.innerHTML = tabla;
}

MI_APLICACION.limpiarCampos = () => {
    MI_APLICACION.campos.documento.value = "";
    MI_APLICACION.campos.nombre.value = "";
    MI_APLICACION.campos.apellido.value = "";
}