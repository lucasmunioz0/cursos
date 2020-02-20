function test1A() {
    var x = 10;
    var y = 20;
    x = x + x + 1;
    y = y - y - x;
    var result = "Test 1A\nX estimado/X resultante: 21/" + x + "\nY estimado/Y resultante: -21/" + y;
    alert(result);
}

function test1B() {
    var x = 10;
    var y = 20;
    x = (x - y) + 4;
    y = 4 + (y + 5);
    var result = "Test 1B\nX estimado/X resultante: -6/" + x + "\nY estimado/Y resultante: 29/" + y;
    alert(result);
}

function test1C() {
    var x = 10;
    var y = 20;
    x = x * 2 - 4;
    y = 4 - y * 2;
    var result = "Test 1C\nX estimado/X resultante: 16/" + x + "\nY estimado/Y resultante: -36/" + y;
    alert(result);
}

function test1D() {
    var x = 10;
    var y = 20;
    x = (20 - x) / y;
    y = x + 2 / y;
    var result = "Test 1D\nX estimado/X resultante: 0.5/" + x + "\nY estimado/Y resultante: 0.6/" + y;
    alert(result);
}

function test1E() {
    var x = 10;
    var y = 20;
    x = ((1 - x) * (y / 8)) * 4 * 0;
    y = (x + 3) / x;
    var result = "Test 1E\nX estimado/X resultante: 0/" + x + "\nY estimado/Y resultante: Infinity/" + y;
    alert(result);
}

function test2A() {
    var palabra1 = "hola";
    var palabra2 = "chau";
    var frase = "";
    frase = palabra1 + " mundo";
    var result = "Test 2A\nPalabra1 estimado/Palabra1 resultante: hola/" + palabra1 + "\nPalabra2 estimado/Palabra2 resultante: chau/" + palabra2 + "\nFrase estimada/Frase resultante: hola mundo/" + frase;
    alert(result);
}

function test2B() {
    var palabra1 = "hola";
    var palabra2 = "chau";
    var frase = "";
    palabra1 = palabra2;
    palabra2 = palabra1;
    frase = "frase nueva";
    var result = "Test 2B\nPalabra1 estimado/Palabra1 resultante: chau/" + palabra1 + "\nPalabra2 estimado/Palabra2 resultante: chau/" + palabra2 + "\nFrase estimada/Frase resultante: frase nueva/" + frase;
    alert(result);
}

function test2C() {
    var palabra1 = "hola";
    var palabra2 = "chau";
    var frase = "";
    palabra1 = palabra1 + " " + palabra2;
    palabra2 = palabra2 + " " + palabra2;
    frase = palabra2 + " y " + palabra2;
    var result = "Test 2C\nPalabra1 estimado/Palabra1 resultante: hola chau/" + palabra1 + "\nPalabra2 estimado/Palabra2 resultante: chau chau/" + palabra2 + "\nFrase estimada/Frase resultante: chau chau y chau chau/" + frase;
    alert(result);
}

function test2D() {
    var palabra1 = "hola";
    var palabra2 = "chau";
    palabra1 = "1+1";
    palabra2 = "2/0";
    frase = palabra1 + "=2";
    var result = "Test 2C\nPalabra1 estimado/Palabra1 resultante: 1+1/" + palabra1 + "\nPalabra2 estimado/Palabra2 resultante: 2/0/" + palabra2 + "\nFrase estimada/Frase resultante: 1+1=2/" + frase;
    alert(result);
}

function ejercicio3() {
    var edad = prompt("Ingrese su edad");
    var nombre = prompt("Ingrese su nombre");
    var apellido = prompt("Ingrese su apellido");

    alert("El nombre del usuario completo es: " + apellido + ", " + nombre + " y tiene " + edad + " años.");
}

function ejercicio4() {
    var edad = prompt("Ingrese su edad");
    var nombre = prompt("Ingrese su nombre");
    var apellido = prompt("Ingrese su apellido");
    document.getElementById("ejercicio4").innerHTML = "<p>El nombre del usuario completo es: " + apellido + ", " + nombre + " y tiene " + edad + " años.</p>";
}

function ejercicio5() {
    var sueldo = prompt("¿Cuál es tu sueldo?");
    var bonus = prompt("¿Cuánto fue tu bonus de este mes?");
    try {
        if(Number.isNaN(parseFloat(sueldo)) || Number.isNaN(parseFloat(bonus))){
            throw error;
        }
        var resultado = parseFloat(sueldo) + parseFloat(bonus);
        document.getElementById("ejercicio5").innerHTML = "<p>El resultado final de tu sueldo es: $" + resultado + "</p>";
    } catch (error) {
        document.getElementById("ejercicio5").innerHTML = "<p style='color:red'>ERROR: Por favor ingrese solamente números.</p>";
    }
}