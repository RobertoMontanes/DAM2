$(document).ready(function () {

    
    $(document).on("keyup", "#mainTextarea", function () {
        
        let contParragrahp = 0
        let contCar = 0
        let contPalbra = 0
        let contCarNoSpc = 0

        let textoActual = $("#mainTextarea").val()        

        for (let index = 0; index < textoActual.length; index++) {
            const element = textoActual[index];

            if (element == " " || element == "\n") {
                contPalbra++
            } else {
                contCarNoSpc++
            }

            if (element == "\n") {
                contParragrahp++
            }

            contCar++

        }

        $("#charCounter").text(contCar)
        $("#wordCounter").text(contPalbra)
        $("#notSpaceCounter").text(contCarNoSpc)
        $("#parragrahpCounter").text(contParragrahp)

        console.log($("#mainTextarea").val());
        

    })

})