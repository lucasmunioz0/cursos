// let xhr = new XMLHttpRequest();
// xhr.open("get", "https://jsonplaceholder.typicode.com/users");
// xhr.addEventListener("load", () => {
//     if (xhr.status == 200) {
//         let respuesta = JSON.parse(xhr.response);
//         JSON.stringify
//         console.log(typeof respuesta);
//         console.log(respuesta);
//     }
// });

let xhr = new XMLHttpRequest();
xhr.open("get", "https://glosbe.com/gapi/translate?from=es&dest=en&phrase=hola&format=json");
xhr.addEventListener("load", () => {
    if (xhr.status == 200) {
        let respuesta = JSON.parse(xhr.response);
        JSON.stringify
        console.log(typeof respuesta);
        console.log(respuesta);
    }
});

xhr.send();