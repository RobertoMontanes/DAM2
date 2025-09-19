
$(document).ready(function () {

    var p = true


    // Selector de ID = #
    $("#pageTitle").html("Bye bye, World!");

    // Selector de clase = .
     //$(".course").css("color", "red");

    // Selector de etiqueta = etiqueta
    $("span").addClass("course");

    $(document).on("click","#span1Dam", function () {
        if (p) {
            $(this).html("🐵 1 DAM")
        } else {
            $(this).html("🥳 1º DAM")
        }
        p = !p;
    })
});