var inputFile = document.querySelector("input[type=file]");
var vistaPrevia = document.getElementById("vistaPrevia");

inputFile.addEventListener('change', function(e) {

    vistaPrevia.addEventListener('load', function() {
        var dimensiones = document.getElementById("dimensiones");
        dimensiones.innerHTML = vistaPrevia.naturalWidth + " x " + vistaPrevia.naturalHeight;

        window.URL.revokeObjectURL(vistaPrevia.src);
    });

    var url = window.URL.createObjectURL(e.target.files[0]);
    vistaPrevia.setAttribute("src", url);
});