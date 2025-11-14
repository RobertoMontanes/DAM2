f = open("files/temps.txt")
print(f.read())

print("BUSQUEDA LINEA A LINEA")

f.seek(0)
linea1 = f.readline(1)
print(linea1)

print("BUSQUEDA for")

f.seek(0)
for linea in f.readlines():
    print(linea, end='')