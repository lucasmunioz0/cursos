let promesa = fetch("info.txt");

promesa
    .then(valor => {
        return valor.text();
    })
    .then(valor => {
        console.log(valor);
    })