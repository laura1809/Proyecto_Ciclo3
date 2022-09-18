$(document).ready(function () {
        $("#userSignIn-form").submit(function (event) {
            event.preventDefault();
            autenticarUsuario();
        });
        
        $("#adminSignIn-form").submit(function (event) {
            event.preventDefault();
            autenticarAdmin();
        });
    });

function autenticarUsuario() {

    let username = $("#username").val();
    let contrasena = $("#password").val();
    let cargo ="Cliente";
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            username: username,
            contrasena: contrasena,
            cargo :cargo
        }),
        success: function (result) {

            let parsedResult = JSON.parse(result);
            console.log(parsedResult);
            if (parsedResult != false) {
                let username = parsedResult['username'];
                document.location.href = "home.html?username=" + username;
            } else {
                alert("Datos incorrectos o el usuario es un administrador.");
            }
        },
        error: function () {
            console.log('No funcionó nada :)');
        }

    });
}

function autenticarAdmin() {

    let username = $("#username").val();
    let contrasena = $("#password").val();
    let cargo ="Administrador";
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            username: username,
            contrasena: contrasena,
            cargo :cargo
        }),
        success: function (result) {

            let parsedResult = JSON.parse(result);
            console.log(parsedResult);
            if (parsedResult != false) {
                let username = parsedResult['username'];
                document.location.href = "home.html?username=" + username;
            } else {
                alert("Datos incorrectos o el usuario es un cliente.");
                document.getElementById ("password").value = "";
            }
        },
        error: function () {
            console.log('No funcionó nada :)');
        }

    });
}