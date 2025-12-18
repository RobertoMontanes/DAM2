# Crea una función es_spam(asunto, *palabras_prohibidas) que devuelva True si en el asunto aparece
# alguna de las palabras prohibidas (ignorando mayúsculas/minúsculas), y False en caso contrario.

def es_spam(asunto, *palabras_prohibidas):
    asunto = asunto.lower()
    for palabra in palabras_prohibidas:
        if palabra.lower() in asunto:
            return True
    
    return False

spam = es_spam("Presentacion", "venta", "regalo", "premio")

if spam:
    print("El texto es spam")
else:
    print("El texto no es spam")
    