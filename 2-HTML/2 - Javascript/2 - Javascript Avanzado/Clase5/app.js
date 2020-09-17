/*
var ajax = new XMLHttpRequest();

Si el método es GET: No se envía parametros o a lo sumo "null"
Si el método es POST: 

5 estados
0 - UNSENT: Objeto inicializado
1 - OPENED: Objeto configurado
2 - HEADERS RECEIVED: El objeto fue enviado al servidor y el header de la respuesta ya volvió.
3 - LOADING: Descargando. ResponseText va a tener datos parciales.
4 - DONE: Operación terminada.

*/

var email = document.querySelector("#email");
var alerta = document.querySelector(".alert");
var objAjax;

email.addEventListener("blur", function() {
    objAjax = new XMLHttpRequest();
    objAjax.onreadystatechange = callback;

    var flag = validateEmail();

    if (flag === "") {
        objAjax.open("get", "http://localhost:3000/?email=" + email.value);
        objAjax.send();
        alerta.classList.add("hide");
    } else {
        alerta.innerHTML = flag;
        alerta.classList.remove("hide");
    }
});

function validateEmail() {
    var flag = "";
    if (email.value.trim() === '') {
        flag = "El mail no puede estar vacío.";
    }

    var regEmail = /^[a-zA-z]+([\.\-_]?\w+)*@[a-zA-z]+([\-_]?\w+)*(\.[a-zA-Z]{2,7})+$/;
    if (flag == "" && !email.value.trim().match(regEmail)) {
        flag = "El mail no tiene un formato válido";
    }

    return flag;
}

function callback() {
    //console.log(objAjax.readyState);

    var status = objAjax.readyState;
    var loading = document.querySelector(".spinner-border");
    loading.classList.remove("hide");
    email.classList.remove("is-valid", "is-invalid");
    if (status === 4) {
        loading.classList.add("hide");
        if (objAjax.status === 200) {
            var respuesta = objAjax.responseText;
            if (respuesta === "no existe") {
                email.classList.add("is-valid");
                alerta.classList.add("hide");
            } else {
                email.classList.add("is-invalid");
                alerta.innerHTML = "El email ya existe en el sistema.";
                alerta.classList.remove("hide");
            }
        } else {
            email.classList.add("is-invalid");
        }
    }
}

var ojbPost;
var grupo = document.getElementById("grupo");

grupo.addEventListener("change", function() {
    ojbPost = new XMLHttpRequest();

    ojbPost.addEventListener("load", listarSuperHeroes);
    ojbPost.addEventListener("error", errorAjax);

    ojbPost.open("post", "http://localhost:3000");
    ojbPost.send(grupo.value);

});


function listarSuperHeroes() {
    if (ojbPost.status !== 200) {
        errorAjax();
    }

    document.getElementById("listado").innerHTML = ojbPost.responseText;
}

function errorAjax() {
    console.log("Se rompió");
}