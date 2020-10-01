var MI_APLICACION = MI_APLICACION || {};

MI_APLICACION.validadores = function() {
    var valido = true;
    //is-invalid valid boostrap

    for (var campo in this.campos) {
        this.campos[campo].classList.remove("is-invalid");
        if (this.campos[campo].value.trim() === "") {
            this.campos[campo].classList.add("is-invalid");
            valido = false;
        }
    }

    return valido;
}