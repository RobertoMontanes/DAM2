# 15) Escribe un programa en python que, dada una lista (y haciendo uso de la función type) imprima cada
# elemento de la lista, indicando su tipo

lista = [1452, 11.23, 1+2j, True, ' w3resource', (0, -1), [5, 12], {"class":'V', "section":'A'}]


print("Bienvenido")
for i in lista:
    print(f"Valor: {i}, Tipo: {type(i)}")
print("Gracias por usar el programa.")

