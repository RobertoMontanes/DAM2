# Crea una función en python, triangulo, que reciba un número entero, e imprima un patrón como este por
# pantalla. Este sería el resultado de llamar a triangulo(5)

def triangulo(num):
    for i in range(1,num):
        print("*"*i)
    for i in range(num,0,-1):
        print("*"*i)

print("Bienvenido")
triangulo(int(input("Indica el valor de la longitud del triangulo: ")))
print("Gracias por usar el programa.")