# 5. Escriba un programa que permita crear una lista de palabras y que, a continuación, pida una palabra y diga
# cuántas veces aparece esa palabra en la lista.

numPalabras = -1
arrayPalabras = []
findPalabra = ""

numPalabras = int(input("Type how many words you want to write: "))

for i in range (1, numPalabras+1):
    arrayPalabras.append(input(f"Type the word n.{i}: " ))

print("The final word array is: " + str(arrayPalabras)) 

findPalabra = input("Type the word that you want to find in the Array: ")
print(f"The word {findPalabra} appears {arrayPalabras.count(findPalabra)} time\s")