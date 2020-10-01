var btnMenu = document.getElementsByClassName("material-icons")[0];
var links = document.getElementsByTagName("a");

document.addEventListener("click", function(e) {
    var target = e.target;
    var tag = target.tagName;


    if (tag === "A" || target.classList.contains("material-icons")) {
        if (tag === "A") {
            e.preventDefault();
            document.getElementsByTagName("article")[0].innerHTML = textos[target.attributes.href.value];
        }
        var left = document.getElementById("drawer").style.left;
        document.getElementById("drawer").style.left = left ? "" : "0px";
    }
});

document.addEventListener("submit", function(e) {
    e.preventDefault();
    var nombre = document.getElementById("nombre").value;
    var titulo = document.getElementById("titulo").value;
    var mensaje = document.getElementById("mensaje").value;
    var fragment = document.createDocumentFragment();
    var li = document.createElement("li");
    li.innerHTML = `${nombre} - ${titulo}: ${mensaje}`;
    document.getElementsByTagName("ul")[0].appendChild(li);
})

window.addEventListener("resize", function(e) {
    var doc = document.getElementsByTagName("body")[0];
    doc.style.backgroundColor = window.innerWidth > 600 ? "red" : "blue";
});