import datetime

# Crea un programa que añada la fecha y hora actuales al final de un fichero.

f = open("files/fechas.txt", "a")

f.write(str(datetime.datetime.now()) +  "\n")

f.close()