# 10) Realiza la misma operación del ejercicio anterior pero con números

numeros = []
seguir = "s"
while (seguir=="s"):
    numeros.append(int(input("Escribe un número: ")))
    seguir = input("Quieres seguir escribiendo? s/n ")

print(numeros)
