$(document).ready(function () {

    const abecedario = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"];

    let cypherCode = 3;


    $(document).on("click", "#cypherBTN", function () {

        cypherCode = parseInt($("#cypherNum").val());

        let originalText = $("#cypherTEXT").val();
        let newText = ""
        let index;

        if (originalText.length == 0) {
            alert("No podemos descrifrar texto vacio")
        } else {
            for (var i = 0; i < originalText.length; i++) {
                const letter = originalText[i];
                let len = 0

                index = buscarAbecedario(letter);


                if (index == -1) {
                    newText += letter
                } else {

                    len = newText.length

                    if (index >= 26) {
                        if (index + cypherCode >= 52) {
                            newText += abecedario[index + cypherCode - 26]
                        }
                    } else {
                        if (index +cypherCode >= 26) {
                            newText += abecedario[index + cypherCode - 26]
                        }
                    }

                    if (newText.length == len) {
                        newText += abecedario[index + cypherCode]
                    }

                }

            }

            $("#cypherTEXT").val(newText)

        }
    })

    $(document).on("click", "#unCypherBTN", function () {

        cypherCode = $("#cypherNum").val();

        let originalText = $("#cypherTEXT").val();
        let newText = ""
        let index;

        if (originalText.length == 0) {
            alert("No podemos descrifrar texto vacio")
        } else {
            for (var i = 0; i < originalText.length; i++) {
                const letter = originalText[i];
                let len = 0

                index = buscarAbecedario(letter);

                if (index == -1) {
                    newText += letter
                } else {

                    len = newText.length

                    if (index >= 26) {
                        if (index - cypherCode < 26) {
                            newText += abecedario[index - cypherCode + 26]
                        }
                    } else {
                        if (index - cypherCode < 0) {
                            newText += abecedario[index - cypherCode + 26]
                        }
                    }

                    if (newText.length == len) {
                        newText += abecedario[index - cypherCode]
                    }

                }

            }

            $("#cypherTEXT").val(newText)

            alert("Codigo cifrado.")

        }
    })


    function buscarAbecedario(letra) {
        for (var ii = 0; ii < abecedario.length; ii++) {
            if (abecedario[ii] == letra) {
                return ii;
            }
        }
        return -1
    }

})

