import env



def generarSubscripciones():
    textoFinal = ""
    subscripciones_Creadas = [];
    for nombre in env.nombreSubscripciones:
        for frecuencia in env.frecuenciaSubscripciones:
            precio = env.precios[nombre][frecuencia]
            soporte = env.soportePrioritario[nombre]
            numAlmacenes = env.numeroAlmacenes[nombre]
            textoFinal += f"INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('{nombre}', {precio}, {numAlmacenes}, {str(soporte).lower()}, {frecuencia});\n"
            subscripciones_Creadas.append(
                {
                    "id": len(subscripciones_Creadas),
                    "nombre": nombre,
                    "frecuencia": frecuencia,
                    "precio": precio,
                    "soporte": soporte,
                    "numAlmacenes": numAlmacenes
                }
            )
    return textoFinal,subscripciones_Creadas
