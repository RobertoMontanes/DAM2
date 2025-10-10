sueldoBase = -1
sueldoFinal = -1

horasExtra = -1
maxHoraExtra = 30
horaExtraPago = 0

aniosTrab = -1
calculoAntiguedad = -1
cadaAniosTrab = 3
extraPorAnti = 2

calculoRegalo = -1
regalAntEdad = 25
regalAntPrem = 4

basePorcentaje = 100

catSelect = -1
cat1Extra = 40
cat2Extra = 50
cat3Extra = 75
cat4Extra = 0

opcionAct = -1
opcionSalir = 0




print("Bienvenido, vamos a revisar el sueldo de algunos trabajadores.")


while opcionAct != 0:
    print("0. Salir")
    print("1. Calcular sueldo")
    print("2. Modificar sueldo base")
    
    opcionAct = int(input("¿Que quiere hacer? "))

    if opcionAct == 0:
        continue
    elif opcionAct == 1:
        if sueldoBase == -1:
            print("No podemos calcular el sueldo de los trabajadores si aún no has definido el sueldo base.")
            continue

        print("Categorías de los trabajadores: ")
        print("0. Salir")        
        print(f"1. Categoría 1: {cat1Extra} euros por hora")        
        print(f"2. Categoría 2: {cat2Extra} euros por hora")        
        print(f"3. Categoría 3: {cat3Extra} euros por hora")        
        print(f"4. Categoría 4: {cat4Extra} euros por hora")        
        
        opcionAct = int(input("¿Que quiere hacer? "))
        if opcionAct == 0:
            opcionAct = -1
            print("Volviendo al menú inicial.")
            continue
        else:
            match opcionAct:
                case 1:
                    catSelect = cat1Extra
                case 2:
                    catSelect = cat2Extra
                case 3:
                    catSelect = cat3Extra
                case 4:
                    catSelect = cat4Extra
                case _:
                    print("Opcion invalida seleccionada, volviendo al menu inicial.")
                    continue

            print(f"Vamos a calcular el sueldo de un trabajador de Categoría {opcionAct}")

            print(f"El sueldo base de un trabajador es: {sueldoBase}")

            horasExtra = int(input("¿Cuantas horas extras ha trabajado? "))


            if horasExtra < 0:
                print("Un trabajador no puede tener horas extras negativas, estableciendo horas a 0.")
                horasExtra = 0

            if horasExtra > maxHoraExtra:
                horasExtra = maxHoraExtra
                print("Has superado el límite de horas extras, te estableceremos 30.")    

            horaExtraPago = horasExtra*catSelect

            print(f"Tras calcular las horas extras, el Trabajador de categoría {opcionAct}, cobrará {horaExtraPago} euros solo de horas extras")

            sueldoFinal = sueldoBase + horaExtraPago

            aniosTrab = int(input("¿Cuantas años lleva en la empresa? "))


            if aniosTrab < 0:
                print("Un trabajador no puede tener tiempo trabajado negativo, estableciendo años a 0.")
                aniosTrab = 0

            calculoAntiguedad = (sueldoFinal * (int(aniosTrab / cadaAniosTrab) * extraPorAnti)) / basePorcentaje
            print("Por antigüedad, el trabajador cobrará un extra de: " + str(calculoAntiguedad) + " euros")
            sueldoFinal += calculoAntiguedad

            if aniosTrab == regalAntEdad:
                calculoRegalo = (sueldoBase * regalAntPrem) / basePorcentaje
                print(f"Por llevar exactamente {regalAntEdad} años en la empresa, te regalaremos un extra del {regalAntPrem}% sobre tu sueldo base, es decir: {calculoRegalo}")
                sueldoFinal += calculoRegalo

            print(f"En total, el trabajador cobrará: {sueldoFinal}")
    elif opcionAct == 2:
        sueldoBase = float(input("Dime cuánto cobran los trabajadores: "))
    else:
        print("Ha seleccionado una opcion invalida, volviendo al menú.")

print("Gracias por usar el programa, que tenga buen dia.")