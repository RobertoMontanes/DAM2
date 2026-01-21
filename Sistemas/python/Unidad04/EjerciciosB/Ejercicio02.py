# 2. Escribir una función que simule una calculadora científica trigonométrica que permita calcular el seno,
# coseno, tangente, exponencial y logaritmo neperiano. La función preguntará al usuario el valor y la función a
# aplicar, y mostrará por pantalla una tabla con los enteros de 1 al valor introducido y el resultado de aplicar la
# función a esos enteros.

import math

def calcularTrigonometria(limite, funcion):
    calculo = 0
    tabla = "Numero | Resultado\n-------+-----------------\n"
    
    for i in range(1, limite + 1):
        calculo = funcion(limite)
            
        tabla += str(i) + "      | " + str(calculo) + "\n"
        
    return tabla


resultado = ""
opcion_usuario = 0
valor_usuario = 0
print("Bienvenido a la calculadora trigonométrica")

while True:
    print("\n---------Menú---------")
    print("0. Salir")
    print("1. Seno")
    print("2. Coseno")
    print("3. Tangente")
    print("4. Exponencial")
    print("5. Logaritmo Neperiano")

    opcion_usuario = int(input("Elige una función (1-5): "))
  

    match(opcion_usuario):
        case 0:
            print("Saliendo...")
            break

        case 1:
            valor_usuario = int(input("Introduce el número límite: "))
            resultado = calcularTrigonometria(valor_usuario, math.sin)

        case 2:
            valor_usuario = int(input("Introduce el número límite: "))
            resultado = calcularTrigonometria(valor_usuario, math.cos)

        case 3: 
            valor_usuario = int(input("Introduce el número límite: "))
            resultado = calcularTrigonometria(valor_usuario, math.tan)

        case 4:
            valor_usuario = int(input("Introduce el número límite: "))
            resultado = calcularTrigonometria(valor_usuario, math.exp)

        case 5:
            valor_usuario = int(input("Introduce el número límite: "))
            resultado = calcularTrigonometria(valor_usuario, math.log)

        case _:
            print("\nIntroduzca una opción válida\n")
            continue    


    print("\n" + resultado)