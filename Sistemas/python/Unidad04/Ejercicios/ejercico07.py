#7. Simulando apuestas con la librería numpy. Simularemos una apuesta con las siguiente características:
# • Tenemos una moneda con cara y cruz.
# • Se empieza con un dinero_inicial.
# • Se apuesta un número de veces num_apuestas.
# • Existe una probabilidad de ganar prob_ganar. Si se gana obtenemos retorno_ganar.
# • Existe una probabilidad de perder 1-prob_ganar. Si se pierde perdemos retorno_perder.
# Crea también una función para simular la evolución de nuestro dinero a lo largo de varias jugadas o apuestas.

import numpy as np

def simular_evolucion_apuestas(dinero_inicial, num_apuestas, prob_ganar, retorno_ganar, retorno_perder):
    tiradas = np.random.random(num_apuestas)
    
    evolucion = [dinero_inicial]
    saldo_actual = dinero_inicial
    
    for tirada in tiradas:
        if tirada < prob_ganar:
            saldo_actual += retorno_ganar
        else:
            saldo_actual -= retorno_perder
            
        evolucion.append(saldo_actual)
    
    return evolucion

import numpy as np

def simular_evolucion_apuestas(dinero_inicial, num_apuestas, prob_ganar, retorno_ganar, retorno_perder):
    tiradas = np.random.random(num_apuestas)
    evolucion = [dinero_inicial]
    saldo_actual = dinero_inicial
    
    for tirada in tiradas:
        if tirada < prob_ganar:
            saldo_actual += retorno_ganar
        else:
            saldo_actual -= retorno_perder
        evolucion.append(saldo_actual)
    
    return evolucion

opcion = -1
print("--- Simulador de Apuestas ---")

while opcion != 0:
    print("1. Nueva Simulacion")
    print("0. Salir")
    
    try:
        opcion = int(input("Seleccione una opcion: "))
    except ValueError:
        opcion = -1

    if opcion == 1:
        dinero_inicial = float(input("Dinero inicial: "))
        num_apuestas = int(input("Numero de apuestas: "))
        prob_ganar = float(input("Probabilidad de ganar (0.0 a 1.0): "))
        retorno_ganar = float(input("Ganancia por apuesta ganada: "))
        retorno_perder = float(input("Perdida por apuesta perdida: "))

        resultado = simular_evolucion_apuestas(dinero_inicial, num_apuestas, prob_ganar, retorno_ganar, retorno_perder)

        saldo_final = resultado[-1]
        pico_maximo = max(resultado)
        pico_minimo = min(resultado)

        victorias = 0
        for i in range(1, len(resultado)):
            if resultado[i] > resultado[i-1]:
                victorias += 1
                
        derrotas = num_apuestas - victorias

        print("--- Resultados de la Simulacion ---")
        print(f"Saldo Inicial: {resultado[0]}")
        print(f"Saldo Final: {saldo_final}")
        print(f"Pico Maximo de dinero: {pico_maximo}")
        print(f"Pico Minimo de dinero: {pico_minimo}")
        print(f"Total Victorias: {victorias}")
        print(f"Total Derrotas: {derrotas}")
        print("Primeros 10 movimientos de saldo:")
        print(resultado[:11])

print("Programa finalizado.")