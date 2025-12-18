# Crea una función estado_bateria(porcentaje) que:
# - Devuelva "Perfecto" si porcentaje está entre 80 y 100.
# - Devuelva "Aceptable" entre 30 y 79.
# - Devuelva "Modo ahorro YA" entre 10 y 29.
# - Devuelva "Busca un enchufe" si es menor que 10.

def estado_bateria(porcentaje):
    if 80 <= porcentaje <= 100:
        return "Perfecto"
    elif 30 <= porcentaje <= 79:
        return "Aceptable"
    elif 10 <= porcentaje <= 29:
        return "Modo ahorro YA"
    else:
        return "Busca un enchufe"
    
print(estado_bateria(50))
print(estado_bateria(29))
print(estado_bateria(30))
print(estado_bateria(79))
print(estado_bateria(80))
print(estado_bateria(4))