let divDrop = document.getElementById("drop");
let input = document.getElementById("texto");

input.addEventListener("change", (e) => {
    manejarArchivos(input.files);
});

divDrop.addEventListener("dragenter", (e) => {
    e.preventDefault();
});

divDrop.addEventListener("dragleave", (e) => {
    e.preventDefault();
});

divDrop.addEventListener("dragover", (e) => {
    e.preventDefault();
});

divDrop.addEventListener("drop", (e) => {
    e.preventDefault();
    manejarArchivos(e.dataTransfer.files);
});

let data;

function manejarArchivos(archivos) {
    data = new FormData();

    for (var i = 0; i < archivos.length; i++) {
        data.append(`imagen-${i}`, archivos[i]);
    }
    let xhr = new XMLHttpRequest();
    xhr.open("post", "url");
    //xhr.setRequestHeader("content-type", "?");
    xhr.send(data);
    console.log(data);
}