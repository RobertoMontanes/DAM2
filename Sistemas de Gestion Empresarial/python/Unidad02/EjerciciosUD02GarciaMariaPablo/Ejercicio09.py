# 9. Escriba un programa que permita crear una lista de palabras y que, a continuación, cree una segunda lista
# igual a la primera, pero al revés (no se trata de escribir la lista al revés, sino de crear una lista distinta)

numPalabras = -1
arrayPalabras = []
arrayPalabras2 = []

numPalabras = int(input("Type how many words you want to write: "))

for i in range (1, numPalabras+1):
    arrayPalabras.append(input(f"Type the word n.{i}: " ))
    

arrayPalabras2 = list(reversed(arrayPalabras))

print("The word array is: " + str(arrayPalabras))
print("The second array (reversed) is: " + str(arrayPalabras2))