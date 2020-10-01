// Promesa: Representacion de un valor eventual.

let promesa = new Promise((resolver, rechazar) => {
    let xhr = new XMLHttpRequest();
    xhr.open("get", "info.txt");
    xhr.addEventListener("load", () => {
        if (xhr.status == 200) {
            resolver(xhr.response);
        }
    });

    xhr.send();
});
promesa
    .then((e) => {
        console.log("Promesa 1 resuelta!", e);
        return new Promise((resolver, rechazar) => {
            let xhr = new XMLHttpRequest();
            xhr.open("get", "info.txt");
            xhr.addEventListener("load", () => {
                if (xhr.status == 200) {
                    resolver(xhr.response + e);
                }
            });

            xhr.send();
        });

    })
    .then((valor) => {
        console.log("Promesa 2 resuelta!", valor)
    })
    .catch((e) => {
        console.log("Error!");
    });