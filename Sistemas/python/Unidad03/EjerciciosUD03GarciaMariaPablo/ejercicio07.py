# Implementa una función modo_avion(texto, activar=True) que reciba una cadena y un booleano.
# - Si activar es True, devuelve la cadena "[MODO AVIÓN] " seguida del texto.
# - Si activar es False, devuelve solo el texto original.

def modo_avion(texto, activar=True):
    if activar:
        return "[MODO AVIÓN] " + texto
    else:
        return texto
    
print(modo_avion("Conexión desactivada"))
print(modo_avion("Conexión activada", False))