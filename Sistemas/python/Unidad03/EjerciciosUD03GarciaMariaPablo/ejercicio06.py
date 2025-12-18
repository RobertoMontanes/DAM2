# Escribe una función filtrar_calorias (lista_comidas, max_calorias) que reciba una lista de tuplas
# (nombre_comida, calorías) y devuelva una nueva lista solo con las comidas cuya cantidad de calorías
# sea menor o igual que max_calorias. Si la lista está vacía, devuelve una lista vacía

lista_comidas = [
    ("Ensalada", 150),
    ("Hamburguesa", 550),
    ("Fruta", 100),
    ("Pizza", 400),
    ("Yogur", 120),
    ("Patatas fritas", 300),
    ("Sopa", 200)
]

def filtar_calorias(lista_comidas, max_calorias):
    nueva_lista = []
    for comida, calorias in lista_comidas:
        if calorias <= max_calorias:
            nueva_lista.append((comida, calorias))
    return nueva_lista

print(filtar_calorias(lista_comidas, 200))  # Ejemplo de uso