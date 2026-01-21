def calcular_cuota_mensual(capital, interes_anual, anios): 
    meses_totales = anios * 12 
    interes_mensual = interes_anual / 100 / 12

    if interes_mensual == 0:
        return capital / meses_totales

    numerador = capital * interes_mensual * ((1 + interes_mensual) ** meses_totales)
    denominador = ((1 + interes_mensual) ** meses_totales) - 1

    return numerador / denominador

def calcular_estado_tras_tiempo(capital, interes_anual, anios_totales, anios_transcurridos): 
    cuota = calcular_cuota_mensual(capital, interes_anual, anios_totales) 
    interes_mensual = interes_anual / 100 / 12

    meses_a_simular = anios_transcurridos * 12
    saldo_pendiente = capital
    total_intereses_pagados = 0
    total_capital_amortizado = 0

    for _ in range(meses_a_simular):
        interes_mes = saldo_pendiente * interes_mensual
        capital_mes = cuota - interes_mes
        
        saldo_pendiente -= capital_mes
        total_intereses_pagados += interes_mes
        total_capital_amortizado += capital_mes

    return {
        "intereses_pagados": total_intereses_pagados,
        "capital_amortizado": total_capital_amortizado,
        "saldo_restante": saldo_pendiente
    }
    
capital_solicitado = float(input("Introduce el capital a solicitar (Euros): ")) 
interes_banco = float(input("Introduce el interés anual fijo (%): ")) 
plazo_anios = int(input("Introduce el plazo en años para pagar: "))

cuota_mensual = calcular_cuota_mensual(capital_solicitado, interes_banco, plazo_anios) 
meses_totales = plazo_anios * 12 
total_a_pagar = cuota_mensual * meses_totales

print("\n--- RESUMEN DE LA HIPOTECA ---") 
print(f"Cuota mensual a pagar: {cuota_mensual:.2f} €") 
print(f"Número total de meses a pagar: {meses_totales} meses") 
print(f"Total devuelto al final (Capital + Intereses): {total_a_pagar:.2f} €")

opcion = -1 
while opcion != 0: 
    print("\n--------------------------------") 
    print("¿Desea simular el estado de la hipoteca tras X años?") 
    print("1. Sí") 
    print("0. No, salir")

    opcion = int(input("Opción: "))

    if opcion == 1:
        anios_consulta = int(input(f"Indique cuántos años han pasado (máximo {plazo_anios}): "))
        
        if anios_consulta > plazo_anios:
            print("Error: Los años superan el plazo de la hipoteca.")
        else:
            datos = calcular_estado_tras_tiempo(capital_solicitado, interes_banco, plazo_anios, anios_consulta)
            
            print(f"\n--- ESTADO TRAS {anios_consulta} AÑOS ({anios_consulta*12} meses) ---")
            print(f"Intereses pagados hasta la fecha: {datos['intereses_pagados']:.2f} €")
            print(f"Capital amortizado (devuelto): {datos['capital_amortizado']:.2f} €")
            print(f"Dinero que falta por pagar al banco: {datos['saldo_restante']:.2f} €")

    elif opcion != 0:
        print("Opción no válida.")
print("Programa finalizado.")