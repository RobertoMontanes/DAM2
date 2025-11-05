# 17) Escribe un programa que, de forma indefinida, nos permita jugar a piedra, papel, tijera (y si te atreves,
# lagarto, Spock) contra el ordenador.

from random import choice

opciones = ["piedra", "papel", "tijera", "lagarto", "spock"]
gana = {
    "piedra": ["tijera", "lagarto"],
    "papel": ["piedra", "spock"],
    "tijera": ["papel", "lagarto"],
    "lagarto": ["spock", "papel"],
    "spock": ["tijera", "piedra"]
}

while True:
    intento = input("Elige piedra, papel, tijera, lagarto o spock (o 'salir' para terminar): ").lower()
    if intento == "salir":
        print("Gracias por jugar. Adios")
        break
    if intento not in opciones:
        print("Opción no valida. Intentalo de nuevo.")
        continue
    ordenador = choice(opciones)
    print(f"El ordenador ha elegido: {ordenador}")
    if intento == ordenador:
        print("Empate!")
    elif ordenador in gana[intento]:
        print("Has ganado!")
    else:
        print("Has perdio!")