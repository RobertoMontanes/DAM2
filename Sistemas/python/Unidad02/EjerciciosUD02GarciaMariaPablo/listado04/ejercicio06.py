# 6. Crea un programa que lea de un fichero y tenga las siguientes funcionalidades en un menú:
# - La palabra de mayor longitud.
# - Las veces que aparece una palabra.
# - Lea una línea aleatoria del fichero.
# - Contar el número total de palabras.
# - Encontrar palabras que empiezan con una letra específica.

import random

maxLength = 0
wordFindCounter = 0
wordCounter = 0
letterFindCounter = 0
word = ""
startingLetter = ""

f = open("files/ejercicio6.txt")
palabras = []
lineas = f.readlines()
f.close()

for linea in lineas:
    palabras += linea.split()
    
maxLength = len(palabras[0])
word = palabras[0]

palabraFind = input("Wich word do you want to find? ")
startingLetter = input("Wich starting letter do you want to use? ")

for palabra in palabras:
    if palabra == palabraFind:
        wordFindCounter+=1
        
    if palabra[0] == startingLetter:
        letterFindCounter += 1
    
    if maxLength < len(palabra):
        maxLength = len(palabra)
        word = palabra
        
    wordCounter+=1

print("Longest word: " + word)
print(f"The word {palabraFind} appears: {wordFindCounter}")
print(f"Here you have a random line of the file: {lineas[random.randint(0,len(lineas))]}")
print(f"The file contains: {wordCounter} words")
print(f"There are {letterFindCounter} words that starts with: {startingLetter}")

