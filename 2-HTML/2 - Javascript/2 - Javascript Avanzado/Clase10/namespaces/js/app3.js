var MI_APLICACION = MI_APLICACION || {};

document.getElementById("form_alta").addEventListener("submit", (e) => {
    e.preventDefault();
    var flag = MI_APLICACION.validadores();

    if (flag) {
        var documento = MI_APLICACION.campos.documento.value;
        var nombre = MI_APLICACION.campos.nombre.value;
        var apellido = MI_APLICACION.campos.apellido.value;
        MI_APLICACION.ingresarEstudiante(documento, nombre, apellido);
        MI_APLICACION.limpiarCampos();
        MI_APLICACION.mostrarEstudiantes();
    }
});

document.querySelector("#span_materia").innerHTML = MI_APLICACION.materia;
document.querySelector("#span_profesor").innerHTML = `${MI_APLICACION.profesor.nombre} ${MI_APLICACION.profesor.apellido}`;