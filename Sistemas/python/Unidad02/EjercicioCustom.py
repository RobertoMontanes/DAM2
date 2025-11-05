

productos = ["Telarañas falsas", "Mascaras de Halloween", "Calabazas decorativas", "Dulces surtidos", "Disfraces de monstruos"]
ventas = [150, 200, 100, 250, 300]

ventasPorLetra = 0
letra = ""

print("Ventas de productos de Halloween:")
productos_ventas = zip(productos, ventas)

for producto, venta in productos_ventas:
    print(f"{producto}: {venta}")

# Muestra el total de ventas
total_ventas = sum(ventas)
print(f"Total de ventas: {total_ventas}")

# Muestra el promedio de ventas
promedio_ventas = total_ventas / len(ventas)
print(f"Promedio de ventas: {promedio_ventas:.2f}")

# Muestra el porcentaje de venta de cada producto respecto al total de ventas
for i in range(len(productos)):
    porcentaje_venta = (ventas[i] / total_ventas) * 100
    print(f"El producto {productos[i]} representa el {porcentaje_venta:.2f}% del total de ventas.")

# Muestra los productos que tienen ventas por debajo del promedio
for i in range(len(ventas)):
    if ventas[i] < promedio_ventas:
        print(f"El producto {productos[i]} con {ventas[i]} ventas está por debajo del promedio.")

# Preguntale al usuario por una letra y calcula las ventas de los productos que comienzen por esa letra
letra = input("Ingresa una letra para filtrar productos: ")
for i in range(len(productos)):
    if productos[i][0].lower() == letra.lower():
        ventasPorLetra += ventas[i]
        print("El producto", productos[i], "comienza con la letra", letra, "y tiene", ventas[i], "ventas.")

print(f"Ventas totales de productos que comienzan con '{letra}': {ventasPorLetra}")