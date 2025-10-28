# 10. Escriba un programa que permita crear una lista de palabras y que, a continuación, elimine los elementos
# repetidos (dejando únicamente el primero de los elementos repetidos).


# MIO
numPalabras = -1
arrayPalabras = []
indices = []

numPalabras = int(input("Type how many words you want to write: "))

for i in range (1, numPalabras+1):
    arrayPalabras.append(input(f"Type the word n.{i}: " ))
    
print("The word array is: " + str(arrayPalabras))

for w in arrayPalabras:
    if arrayPalabras.count(w) > 1:
        firstOcur = False
        indices.clear()
        for w2 in range(len(arrayPalabras)):
            if arrayPalabras[w2] == w and not firstOcur:
                firstOcur = True
            elif arrayPalabras[w2] == w:
                indices.append(w2)
        for i in indices:
            del arrayPalabras[i]
            for i2 in range(len(indices)):
                indices[i2] -= 1
                
print("The word array after deleting repeated words is: " + str(arrayPalabras))

#CHATGPT
numPalabras = -1
arrayPalabras = []
arrayPalabrasNR = []

numPalabras = int(input("Type how many words you want to write: "))

for i in range (1, numPalabras+1):
    arrayPalabras.append(input(f"Type the word n.{i}: " ))
    
print("The word array is: " + str(arrayPalabras))

for w in arrayPalabras:
    if w not in arrayPalabrasNR: arrayPalabrasNR.append(w)

print("The non repeating array is: " + str(arrayPalabrasNR))