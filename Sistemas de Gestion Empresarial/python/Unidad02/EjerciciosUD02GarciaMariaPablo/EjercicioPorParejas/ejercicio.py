# Tiene que ser de cadenas, debe llamarse provincias y vamos a guardar 5 provincias de andalucia.
# Ahora tenemos que eliminar una que no tenga costa, playa.
# Ordena las que quieras alfabeticamente
# De entre las provincias restantes escogeremos una provincia favorita.
# Insertar en la primera posicion, nuestra provincia favorita.
# Ahora vamos a eliminar las 2 que estan en medio 
# Habeis elegido antes una provincia favorita, ahora vamos a hacer que se repita ese elemento 2 veces masp

provincias = ['Sevilla', 'Jaén', 'Málaga', 'Cádiz', 'Huelva', 'Granada', 'Córdoba', 'Almería']
insertarVeces = 2

provinciaSinCosta = 'Sevilla'
provinciaFavorita = 'Cádiz'

masApariciones = -1
veces = -1
nombreMasApariciones = ""

print("Bienvenido al juego de Provincias, vamos a realizar una serie de actividades sobre una lista con las provincias de Andalucía.\n")

print("Para empezar vamos a eliminar una ciudad que no tenga costa: ")
provincias.remove(provinciaSinCosta)
print(f"La lista actual es: {provincias} \n")

print("Ahora vamos a ordenar la lista en orden alfabetico: ")
provincias.sort()
print(f"La lista actual es: {provincias} \n")

print("Nuestra provincia favorita es " + provinciaFavorita + ".")
provincias.insert(0, provinciaFavorita)
print(f"La lista actual es: {provincias} \n")

print("Ahora vamos a eliminar las 2 provincias ubicadas en el centro de la lista.")
del provincias[3:5]
print(f"La lista actual es: {provincias} \n")


print(f"Ahora vamos a insertar nuestra provincia favorita ({provinciaFavorita}) en las posiciones 1 y 2 lista original.")
for i in range(0,insertarVeces):
    provincias.insert(1,provinciaFavorita)
print(f"La lista actual es: {provincias} \n")

print("Vamos a buscar la provincia que mas se repite: ")
for provincia in provincias:
    veces = provincias.count(provincia)
    if masApariciones < veces: 
        masApariciones = veces
        nombreMasApariciones = provincia
print(f"La provincia mas repetida es: {nombreMasApariciones}, aparece {masApariciones} veces. \n")

print(f"Ahora vamos a eliminar el elemento en el indice: {masApariciones}. ")
del provincias[masApariciones]
print(f"La lista actual es: {provincias} \n")

print("Ahora vamos a invertir la lista. ")
provincias.reverse()
print(f"La lista actual es: {provincias} \n")

print("Ahora eliminaremos los dos ultimos elementos. ")
provincias[-3:-1] = []
print(f"La lista actual es: {provincias} \n")
