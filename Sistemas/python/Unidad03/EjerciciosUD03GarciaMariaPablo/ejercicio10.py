# Implementa generar_password(base="1234", repeticiones=3) que devuelva una contraseña formada
# por la cadena base repetida el número de veces indicado y seguida de "!" al final.
# Ejemplo: generar_password("abc", 2) → "abcabc!".

def generar_password(base="1234", repeticiones=3):
    return base*repeticiones + "!"

print(generar_password())
print(generar_password("njfuvbyd",9))
    