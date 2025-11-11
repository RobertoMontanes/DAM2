import env
import random
import PasswordGen
from datetime import date;
import MembresiasGen

def generarUsuarios(limit, subscripciones):
    finalString = ""
    
    for i in range(limit):
        nombre = random.choice(env.nombres);
        apellido1 = random.choice(env.apellidos);
        apellido2 = random.choice(env.apellidos);
        username = f"{simplify_text(f"{apellido1.lower()}.{apellido2.lower()[0:2]}{nombre.lower()[0:2]}")}"
        email = f"{username}@example.com"
        activo = random.choice([True, False])
        
        anio = random.choice(env.anios)
        mes = random.choice(env.meses)
        dia = random.randint(1, env.dias_mes[mes - 1])
        
        while date.today() <= date(anio, mes, dia):
            mes = date.today().month
            dia = random.randint(1, env.dias_mes[mes - 1])

        fecha_creacion = f"{anio}-{mes:02d}-{dia:02d}"

        usuario = {
            "id": i,
            "nombre": nombre,
            "apellido1": apellido1,
            "apellido2": apellido2,
            "username": username,
            "email": email,
            "activo": activo,
            "fecha_creacion": fecha_creacion
        }
        finalString += "\n\n"
        finalString += f"INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('{nombre}', '{apellido1} {apellido2}', '{email}', '{username}', '{PasswordGen.generar_contraseña()}', {activo}, '{fecha_creacion}')\n"
        
        finalString += "\n"
        finalString += MembresiasGen.generarMembresias(usuario, subscripciones)
        
    return finalString

def simplify_text(text):
    replacements = {
        'á': 'a', 'é': 'e', 'í': 'i', 'ó': 'o', 'ú': 'u',
        'Á': 'A', 'É': 'E', 'Í': 'I', 'Ó': 'O', 'Ú': 'U',
        'ñ': 'n', 'Ñ': 'N', " ": "_"
    }
    for old, new in replacements.items():
        text = text.replace(old, new)
    return text