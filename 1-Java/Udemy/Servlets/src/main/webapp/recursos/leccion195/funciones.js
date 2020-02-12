function validarForma(forma){
    var usuario = forma.usuario;
    if(usuario.value == "" || usuario.value == "Escribir usuario"){
        alert("Debe ingresar el usuario");
        usuario.focus();
        usuario.select();
        return false;
    }
    var password = forma.password;
    if(password.value == "" || password.value.length < 3){
        alert("Debe ingresar un password al menos de 3 caracteres");
        password.focus();
        password.select();
        return false;
    }
    var tecnologias = forma.tecnologia;
    var checkSeleccionado = false;
    for (var i = 0; i < tecnologias.length; i++){
        if(tecnologias[i].checked){
            checkSeleccionado = true;
            break;
        }
    }
    
    if(!checkSeleccionado){
        alert("Debe seleccionar al menos 1 tecnología");
        return false;
    }
    var genero = forma.genero;
    var radioSeleccionado = false;
    for (var i = 0; i < genero.length; i++){
        if(genero[i].checked){
            radioSeleccionado = true;
            break;
        }
    }
    
    if(!radioSeleccionado){
        alert("Debe seleccionar el género");
        return false;
    }
    
    var ocupacion = forma.ocupacion;
    if(ocupacion.value == ""){
        alert("Debe seleccionar una ocupación");
        return false;
    }
    
    alert("Formulario válido, enviando datos al servidor.");
    return true;
}