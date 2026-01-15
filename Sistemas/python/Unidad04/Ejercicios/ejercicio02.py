# 2. Escribir una función que simule una calculadora científica trigonométrica que permita calcular el seno,
# coseno, tangente, exponencial y logaritmo neperiano. La función preguntará al usuario el valor y la función a
# aplicar, y mostrará por pantalla una tabla con los enteros de 1 al valor introducido y el resultado de aplicar la
# función a esos enteros.

import math

opcion = -1
opcion_abandonar = 0

def calculadora(valor, funcion):
    resultados = {}
    
    for i in range(1, valor + 1):
        if funcion == "seno":
            resultado = math.sin(i)
        elif funcion == "coseno":
            resultado = math.cos(i)
        elif funcion == "tangente":
            resultado = math.tan(i)
        elif funcion == "exponencial":
            resultado = math.exp(i)
        elif funcion == "logaritmo":
            resultado = math.log(i)
        else:
            print("Función no válida")
            return
        
        resultados[i] = resultado;
        
    return resultados;

while opcion != opcion_abandonar:
    valor = int(input("Introduce un número entero: "))
    funcion = input("Función (seno, coseno, tangente, exponencial, logaritmo): ")
    resultado = calculadora(valor, funcion)

    for clave in resultado:
        print(f"{clave} -> {resultado[clave]}")
        
    opcion = input("Para abandonar pulse 0, para continuar, pulse otra cosa: ") 
