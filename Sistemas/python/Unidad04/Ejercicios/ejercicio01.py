# 1. Escribir una función que aplique un descuento a un precio y otra que aplique el IVA a un precio. Escribir
# una tercera función que reciba un diccionario con los precios y porcentajes de una cesta de la compra, y una
# de las funciones anteriores, y utilice la función pasada para aplicar los descuentos o el IVA a los productos de
# la cesta y devolver el precio final de la cesta.

productos = {
    5.99: 5,
    7.49: 8,
    9.99: 10,
    12.50: 12,
    14.90: 15,
    17.75: 18,
    19.99: 20,
    22.40: 22,
    24.75: 25,
    27.30: 28,
    29.90: 30,
    32.60: 32,
    35.00: 35,
    37.80: 38,
    39.99: 40,
    42.50: 42,
    45.90: 45,
    48.25: 48,
    50.75: 50,
    54.99: 52,
    59.90: 55,
    64.50: 58,
    69.99: 60,
    74.30: 62,
    79.90: 65,
    85.00: 68,
    89.99: 70,
    95.50: 72,
    99.99: 75,
    120.00: 80,
}



def aplicar_iva(productos: dict):
    descuento_aplicado = []
    iva = 21
    base_porcentaje = 100
    
    for precio in productos:
        descuento_aplicado.append(precio + (precio * iva) / base_porcentaje)
    
    return descuento_aplicado

def aplicar_descuento(productos: dict):
    descuento_aplicado = []
    base_porcentaje = 100
    
    for precio in productos:
        descuento_aplicado.append(precio + (precio * productos[precio]) / base_porcentaje)
    
    return descuento_aplicado

def ejecutar_funciones(productos, funcion):
    return funcion(productos)


print("Aplicando descuento: ")
print(ejecutar_funciones(productos, aplicar_descuento))
print("Aplicando iva: ")
print(ejecutar_funciones(productos, aplicar_iva))