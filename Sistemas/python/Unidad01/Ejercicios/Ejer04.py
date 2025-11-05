# 4) De dos números, saber cuál es el mayor.

num1 = int(input("Dime el primer numero: "))
num2 = int(input("Dime el segundo numero: "))

# if num1 > num2:
#     print(f"El mayor numero es: {num1}")
# else:
#     print(f"El mayor numero es: {num2}")


if num1 == num2:
    print("Ambos numeros son iguales.")
elif num1 > num2:
    print(f"El mayor numero es: {num1}")
else:
    print(f"El mayor numero es: {num2}")