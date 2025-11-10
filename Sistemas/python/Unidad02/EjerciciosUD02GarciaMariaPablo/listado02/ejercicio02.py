# Estoy dando clases de inglés para el B2 y me gustaría que me ayudarais a crear un 
# diccionario para ver cómo se dicen palabras con significado “raro” españolas en inglés. 
# Se hará todo en el mismo archivo, no se crean clases. Por ejemplo, “Cabeza: (en el sur 
# de España) amigo/colega”, aro: sí, de acuerdo. Consideraremos que no se repiten palabras 
# con el mismo nombre, es decir, que la palabra “take” no aparece dos veces en el diccionario 
# y que, si tiene varios significados, estos pueden ir en el mismo String “significado”, por 
# ejemplo, for---->por, para, durante

diccionario = {
    "cabeza": "amigo o colega",
    "aro": "si, de acuerdo",
}

diccionario = {
    "cabeza": "amigo o colega",
    "aro": "sí, de acuerdo",
    "pechá": "gran cantidad o exceso",
    "illo": "forma coloquial para amigo o chico",
    "pisha": "amigo, colega",
    "miarma": "amigo o cariño",
    "malaje": "persona antipática o sin gracia",
    "guasa": "broma o actitud graciosa",
    "jaleo": "lío o situación complicada",
    "chungo": "difícil o de mal aspecto",
    "curro": "trabajo",
    "flipar": "alucinar o sorprenderse",
    "guiri": "turista extranjero",
    "movida": "lío o asunto complicado",
    "birra": "cerveza",
    "pasta": "dinero",
    "manta": "persona perezosa",
}

diccionario_favorito = {}

opcion = -1

claveInt = ""
valorInt = ""
claves = []

# • Agregar una nueva palabra por teclado.
# • Imprimir el diccionario completo “en bonito”.
# • Buscar una palabra por nombre y mostrar su significado evitando que salta un error si 
# la palabra no sencuentra.
# • Modificar una palabra, modificando únicamente el significado de esta por otro nuevo, 
# leído por teclado.
# • Pedir al usuario sus dos palabras favoritas con los significados y combinar este con el ya creado
# modificando el original.
# • Borrar una palabra (ustedes decidís la mejor forma).
# • Ordenar el diccionario por orden alfabético.


opciones = [
    "Salir",
    "Agregar una nueva palabra",
    "Imprimir diccionario",
    "Buscar una palabra",
    "Modificar una palabra",
    "Borrar una palabra",
    "Ordenar alfabeticamente",
    "Añadir palabras favoritas",
]

print("Bienvenido al diccionario de español a inglés coloquial.")

while opcion != 0:
    for i in range(len(opciones)):
        print(f"{i}. {opciones[i]}")
    opcion = int(input("Seleccione una opción: "))
    
    match opcion:
        case 0:
            print("Saliendo del programa.")
        case 1:
            print("Agregar una nueva palabra: ")
            claveInt = input("Ingrese la palabra en español: ")
            valorInt = input(f"Ingrese el significado de la palabra {claveInt}: ")
            diccionario[claveInt] = valorInt
        case 2:
            print("Imprimir diccionario: ")
            for clave,valor in diccionario:
                print(f"La palabra: {clave}, puede significar: \n - {valor}")
        case 3:
            print("Buscar una palabra: ")
            claveInt = input("Indique la palabra que esta buscando: ")
            valorInt = diccionario.get(claveInt,"Palabra no encontrada.")
            if valorInt == "Palabra no encontrada":
                print(f"No se ha encontrado la palabra {claveInt} en el diccionario.")
            else:
                print(f"La palabra: {claveInt}, puede significar: \n - {valorInt}")
        case 4:
            print("Modificar una palabra: ")
            claveInt = input("Indique la palabra que esta buscando: ")
            valorInt = diccionario.get(claveInt,"Palabra no encontrada.")
            if valorInt == "Palabra no encontrada":
                print(f"No se ha encontrado la palabra {claveInt} en el diccionario.")
            else:
                valorInt = input("Indique el nuevo significado de la palabra: ")
                diccionario[claveInt] = valorInt
                print(f"La palabra: {claveInt}, puede significar: \n -{valorInt}")
        case 5:
            print("Eliminar una palabra: ")
            claveInt = input("Indique la palabra que esta buscando: ")
            valorInt = diccionario.get(claveInt,"Palabra no encontrada.")
            if valorInt == "Palabra no encontrada":
                print(f"No se ha encontrado la palabra {claveInt} en el diccionario.")
            else:
                del diccionario[claveInt]
                print(f"La palabra {claveInt} ha sido eliminada del diccionario.")
        case 6:
            print("Ordenar el diccionario alfabeticamente: ")
            claves.clear()
            for key in diccionario.keys():
                claves.append(key)
            claves.sort()
            for clave in claves:
                print(f"La palabra: {clave}, puede significar: \n - {diccionario[clave]}")
        case 7:
            print("Añadir palabras favoritas: ")
            for i in range(2):
                claveInt = input("Ingrese la palabra en español: ")
                valorInt = input(f"Ingrese el significado de la palabra {claveInt}: ")
                diccionario_favorito[claveInt] = valorInt
            diccionario.update(diccionario_favorito)
            print("Palabras favoritas añadidas al diccionario.")
            
        case _:
            print("Opción no válida. Intente de nuevo.")

