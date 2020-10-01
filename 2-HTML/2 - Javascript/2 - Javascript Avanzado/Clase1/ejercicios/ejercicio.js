function ejercicio1() {
    var ejercicio = document.getElementById("ejercicio1");
    var ul = document.createElement("ul");

    ul.appendChild(createLi(10));
    ejercicio.appendChild(ul);
}

/* Ejercicio 2*/
if (window.outerWidth > 700) {
    document.querySelector("#movil").style.display = 'none'
}

function createLi(size) {
    let fragment = document.createDocumentFragment();
    for (var i = 0; i < size; i++) {
        var li = document.createElement("li");
        li.innerHTML = "Hijo " + (i + 1);
        fragment.appendChild(li);
    }

    return fragment;
}

function ejercicio3() {
    var ejercicio = document.getElementById("ejercicio3");
    var ul = ejercicio.children[0];

    ul.appendChild(createLi(10));
    ejercicio.appendChild(ul);
}

function ejercicio4() {
    var links = document.querySelectorAll("#ejercicio4 a");
    var link_axu = links[0].href;
    links[0].href = links[1].href;
    links[1].href = link_axu;
}

function ejercicio5() {
    var header = document.getElementById("ejercicio5");
    header.style.backgroundColor = "darkBlue";
    var h1 = document.querySelector("#ejercicio5 h1");
    h1.style.color = "red";
}