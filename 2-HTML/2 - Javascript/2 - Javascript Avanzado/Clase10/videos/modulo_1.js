(function() {
    "use strict"

    var y = 1;

    function changeY(value) {
        y = value;
        console.log(y);
    }

    window.modulo1 = changeY;
})()