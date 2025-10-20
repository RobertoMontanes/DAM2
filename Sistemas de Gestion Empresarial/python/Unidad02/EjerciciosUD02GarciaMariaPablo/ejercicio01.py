listaString = ["Hola", "Mundo", "Python", "Genial", "Es", "Genial", "Genial"]

print("Hola, en el programa de hoy vamos a ver que Operaciones existen para trabajar con listas.")

print()

print("### OBTENER ###")
print("Vamos a ver como obtener elementos de una lista, para ello llamaremos a la variable de lista y entre corchetes pondremos el indice del elemento que queremos obtener,"+
    " por ejemplo listaString[0], devolveria el primer valor de la lista.")
print("El primer valor de la lista es:", listaString[0])

print()


print("Para obtener el ultimo elemento de la lista podemos usar el indice -1, por ejemplo listaString[-1], devolveria el ultimo valor de la lista.")
print("El ultimo valor de la lista es:", listaString[-1])

print()


print("### TROCEAR ###")
print("Tambien podemos trocear una lista, para ello usaremos dos indices separados por dos puntos dentro de los corchetes, por ejemplo listaString[1:4], devolveria los elementos "+
    "desde el indice 1 hasta el indice 3 (el indice 4 no se incluye).")
print("Los valores desde el indice 1 hasta el indice 3 son:", listaString[1:4])
print("Los valores desde el indice 2 hasta el final son:", listaString[2:])

print()


print("### INVERTIR ###")
print("Podemos invertir una lista utilizando el indice -1, por ejemplo listaString[::-1] devolveria la lista al reves.")
print("La lista invertida es:", listaString[::-1])
print("tambien podemos usar el metodo reverse() que invierte la lista original.")
print("La lista invertida es:", list(reversed(listaString)))

print("### AÑADIR ###")
print("Para añadir un elemento al final de la lista usaremos el metodo append(), por ejemplo listaString.append('NuevoElemento') añadira 'NuevoElemento' al final de la lista.")
listaString.append("NuevoElemento")
print("La lista despues de añadir un elemento es:", listaString)

print()
print("Aunque tambien podemos usar el metodo insert() para añadir un elemento en una posicion concreta, por ejemplo listaString.insert(2, 'ElementoEnPosicion2') añadira "+
    "'ElementoEnPosicion2' en la posicion 2 de la lista.")
listaString.insert(2, "ElementoEnPosicion2")
print("La lista despues de añadir un elemento en una posicion concreta es:", listaString)


print()
print("### ELIMINAR ###")
print("Para eliminar un elemento de la lista usaremos el metodo remove(), por ejemplo listaString.remove('Mundo') eliminara 'Mundo' de la lista.")
listaString.remove("Mundo")
print("La lista despues de eliminar un elemento es:", listaString)
print("Tambien podemos usar el metodo pop() para eliminar un elemento en una posicion concreta, por ejemplo listaString.pop(3) eliminara el elemento en la posicion 3 de la lista.")
listaString.pop(3)
print("La lista despues de eliminar el elemento en la posicion 3 es:", listaString)

print("O tambien podemos eliminar con la sentencia del, por ejemplo del listaString[0] eliminara el primer elemento de la lista.")
del listaString[0]
print("La lista despues de eliminar el primer elemento es:", listaString)

print()
print("### MODIFICAR ###")
print("Para modificar un elemento de la lista simplemente llamamos a la posicion del elemento y le asignamos un nuevo valor, por ejemplo listaString[1] = 'ElementoModificado' "+
    "modificara el elemento en la posicion 1 de la lista.")
listaString[1] = "ElementoModificado"
print("La lista despues de modificar el elemento en la posicion 1 es:", listaString)

print()
print("### VERACIDAD MULTIPLE ###")
print("Las listas pueden contener elementos de diferentes tipos de datos, por ejemplo podemos tener una lista con booleanos, y podriamos usar estos booleanos para comprobar las "+
    "condiciones almacenadas dentro de ellos, por ejemplo podriamos hacer una lista cuyo primer elemento fuera una comprobacion de '4 < 3', que se quedaria como falso.")
listaVeracidad = [4 < 3, 5 == 5, 10 > 2]
print("La lista de veracidad es:", listaVeracidad)
print("Podemos usar esta lista para comprobar las condiciones almacenadas en ella, por ejemplo:")
print("Podemos comprobar si todas las condiciones son verdaderas usando la funcion all():", all(listaVeracidad))
print("Podemos comprobar si alguna de las condiciones es verdadera usando la funcion any():", any(listaVeracidad))
print("Y estas comprobaciones podemos usarlas para condicionales:")
if all(listaVeracidad):
    print("Todas las condiciones son verdaderas.")
else:
    print("No todas las condiciones son verdaderas.")

print()
print("### BUSCAR ###")
print("Para buscar un elemento en la lista usaremos el metodo index(), por ejemplo listaString.index('Genial') devolvera el indice del elemento 'Genial' en la lista.")
indice = listaString.index("Genial")
print("El indice del elemento 'Genial' es:", indice)
print("Si el elemento no existe en la lista, se generara un error.")
print("Tambien podemos usar el operador in para comprobar si un elemento existe en la lista, por ejemplo 'Genial' in listaString devolvera True si 'Genial' existe en la lista y"+
    " False si no existe.")
existe = "Genial" in listaString
print("¿El elemento 'Genial' existe en la lista?:", existe)

print()
print("Tambien podemos contar el numero de veces que aparece un elemento en la lista con la funcion .count(), por ejemplo listaString.count('Genial') devolvera el numero de veces"+
    " que 'Genial' aparece en la lista.")
contador = listaString.count("Genial")
print("El elemento 'Genial' aparece", contador, "veces en la lista.")

print()
print("### RECORRER ###")
print("Para recorrer una lista disponemos de diversas maneras, entre ellas podemos o bien iterar por lo elementos o iterar por la longitud, para este segundo caso deberemos usar"+
    " la funcion len() para obtener la longitud de la lista.")
print("Por ejemplo, en el estado actual de la lista tenemos los siguientes elementos:" + str(len(listaString)) + " elementos, y con un for i in range(len(listaString)) podemos "+
    "recorrer la lista por indices:")
for i in range(len(listaString)):
    print("Elemento en la posicion", i, "es:", listaString[i])
print("Otra forma de recorrer la lista es directamente por los elementos, usando for elemento in listaString:")
for elemento in listaString:
    print("Elemento:", elemento)

print("La ITERACION no esta limitada a solo una lista, podemos usar la funcion zip() para iterar por varias listas a la vez, por ejemplo:")

shopping = [ "Agua" , "Aceite" , "Arroz","Pan","Harina" ]
details = [ "mineral natural" , "de oliva virgen" , "basmati", "integral" ]

for prod,det in zip(shopping,details):
    print ( prod + " - " + det )
    
print(" Si alguna de las listas no fuese de la misma longitud, la iteracion se detendria en la longitud de la lista mas corta.")



print()
print("### ORDENAR ###")
print("Para ordenar una lista usaremos el metodo sort(), por ejemplo listaString.sort() ordenara la lista en orden alfabetico.")
listaString.sort()  
print("La lista despues de ordenar es:", listaString)
print("Si queremos ordenar la lista en orden inverso, podemos usar el parametro reverse=True, por ejemplo listaString.sort(reverse=True) ordenara la lista en orden alfabetico inverso.")
listaString.sort(reverse=True)
print("La lista despues de ordenar en orden inverso es:", listaString)
print("Tambien podemos usar la funcion sorted() que devuelve una nueva lista ordenada sin modificar la lista original.")
nuevaListaOrdenada = sorted(listaString)
print("La nueva lista ordenada es:", nuevaListaOrdenada)
print("La lista original no se ha modificado:", listaString)

print()
print("### COPIAR ###")
print("Para copiar una lista usaremos el metodo copy(), por ejemplo listaCopia = listaString.copy() creara una copia de la lista original.")
listaCopia = listaString.copy()
print("La copia de la lista es:", listaCopia)
print("La lista original es:", listaString)

print("Tambien podemos copiar una lista de forma literal igualando la lista original a una nueva variable, por ejemplo listaCopiaLiteral = listaString")
listaCopiaLiteral = listaString
print("La copia literal de la lista es:", listaCopiaLiteral)
print("La lista original es:", listaString)
print("La diferencia entre ambos metodos de copia es que si modificamos la copia literal, tambien se modificara la lista original, ya que ambas variables apuntan a la misma lista en memoria.")
listaCopiaLiteral.append("ElementoEnCopiaLiteral")
print("Despues de añadir un elemento a la copia literal:")
print("La copia literal de la lista es:", listaCopiaLiteral)
print("La lista original es:", listaString)
print("En cambio, si modificamos la copia realizada con el metodo copy(), la lista original no se vera afectada.")
listaCopia.append("ElementoEnCopia")
print("Despues de añadir un elemento a la copia realizada con copy():")
print("La copia de la lista es:", listaCopia)
print("La lista original es:", listaString)

print("Si quisieramos hacer una copia literal pero sin que afectase a la lista original, podriamos usar el slicing completo, por ejemplo listaCopiaSlicing = listaString[:]")
listaCopiaSlicing = listaString[:]
print("La copia por slicing de la lista es:", listaCopiaSlicing)
print("La lista original es:", listaString)
print("Ahora si modificamos la copia por slicing, la lista original no se vera afectada.")
listaCopiaSlicing.append("ElementoEnCopiaSlicing")
print("Despues de añadir un elemento a la copia por slicing:")
print("La copia por slicing de la lista es:", listaCopiaSlicing)
print("La lista original es:", listaString)

print()
print("### LIMPIAR ###")
print("Para limpiar una lista usaremos el metodo clear(), por ejemplo listaString.clear() eliminara todos los elementos de la lista.")
listaString.clear() 
print("La lista despues de limpiarla es:", listaString)
print("Como podemos ver, la lista esta vacia ahora.")

print("Tambien podriamos limpiar igualando la lista actual a una lista vacia, por ejemplo listaString = []")
print("Esto tambien dejaria la lista vacia, con la diferencia de que ocuparia un espacio en memoria diferente al original.")

print()

print()
print("### OTRAS OPERACIONES ###")


print("Tambien podemos trocear algun elemento para convertirlo en cadena usando .split() para convertir una cadena de texto en una lista, por ejemplo 'Hola Mundo Python'.split() "+
    "devolveria una lista con los elementos separados por espacios.")
cadena = "Hola Mundo Python"
listaDesdeCadena = cadena.split()
print("La lista creada a partir de la cadena es:", listaDesdeCadena)

print()
print("### FIN DEL PROGRAMA ###")