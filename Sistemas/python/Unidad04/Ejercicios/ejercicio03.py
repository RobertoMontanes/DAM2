# 3. Una inmobiliaria de una ciudad maneja una lista de inmuebles como la siguiente:
# [{'año': 2000, 'metros': 100, 'habitaciones': 3, 'garaje': True, 'zona': 'A'},
# {'año': 2012, 'metros': 60, 'habitaciones': 2, 'garaje': True, 'zona': 'B'},
# {'año': 1980, 'metros': 120, 'habitaciones': 4, 'garaje': False, 'zona': 'A'},
# {'año': 2005, 'metros': 75, 'habitaciones': 3, 'garaje': True, 'zona': 'B'},
# {'año': 2015, 'metros': 90, 'habitaciones': 2, 'garaje': False, 'zona': 'A'}]
# Construir una función que permita hacer búsqueda de inmuebles en función de un presupuesto dado. La función
# recibirá como entrada la lista de inmuebles y un precio, y devolverá otra lista con los inmuebles cuyo precio
# sea menor o igual que el dado. Los inmuebles de la lista que se devuelva deben incorporar un nuevo par a cada
# diccionario con el precio del inmueble, donde el precio de un inmueble se calcula con la siguiente fórmula en
# función de la zona:
# • Zona A: precio = (metros * 1000 + habitaciones * 5000 + garaje * 15000) * (1-antiguedad/100)
# • Zona B: precio = (metros * 1000 + habitaciones * 5000 + garaje * 15000) * (1-antiguedad/100) * 1.5

import datetime

opcion = -1
opcionAbandonar = 0

inmuebles = [
    {'año': 2000, 'metros': 100, 'habitaciones': 3, 'garaje': True, 'zona': 'A'},
    {'año': 2012, 'metros': 60, 'habitaciones': 2, 'garaje': True, 'zona': 'B'},
    {'año': 1980, 'metros': 120, 'habitaciones': 4, 'garaje': False, 'zona': 'A'},
    {'año': 2005, 'metros': 75, 'habitaciones': 3, 'garaje': True, 'zona': 'B'},
    {'año': 2015, 'metros': 90, 'habitaciones': 2, 'garaje': False, 'zona': 'A'}
    ]

inmueblesRetorno = []

def buscarInmueble(inmuebles, precioMax):
    inmueblesAptos = []
    año_actual = datetime.datetime.now().year
    
    
    for inmueble in inmuebles:
        
        antiguedad = año_actual - inmueble["año"]
        
        if inmueble["zona"] == "A":
            precio = (inmueble["metros"] * 1000 + inmueble["habitaciones"] * 5000 + inmueble["garaje"] * 15000) * (1-antiguedad/100)
        else:
            precio = (inmueble["metros"] * 1000 + inmueble["habitaciones"] * 5000 + inmueble["garaje"] * 15000) * (1-antiguedad/100) * 1.5
        
        if precio <= precioMax:
            inmueble["precio"] = precio
            inmueblesAptos.append(inmueble);
    
    return inmueblesAptos

print("Bienvenido al programa de busqueda de inmuebles. ")

while opcion != opcionAbandonar:
    precioLimite = float(input("Indique el precio maximo de busqueda: "));
    inmueblesRetorno = buscarInmueble(inmuebles, precioLimite)
    
    if len(inmueblesRetorno) == 0:
        print(f"No se han encontrada casas con precio menor a {precioLimite}.")
    else:
        print(f"Los siguientes inmuebles se encuentran por debajo de {precioLimite}: ")
        for i in range(0, len(inmueblesRetorno)):
            print(i+1, ". ", inmueblesRetorno[i])
        
    opcion = int(input("Si quiere repetir el programa indique algun numero, si no, pulse 0: "))

print("Muchas gracias por usar el programa, tenga un buen dia.")