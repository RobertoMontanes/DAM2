import datetime

# Crea un programa que añada la fecha y hora actuales al final de un fichero.

f = open("files/fechas.txt", "a")

f.write(datetime.datetime.now().strftime("%d/%m/%Y %H:%M:%S") +  "\n")

f.close()