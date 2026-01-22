# 8. Una aplicación de dibujo necesita trabajar con distintas figuras geométricas. 
# Todas las figuras deben poder: 
# • Calcular su área 
# • Calcular su perímetro 
# • Calcular un factor de escala (aumentar tamaño) 
# Crea una clase base Figura y las clases hijas Rectangulo, Circulo y Triangulo. 
# Utiliza polimorfismo para que, al recorrer una lista de figuras, se llamen a los métodos correctos según el tipo de figura y se calcule la suma de sus áreas, 
# perímetro total y se busque en la lista algún tipo, por ejemplo, el mayor triángulo según su área.

import math

class Figura:
    
    def __init__(self, nombre):
        self.nombre = nombre
        
    def calcular_area(self):
        pass
    
    def calcular_perimetro(self):
        pass
    
    def calcular_factor_escala(self, factor):
        pass
    
class Rectangulo(Figura):
    
    def __init__(self, base, altura, nombre):
        super().__init__(nombre)
        self.base = base
        self.altura = altura
    
    def calcular_area(self):
        return self.base * self.altura
    
    def calcular_perimetro(self):
        return self.base + self.base + self.altura + self.altura
    
    def calcular_factor_escala(self, factor):
        self.base *= factor
        self.altura *= factor


class Circulo(Figura):
    
    def __init__(self, radio, diametro, nombre):
        super().__init__(nombre)
        self.radio = radio
        self.diametro = diametro
        
    def calcular_area(self):
        return math.pi * (self.radio ** 2)
    
    def calcular_perimetro(self):
        return math.pi * self.diametro
    
    def calcular_factor_escala(self, factor):
        self.radio *= factor
        self.diametro *= factor

class Triangulo(Figura):
    def __init__(self, base, altura, lados: tuple, nombre):
        super().__init__(nombre)
        self.base = base
        self.altura = altura
        self.lados = lados
        
    def calcular_area(self):
        return 0.5 * self.base * self.altura
    
    def calcular_perimetro(self):
        return self.lados[0] + self.lados[1] + self.lados[2]
    
    def calcular_factor_escala(self, factor):
        self.base *= factor
        self.altura *= factor
        self.lados[0] *= factor
        self.lados[1] *= factor
        self.lados[2] *= factor


rectangulo01 = Rectangulo(5, 3, "Rectángulo 1")
rectangulo02 = Rectangulo(8, 4, "Rectángulo 2")
rectangulo03 = Rectangulo(10, 6, "Rectángulo 3")
rectangulo04 = Rectangulo(7, 2,"Rectángulo 4")

circulo01 = Circulo(3, 6, "Círculo 1")
circulo02 = Circulo(5, 10, "Círculo 2")
circulo03 = Circulo(2, 4, "Círculo 3")
circulo04 = Circulo(4, 8, "Círculo 4")

triangulo01 = Triangulo(6, 5, (5, 5, 6), "Triángulo 1")
triangulo02 = Triangulo(8, 7, (7, 7, 8), "Triángulo 2")
triangulo03 = Triangulo(4, 3, (3, 3, 4), "Triángulo 3")
triangulo04 = Triangulo(10, 8, (8, 8, 10), "Triángulo 4")

figuras: list[Figura] = [
    rectangulo01, rectangulo02, rectangulo03, rectangulo04,
    circulo01, circulo02, circulo03, circulo04,
    triangulo01, triangulo02, triangulo03, triangulo04,
]

suma_areas = 0
suma_perimetros = 0

tring_mayor_area: Triangulo = None

for fig in figuras:
    area = fig.calcular_area()
    
    if fig.__class__.__name__ == "Triangulo":
        if tring_mayor_area == None or area > tring_mayor_area.calcular_area():
            tring_mayor_area = fig
    
    suma_areas += area
    suma_perimetros += fig.calcular_perimetro()

print(f"El triangulo de mayor area es: {tring_mayor_area.nombre}")
print(f"La suma de las areas es: {suma_areas}, la suma de los perimetros es: {suma_perimetros}")