# 6. La Martingala es una estrategia de apuestas que se popularizó en la ruleta y tiene la siguiente estructura
# (usaremos radom):
# • 🎲 Se comienza con una apuesta inicial. Se apuesta siempre al ⚫.
# • ⚫ Si se gana, se vuelve a la apuesta inicial.
# • 🔴 Si se pierde, se dobla la apuesta.
# La esencia de esta estrategia es que cuando perdemos, doblamos la siguiente apuesta para intentar recuperar la
# cantidad perdida. En la teoría, suena bien.

import random;
import datetime;

opcion = -1
opcionAbandonar = 0

saldo = 0.0;
cantidadApostar = 0.0;
continuar = True

numeros = {
    0: "Verde",
    1: "Rojo",    2: "Negro",   3: "Rojo",    4: "Negro",   5: "Rojo",
    6: "Negro",   7: "Rojo",    8: "Negro",   9: "Rojo",    10: "Negro",
    11: "Negro",  12: "Rojo",   13: "Negro",  14: "Rojo",   15: "Negro",
    16: "Rojo",   17: "Negro",  18: "Rojo",   19: "Rojo",    20: "Negro",
    21: "Rojo",   22: "Negro",  23: "Rojo",   24: "Negro",  25: "Rojo",
    26: "Negro",  27: "Rojo",   28: "Negro",  29: "Negro",  30: "Rojo",
    31: "Negro",  32: "Rojo",   33: "Negro",  34: "Rojo",   35: "Negro",
    36: "Rojo"
}

def girar_ruleta():
    return random.randint(0,36)


while opcion != opcionAbandonar:
    saldo = int(input("Indique su saldo inicial: "))
    cantidadApostarInicial = int(input("Indique la apuesta inicial: "))
    cantidadAbandonar = int(input("Indique con cuanto dinero quiere irse: "))
    cantidadApostar = cantidadApostarInicial
    tiradas = []
    continuar = True
    
    print("A continuacion, apostaremos hasta que el saldo llegue a 0")
    inicio = datetime.datetime.now()
    
    cont = 1
    while continuar or saldo < 0:
        
        print(f"Saldo actual: {saldo}")
        if saldo >= cantidadApostar:
            print("Vamos a apostar: ")
            print(f"{cantidadApostar} al Negro.")
            saldo -= cantidadApostar
        else:
            tiradas.append(cont)
            print(f"No tienes saldo suficiente como para apostar. Saldo: {saldo}, Cantidad esperada: {cantidadApostar}")
            continuar = False
            continue
        
        numGanador = girar_ruleta()
        print(f"Tirada {cont} => Ha salido el numero: {numGanador}")
        if (numeros[numGanador] == "Negro"):
            #continuarInp = input(f"Has ganado => {cantidadApostar}, para salir pulse 0, para continuar otra cosa: ")
            print(f"Has ganado => {cantidadApostar*2}")
            continuarInp = 1
            
            tiradas.append(cont)
            
            if continuarInp == "0":
                continuar = False
            
            saldo += cantidadApostar*2
            print(f"Has ganado {cantidadApostar*2}, saldo actual {saldo}")
            cont = 1
            
            cantidadApostar = cantidadApostarInicial
            
        else:
            print(f"Has perdido, duplicando apuesta.")
            cantidadApostar = cantidadApostar * 2
            cont += 1
        
        if (saldo >= cantidadAbandonar):
            print("Has llegado al objetivo, abandonado.")
            continuar = False
    
    fin = datetime.datetime.now()
    tiempoTotal = fin - inicio
    print(f"Has jugado un total de: {len(tiradas)} veces, durante {tiempoTotal}")
    print(f"Una media de {sum(tiradas) / len(tiradas)} tiradas por partida.")
    
    opcion= int(input("Si quieres abandonar pulse 0, si no otro numero: "))
        