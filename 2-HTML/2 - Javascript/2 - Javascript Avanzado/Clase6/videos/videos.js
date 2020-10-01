let progress = document.querySelector("progress");
let p = document.querySelector("p");

var xhr = new XMLHttpRequest();
xhr.responseType = "blob";
xhr.open("get", "imagen.jpg");
//URL
xhr.addEventListener("load", () => {
    if (xhr.status == 200) {
        let imagenBlob = xhr.response;
        let url = URL.createObjectURL(imagenBlob);
        console.log(url);
        document.getElementById("imagen").src = url;
    }
});

xhr.addEventListener("progress", (e) => {
    if (e.lengthComputable) {
        let porcentaje = Number.parseInt(e.loaded * 100 / e.total);
        progress.value = porcentaje;
        p.innerHTML = "Se ha descargado el %" + porcentaje + " del archivo.";
    }
});


//
xhr.send();

//API WEB -> Blob - File
//API WEB -> MediaStream

// let form = document.querySelector("form");
// form.addEventListener("submit", (e) => {
//     e.preventDefault();
//     let valor = form[0].files;
//     console.log(valor);
// })