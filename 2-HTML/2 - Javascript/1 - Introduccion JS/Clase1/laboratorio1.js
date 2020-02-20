function testA() {
    var x = 10;
    var y = 20;
    x = x + x + 1;
    y = y - y - x;
    var result = "Test A\nX estimado/X resultante: 21/" + x + "\nY estimado/Y resultante: -21/" + y;
    alert(result);
}

function testB() {
    var x = 10;
    var y = 20;
    x = (x - y) + 4;
    y = 4 + (y + 5);
    var result = "Test B\nX estimado/X resultante: -6/" + x + "\nY estimado/Y resultante: 29/" + y;
    alert(result);
}

function testC() {
    var x = 10;
    var y = 20;
    x = x * 2 - 4;
    y = 4 - y * 2;
    var result = "Test C\nX estimado/X resultante: 16/" + x + "\nY estimado/Y resultante: -36/" + y;
    alert(result);
}

function testD() {
    var x = 10;
    var y = 20;
    x = (20 - x) / y;
    y = x + 2 / y;
    var result = "Test D\nX estimado/X resultante: 0.5/" + x + "\nY estimado/Y resultante: 0.6/" + y;
    alert(result);
}

function testE() {
    var x = 10;
    var y = 20;
    x = ((1 - x) * (y / 8)) * 4 * 0; 
    y = (x + 3) / x;    
    var result = "Test E\nX estimado/X resultante: 0/" + x + "\nY estimado/Y resultante: Infinity/" + y;
    alert(result);
}