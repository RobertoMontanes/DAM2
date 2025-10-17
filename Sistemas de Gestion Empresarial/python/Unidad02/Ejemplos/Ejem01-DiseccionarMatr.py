matriculas = [
    "1234ABC",
    "5678DEF",
    "9012GHI"
]


for matricula in matriculas:
    print("Matrícula: ", matricula)
    letras = []
    numeros = []
    
    for i in matricula:
        if not i.isnumeric():
            letras.append(i)
        else:
            numeros.append(i)
            
    print("Letras: ", letras)
    print("Números: ", numeros)