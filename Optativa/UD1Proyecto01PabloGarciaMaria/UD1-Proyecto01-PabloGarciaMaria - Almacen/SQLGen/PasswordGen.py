import string
import random

def generar_contraseña(longitud=12, mayusculas=True, minusculas=True, digitos=True, simbolos=True):
    caracteres = ''
    if mayusculas:
        caracteres += string.ascii_uppercase
    if minusculas:
        caracteres += string.ascii_lowercase
    if digitos:
        caracteres += string.digits
    if simbolos:
        caracteres += string.punctuation
        
    if "'" in caracteres:
        caracteres = caracteres.replace("'", "")

    if not caracteres:
        raise ValueError("Debe seleccionar al menos un tipo de caracteres")

    contraseña = ''.join(random.choice(caracteres) for _ in range(longitud))
    return contraseña