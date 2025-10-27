# Escriba un programa que permita crear una lista de palabras y que, a continuación, pida una palabra y
# elimine esa palabra de la lista.

numPalabras = -1
arrayPalabras = []
objetiveWord = ""

numPalabras = int(input("Type how many words you want to write: "))

for i in range (1, numPalabras+1):
    arrayPalabras.append(input(f"Type the word n.{i}: " ))
    
print("The word array is: " + str(arrayPalabras))

objetiveWord = input("Wich word do you want to delete from the array? ")
while objetiveWord in arrayPalabras:
    arrayPalabras.remove(objetiveWord)
        
print(f"After deleting the Word {objetiveWord} the array is: {arrayPalabras}")