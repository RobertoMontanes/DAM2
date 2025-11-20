# Haz un programa que copie el contenido de un fichero llamado 'origen.txt' en otro llamado
# 'copia.txt'.

fOrigen = open("files/origen.txt")
fCopia = open("files/copia.txt", "w")

for linea in fOrigen:
    fCopia.write(linea)

fCopia.close()
fOrigen.close()