# 5. Investiga un poco por internet cómo se calcula lo que se paga de hipoteca e intenta hacer un programa que
# haga dichos cálculos o simulaciones, es decir, que se diga qué dinero se quiere pedir al banco, cuántos años se
# quiere estar pagando. El banco dirá a qué interés se dará la hipoteca (puedes considerar que es una cantidad
# fija mensual) y que diga cuántos meses debemos estar pagando y cuánto habremos pagado de intereses después
# de una cantidad de años, por ejemplo:

def calcular_cuota_mensual(principal, interes_aunal, anos):
    meses = anos * 12
    interes_mensual = (interes_aunal / 100) / 12
    #FORMULA = P * [i * (1 + i)^n] / [(1 + i)^n - 1]

    numerador = interes_mensual*((1 + interes_mensual) ** meses)
    denominador = ((1 + interes_mensual) ** meses) - 1
    cuota = principal * (numerador/denominador)

    return cuota

def calcular_total_pagado(cuota, anos):
    return cuota * (anos * 12)

def calcular_intereses_totales(total_pagado, principal):
    return total_pagado - principal

opcion = 0
capital = 0.0
interes = 0.0
anos = 0
cuota_fija = 0.0

print("Bienvenido al simulador de hipotecas")

while True:
    print("\nSIMULADOR DE HIPOTECAS")
    print("0. Salir")
    print("1. Realizar nueva simulación")

    opcion = int(input("\nSelecciona una opción: "))

    match(opcion):
        case 0:
            print("Saliendo...")
            break

        case 1:
            capital = float(input("¿Cuánto dinero pides al banco?: "))
            interes = float(input("¿Qué interés anual te da el banco?: "))
            anos = int(input("¿En cuántos años lo vas a pagar?: "))

            cuota_fija = calcular_cuota_mensual(capital, interes, anos)
            total_pagado = calcular_total_pagado(cuota_fija, anos)
            intereses_totales = calcular_intereses_totales(total_pagado, capital)

            print("-----RESUMEN HIPOTECARIO-----")
            print(f"Capital solicitado:   {capital:,.2f}€")
            print(f"Plazo:                {anos} años ({anos*12} meses)")
            print(f"Interés anual:        {interes}%")
            print("")
            print(f"CUOTA MENSUAL:        {cuota_fija:,.2f}€")
            print(f"TOTAL INTERESES:      {intereses_totales:,.2f}€")
            print(f"TOTAL A DEVOLVER:     {total_pagado:,.2f}€")

        case _:
            print("Opción no válida")

    
