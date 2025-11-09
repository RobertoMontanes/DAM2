import random
import env
import datetime

def generarMembresias(usuario, subscripciones):
    finalString = ""
    
    # INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (1, 2, '2025-09-10', '2025-11-10', true, false);
    usuario_id = usuario["id"]
    membresias = random.randint(0,10);
    fecha_inicio_anterior = None;
    for i in range(0,membresias):
        
        subscripcion = random.choice(subscripciones);
        
        subscripcion_id = subscripcion["id"]

        fecha_inicio_anio = random.choice(env.anios)
        fecha_inicio_mes = random.choice(env.meses)
        fecha_inicio_dia = random.randint(1, env.dias_mes[fecha_inicio_mes - 1])
        fecha_incio = datetime.date(fecha_inicio_anio, fecha_inicio_mes, fecha_inicio_dia);
        
        if fecha_inicio_anterior == None:
            fecha_inicio_anterior = fecha_incio;
        else:
            while fecha_incio <= fecha_inicio_anterior:
                fecha_inicio_anio = random.choice(env.anios)
                fecha_inicio_mes = random.choice(env.meses)
                fecha_inicio_dia = random.randint(1, env.dias_mes[fecha_inicio_mes - 1])
                fecha_incio = datetime.date(fecha_inicio_anio, fecha_inicio_mes, fecha_inicio_dia);
        
        fecha_fin_anio = fecha_inicio_anio + (subscripcion["frecuencia"] // 12)
        fecha_fin_mes = fecha_inicio_mes + (subscripcion["frecuencia"] % 12)
        if fecha_fin_mes > 12:
            fecha_fin_anio += 1
            fecha_fin_mes -= 12 
        fecha_fin_dia = fecha_inicio_dia
        if fecha_fin_dia > env.dias_mes[fecha_fin_mes -1]:
            fecha_fin_dia = env.dias_mes[fecha_fin_mes -1]
        fecha_fin = datetime.date(fecha_fin_anio, fecha_fin_mes, fecha_fin_dia);
        fecha_inicio = fecha_incio.strftime("%Y-%m-%d")
        fecha_fin = fecha_fin.strftime("%Y-%m-%d")
        activa = False
        cancelado = False
        if fecha_fin > str(datetime.date.today()) and fecha_inicio <= str(datetime.date.today()):
            activa = True
        else:
            cancelado = random.choice([True, False])
        
        fecha_inicio_anterior = fecha_incio
        
        finalString += f"INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES ({usuario_id}, {subscripcion_id}, '{fecha_inicio}', '{fecha_fin}', {str(activa).lower()}, {str(cancelado).lower()});\n"

        if fecha_fin > str(datetime.date.today()):
            break;
    
    return finalString
