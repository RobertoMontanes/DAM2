# 5. Realiza un programa que lea el fichero 'datos.txt' y cree un nuevo fichero 'invertido.txt' con las
# líneas en orden inverso.

fOriginal = open("files/datos.txt")
lineas = fOriginal.readlines()
fOriginal.close()

fCopia = open("files/invertido.txt", "w")

for line in reversed(lineas):
    fCopia.write(line)
    
fCopia.close()