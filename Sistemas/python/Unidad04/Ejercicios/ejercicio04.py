# Crear un programa de ayuda a operaciones con aleatorios, es decir, que tenga, al menos, 4 funciones que
# generen y hagan operaciones con números aleatorios, por ejemplo, tirar un dado pero también puede haber
# otras que calculen cosas con una serie de números de forma aleatoria, por ejemplo, decir cuántas veces ha
# salido un número en una serie de tiradas del dado, cuál es el porcentaje de que salga un número según esas
# tiradas (si de 10 veces ha salido el 6 dos veces en 100 tiradas saldría...).

import random

def generar_tiradas(cantidad: int, caras: int = 6):
    tiradas = []
    for i in range(cantidad):
        tiradas.append(random.randint(1, caras))
    return tiradas

def contar_frecuencia(lista_tiradas: list, numero_objetivo: int):
    return lista_tiradas.count(numero_objetivo)

def calcular_porcentaje(lista_tiradas: list, numero_objetivo: int):
    if not lista_tiradas:
        return 0
    frecuencia = contar_frecuencia(lista_tiradas, numero_objetivo)
    return (frecuencia / len(lista_tiradas)) * 100

def simulacion_hasta_objetivo(numero_objetivo: int, veces_necesarias: int, caras: int = 6):
    total_tiradas = 0
    conteo_actual = 0
    
    while conteo_actual < veces_necesarias:
        tirada = random.randint(1, caras)
        total_tiradas += 1
        if tirada == numero_objetivo:
            conteo_actual += 1
            
    return total_tiradas

print("--- BIENVENIDO AL ANALIZADOR DE DADOS ALEATORIOS ---")

opcion = -1
while opcion != 0:
    print("Seleccione una operacion:")
    print("1. Tirada masiva y analisis de frecuencia")
    print("2. Simulacion de probabilidad (¿Cuanto tardara en salir mi numero?)")
    print("0. Salir")
    
    opcion = int(input("Opcion: "))
    
    if opcion == 1:
        n = int(input("¿Cuantas veces quieres tirar el dado?: "))
        caras = int(input("¿De cuantas caras es el dado?: "))
        num = int(input(f"¿Que numero quieres analizar (1-{caras})?: "))
        
        resultados = generar_tiradas(n, caras)
        veces = contar_frecuencia(resultados, num)
        porcentaje = calcular_porcentaje(resultados, num)
        
        print(f"RESULTADOS DE LA SERIE:")
        print(f"- El numero {num} ha salido {veces} veces.")
        print(f"- Representa un {porcentaje:.2f}% del total de tiradas.")
        
    elif opcion == 2:
        num = int(input("¿Que numero buscas?: "))
        objetivo = int(input(f"¿Cuantas veces debe aparecer el {num} para terminar?: "))
        
        intentos = simulacion_hasta_objetivo(num, objetivo)
        print(f"SIMULACION COMPLETADA:")
        print(f"- Se han necesitado {intentos} tiradas para conseguir que el {num} salga {objetivo} veces.")

    elif opcion != 0:
        print("Opcion no valida.")

print("Gracias por usar el simulador. ¡Buen dia!")