(function() {
    "use strict"

    var x = true;

    function getX() {
        console.log(x);
    }

    window.modulo2 = getX;
})()