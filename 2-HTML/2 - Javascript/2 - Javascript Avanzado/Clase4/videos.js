// let xhr = new XMLHttpRequest();
// //console.log(xhr.readyState);
// xhr.open("get", "text.txt");

// xhr.addEventListener("readystatechange", function() {
//     console.log(xhr.readyState);
//     if (xhr.readyState == 2) {
//         let headers = xhr.getAllResponseHeaders();
//         let tipo = xhr.getResponseHeader("content-type");
//         console.log(headers);
//         console.log(tipo);
//         if (tipo != "text/html") {
//             xhr.abort();
//         }
//     }
// });


/* Ejercicio de timeout */
// xhr.addEventListener("readystatechange", function() {
//     console.log(xhr);
//     if (xhr.readyState == 2) {
//         let headers = xhr.getAllResponseHeaders();
//         let tipo = xhr.getResponseHeader("content-type");
//         //console.log(headers);
//         console.log(tipo);
//         if (tipo != "text/html") {
//             //xhr.abort();
//         }
//     }
// });

// xhr.addEventListener("timeout", () => {
//     console.log("El pedido se ha excedido de tiempo.");
//     console.log(xhr);
// })
// xhr.timeout = 1;



// setTimeout(() => {
//     console.log(xhr.response);
// }, 1000);
// xhr.addEventListener("readystatechange", function() {
//     console.log("Estado actual:" + xhr.readyState);
//     if (xhr.readyState == 4) {
//         console.log(xhr.response);
//     }
// });

// xhr.send();

document.getElementsByTagName("button")[0].addEventListener("click", () => {
    let xhr = new XMLHttpRequest();
    xhr.open("get", "plantilla.html");
    xhr.addEventListener("load", () => {
        if (xhr.status == 200) {
            let plantilla = xhr.response;
            let div = document.createElement("div");
            div.innerHTML = plantilla;
            document.body.appendChild(div);
        }
    });

    xhr.send();
});