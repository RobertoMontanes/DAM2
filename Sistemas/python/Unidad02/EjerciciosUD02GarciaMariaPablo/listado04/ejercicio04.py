# Crea un programa que lea un fichero llamado 'texto.txt' y genere 'numerado.txt' con todas las líneas
# precedidas de su número.

f = open("files/texto.txt")
newF = open("files/numerado.txt", "w")

lines = f.readlines()
f.close()

for i in range(len(lines)):
    newF.write(f"{i}. {lines[i]}")

newF.close()
