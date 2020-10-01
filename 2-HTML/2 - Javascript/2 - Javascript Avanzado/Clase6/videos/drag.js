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

function manejarArchivos(archivos) {
    console.log(archivos);
}