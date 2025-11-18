f = open("luminitas.log", "w")
f.write("Día 1: Los Luminitas brillan más cuando escuchan música suave.\n")
f.write("Día 2: Hoy uno de ellos imitó el sonido de la lluvia.\n")
f.write("Día 3: Parece que se agrupan cuando la temperatura baja.\n")
f.close()

f = open("luminitas.log", "a")
f.write("Día 4: Descubrí que se comunican con destellos de luz.\n")
f.close()

f = open("luminitas.log", "r")
contenido = f.read()
print("Lectura inicial:\n", contenido)
f.close()

contenido_mod = contenido.replace("luz", "luminiscencia").replace("Luz", "LUMINISCENCIA")
f = open("luminitas.log", "w")
f.write(contenido_mod)
f.close()

f = open("luminitas.log", "r")
lineas = f.readlines()
f.close()
lineas.pop(1)

f = open("luminitas.log", "w")
f.writelines(lineas)
f.close()

f = open("luminitas.log", "r")
print("\nLectura final tras eliminar una línea y modificar:")
print(f.read())
f.close()