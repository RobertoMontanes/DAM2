# 7. Crea un programa que lea los datos de clientes y los vaya escribiendo en un fichero de texto, de tal
# manera que dicho fichero quede algo así como el siguiente:

opcion = -1
f = open("files/clientes.txt", "w")
f.write("El contenido del fichero cliente.txt es:\n")

while opcion != 0:
    nombre = input("Escriba el nombre: ")
    f.write(f"Nombre:\t\t\t\t{nombre}\n")
    
    apellido1 = input("Escriba el apellido1: ")
    f.write(f"Apellido1:\t\t\t{apellido1}\n")
    
    apellido2 = input("Escriba el apellido2: ")
    f.write(f"Apellido2:\t\t\t{apellido2}\n")
    
    edad = input("Escriba el edad: ")
    f.write(f"Edad:\t\t\t\t{edad}\n")
    
    opcion = int(input("Si quiere salir pulse 0, si no, otro numero: "))
    
f.close()