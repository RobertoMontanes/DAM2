objetivo = int(input("Introduce el número objetivo: "))

numeros = []
suma = 0

while suma != objetivo:
    num = int(input("Introduce un número entero: "))
    suma += num

    if suma > objetivo:
        print("Te has pasado")
        #break
        print("Retornando al ultimo valor valido: ")
        suma -= num
    else:
        numeros.append(num)

print("Lista de números introducidos:", numeros)