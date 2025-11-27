# Escriba un programa que pida tres números enteros distintos y que escriba una lista que empiece por
# el más pequeño y termine en el más grande.

import random
import datetime

def sort(listaNum=[]):
    newLista = []
    
    for i in listaNum:
        print(f"Procesando: {i}")
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
                continue
        
        print(f"Insertando {i} en la posicion {actualPos}")
        newLista.insert(actualPos,i)
        
                
    print(newLista)

def ejerClase():
    numEjer = int(input("Cuantos numeros quieres insertar: "))
    listaEjer = []

    for i in range(0,numEjer):
        listaEjer.append(int(input("Inserte un numero: ")))
        
    sort(listaEjer)

print("Bienvenido al sorter.")
#ejerClase()

comienzoEjec = datetime.datetime.now()
listaEjer = []
for i in range(1000):
    listaEjer.append(random.randint(0,1000))

sort(listaEjer)
finEjec = datetime.datetime.now()

print(f"Comenzo el sort a: {comienzoEjec}, termino a las: {finEjec}, ha tardado {finEjec - comienzoEjec} en terminar 1000 numeros.")