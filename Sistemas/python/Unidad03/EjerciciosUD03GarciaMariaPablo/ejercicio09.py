# Define una función mas_procrastina(diccionario_horas) que reciba un diccionario con pares {nombre:
# horas_procrastinando} y devuelva el nombre de la persona que más horas ha procrastinado.
# Si el diccionario está vacío, devuelve None.
import random

valor_inicial = {
    "nombre1": 12,
    "nombre2": 7,
    "nombre3": 9,
    "nombre4": 16,
    "nombre5": 15,
}

# MIO

def mas_procastina(diccionario_horas):
    
    nombre_horas = random.choice(list(diccionario_horas.items()))
    mayor_horas = diccionario_horas[nombre_horas[0]]
    
    if len(diccionario_horas) == 0:
        return None
    
    for n in diccionario_horas:
        if (diccionario_horas[n] > mayor_horas):
            nombre_horas = n
            mayor_horas = diccionario_horas[n]
    
    return nombre_horas

print(mas_procastina(valor_inicial))