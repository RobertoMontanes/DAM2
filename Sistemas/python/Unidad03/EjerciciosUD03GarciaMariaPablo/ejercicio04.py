# Escriba un programa que pida un número y dibuje dos cuadrados de ese número de estrellas en
# diagonal, como muestran los ejemplos siguientes:

def draw_squares(n):
    for i in range(n):
        print('* ' * n)

    for i in range(n):
        print('  ' * n + '* ' * n)
        
draw_squares(int(input("Introduzca el tamaño de los cuadrados: ")))