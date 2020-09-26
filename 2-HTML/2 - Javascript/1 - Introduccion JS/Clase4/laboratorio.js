var botones = document.querySelectorAll("div:first-of-type button");
var botones2 = document.querySelectorAll("div:last-of-type button");

for (var i = 0; i < botones.length; i++) {
    botones[i].onclick = function() {
        ejercicio1(this.innerHTML);
    }
}

for (var i = 0; i < botones2.length; i++) {
    botones2[i].onclick = function() {
        ejercicio2(this.innerHTML);
    }
}

function ejercicio1(color) {
    alert(color);
}

function ejercicio2(color) {
    document.querySelector("#ejercicio02").innerHTML = "El color es: " + color;
    document.querySelector("#ejercicio02").style.background = color;
}