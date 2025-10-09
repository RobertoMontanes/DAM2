#  Implementa una función que calcule el factorial de un número. Recuerda que el factorial de un número es
# el producto de todos los números desde ese número hasta 1. Por ejemplo, 6, 3!, es 6

print("Bienvenido")
num = int(input("Vamos a calcular el factorial del numero: "))
resul = 1;

for i in range(1,num+1):
    resul *= i

print(f"El factorial de {num} es {resul}")

print("Gracias por usar el programa.")