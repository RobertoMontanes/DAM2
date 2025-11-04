# 8. Escriba un programa que permita crear dos listas de palabras y que, a continuación, elimine de la primera
# lista los nombres de la segunda lista. 

numPalabras = -1
arrayArrays = [[],[]]

for j in range(len(arrayArrays)):
    print(f"Array {j+1}")
    numPalabras = int(input("Type how many words you want to write: "))

    for i in range (1, numPalabras+1):
        arrayArrays[j].append(input(f"Type the word n.{i}: " ))
        
    print("The word array is: " + str(arrayArrays[j]))
    
print("Now, we are going to delete words from the first array using the ones that appear on the second one.")
for w in arrayArrays[1]:
    for w2 in arrayArrays[0]:
        if w2 == w:
            arrayArrays[0].remove(w2)
    
print(f"The final first array is: {arrayArrays[0]}")
print(f"The final second array is: {arrayArrays[1]}")
