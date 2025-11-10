# Voy a alquilar una habitación de mi casa a modo de apartamento turístico y necesito un programa para gestionar lo
# recaudado. Se debe usar una lista como estructura principal para guardar los datos (si hace falta alguna tupla se puede
# usar). Como no hemos dado todavía objetos, lo haremos con una lista de flotantes, que será lo recaudado cada día que lo
# alquilo.
# El programa puede empezar creando una lista directamente con datos y luego poder hacer lo siguiente mediante un menú
#en la clase Principal y debe mostrar en la misma
# • Agregar una nueva recaudación.
# • Poner a cero una recaudación (se me ha ido el cliente sin pagar).
# • Imprimir toda la lista, es decir, mostrar todos los datos de todas las recaudaciones en bonito.
# • Buscar el día en que más he ganado y decir cuántos días he ganado esa cantidad.
# • Sumar una cantidad a un día como gasto extra.
# • Calcular cuánto he recaudado en todas las recaudaciones.
# • Ordenar la lista de mayor a menor.
# • Calcular la media diaria.
# • Calcular el porcentaje de días al mes (suponiendo 30 días) en que he tenido la habitación alquilada.
# • Dividir la lista en dos nuevas listas. Una de ellas debe ser la que tenga las 5 menores recaudaciones, la otra las restantes.

recaudaciones = [117.20, 0.0, 89.50, 200.00, 150.75, 0.0, 300.40, 50.00, 0.0, 400.00]

opcion = -1
opciones = [
    "Salir",
    "Agregar una nueva recaudación",
    "Poner a cero una recaudación",
    "Imprimir todas las recaudaciones",
    "Buscar el día con mayor recaudación",
    "Sumar gasto extra a un día",
    "Calcular recaudación total",
    "Ordenar recaudaciones de mayor a menor",
    "Calcular media diaria",
    "Calcular porcentaje de días alquilados",
    "Dividir recaudaciones en dos listas",
]

while opcion != 0:
    for i in range(len(opciones)):
        print(f"{i}. {opciones[i]}")
    opcion = int(input("Seleccione una opción: "))
    
    match opcion:
        case 0:
            print("Saliendo del programa.")
        case 1:
            nueva_recaudacion = float(input("Ingrese la nueva recaudación: "))
            recaudaciones.append(nueva_recaudacion)
            print("Recaudación agregada.")
        case 2:
            indice = int(input("Ingrese el índice de la recaudación a poner a cero: "))
            if 0 <= indice < len(recaudaciones):
                recaudaciones[indice] = 0.0
                print("Recaudación puesta a cero.")
            else:
                print("Índice no válido.")
        case 3:
            print("Lista de recaudaciones:")
            for i, recaudacion in enumerate(recaudaciones):
                print(f"Día {i + 1}: {recaudacion} €")
        case 4:
            max_recaudacion = max(recaudaciones)
            dias_max = recaudaciones.count(max_recaudacion)
            print(f"La mayor recaudación es {max_recaudacion} €, ocurrida en {dias_max} días.")
        case 5:
            indice = int(input("Ingrese el índice del día al que desea sumar gasto extra: "))
            if 0 <= indice < len(recaudaciones):
                gasto_extra = float(input("Ingrese el gasto extra a sumar: "))
                recaudaciones[indice] += gasto_extra
                print("Gasto extra sumado.")
            else:
                print("Índice no válido.")
        case 6:
            total_recaudado = sum(recaudaciones)
            print(f"Total recaudado: {total_recaudado} €")
        case 7:
            recaudaciones_ordenadas = sorted(recaudaciones, reverse=True)
            
            for r in recaudaciones_ordenadas:
                print(f"{r} €")
                
        case 8:
            media_diaria = sum(recaudaciones) / len(recaudaciones)
            print(f"La media diaria de recaudación es: {media_diaria} €")
        case 9:
            dias_alquilados = sum(1 for r in recaudaciones if r > 0)
            porcentaje_alquilados = (dias_alquilados / 30) * 100
            print(f"Porcentaje de días alquilados: {porcentaje_alquilados:.2f}%")
        case _:
            print("Opción no válida. Por favor, seleccione una opción del menú.")
        