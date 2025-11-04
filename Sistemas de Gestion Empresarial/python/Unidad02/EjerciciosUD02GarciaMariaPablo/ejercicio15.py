# 15. Determine si una cadena de texto dada es un isograma, es decir, no se repite ninguna letra.

palabras = ["background", "downstream", "six-year-old", "isograma", "repeticion"]

for palabra in palabras:
    isograma = True
    for letra in palabra:
        if letra == "-" or letra == " ":
            continue
        if palabra.count(letra) > 1:
            isograma = False
            break
        
    if isograma:
        print(f"La palabra {palabra} es un isograma.")
    else:
        print(f"La palabra {palabra} no es un isograma.")