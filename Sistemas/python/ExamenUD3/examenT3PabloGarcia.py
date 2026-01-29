class Interaccion():
    puntuacion_minima = 0
    interacciones = 0

    @classmethod
    def incrementar_interacciones(self):
        Interaccion.interacciones += 1

    def __init__(self, dias_puntuacion: int, puntuacion_base: int) -> None:
        self.dias_puntuacion = dias_puntuacion
        self.puntuacion_base = puntuacion_base

        if (isinstance(self, VideoCompartido)) : None 
        else: Interaccion.incrementar_interacciones()

    def comprobar_puntuacion(func):
        def wrapper(*args, **kwargs):
            puntuacion_final = func(*args, **kwargs)
            if puntuacion_final < Interaccion.puntuacion_minima:
                return Interaccion.puntuacion_minima
            return puntuacion_final
        return wrapper

    @comprobar_puntuacion
    def calcular_valor(self, argumentoVisualizacion: int, argumentoReproduccion: int) -> int:
        return self.puntuacion_base
    
    def __enter__(self):
        self.dias_puntuacion = 5
        return self

    def __exit__(*args):
        pass

class Reaccion(Interaccion):
    
    def __init__(self, dias_puntuacion, 
    puntuacion_base, positiva: bool) -> None:
        Interaccion.__init__(self, dias_puntuacion, puntuacion_base)
        self.positiva = positiva

    def calcular_valor(self, argumentoVisualizacion: int, argumentoReproduccion: int) -> int:
        return Interaccion.calcular_valor(self, argumentoVisualizacion, argumentoReproduccion) + (argumentoReproduccion if self.positiva else -argumentoReproduccion)

class Visualizacion(Interaccion):

    segundos_minimo_reproducido = 3

    def __init__(self, dias_puntuacion, puntuacion_base, segundos_reproducido: int) -> None:
        Interaccion.__init__(self, dias_puntuacion, puntuacion_base)
        self.segundos_reproducido = segundos_reproducido
    
    def calcular_valor(self, argumentoVisualizacion: int, argumentoReproduccion: int) -> int:
        return Interaccion.calcular_valor(self, argumentoVisualizacion, argumentoReproduccion) * argumentoVisualizacion if self.segundos_reproducido > Visualizacion.segundos_minimo_reproducido else 1

class VideoCompartido(Reaccion, Visualizacion):
    
    def __init__(self, dias_puntuacion, puntuacion_base, positiva: bool,segundos_reproducido: int, usuarios_compartido: int):
        Reaccion.__init__(self, dias_puntuacion, puntuacion_base, positiva)
        Visualizacion.__init__(self, dias_puntuacion, puntuacion_base, segundos_reproducido)
        self.usuarios_compartido = usuarios_compartido
        Interaccion.incrementar_interacciones()
    
    def calcular_valor(self, argumentoVisualizacion: int, argumentoReproduccion: int) -> int:
        return Reaccion.calcular_valor(self,argumentoVisualizacion, argumentoReproduccion) + Visualizacion.calcular_valor(self,argumentoVisualizacion, argumentoReproduccion)

class Publicacion():

    def __init__(self, interacciones: list[Interaccion]):
        self.interacciones = interacciones
    
    def calcular_total(self, argumentoVisualizacion: int, argumentoReproduccion: int) -> int:
        return sum(interaccion.calcular_valor(argumentoVisualizacion, argumentoReproduccion) for interaccion in self.interacciones)

    def modificar_puntuacion_minima(self, nueva_puntuacion):
        Interaccion.puntuacion_minima = nueva_puntuacion

    def contar_interacciones(self):
        return Interaccion.interacciones

    def reiniciar_dias_interracion(self,interaccion : Interaccion):
        with interaccion as i:
            pass



interaccion1 = Interaccion(5, 100)
interaccion2 = Interaccion(2, 1050)
interaccion3 = Interaccion(3, 120)

visualizacion1 = Visualizacion(4, 70, 12)
visualizacion2 = Visualizacion(7, 96, 6)
visualizacion3 = Visualizacion(10, 7, 2)

reaccion1 = Reaccion(3,100, True)
reaccion2 = Reaccion(6,120, False)
reaccion3 = Reaccion(5,1020, True)

videoCompartido1 = VideoCompartido(7, 102, True, 20, 100) 
videoCompartido2 = VideoCompartido(1, 14, False, 5, 12)
videoCompartido3 = VideoCompartido(4, 6, True, 2, 15)

publicacion = Publicacion([
    interaccion1,
    interaccion2,
    interaccion3,
    visualizacion1,
    visualizacion2,
    visualizacion3,
    reaccion1,
    reaccion2,
    reaccion3,
    videoCompartido1,
    videoCompartido2,
    videoCompartido3,
])

print("-- PUNTUACION TOTAL --")
print(publicacion.calcular_total(2,1))

print("-- MODIFICAR MINIMO --")
publicacion.modificar_puntuacion_minima(int(input("Indique la nueva puntuacion minima: ")))

print("-- CONTABILIZAR INTERACCIONES --")
print(publicacion.contar_interacciones())

print("-- REINICIAR DIAS --")
print(f"Dias actuales: {interaccion2.dias_puntuacion}")
publicacion.reiniciar_dias_interracion(interaccion2)
print(f"Dias post, gestor de contexto: {interaccion2.dias_puntuacion}")
