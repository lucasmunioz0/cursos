var url = "https://spreadsheets.google.com/feeds/cells/1mon3Oyb2Z3VI7w31Oq28yeyUCpJxmOZnbk8ESJVhFhw/od6/public/basic?alt=json";
var url2 = "https://sheet.best/api/sheets/3457c26e-6755-4b80-801c-e26e6dca0620";

// var alumno = {
//     "Alumno": "Lucas Muñoz",
//     "Documento": "37627180",
//     "Materia": "Matematica",
//     "TP": "1",
//     "Cumplio": "Si"
// }

// var alumno2 = {
//     "Alumno": "Lucas Muñoz",
//     "Documento": "37627180",
//     "Materia": "Matematica",
//     "TP": "1",
//     "Cumplio": "Si"
// }

// var alumno3 = {
//     "Alumno": "Lucas Muñoz",
//     "Documento": "37627180",
//     "Materia": "Matematica",
//     "TP": "1",
//     "Cumplio": "Si"
// }

// var alumno4 = {
//     "Alumno": "Lucas Muñoz",
//     "Documento": "37627180",
//     "Materia": "Matematica",
//     "TP": "1",
//     "Cumplio": "Si"
// }


var alumnos = [];

function search() {
    var input = document.querySelector('input[type="number"]').value;
    buscarAlumno(input);
}

function buscarAlumno(dni) {
    var tps = [];

    $.get(url2, function(data) {
        alumnos = data;
    });

    alumnos.forEach(element => {
        if (element.Documento == dni) {
            tps.push(element);
        }
    });

    armarTabla(tps);
}

function armarTabla(alumno) {
    var tbody = document.getElementsByTagName("tbody")[0];

    var tabla = "";
    alumno.forEach(element => {
        var fila = `<tr><td>${element.Materia}</td><td>${element.TP}</td><td>${element.Cumplio}</td>`;
        tabla += fila;
    });
    tbody.innerHTML = tabla;
}


// $.get(url2, function(data) {
//     console.log(data);
// });