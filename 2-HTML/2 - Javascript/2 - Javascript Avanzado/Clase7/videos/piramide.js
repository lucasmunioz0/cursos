let url = "https://jsonplaceholder.typicode.com"
let btn = document.querySelector("button");

btn.addEventListener("click", () => {
    ajax({
        metodo: "get",
        url: `${url}/users`,
        load: primerCallback
    });
});

function ajax(config) {
    let xhr = new XMLHttpRequest();
    xhr.open(config.metodo, config.url);
    xhr.addEventListener("load", () => {
        if (xhr.status == 200) {
            config.load(JSON.parse(xhr.response));
        }
    });

    xhr.send();
}

let primerCallback = data => {
    let usuario = data[4];
    let id = usuario.id;
    ajax({
        metodo: "get",
        url: `${url}/posts?userId=${id}`,
        load: segundoCallback
    });
}

let segundoCallback = posteos => {
    posteos.forEach(post => {
        ajax({
            metodo: "get",
            url: `${url}/comments?postId=${post.id}`,
            load: tercerCallback
        });
    })
}

let tercerCallback = comentarios => {
    console.log(comentarios);
}