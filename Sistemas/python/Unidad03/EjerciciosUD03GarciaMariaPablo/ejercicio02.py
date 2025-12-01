# Escriba un programa que pida tres números enteros distintos y que escriba una lista que empiece por
# el más pequeño y termine en el más grande.

import random
import datetime

def sort(listaNum=[]):
    newLista = []
    
    for i in listaNum:
        print(f"Procesando: {i}")
        exit = False
        newListLength = len(newLista);
        
        if(newListLength == 0):
            newLista.append(i)
            continue

        actualPos = 0
        
        while i > newLista[actualPos]:
            print(f"{i} es mayor que {newLista[actualPos]}")
            actualPos+=1
            
            if actualPos >= newListLength:
                print(f"{i} es el mayor actual.")
                newLista.append(i)
                exit = True
                break
            
        if exit:
            continue
        
        print(f"Insertando {i} en la posicion {actualPos}")
        newLista.insert(actualPos,i)
        
                
    return newLista

def ejerClase():
    numEjer = int(input("Cuantos numeros quieres insertar: "))
    listaEjer = []

    for i in range(0,numEjer):
        listaEjer.append(int(input("Inserte un numero: ")))
        
    print(sort(listaEjer))
    #print(highLow(listaEjer))

def sortAuto():
    comienzoEjec = datetime.datetime.now()
    listaEjer = []
    for i in range(1000):
        listaEjer.append(random.randint(0,1000))

    print(sort(listaEjer))
    finEjec = datetime.datetime.now()

    print(f"Comenzo el sort a: {comienzoEjec}, termino a las: {finEjec}, ha tardado {finEjec - comienzoEjec} en terminar 1000 numeros.")

def highLow(listaNum=[]):
    newArray = []
    high = listaNum[0]
    low = listaNum[0]
    
    contHigh = 0
    contLow = 0
    
    for i in listaNum:
        if i > high:
            high = i
        if i < low:
            low = i
    
    contLow = listaNum.count(low)
    contHigh = listaNum.count(high)
    
    newArray.append(low)
    for i in range(1,contLow):
        newArray.append(low)

    for i in range(0,len(listaNum)):
        if listaNum[i] != low and listaNum[i] != high:
            newArray.append(listaNum[i])
    
    for i in range(0,contHigh):
        newArray.append(high)

    return newArray

print("Bienvenido al sorter.")
ejerClase()
print()