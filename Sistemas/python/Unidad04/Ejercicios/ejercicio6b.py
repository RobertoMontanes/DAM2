import random

class Persona:
    
    def __init__(self, nombre, saldo):
        self.nombre = nombre
        self.saldo = saldo

class Estadisticas:
    def __init__(self, giros,punto_alto, punto_bajo):
        self.giros = giros
        self.punto_alto = punto_alto
        self.punto_bajo = punto_bajo
        self.estado_final = "Sin definir"
    
    def __str__(self):
        return f"Giros totales: {self.giros}, Maximo historico: {self.punto_alto}, Minimo historico: {self.punto_bajo}, Estado final: {self.estado_final}"

colores = ["Verde", "Rojo", "Negro"]

numeros = {
    0: "Verde",
    1: "Rojo",    2: "Negro",   3: "Rojo",    4: "Negro",   5: "Rojo",
    6: "Negro",   7: "Rojo",    8: "Negro",   9: "Rojo",    10: "Negro",
    11: "Negro",  12: "Rojo",   13: "Negro",  14: "Rojo",   15: "Negro",
    16: "Rojo",   17: "Negro",  18: "Rojo",   19: "Rojo",    20: "Negro",
    21: "Rojo",   22: "Negro",  23: "Rojo",   24: "Negro",  25: "Rojo",
    26: "Negro",  27: "Rojo",   28: "Negro",  29: "Negro",  30: "Rojo",
    31: "Negro",  32: "Rojo",   33: "Negro",  34: "Rojo",   35: "Negro",
    36: "Rojo"
}

def girar_ruleta():
    return random.randint(0,36)

def jugar_ruleta(persona: Persona, cantidad_apostar: float, color_apostar: str):
    
    if persona.saldo < cantidad_apostar:
        return -1
        
    
    persona.saldo = persona.saldo - cantidad_apostar;
    # print(f"A {persona.nombre} se le han deducido {cantidad_apostar} euros de su saldo.")
    # print(f" - Saldo restante: {persona.saldo}")
    
    numero_ganador = girar_ruleta()
    # print(f"El numero ganador ha sido el: {numero_ganador}, color {numeros[numero_ganador]}")
    
    if numeros[numero_ganador] == color_apostar:
        persona.saldo += cantidad_apostar * 2
        # print(f"El jugador {persona.nombre} ha ganado {cantidad_apostar * 2}, su nuevo saldo es: {persona.saldo}")
        return 1
    else:
        # print(f"El jugador {persona.nombre} no ha ganado nada, su saldo actual es: {persona.saldo}.")
        return 0

def estrategia_martingala(persona: Persona, cantidad_inicial_apostar: float, color_apostar):
    # print("Iniciando martingala...")
    
    estadisiticas_partida = Estadisticas(1,persona.saldo, persona.saldo - cantidad_inicial_apostar)
    
    cantidad_apostar = cantidad_inicial_apostar
    
    resul = jugar_ruleta(persona, cantidad_apostar, color_apostar)
    
    while resul != 1:
        
        if resul == -1:
            # print("No dispones de dinero suficiente como para seguir apostando.")
            estadisiticas_partida.estado_final = "Derrota"
            return estadisiticas_partida
        
        # print(f"Llevamos {estadisiticas_partida.giros} rondas sin ganar, vamos a aumentar la cantidad de {cantidad_apostar} a {cantidad_apostar*2}")
        cantidad_apostar *= 2
        
        estadisiticas_partida.giros += 1
        
        if persona.saldo > estadisiticas_partida.punto_alto:
            estadisiticas_partida.punto_alto = persona.saldo
        
        if persona.saldo < estadisiticas_partida.punto_bajo:
            estadisiticas_partida.punto_bajo = persona.saldo
            
        resul = jugar_ruleta(persona, cantidad_apostar, color_apostar)

    
    # print(f"Felicidades, has ganado.")
    estadisiticas_partida.punto_alto = persona.saldo
    estadisiticas_partida.estado_final = "Victoria"
    # print(f"Tu saldo tras aplicar martingala es: {persona.saldo}")
    return estadisiticas_partida

def calcular_estadisticas(resultados: list[Estadisticas]):
    total_victorias = 0
    total_derrotas = 0
    total_something = 0
    
    total_giros = 0
    
    for resultado in resultados:
        if resultado.estado_final == "Victoria":
            total_victorias += 1
        elif resultado.estado_final == "Derrota":
            total_derrotas += 1
        else:
            total_something += 1
        
        total_giros += resultado.giros
        
            
    print(f"Has ganado {total_victorias} veces, perdido {total_derrotas} veces y fallos: {total_something} veces")
            
    procentaje_victorias = (total_victorias * 100) / len(resultados)
    procentaje_derrotas = (total_derrotas * 100) / len(resultados)
    procentaje_something = (total_something * 100) / len(resultados)
    print(f"Has ganado un {procentaje_victorias}%, perdido {procentaje_derrotas}% y fallos: {procentaje_something}%")
    
    print(f"Has girado la ruleta un total de {total_giros} veces, a una media de {total_giros / len(resultados)} por partida.")
    


def simulacion_simple(saldo, cantidad_apostar):
    resultados = []
    for i in range(0, 100):
        persona1 = Persona(nombre="Hugo", saldo=saldo)
        resultado = estrategia_martingala(persona1,cantidad_apostar,colores[2]);
        # print(f"Juego {i+1}, estado final: {resultado.estado_final}")
        resultados.append(resultado)

    # for i in range(0, len(resultados)):
    #     print(f"{i+1} => {resultados[i]}")

    calcular_estadisticas(resultados)
    
def simulacion_compleja(saldo, cantidad_apostar, saldo_final):
    resultados = []
    for i in range(0, 100):
        resultado_final = Estadisticas(0,0,0)
        persona1 = Persona(nombre="Hugo", saldo=saldo)

        while persona1.saldo < saldo+saldo_final and persona1.saldo > 0:
            resultado = estrategia_martingala(persona1,cantidad_apostar,colores[2]);
            
            resultado_final.giros += resultado.giros
            resultado_final.estado_final = resultado.estado_final
            resultado_final.punto_alto = resultado.punto_alto
            resultado_final.punto_bajo = resultado.punto_bajo

        # print(f"Juego {i+1}, estado final: {resultado.estado_final}")
        resultados.append(resultado_final)

    # for i in range(0, len(resultados)):
    #     print(f"{i+1} => {resultados[i]}")

    calcular_estadisticas(resultados)


# Simulacion:
print("Vamos a realizar 100 juegos usando martin gala.")
print(" - Para salir, el jugador debe GANAR usando el metodo martin gala o debe quedarse sin saldo.")

print("Jugando con 100 euros y 10 apuesta: ")
simulacion_simple(100,10)

print("Jugando con 1000 euros y 10 apuesta: ")
simulacion_simple(1000,10)

print("Jugando con 10000 euros y 10 apuesta: ")
simulacion_simple(10000,10)

print("Jugando con 10000 euros y 100 apuesta: ")
simulacion_simple(10000,100)

print("Jugando con 10000 euros y 100 apuesta: ")
simulacion_simple(10000,1000)

print("Vamos a realizar 100 juegos usando martin gala, pero con objetivo.")
print(" - Para salir, el jugador debe GANAR usando el metodo martin gala hasta llegar al objetivo solicitado o debe quedarse sin saldo.")
print(" - En este caso, perder significa quedar en saldo 0, ganar significa llegar al saldo objetivo")

print("Jugando con 100 euros, 10 en apuesta y objetivo +200 euros")
simulacion_compleja(100,10,200)

print("Jugando con 1000 euros, 10 en apuesta y objetivo +200 euros")
simulacion_compleja(1000,10,200)

print("Jugando con 2000 euros, 10 en apuesta y objetivo +200 euros")
simulacion_compleja(2000,10,200)

print("Jugando con 2100 euros, 10 en apuesta y objetivo +200 euros")
simulacion_compleja(2100,10,200)

print("Jugando con 3000 euros, 10 en apuesta y objetivo +200 euros")
simulacion_compleja(3000,10,200)