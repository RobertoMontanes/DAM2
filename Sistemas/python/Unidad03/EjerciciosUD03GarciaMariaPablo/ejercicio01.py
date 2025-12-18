# Escriba un programa que pida un número. Después pregunte cuántos números se van a introducir, pida
# esos números, y escriba cuántos de esos números era mayor que el anterior.


# Los primeros 3 ejercios tienen prints e inputs dentro por que aun no sabia que no era aconsejable usaros dentro de las funciones
# a partir del ejercicio 4 ya no hay nada

def checkHighers(numObj = 0, numToInsert = 0):
    arrayNum = []
    cont = 0

    for i in range(0,numToInsert):
        arrayNum.append(int(input("Inserta un nuevo numero: ")))
        
    for i in arrayNum:
        if i > numObj:
            cont += 1
            

    print(f"{cont} numeros de los introducidos. son mayores que {numObj}")
    
num0 = int(input("Introduce un numero: "))
num1= int(input("Introduce cuantos numeros vas a meter: "))
checkHighers(num0, num1)

## V2

def checkHighers(numObj = 0, numToInsert = 0):
    arrayNum = []
    arrayHigh = []

    for i in range(0,numToInsert):
        arrayNum.append(int(input("Inserta un nuevo numero: ")))
        
    for i in arrayNum:
        if i > numObj:
            arrayHigh.append(i)
            

    print(f"Los numeros mayores que {numObj} son: {arrayHigh}")
    
num0 = int(input("Introduce un numero: "))
num1= int(input("Introduce cuantos numeros vas a meter: "))
checkHighers(num0, num1)