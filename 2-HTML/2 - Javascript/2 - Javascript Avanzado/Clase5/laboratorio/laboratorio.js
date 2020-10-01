//Continuando con la pagina dinamica que habiamos construido en la clase anterior vamos a intentar controlar el historial del cliente para poder simular una navegacion completa

//3)Cada vez que se modifique el historial, se debe guardar en su estado la respuesta del pedido dentro de un objeto bajo una propiedad llamada template y la url que le corresponda bajo una propiedad llamada url. Podemos bajar el pushState al evento load para tener acceso a la respuesta de la solicitud (*Podemos tener comportamiento erratico) . La funcion ajax va a recibir entonces un cuarto parametro booleano para saber si tiene que modificar el historial o no. 
//4)En caso que nos quede un comportamiento erratico dado que estamos ejecutando una funcion usando la url antes de que cambie y que de hecho si observamos el objeto state del historial tampoco corresponde al estado anterior correcto podemos dejar de ejecutar ajax y simplemente hacer render del contenido de nuestro template guardado en el historial
//5)Refactorizar la funcion callback de ajax para que ademas pueda ejecutar una funcion llamada portfolioLoad. La misma debera ser capaz de reconocer si portfolio es la pagina que se cargo y si lo fue, hara un pedido por ajax a la API de imagenes https://dog.ceo/api/breeds/image/random la cual nos devolvera un JSON con la url de una imagen de perros! Estas imagenes vamos a usarlas como elementos nuevos dentro de cada <article> que se encuentre en la seccion de portfolio

//Bonus
//6)Asignarles un evento de click a cada item dentro de la seccion portfolio para que puedan cargar su propio contenido por AJAX. La seccion de "Listado de usuarios" debe pedir un archivo llamado listado.html y la seccion "Traduccion de palabras" debe cargar un archivo llamado traduccion.html
//7)Refactorizar el callback del punto anterior para que tambien se le pueda asignar un click dinamico al <button> del template de listado.html . El callback de su click debera ir a pedir por GET la siguiente URL : https://jsonplaceholder.typicode.com/users y mostrar un <li> con el nombre de cada usuario dentro del <ul> del mismo template.
//Seleccion de elementos globales
let menu = document.querySelector(".material-icons");
let drawer = document.querySelector("#drawer");
let main = document.querySelector("main");
let links = document.querySelectorAll("a");
let loader = document.querySelector("img");

if (loader.complete) {
    ajax("home.html", "get", function(data) {
        render(main, data);
        history.pushState({
            url: "home",
            template: data
        }, "", "home");
    });
} else {
    loader.addEventListener("load", function(e) {
        console.log("Loaded!");
    });
}

//Animacion del drawer
menu.addEventListener("click", function(e) {
    if (drawer.style.left) {
        drawer.style.left = '';
    } else {
        drawer.style.left = '0px';
    }
});

//Pedidos de ajax
links.forEach(function(link) {
    link.addEventListener("click", function(e) {
        e.preventDefault();
        drawer.style.left = '';
        //1) Modificar el callback de los clicks de cada link para que ademas se cree un nuevo punto en el historial del usuario usando el texto de cada link como nueva url
        ajax(e.target.href, "get", function(data) {
            render(main, data);
            portfolioLoad();
            history.pushState({
                url: e.target.id,
                template: data
            }, "", e.target.id);
        });
    });
});
//Funciones Utilitarias
/*
 *@param url       String   : La url donde hacemos el pedido.
 *@param metodo    String   : El metodo HTTP del pedido.
 *@param callback  Function : La funcion a ejecutar en el evento load .
 */
function ajax(url, metodo, callback) {
    let xhr = new XMLHttpRequest();
    xhr.open(metodo, url);
    xhr.addEventListener("load", function() {
        if (xhr.status == 200) {
            callback(xhr.response);
        }
    })
    xhr.send();
}
/*
 *@param selector    String : El selector donde se le hara render a la informacion
 *@param data        String : La informacion para mostrar
 */
function render(selector, data) {
    selector.innerHTML = data
}
//2)Asignarle a window un evento de popstate para que dentro de su callback podamos volver a solicitar el contenido de la url reflejada. Podemos usar el string ubicado en window.location.pathname que nos da nuestra URL generada en el paso anterior
window.addEventListener("popstate", function(e) {
    let split = location.pathname.split("/");
    let url = split[split.length - 1] + ".html";
    if (e.state && e.state.template) {
        render(main, e.state.template);
    } else {
        ajax("get", url, function(data) {
            render(main, data);
        });
    }
});
//5)Refactorizar la funcion callback de ajax para que ademas pueda ejecutar una funcion llamada portfolioLoad. La misma debera ser capaz de reconocer si portfolio es la pagina que se cargo y si lo fue, hara un pedido por ajax a la API de imagenes https://dog.ceo/api/breeds/image/random la cual nos devolvera un JSON con la url de una imagen de perros! Estas imagenes vamos a usarlas como elementos nuevos dentro de cada <article> que se encuentre en la seccion de portfolio

function portfolioLoad() {
    let articles = document.querySelectorAll("article");
    if (articles) {
        let src = "";
        ajax("https://dog.ceo/api/breeds/image/random", "get", function(data) {
            var json = JSON.parse(data);
            src = json.message;
            articles.forEach(element => {
                var img = document.createElement("img");
                img.alt = "doggy";
                img.src = src;
                element.appendChild(img);
            });
        });
    }
}

document.addEventListener("click", function(e) {
        if (e.target.tagName.toLowerCase() === "footer") {
            var page = "";
            var id = e.target.id;
            if (id) {
                switch (id) {
                    case "listado":
                        page = "listado.html";
                        break;
                    case "traduccion":
                        page = "traduccion.html";
                        break;
                }
                ajax(page, "get", function(data) {
                    render(e.target.parentElement, data);
                });
            }
        } else if (e.target.id === "usuarios") {
            var listado = document.getElementById("listado-usuarios");
            listado.innerHTML = "";
            ajax("https://jsonplaceholder.typicode.com/users", "get", function(data) {
                var fragment = document.createDocumentFragment();
                var json = JSON.parse(data);
                json.forEach(user => {
                    var li = document.createElement("li");
                    li.innerHTML = user.name;
                    fragment.appendChild(li);
                });

                listado.appendChild(fragment);
            });
        }
    })
    //7)Refactorizar el callback del punto anterior para que tambien se le pueda asignar un click dinamico al <button> del template de listado.html . El callback de su click debera ir a pedir por GET la siguiente URL : https://jsonplaceholder.typicode.com/users y mostrar un <li> con el nombre de cada usuario dentro del <ul> del mismo template.