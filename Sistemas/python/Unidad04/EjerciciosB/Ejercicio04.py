# Crear un programa de ayuda a operaciones con aleatorios, es decir, que tenga, al menos, 4 funciones que
# generen y hagan operaciones con números aleatorios, por ejemplo, tirar un dado pero también puede haber
# otras que calculen cosas con una serie de números de forma aleatoria, por ejemplo, decir cuántas veces ha
# salido un número en una serie de tiradas del dado, cuál es el porcentaje de que salga un número según esas
# tiradas (si de 10 veces ha salido el 6 dos veces en 100 tiradas saldría...).

import random

def tirarDado():
    return random.randint(1,6)

def generarSerie(repeticiones):
    listaRes = []

    for i in range(0, repeticiones):
        listaRes.append(tirarDado())

    return listaRes


def calcularFrecuencia(lista, buscado):
    return lista.count(buscado)


def proyectarProbabilidad(buscado, repeticiones, serie):
    apariciones = calcularFrecuencia(serie, buscado)

    return (apariciones/ len(serie))*repeticiones

serie_actual = []
continuar = True
numReps = 0
buscado = 0
frecuencia = 0.0
resultado_proyectado = 0.0

print("Bienveniod al \"Ludopator\"")

while continuar:
    print("MENÚ DE OPERACIONES ALEATORIAS")
    print("1. Tirar un dado")
    print("2. Generar serie de lanzamientos")
    print("3. Calcular frecuencia de un número")
    print("4. Proyectar resultado a futuro")
    print("5. Salir")
    
    opcion = int(input("\nSelecciona una opción: "))

    match opcion:
        case 1:
            resultado = tirarDado()
            print(f"\nResultado: {resultado}")

        case 2:
            numReps = int(input("¿Cuántas veces quieres tirar?: "))
            serie_actual = generarSerie(numReps)
            print(f"Serie de {numReps} números generada y guardada.")

        case 3:
            if not serie_actual:
                print("Error: Primero genera una serie en la opción 2.")
            else:
                buscado = int(input("¿Qué número buscas (1-6)?: "))
                frecuencia = calcularFrecuencia(serie_actual, buscado)
                print(f"El número {buscado} ha salido {frecuencia} veces.")

        case 4:
            if not serie_actual:
                print("Error: No hay datos para proyectar. Usa la opción 2.")
            else:
                buscado = int(input("¿Para qué número quieres la proyección?: "))
                numReps = int(input("¿Cuántas tiradas nuevas quieres simular?: "))
                resultado_proyectado = proyectarProbabilidad(buscado, numReps, serie_actual)
                print(f"Proyección: En {numReps} tiradas, el {buscado} saldría unas {resultado_proyectado:.1f} veces.")

        case 5:
            print("Saliendo... ¡Hasta pronto!")
            continuar = False

        case _:
            print("Opción inválida")
