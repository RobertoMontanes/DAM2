# 1. Escribir una función que aplique un descuento a un precio y otra que aplique el IVA a un precio. Escribir
# una tercera función que reciba un diccionario con los precios y porcentajes de una cesta de la compra, y una
# de las funciones anteriores, y utilice la función pasada para aplicar los descuentos o el IVA a los productos de
# la cesta y devolver el precio final de la cesta.

def aplicarDescuento(precio, descuento):
    return precio - (precio*descuento/100)

def aplicarIva(precio, iva):
    return precio + (precio*iva/100)

def actualizarPrecios(lineasVenta, funcion):
    precioFinal = 0

    for precio, porcentaje in lineasVenta.items():
        precioFinal += funcion(precio, porcentaje)

    return round(precioFinal, 2)


lineasVenta = {3.99: 10, 5.00: 5, 7.89: 3, 15.50: 15}

while True:
    print("\n--- MENÚ ---")
    print("1. Aplicar descuento")
    print("2. Aplicar IVA")
    print("3. Salir")
    
    opcion = input("Seleccione una opción: ")
    
    if opcion == "1":
        precioFinal = actualizarPrecios(lineasVenta, aplicarDescuento)
        print(f"Precio final con descuento: {precioFinal}")
    elif opcion == "2":
        precioFinal = actualizarPrecios(lineasVenta, aplicarIva)
        print(f"Precio final con IVA: {precioFinal}")
    elif opcion == "3":
        print("Saliendo...")
        break
    else:
        print("Opción no válida. Intente de nuevo.")