var carritoModulo = (function() {
    let carrito = [];
    const iva = 1.21;
    let tblBody = document.getElementById("tbody");

    function calcularIva(precio) {
        var valor = precio * iva;
        return valor;
    }

    function calcularIvaSinFormato() {
        var valor = precio * iva;
        return valor;
    }
    return {
        additem: function(item) {
            item.precioConIva = calcularIva(item.precio);
            carrito.push(item);
            this.mostrarProductos();
        },
        getItemsTotales: () => {
            return carrito.length;
        },
        getTotalCompra: function() {
            let items = this.getItemsTotales();
            let total = 0;
            carrito.forEach(item => {
                total += item.precio;
            });
            return total;
        },
        mostrarProductos: function() {
            var tabla = "";
            carrito.forEach(item => {
                tabla += `<tr><td>${item.producto}</td><td>${item.precio}</td><td>${item.precioConIva}</td>`;
            });
            tabla += `<tr><td>Total:</td><td></td><td>${this.getTotalCompra()}</td>`

            tblBody.innerHTML = tabla;
        }
    };;
})();