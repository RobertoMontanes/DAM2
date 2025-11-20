# Escribe un programa que cuente cuántas líneas NO vacías contiene un fichero 'entrada.txt' que
# tenga varias líneas de prueba.

f = open("files/entrada.txt")

fullEmpty = False;
cont = 0
lastCharacter = ""

for linea in f:
    if linea != "\n":
        cont+=1
    
print(f"Este fichero contiene un total de {cont} lineas con contenido.")

f.close()