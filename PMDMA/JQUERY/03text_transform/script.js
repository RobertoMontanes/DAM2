$(document).ready(function () {

    var output = ""

    $(document).on("click", "#btnAction", function () {
        var input = $("#textInput").val()
        var selectVal = $("#selectAction").val();

        console.log(input);
        
        if (input == "") {            
            alert("Tienes que escribir algun contenido")
        } else {
            if (selectVal == "null") {
                alert("Debes seleccionar una opcion valida.")
            } else {
                if (selectVal == "upper") {
                    console.log(input);
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