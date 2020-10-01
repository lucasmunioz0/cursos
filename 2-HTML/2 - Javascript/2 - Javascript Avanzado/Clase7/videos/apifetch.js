let url = "https://jsonplaceholder.typicode.com";

let primer_fetch = fetch(`${url}/users`);
primer_fetch
    .then(valor => valor.json())
    .then(valor => {
        let userId = valor[4].id;
        return fetch(`${url}/posts?userId=${userId}`)
    })
    .then(valor => valor.json())
    .catch(err => {
        console.log(err);
    })
    .finally(() => {
        console.log("finalmente")
    })