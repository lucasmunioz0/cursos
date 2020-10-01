function Menu(entrada) {
    this.entrada = entrada;
    this.servirMenu = function() {
        return `El menu de hoy consiste en ${this.entrada}, ${this.plato_principal} y ${this.postre}`;
    }
}

Menu.prototype.plato_principal = "Milanesa con pure";
Menu.prototype.postre = "Flan con dulce de leche";

var menu1 = new Menu("Vittel Tone");;