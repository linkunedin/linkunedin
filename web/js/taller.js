function validarLogin(form) {
    var isValid = true;
    var descErrors = "";
    if (form.email.value == "") {
        descErrors += "El correo no puede estar vacio<br>";
        isValid = false;
    }
    if (form.password.value == "") {
        descErrors += "La contraseña no puede estar vacia";
        isValid = false;
    }
    if (!isValid) {
        bootbox.alert(descErrors)
    }
    return isValid;
}

function validarRegistro(form) {
    var isValid = true;
    var descErrors = "";
    if (form.nombre.value == "") {
        descErrors += "El nombre no puede estar vacio<br>";
        isValid = false;
    }
    if (form.apellidos.value == "") {
        descErrors += "Los apellidos no pueden estar vacios<br>";
        isValid = false;
    }
    if (form.nif.value == "") {
        descErrors += "El NIF no puede estar vacio<br>";
        isValid = false;
    }
    if (form.email.value == "") {
        descErrors += "El email no puede estar vacio<br>";
        isValid = false;
    }
    if (form.password.value == "") {
        descErrors += "La contraseña no puede estar vacia<br>";
        isValid = false;
    }
    if (!isValid) {
        bootbox.alert(descErrors)
    }
    return isValid;
}

function validarVehiculo(form) {
    var isValid = true;
    var descErrors = "";
    if (form.matricula.value == "") {
        descErrors += "La matricula no puede estar vacia<br>";
        isValid = false;
    }
    if (form.marca.value == "") {
        descErrors += "La marca no puede estar vacia<br>";
        isValid = false;
    }
    if (form.modelo.value == "") {
        descErrors += "El modelo no puede estar vacio<br>";
        isValid = false;
    }    
    
    if (!isValid) {
        bootbox.alert(descErrors)
    }
    return isValid;
}

function validarUsuario(form) {
    var isValid = true;
    var descErrors = "";
    if (form.nombre.value == "") {
        descErrors += "El nombre no puede estar vacio<br>";
        isValid = false;
    }
    if (form.apellidos.value == "") {
        descErrors += "Los apellidos no pueden estar vacios<br>";
        isValid = false;
    }
    if (form.nif.value == "") {
        descErrors += "El NIF no puede estar vacio<br>";
        isValid = false;
    }
    if (form.email.value == "") {
        descErrors += "El email no puede estar vacio<br>";
        isValid = false;
    }
    if (form.password.value == "") {
        descErrors += "La contraseña no puede estar vacia<br>";
        isValid = false;
    }
    if (!isValid) {
        bootbox.alert(descErrors)
    }
    return isValid;
}



