# Escriba un programa que pida dos números (m y n) y que escriba n segmentos de m estrellas
# separados por m espacios, como muestran los ejemplos siguientes:

def draw_segments(m, n):
    estrellitas = "*" * m
    espacios = " " * m
    string = ""
    for i in range(n):
        string += estrellitas + "" + espacios
    return string
    
    
m = int(input("Introduzca el número de estrellas por segmento (m): "))
n = int(input("Introduzca el número de segmentos (n): "))

print(draw_segments(m, n))