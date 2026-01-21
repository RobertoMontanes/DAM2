# ∏La Martingala es una estrategia de apuestas que se popularizó en la ruleta y tiene la siguiente estructura
# (usaremos radom):
# • 🎲 Se comienza con una apuesta inicial. Se apuesta siempre al ⚫.
# • ⚫ Si se gana, se vuelve a la apuesta inicial.
# • 🔴 Si se pierde, se dobla la apuesta.
# La esencia de esta estrategia es que cuando perdemos, doblamos la siguiente apuesta para intentar recuperar la
# cantidad perdida. En la teoría, suena bien.
# Intenta crear una función que simule esta estrategia, definiendo una cantidad inicial, una apuesta, una
# probabilidad de ganar y una cantidad objetivo a ganar, después de la cual se debe para la simulación.
# Puedes intentar buscar una estrategia que reduzca el riesgo de bancarrota.

import random

def simularTirada(probabilidad):

    return random.random() < probabilidad
    


def apostarALaMartingala(cantidadInicial, apuestaInicial, objetivo ,probabilidad):

    fondos = cantidadInicial
    apuestaActual = apuestaInicial
    apuestaRealizada = apuestaActual
    historialTiradas = []
    resultadoTexto = ""

    while 0 < fondos < objetivo:
        if apuestaActual > fondos:
            apuestaActual = fondos

        apuestaRealizada = apuestaActual

        if simularTirada(probabilidad):
            fondos += apuestaActual
            apuestaActual = apuestaInicial
            resultadoTexto = "GANO"
        else:
            fondos -= apuestaActual
            apuestaActual *= 2
            resultadoTexto = "PERDIO"

        historialTiradas.append({
            "ronda": len(historialTiradas) + 1,
            "apuesta": apuestaRealizada,
            "resultado": resultadoTexto,
            "fondos_restantes": round(fondos, 2)
        })

    return {"historial": historialTiradas,
            "objetivo": fondos >= objetivo,
            "fondos_finales": fondos}



partida = apostarALaMartingala(5000, 100, 6000, 0.27)

print(partida)