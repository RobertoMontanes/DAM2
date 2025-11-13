agenda = {
    "987 65 43 21": "Luisito",
    "012 34 56 78": "Papa",
    "901 23 45 67": "Jose",
    "890 12 34 56": "Paco",
    "789 01 23 45": "Luis",
    "678 90 12 34": "Paco",
    "567 89 01 23": "Alberto",
    "456 78 90 12": "Antonio",
    "345 67 89 01": "German",
    "234 56 78 90": "Simon",
    "123 45 67 89": "Mama", 
    }
historico = dict()

claveInt = ""
valorInt = ""

opcion = -1
opcionSalir = 0
opciones = [
    "Exit",
    "Modify a value",
    "Search a phone number",
    "Count a name",
    "Show all",
    "Delete an element",
    "Show historical agenda"
]

print("Hello, welcome to our Contacts program, in todays program we are going to emulate a phone agenda.")

while opcion != opcionSalir:
    for i in range(len(opciones)):
        print(f"{i}. {opciones[i]}")
        
    opcion = int(input("What do you want to do? "))
    print()
    
    match opcion:
        case 0:
            print("Thanks for using our program, have a nice day.")
        case 1:
            claveInt = input("Insert the phone number wich you want to modify: ")
            valorInt = input("Insert the new name of the owner of the telephone: ")
            
            agenda[claveInt] = valorInt
            
            print(f"The key: {claveInt} has been modified or added in case it didn't exist.")
        case 2:
            claveInt = input("Insert the phone number wich you want to search for: ")
            valorInt = agenda.get(claveInt,"No está en la agenda")
            print(f"The owner of: {claveInt} is {valorInt}")
        case 3:
            valorInt = input("Insert the name that you want to count: ")
            print(f"The name: {valorInt} appears {list(agenda.values()).count(valorInt)} times on the agenda")
        case 4:
            print("Loading the agenda")
            if len(agenda)<= 0:
                print("There are no record on the agenda.")
            else:
                for clave,valor in agenda.items():
                    print(f"The owner of: {clave} is {valor}.")
        case 5:
            claveInt = input("Insert the phone number wich you want to delete: ")
            historico[claveInt] = agenda.pop(claveInt)
            print(f"The phone number: {claveInt} has been deleted and added to the historical agenda.")
        case 6:
            print("Loading the historical agenda")
            if len(historico)<= 0:
                print("There are no record on the historical agenda.")
            else:
                for clave,valor in historico.items():
                    print(f"The owner of: {clave} is {valor}.")
        case _:
            print("Invalid option selected, please try another.")                
    print()

