# Añadir al ejercicio anterior, que si está entre 11 y 20, muestre otro mensaje diferente y si está entre 21 y 30
# otro mensaje.

num1 = int(input("Dime el numero: "))
if 10 > num1 > 0:
    print(f"El numero {num1} esta entre 0 y 10")
elif 20 >= num1 > 10:
    print(f"El numero {num1} esta entre 11 y 20")
elif 30 >= num1 > 20:
    print(f"El numero {num1} esta entre 21 y 30")