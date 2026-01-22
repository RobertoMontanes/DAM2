import math
from abc import ABC, abstractmethod

class Figura(ABC):
    @abstractmethod
    def area(self):
        pass
    
    @abstractmethod
    def perimetro(self):
        pass
    
    def escalar(self, factor):
        pass

class Rectangulo(Figura):
    def __init__(self, ancho, alto):
        self.ancho = ancho
        self.alto = alto
    
    def area(self):
        return self.ancho * self.alto
    
    def perimetro(self):
        return 2 * (self.ancho + self.alto)
    
    def escalar(self, factor):
        self.ancho *= factor
        self.alto *= factor

class Circulo(Figura):
    def __init__(self, radio):
        self.radio = radio
    
    def area(self):
        return math.pi * self.radio ** 2
    
    def perimetro(self):
        return 2 * math.pi * self.radio
    
    def escalar(self, factor):
        self.radio *= factor

class Triangulo(Figura):
    def __init__(self, a, b, c):
        self.a, self.b, self.c = a, b, c
    
    def area(self):
        s = (self.a + self.b + self.c) / 2
        return math.sqrt(s * (s - self.a) * (s - self.b) * (s - self.c))
    
    def perimetro(self):
        return self.a + self.b + self.c
    
    def escalar(self, factor):
        self.a *= factor
        self.b *= factor
        self.c *= factor

# Uso
figuras = [Rectangulo(5, 3), Circulo(4), Triangulo(3, 4, 5)]

suma_areas = sum(f.area() for f in figuras)
perimetro_total = sum(f.perimetro() for f in figuras)
mayor_triangulo = max((f for f in figuras if isinstance(f, Triangulo)), key=lambda x: x.area())

print(f"Suma de áreas: {suma_areas:.2f}")
print(f"Perímetro total: {perimetro_total:.2f}")
print(f"Mayor triángulo área: {mayor_triangulo.area():.2f}")