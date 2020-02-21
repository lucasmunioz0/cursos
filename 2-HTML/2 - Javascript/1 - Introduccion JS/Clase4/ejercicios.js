function ejercicio1(color){
    alert(color);
}

function ejercicio2(color){
    document.querySelector("#ejercicio02").innerHTML = "El color es: " + color;
    document.querySelector("#ejercicio02").style.background = color;
}