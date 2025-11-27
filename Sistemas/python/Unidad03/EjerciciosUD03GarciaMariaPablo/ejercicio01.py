# Escriba un programa que pida un número. Después pregunte cuántos números se van a introducir, pida
# esos números, y escriba cuántos de esos números era mayor que el anterior.

def checkHighers(numObj = 0, numToInsert = 0):
    print(f"NumObj={numObj}, numToInser={numToInsert}")
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

