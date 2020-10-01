//1)Asignarle un evento de load a la imagen del gif para que cuando haya terminado de cargar realicemos entonces un pedido por ajax para ir a buscar los contenidos del archivo home.html
//2)Al finalizar el pedido se deberá mostrar el contenido del resultado dentro del elemento <main>
//3)Asignarle un evento de click a cada link del <nav> para que cada uno pueda pedir por ajax los contenidos de los archivos que les corresponden. Para esto recordar que :
//3.1)Hay que cancelarles el evento default
//3.2)El callback para pedir los archivos de cada link debe ser el mismo para los tres casos
//Bonus 
//4)Refactorizar el programa tal que nos quede una funcion llamada ajax que tome como parametros 
//4.1)String Url : la url para usar en el pedido
//4.2)String Metodo : el metodo HTTP del pedido
//5)Refactorizar la funcion ajax creada en el punto anterior para que ademas tome como ultimo parametro una funcion Function callback? opcional que sera usada en el evento load pasandole la respuesta del objeto XHR por defecto
//6)Crear una funcion llamada render que tome como parametros :
//6.1)String Selector : el selector a donde va a ser renderizada la informacion
//6.2)String Data : La informacion para mostrar en el html
//La misma debe ser utilizada en nuestra funcion anterior como parametro para mostrar los resultados del ejercicion 3

let loader = document.getElementById("loader");
let main = document.querySelector("main");
let xhr;

if (loader.complete) {
    ajax("get", "home.html", function(data) {
        render(main, data);
        history.pushState({
            template: data
        }, "", "home");
    });
} else {
    loader.addEventListener("load", function(e) {
        console.log("Loaded!");
    });
}

document.addEventListener("click", (e) => {
    e.preventDefault();
    if (e.target.tagName === "A") {
        e.preventDefault();
        let id = e.target.id;
        // location.hash = e.target.id; /* Utilizando hash */
        ajax("get", id + ".html", function(data) {
            render(main, data);
            history.pushState({
                template: data
            }, "", id); /* Utilizando History API */
        });
    }
});

function ajax(metodo, url, callback) {
    xhr = new XMLHttpRequest();
    xhr.open(metodo, url);
    xhr.addEventListener("load", function() {
        if (xhr.status == 200) {
            callback(xhr.response);
        }
    });
    xhr.send();
}

function render(selector, data) {
    selector.innerHTML = data;
}


/* Utilizando hash */
// window.addEventListener("hashchange", function() { 
//     let url = location.hash.replace("#", '') + ".html";

//     ajax("get", url, function(data) {
//         render(main, data);
//     });
// });

/* Utilizando el History API */
window.addEventListener("popstate", function(e) {
    console.log(e.state);
    let split = location.pathname.split("/");
    let url = split[split.length - 1] + ".html";
    console.log(url);
    if (e.state.template) {
        render(main, e.state.template);
    } else {
        ajax("get", url, function(data) {
            render(main, data);
        });
    }
})