$(document).ready(function () {

    var output = ""

    $(document).on("click", "#btnAction", function () {
        var input = $("#textInput").val()
        var selectVal = $("#selectAction").val();
        var checkPolite = $("#checkboxPolite").prop("checked");

        
        if (input == "") {            
            alert("Tienes que escribir algun contenido")
        } else {
            if (selectVal == "null") {
                alert("Debes seleccionar una opcion valida.")
            } else {

                if (checkPolite) {
                    input = borrarPalabrotas(input);
                }

                if (selectVal == "upper") {
                    output = upperCase(input)
                } else if (selectVal == "lower") {
                    output = lowerCase(input)
                }
                                
                $("#textOutput").val(output)

            }
        }
    });

})

function upperCase(str) {
    return str.toUpperCase()
}

function lowerCase(str) {
    return str.toLowerCase()
}

function borrarPalabrotas(str) {
    var palabrotas = ["gilipollas", "tonto", "anormal", "gilipuertas"];

    palabrotas.forEach(insulto => {
        var regex = new RegExp(insulto, "gi");
        str = str.replace(regex, "***");
    });

    return str;
}