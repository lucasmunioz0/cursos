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
var items = [
    "Comida chicos 1", "Comida chicos 2", "Comida chicos 3", "Comida chicos 4", "Comida chicos 5", "Comida chicos 6",
];
var Menu = /** @class */ (function () {
    function Menu(items, paginas, display) {
        if (display === void 0) { display = "Menu"; }
        this.items = items;
        this.paginas = paginas;
        this.display = display;
    }
    Menu.prototype.listar = function () {
        var ul = "<h1>" + this.display + "</h1><ul>";
        this.items.forEach(function (item) {
            ul += "<li>" + item + "</li>";
            console.log(item);
        });
        document.getElementById("listado").innerHTML = ul + "</ul>";
    };
    return Menu;
}());
var MenuChicos = /** @class */ (function (_super) {
    __extends(MenuChicos, _super);
    function MenuChicos(items, paginas) {
        var _this = _super.call(this, items, paginas, "Menu de Chicos") || this;
        _this.items = items;
        _this.paginas = paginas;
        return _this;
    }
    return MenuChicos;
}(Menu));
function show(mensaje) {
    document.getElementById("showItems").innerHTML = mensaje;
}
