# Funciones matemáticas
# Debemos preparar un ejercicio sobre el apartado de funciones matemáticas en Python.
import random

notas = []
opcion = -1
opcionAbandonar = 0
notasRandom = 10

opciones = [
    "Salir del programa",
    "Ingresar la cantidad de notas que desea evaluar",
    f"Ingresar {notasRandom} notas aleatorias entre 0 y 10",
    "Modificar el numero de notas aleatorias"
]

print("Ejercicio 02: Funciones matemáticas en Python")
print("En el siguiente ejercicio, crearemos una lista con las diferentes notas de un examen y basandonos en esas notas, calcularemos el promedio, la nota más alta y la nota más baja utilizando funciones matemáticas.")

while opcion != opcionAbandonar:
    notas = []
    print("\nVamos a definir como ingresaremos las notas.")
    # print("- Indique 0 para salir del programa.")
    # print("- Indique 1 para ingresar la cantidad de notas que desea evaluar: ")
    # print(f"- Indique 2 para ingresar {notasRandom} notas aleatorias entre 0 y 10: ")
    # print("- Indique 3 para modificar el numero de notas aleatorias: ")
    
    for i in range(0,len(opciones)):
        print(f"- Indique {i} para {opciones[i]}")
    
    opcion = int(input("Ingrese la opción deseada: "))

    match opcion:
        case 0:
            print("\nHa decidido salir del programa.")
            break
        case 1:
            cantidadNotas = int(input("\nIngrese la cantidad de notas que desea evaluar: "))
            for n in range(cantidadNotas):
                notas.append(float(input(f"Indique la nota numero {n+1}: ")))
        case 2:
            for i in range(notasRandom):
                notas.append(round((random.random()*10), 2))
        case 3:
            notasRandom = int(input("\nIngrese la cantidad de notas aleatorias que desea evaluar: "))
            opciones[2] = f"Ingresar {notasRandom} notas aleatorias entre 0 y 10"
            continue
        case _:
            print("\nOpción inválida, volviendo al menu.")

    if opcion in range(0,len(opciones)):
        print("\nLas notas ingresadas son: ", notas)

        print("\nCalculando el promedio....")
        print("- El promedio de las notas es: ", round(sum(notas) / len(notas), 2))

        print("\nCalculando la nota más alta....")
        print("- La nota más alta es: ", max(notas))

        print("\nCalculando la nota más baja....")
        print("- La nota más baja es: ", min(notas))


print("\nGracias por participar en el ejercicio de hoy.")


