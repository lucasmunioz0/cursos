var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var hamburguesa = "Hamburguesa";
var calorias = 300;
var saborRico = true;
function informar(comida, calorias) {
    document.getElementById("informar").innerHTML = "Tu " + comida + " tiene " + calorias + " calorias";
}
informar(hamburguesa, calorias);
var Menu = /** @class */ (function () {
    function Menu(list_items) {
        this.hide = true;
        this.display = '';
        this.items = list_items;
    }
    Menu.prototype.listar = function () {
        var _this = this;
        if (this.hide) {
            this.display = "<h3>Nuestro menú para hoy:</h3>";
            this.display += "<ul>";
            this.items.forEach(function (element) {
                _this.display += "<li>" + element + "</li>";
            });
            this.display += "</ul>";
            this.hide = false;
        }
        else {
            this.display = '';
            this.hide = true;
        }
        document.getElementById("menu").innerHTML = this.display;
    };
    return Menu;
}());
var menu = new Menu(['Plato 1', 'Plato 2', 'Plato 3']);
function listar() {
    menu.listar();
}
function listarChicos() {
    menuChicos.listar();
}
var MenuChicos = /** @class */ (function (_super) {
    __extends(MenuChicos, _super);
    function MenuChicos(list_items) {
        var _this = _super.call(this, list_items) || this;
        _this.display = '';
        return _this;
    }
    MenuChicos.prototype.listar = function () {
        var _this = this;
        if (this.hide) {
            this.display = '<h3>Nuestro menu especial para los chicos</h3>';
            this.display += "<ul>";
            this.items.forEach(function (e) {
                _this.display += "<li>" + e + "</li>";
            });
            this.display += "</ul>";
            this.hide = false;
        }
        else {
            this.display = '';
            this.hide = true;
        }
        document.getElementById("menuChicos").innerHTML = this.display;
    };
    return MenuChicos;
}(Menu));
var menuChicos = new MenuChicos(['Plato Chico 1', 'Plato Chico 2', 'Plato Chico 3']);
function obtenerMenuEmpleado(comida) {
    var display = "<p>El Men\u00FA de los empl\u00F1\u00F1eados tienen " + comida.calorias + " calor\u00EDas. Y est\u00E1 compuesta por " + comida.nombre + "</p>";
    document.getElementById("menuEmpleados").innerHTML = display;
}
var helado = {
    nombre: "helado",
    calorias: 300
};
function mostrarMenuEmpleado() {
    obtenerMenuEmpleado(helado);
}
