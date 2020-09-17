function ajax(url, metodo, callback, error) {
    var xhr = new XMLHttpRequest();
    xhr.open(metodo, url);
    xhr.addEventListener('load', function() {
        if (xhr.status === 200) {
            if (callback !== null) {
                callback();
            }
        } else {
            error();
        }
    });
    xhr.send();
}

var botonPesimista = document.querySelector("#boton_pe");
botonPesimista.addEventListener('click', function() {
    setTimeout(function() {
        ajax("https://jsonplaceholder.typicode.com/users", "get", actualizarBotonPesimista, errorPe);
    }, 2000);
});

var botonOptimista = document.querySelector("#boton_op");
botonOptimista.addEventListener('click', function() {
    actualizarBotonOptimista();
    ajax("https://jsonplaceholder.typicode.com/users", "get", null, errorOp);
});

function actualizarBotonOptimista() {
    botonOptimista.classList.remove("btn-primary");
    botonOptimista.classList.add("btn-danger");
    //botonPesimista.innerHTML = "No me gusta";
    botonOptimista.setAttribute("disabled", true);
    var contador = document.querySelector(".bd-op");
    contador.innerHTML = Number(contador.innerHTML) + 1;
}

function errorOp(error) {
    botonOptimista.classList.remove("btn-danger");
    botonOptimista.classList.add("btn-primary");
    //botonPesimista.innerHTML = "No me gusta";
    botonOptimista.removeAttribute("disabled");
    var contador = document.querySelector(".bd-op");
    contador.innerHTML = Number(contador.innerHTML) - 1;
}

function actualizarBotonPesimista() {
    botonPesimista.classList.remove("btn-primary");
    botonPesimista.classList.add("btn-danger");
    //botonPesimista.innerHTML = "No me gusta";
    botonPesimista.setAttribute("disabled", true);
    var contador = document.querySelector(".bd-pe");
    contador.innerHTML = Number(contador.innerHTML) + 1;
}

function errorPe(error) {
    botonPesimista.classList.remove("btn-primary");
    botonPesimista.classList.add("btn-primary");
    botonPesimista.removeAttribute("disabled");
    console.log(error);
}

function envioOpSuccess() {
    console.log("Todo OK.");
}