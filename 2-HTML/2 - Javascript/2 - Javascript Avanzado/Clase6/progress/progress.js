/*
Eventos: 
    - loadstart
    - progress
    - error
    - load
    - loadend

1 - loadstart
2 - progress: Se puede repetir
3 - load
4 - loadend
*/

var botonOk = document.querySelector(".xhr-success");
var botonError = document.querySelector(".xhr-error");
var botonAbort = document.querySelector(".xhr-abort");
var textArea = document.getElementById("log-evento");
var progress = document.getElementById("file");
var labelProgress = document.getElementById("muestra");

function manejarEvento(evento) {
    //total - loaded
    var porcentaje = Number(Math.round((evento.loaded / evento.total) * 100));
    console.log(porcentaje);
    progress.value = porcentaje;
    labelProgress.innerHTML = porcentaje;
    textArea.value = textArea.value + "\n" + `${evento.type}: ${evento.loaded} Bytes transferidos`;
}

function addListeners(xhr) {
    xhr.addEventListener('loadstart', manejarEvento);
    xhr.addEventListener('progress', manejarEvento);
    xhr.addEventListener('load', manejarEvento);
    xhr.addEventListener('loadend', manejarEvento);
    xhr.addEventListener('error', manejarEvento);
    xhr.addEventListener('abort', manejarEvento);
}

function armarXHR(url) {
    var xhr = new XMLHttpRequest();
    addListeners(xhr);
    xhr.open("get", url);
    xhr.send();
    return xhr;
}

botonOk.addEventListener('click', function() {
    textArea.value = '';
    armarXHR('Test.mp4');
});

botonError.addEventListener('click', function() {
    textArea.value = '';
    armarXHR('noexiste.jpg');
});

botonAbort.addEventListener('click', function() {
    textArea.value = '';
    armarXHR('imagen.jpg').abort();
});