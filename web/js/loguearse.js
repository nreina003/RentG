window.addEventListener("load", cargar, false);

function cargar() {
    iniciar();

}


function iniciar() {
    var email = document.getElementById("email").addEventListener("change", controlar, false);
    var contraseña = document.getElementById("contraseña").addEventListener("change", controlar, false);
    var l = document.getElementById("login1").addEventListener("click", login);

}




//HAY QUE MODIFICAR !!!!!!!
//
//function login() {
//
//    var active = dataBase.result;
//    var data = active.transaction(["clientes"], "readonly");
//    var object = data.objectStore("clientes");
//    var request = object.get(document.querySelector("#email").value);
//    request.onsuccess = function (event) {
//        if (request.result.contraseña === document.querySelector("#contraseña").value)
//        {
//
//            sessionStorage.setItem("nomLogueado", request.result.nombre);
//            sessionStorage.setItem("emaLogueado", request.result.email);
//            if (request.result.nombre === "Responsable")
//            {
//                alert("Hola " + request.result.nombre + ", ahora estas logueado.");
//                location.href = "responsableO.html";
//            }else
//            {
//                alert("Hola " + request.result.nombre + ", ahora estas logueado.");
//                location.href = "inicioCliente.html";
//            }
//        } else
//        {
//            alert("Contraseña erronea");
//        }
//    };
//}