

# 1. Crear las lista
productos = ["Telarañas falsas", "Mascaras de Halloween", "Calabazas decorativas", "Dulces surtidos", "Disfraces de monstruos"]
ventas = [150, 200, 100, 250, 300]

ventasPorLetra = 0
letra = ""

print("Ventas de productos de Halloween:")
# Zippea las dos listas en una lista y muestra los datos en formato "Producto: Ventas"
productos_ventas = zip(productos, ventas)

for producto, venta in productos_ventas:
    print(f"{producto}: {venta}")
    
# Preguntale al usuario por una letra y calcula las ventas de los productos que comienzen por esa letra
letra = input("Ingresa una letra para filtrar productos: ")
for i in range(len(productos)):
    if productos[i][0].lower() == letra.lower():
        ventasPorLetra += ventas[i]
        print("El producto", productos[i], "comienza con la letra", letra, "y tiene", ventas[i], "ventas.")

print(f"Ventas totales de productos que comienzan con '{letra}': {ventasPorLetra}")

# Muestra el producto con mas ventas y el producto con menos ventas
max_ventas = max(ventas)
min_ventas = min(ventas)

producto_max = productos[ventas.index(max_ventas)]
producto_min = productos[ventas.index(min_ventas)]
print(f"Producto con mas ventas: {producto_max} ({max_ventas} ventas)")
print(f"Producto con menos ventas: {producto_min} ({min_ventas} ventas)")

# Muestra el total de venta
total_ventas = sum(ventas)
print(f"Total de ventas: {total_ventas}")

# Muestra el promedio de ventas
promedio_ventas = total_ventas / len(ventas)
print(f"Promedio de ventas: {promedio_ventas:.2f}")