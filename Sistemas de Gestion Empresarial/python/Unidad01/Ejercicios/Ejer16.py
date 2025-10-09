# 16) Escribe un programa que sea capaz de escribir los N primeros números de la sucesión de fibonacci.

org = 0 #Original
val = 1 # Valor
sum = org + val # Suma

print("Bienvenido")
num = int(input("Dime cuantos numeros de la sucesion fibonacci quieres contar: "))
for i in range(0,num):
    org = val
    val = sum
    sum = org + val

print("El resultado es: " + str(sum))
print("Gracias por usar el programa.")


