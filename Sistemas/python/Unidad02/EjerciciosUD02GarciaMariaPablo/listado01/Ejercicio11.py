# 11. Escriba un programa que permita crear dos listas de palabras y que, a continuación, escriba las siguientes
# listas (en las que no debe haber repeticiones):

numPalabras = -1
arrayArrays = [[],[]]
arrayNew = []
arrayDualList = []
arrayOnlyFirst = []
arrayOnlySecond = []
arrayAllIn = []

for j in range(len(arrayArrays)):
    print(f"Array {j+1}")
    numPalabras = int(input("Type how many words you want to write: "))

    for i in range (1, numPalabras+1):
        arrayArrays[j].append(input(f"Type the word n.{i}: " ))
        
    print("The word array is: " + str(arrayArrays[j]))

arrayNew.extend(arrayArrays[0])
arrayNew.extend(arrayArrays[1])
for w in arrayNew:
    if w not in arrayAllIn: arrayAllIn.append(w)

for w in arrayAllIn:
    if w in arrayArrays[0] and w in arrayArrays[1] and w not in arrayDualList: arrayDualList.append(w)
    if w in arrayArrays[0] and w not in arrayArrays[1] and w not in arrayOnlyFirst: arrayOnlyFirst.append(w)
    if w not in arrayArrays[0] and w in arrayArrays[1] and w not in arrayOnlySecond: arrayOnlySecond.append(w)


print(f"The final arrayis are: \nBoth List: {arrayDualList}\n Only first: {arrayOnlyFirst}\nOnly second: {arrayOnlySecond}\n All in one: {arrayAllIn}")