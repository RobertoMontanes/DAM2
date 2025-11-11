

from UsuarioGen import generarUsuarios
from SubscripcionGen import generarSubscripciones


nombre_archivo = "import.sql"

usuarios_count = 100;


finalString = ""

subs_string, subscripciones = generarSubscripciones()

finalString += subs_string
finalString += "\n\n"
finalString += generarUsuarios(usuarios_count, subscripciones)
finalString += "\n\n"

with open(nombre_archivo, "w", encoding="utf-8") as archivo:
    archivo.write(finalString)

print(f"Archivo '{nombre_archivo}' generado")
