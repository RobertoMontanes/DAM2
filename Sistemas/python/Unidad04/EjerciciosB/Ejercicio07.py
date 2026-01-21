import numpy as np

def simular_tirada(prob_ganar: float):
    return np.random.random() < prob_ganar

def simular_evolucion(dinero_inicial: float, num_apuestas: int, prob_ganar: float, retorno_ganar: float, retorno_perder: float):
    saldo_actual = dinero_inicial
    historial = [dinero_inicial]

    for _ in range(0,num_apuestas):
        if simular_tirada(prob_ganar):
            saldo_actual += retorno_ganar
        else:
            saldo_actual -= retorno_perder

        historial.append(round(saldo_actual, 2))

        if saldo_actual <= 0:
            break

    return{
        "evolucion": historial,
        "saldo_final": saldo_actual,
        "apuestas_realizadas": len(historial) - 1
    }


opcion = 0
dinero_inicial = 0.0
num_apuestas = 0
prob_ganar = 0.0
retorno_ganar = 0.0
retorno_perder = 0.0
resultados = []

print("Bienvenido al simulador de CARA O CRUZ")

while True:
        print("\n--- SIMULADOR DE MONEDA (NumPy) ---")
        print("0. Salir")
        print("1. Iniciar simulación de apuestas")
        
        opcion = int(input("Seleccione una opción: "))

        match opcion:
            case 0:
                print("Saliendo...")
                break
            case 1:
                dinero_inicial = float(input("Introduce el dinero inicial: "))
                num_apuestas = int(input("Introduce el número de apuestas: "))
                prob_ganar = float(input("Probabilidad de ganar (0.0 a 1.0): "))
                retorno_ganar = float(input("Cantidad de ganancia: "))
                retorno_perder = float(input("Cantidad de perdida: "))

                resultados = simular_evolucion(dinero_inicial, num_apuestas, prob_ganar, retorno_ganar, retorno_perder)

                print("-----RESULTADOS-----")
                for i, saldo in enumerate(resultados["evolucion"]):
                    print(f"Apuesta {i}: {saldo:.2f}€")
                    
                print(f"\nSaldo final: {resultados['saldo_final']:.2f}€")
                print(f"Apuestas realizadas: {resultados['apuestas_realizadas']}")
     
            case _:
                print("Opción no válida")