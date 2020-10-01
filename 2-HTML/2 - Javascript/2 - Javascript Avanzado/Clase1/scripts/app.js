if ("hola" === "hola") {
    var hola = "pepe";
}

function miFuncion() {
    var hola2 = "hola2";
    let otraVar2 = "";
    if (hola2 === "hola2") {
        var otraVar = "pepe2";
        otraVar2 = "hecha con let";
    }

    console.log(otraVar);
    console.log(otraVar2);

}

console.log(hola);
miFuncion();

console.clear();

var array = [1, "hola", 3];
var contador = 0;

function sumar(e) {
    contador += e;
}

array.forEach(e => sumar(e));
console.log(contador);
console.clear();

var h1 = document.createElement("h2");
h1.id = "hola";
h1.innerHTML = "Esto es un titulo";
document.body.appendChild(h1);

var p = document.createElement("p");
p.innerHTML = "Esto es un precio: $500";
console.log(p.dataset);
p.dataset.asd = "precio";
console.log(p.dataset);

document.getElementsByTagName("button")[0].addEventListener("click", function() {
    var dateNow = new Date();
    var counter = 1;
    var interval = setInterval(() => {
        var dateInterval = new Date();
        var dif = dateNow.getTime() - dateInterval.getTime();
        console.log(dateNow);
        var Seconds_from_T1_to_T2 = dif / 1000;
        var Seconds_Between_Dates = Math.abs(Seconds_from_T1_to_T2);
        if (Seconds_Between_Dates >= 3) {
            clearInterval(interval);
        }
        document.querySelector("h1").innerHTML = counter++;
    }, 1000);

    setTimeout(() => {
        alert("hola");
        setTimeout(() => {
            document.write("hoola mundo");
        }, 3000);
    }, 4000);
});

var sumar = (num1, num2) => num1 + num2;

console.log(sumar(2, 3));