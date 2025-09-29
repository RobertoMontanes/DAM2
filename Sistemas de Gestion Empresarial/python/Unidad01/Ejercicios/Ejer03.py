# 3) Mostrar el precio final (con IVA) de un producto con un valor de 100 euros, suponiendo que el IVA es el
# 21%.

precio = float(input("Introduce el precio del producto: "))
cantidad = int(input("Cuantos productos vas a querer? "))

precioIVA = precio * 1.21
precioFinal = precioIVA * cantidad

print(f"Hemos vendido un total de {cantidad} productos a un precio final de: {precioFinal}")
