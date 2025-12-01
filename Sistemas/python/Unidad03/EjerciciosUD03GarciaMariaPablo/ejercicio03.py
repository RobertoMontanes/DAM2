# Escriba un programa que pregunte cuántos números se van a introducir, pida esos números, y muestre
# un mensaje cada vez que un número no sea mayor que el anterior

def check_increasing():
    cont = int(input("¿Cuántos números va a introducir? "))
    if cont <= 0:
        print("Debe introducir al menos un número.")
        return

    numAnt = None

    for i in range(cont):
        numAct = int(input(f"Introduzca el número {i + 1}: "))
        
        if numAnt is not None and numAct <= numAnt:
            print(f"El número {numAct} no es mayor que el anterior {numAnt}.")
        
        numAnt = numAct

check_increasing()