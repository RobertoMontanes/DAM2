#  Escribe una función total_compra(lista_productos, iva=21) donde lista_productos es una lista de
# precios (floats).
# La función devuelve el total con IVA incluido.
# Si la lista está vacía, devuelve 0.

def total_compra(lista_productos, iva=21):
    total = 0
    basePr = 100
    
    for producto in lista_productos:
        total += producto + ((iva * producto) / basePr)
        
    return total

print(total_compra([5,6,87,2,3,9,8,4,6,2,3,1]))
print(total_compra([]))