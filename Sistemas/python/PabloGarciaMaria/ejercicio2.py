import random as r;

diasSemana = ["Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
juegoSemanal = [0,0,0,0,0,0,0]
videoJuegos = []
indices = []

maxTime = 0
minTime = 0
antesDeExamen = 0
extraTime = 0

opcion = -1
opcionSalir = 0
opciones = [
    "Exit",
    "Add extra time on weekends",
    "Find exam days",
    "Combine play times and videogames",
    "Sort list",
    "Print playtimes"
]

print("Hello and welcome to our time management program, with todays program we are going to help "+
    "you check how many time you spend playing games all over the week.")

print("We are going to start generating your play time: ")
maxTime = int(input("What is the max amount of time that you have spent playing: "))
minTime = int(input("What is the min amount of time that you have spent playing: "))

for i in range(len(juegoSemanal)):
    juegoSemanal[i] = r.randint(minTime,maxTime)

while opcion != opcionSalir:
    for i in range(len(opciones)):
        print(f"{i}. {opciones[i]}")
        
    opcion = int(input("What do you want to do? "))
    print()
    
    match opcion:
        case 0:
            print("Thanks for using the program, have a nice day.")
        case 1: 
            opcion = int(input("In wich day do you want to add playtime 0. Saturday, 1. Sunday: "))
            extraTime = int(input("How many hours do you want to add? "))
            match opcion:
                case 0:
                    juegoSemanal[6] += extraTime
                case 1:
                    juegoSemanal[0] += extraTime
                case _:
                    print("Invalid option selected on day picker, returning to the menu.")
            opcion = -1
        case 2:
            print("Finding the exam days.")
            indices = []
            for i in range(len(juegoSemanal)):
                if juegoSemanal[i] == antesDeExamen:
                    indices.append(i)

            if len(indices) == 0:
                print("There was no exams this week.")
            else:
                for i in indices:
                    print(f"There was an exam on {diasSemana[i]}.")
        
        case 3:
            print("We are going to combine videogames and playtimes: ")
            videoJuegos = []
            for i in range(len(juegoSemanal)):
                videoJuegos.append(input(f"Insert the name of a game that you have played: ")) 
            
            print("Now, the results: ")
            listaCombinada = list(juegoSemanal)
            listaCombinada.extend(videoJuegos)
            print(listaCombinada)            
        case 4:
            print(f"After sorting the times from Max to Min the final list is: {sorted(juegoSemanal,reverse=True)}")
        case 5:
            print("Printing playtimes: ")
            for i in zip(juegoSemanal, diasSemana):
                print(f"You have played {i[0]} hours on {i[1]}")
        case _:
            print("Invalid option selected, please try another one.")
    print()