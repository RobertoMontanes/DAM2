
while True:
    anio = int(input("Dime el año que quieres comprobar: "))

    if (anio % 4 == 0 and anio % 100 == 0) or (anio % 400 == 0):
        print("Este año es bisiesto.")
    else:
        print("Nop")

# anios = [1950,1920,1925,1820,1530,2025,2026,2027,2028,2029,2030,2020,2021,2022]
# for i in range(0,len(anios)):
#     print(f"Estamos comprobando el año: {anios[i]}")
# if (anios[i] % 4 == 0 and anios[i] % 100 != 0) or (anios[i] % 400 == 0):
#     print("Este año es bisiesto.")
# else:
#     print("Nop")