# Implementar un programa en Python que pida un número indeterminado de cadenas de caracteres por el
# teclado, y cuando se finalice dicha introducción, muestre el listado de palabras.

cadenaConjunta = ""
seguir = "s"
while (seguir=="s"):
    cadenaConjunta += input("Escribe lo que quieras: ")
    seguir = input("Quieres seguir escribiendo? s/n ")

print(cadenaConjunta)
