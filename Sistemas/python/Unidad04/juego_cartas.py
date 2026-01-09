# Devolver la media de los numeros pares de una lista

def numeros_pares(lista):
    cont = 0
    total = 0
    for num in lista:
        if num % 2 == 0:
            total += num;
            cont+=1;
    return total / cont;

        
lista = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]
print(numeros_pares(lista))