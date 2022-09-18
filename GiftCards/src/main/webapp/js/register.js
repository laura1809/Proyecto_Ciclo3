$(document).ready(function () {
        $("#userRegister-form").submit(function (event) {
            event.preventDefault();
            registrarUsuario();
        });
        
        $("#adminRegister-form").submit(function (event) {
            event.preventDefault();
            registrarAdmin();
        });
    });

function registrarUsuario() {

    let username = $("#username").val();
    let contrasena = $("#password").val();
    let nombre = $("#name").val();
    let apellido = $("#lastName").val();
    let email = $("#email").val();
    let confirmarContrasena = $("#confirmPassword").val();
    let saldo = 0;
    let cargo ="Cliente";
    
    if(contrasena == confirmarContrasena){
                $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioRegister",
        data: $.param({
            username: username,
            contrasena: contrasena,
            nombre:nombre,
            apellido: apellido,
            email:email,
            saldo: saldo,
            cargo :cargo
        }),
        success: function (result) {

            let parsedResult = JSON.parse(result);
            
            if (parsedResult != false) {
                let username = parsedResult['username'];
                alert("Registro exitoso");
                document.location.href = "index.html?username=" + username;
            } else {
                alert("Hubo un error con tu registro");
            }
        },
        error: function () {
            console.log('No funcionó nada :)');
        }

    });
    } else {
        alert("Las contraseñas no coinciden");
    }

}

function registrarAdmin() {

    let username = $("#username").val();
    let contrasena = $("#password").val();
    let nombre = $("#name").val();
    let apellido = $("#lastName").val();
    let email = $("#email").val();
    let confirmarContrasena = $("#confirmPassword").val();
    let saldo = 0;
    let cargo ="Administrador";
    
    if(contrasena == confirmarContrasena){
                $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioRegister",
        data: $.param({
            username: username,
            contrasena: contrasena,
            nombre:nombre,
            apellido: apellido,
            email:email,
            saldo: saldo,
            cargo :cargo
        }),
        success: function (result) {

            let parsedResult = JSON.parse(result);
            
            if (parsedResult != false) {
                let username = parsedResult['username'];
                alert("Registro exitoso");
                document.location.href = "indexAdmin.html?username=" + username;
            } else {
                alert("Hubo un error con tu registro");
            }
        },
        error: function () {
            console.log('No funcionó nada :)');
        }

    });
    } else {
        alert("Las contraseñas no coinciden");
    }
}


