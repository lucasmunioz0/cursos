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
;
var pepe = {
    apellido: "Sanchez",
    nombre: "Pepe",
    edad: 40,
    saludar: function () {
        console.log("Hola");
    }
};
var Persona = /** @class */ (function () {
    function Persona(apellido, nombre, edad) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
    }
    Persona.prototype.saludar = function () {
        console.log("Me llamo " + this.nombre + ", " + this.apellido + " y tengo " + this.edad + " años.");
    };
    return Persona;
}());
var Empleado = /** @class */ (function (_super) {
    __extends(Empleado, _super);
    function Empleado(apellido, nombre, edad, cargo) {
        if (edad === void 0) { edad = 20; }
        if (cargo === void 0) { cargo = "no soy nada"; }
        var _this = _super.call(this, apellido, nombre, edad) || this;
        _this.cargo = cargo;
        return _this;
    }
    Empleado.prototype.saludar = function () {
        _super.prototype.saludar.call(this);
        console.log("y soy " + this.cargo);
    };
    return Empleado;
}(Persona));
pepe.saludar();
var maria = new Persona("Lopez", "Maria", 45);
maria.saludar();
var fernando = new Empleado("Acevedo", "Fernando");
fernando.saludar();
