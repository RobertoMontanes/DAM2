# Escriba un programa que permita crear una lista de palabras y que, a continuación, pida dos palabras y
# sustituya la primera por la segunda en la lista

numPalabras = -1
arrayPalabras = []
originalWord= ""
newWord = ""

numPalabras = int(input("Type how many words you want to write: "))

for i in range (1, numPalabras+1):
    arrayPalabras.append(input(f"Type the word n.{i}: " ))
    
print("The word array is: " + str(arrayPalabras))

originalWord = input("Type the word that you want to replace in the Array: ")
newWord = input("Type the new word: ")

for i in range(len(arrayPalabras)):
    if arrayPalabras[i] == originalWord:
        arrayPalabras[i] = newWord

print("The final word array is: " + str(arrayPalabras))