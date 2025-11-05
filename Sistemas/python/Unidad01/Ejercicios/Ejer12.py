import random

numero_secreto = random.randint(0, 10)
intentos = 3

print("Adivina el número entre 0 y 10. Tienes 3 intentos.")

for i in range(intentos):
    intento = int(input(f"Intento {i+1}: "))
    if intento == numero_secreto:
        print("¡Felicidades! Has adivinado el número.")
        break
    else:
        print("No es correcto.")
else:
    print(f"Lo siento, has agotado los intentos. El número era {numero_secreto}.")