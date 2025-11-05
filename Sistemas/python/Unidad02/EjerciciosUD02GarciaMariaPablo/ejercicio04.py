# 4. Escriba un programa que permita crear una lista de palabras. Para ello, el programa tiene que pedir un
# número y luego solicitar ese número de palabras para crear la lista. Por último, el programa tiene que escribir
# la lista.

numPalabras = -1
arrayPalabras = []

numPalabras = int(input("Type how many words you want to write: "))

for i in range (1, numPalabras+1):
    arrayPalabras.append(input(f"Type the word n.{i}: " ))

print("The final word array is: " + str(arrayPalabras)) 