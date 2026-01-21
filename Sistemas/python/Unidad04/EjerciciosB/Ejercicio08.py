import math

class Figura:
    def __init__(self, nombre:str):
        self.nombre = nombre

    def calcular_area(self):
        return 0.0
    
    def calcular_perimetro(self):
        return 0.0
    
    def escalar(self, factor: float):
        pass

    def __str__(self):
        return f"{self.nombre}"

class Circulo(Figura):
    def __init__ (self, nombre: str, radio:float):
        super().__init__(nombre)
        self.radio = radio

    def calcular_area(self):
        return math.pi * (self.radio ** 2)
    
    def calcular_perimetro(self):
        return 2 * math.pi * self.radio
    
    def escalar(self, factor: float):
        self.radio *= factor

    def __str__(self):
        return f"Círculo: {self.nombre}; Radio: {self.radio}" 

class Rectangulo(Figura):
    def __init__(self, nombre: str, largo: float, alto: float):
        super().__init__(nombre)
        self.largo = largo
        self.alto = alto

    def calcular_area(self):
        return self.largo * self.alto
    
    def calcular_perimetro(self):
        return self.largo * 2 + self.alto * 2

    def escalar(self, factor: float):
        self.alto *= factor
        self.largo *= factor

    def __str__(self):
        return f"Rectángulo: {self.nombre}; Largo: {self.largo}; Alto: {self.alto}"

class Triangulo(Figura):
    def __init__(self, nombre: str, base: float, altura: float):
        super().__init__(nombre)
        self.base = base
        self.altura = altura

    def calcular_area(self):
        return (self.base * self.altura) / 2
    
    def calcular_perimetro(self):
        return self.base * 3
    
    def escalar(self, factor: float):
        self.base *= factor
        self.altura *= factor

    def __str__(self):
        return f"Triángulo: {self.nombre}; Base: {self.base}, Altura: {self.altura}"

def calcular_area_total(lista_figuras: list):
    total = 0
    
    for figura in lista_figuras:
        total += figura.calcular_area()

    return total

def calcular_perimetro_total(lista_figuras: list):
    total = 0
    
    for figura in lista_figuras:
        total += figura.calcular_perimetro()

    return total

def encontrar_figura_instancia(lista_figuras: list, tipo_clase):
    figuras_tipo = []
    for f in lista_figuras:
        if isinstance(f, tipo_clase):
            figuras_tipo.append(f)

    if not figuras_tipo:
        return None
    
    return figuras_tipo

def encontrar_figura_mas_grande(lista_figuras: list):
    mayor = None
    
    for figura in lista_figuras:
        if mayor == None or figura.calcular_area() > mayor.calcular_area():
            mayor = figura
                
    return mayor


lista_figuras = []
lista_figuras.append(Circulo("Círculo 1",5.0))
lista_figuras.append(Rectangulo("Rectángulo 1",10.0, 4.0))
lista_figuras.append(Triangulo("Triángulo 1",6.0, 8.0))
lista_figuras.append(Circulo("Círculo 2",3.5))
lista_figuras.append(Rectangulo("Rectángulo 2",7.0, 7.0))
opcion = 0
sub_opcion = 0
largo = 0.0
alto = 0.0
radio = 0.0
base = 0.0
total_area = 0.0
total_perimetro = 0.0
factor_escalar = 0.0

print("Bienvenido a la calculadora geométrica")

while True:
    print("APLICACIÓN DE DIBUJO GEOMÉTRICO")
    print("0. Salir")
    print("1. Añadir Rectángulo")
    print("2. Añadir Círculo")
    print("3. Añadir Triángulo")
    print("4. Calcular áreas y perímetros totales")
    print("5. Escalar todas las figuras")
    print("6. Encontrar figura más grande")

    
    opcion = int(input("\nSelecciona una opción: "))

    match opcion:
        case 1:
            largo = float(input("Introduce el largo: "))
            alto = float(input("Introduce el alto: "))
            lista_figuras.append(Rectangulo(largo, alto))
            print("Rectángulo añadido.")

        case 2:
            radio = float(input("Introduce el radio: "))
            lista_figuras.append(Circulo(radio))
            print("Círculo añadido.")

        case 3:
            base = float(input("Introduce la base: "))
            alto = float(input("Introduce la altura: "))
            lista_figuras.append(Triangulo(base, alto))
            print("Triángulo añadido.")

        case 4:
            if not lista_figuras:
                print("La lista está vacía.")
            else:
                total_area = calcular_area_total(lista_figuras)
                total_perimetro = calcular_perimetro_total(lista_figuras)
                print(f"\nRESULTADOS GLOBALES:")
                print(f"- Área total acumulada: {round(total_area, 2)}")
                print(f"- Perímetro total acumulado: {round(total_perimetro, 2)}")

        case 5:
            if not lista_figuras:
                print("No hay figuras para escalar.")
            else:
                factor_escalar = float(input("¿Por qué factor quieres multiplicar el tamaño? (ej: 2): "))
                for f in lista_figuras:
                    f.escalar(factor_escalar)
                print(f"Todas las figuras han sido escaladas por {factor_escalar}.")

        case 6:
            if not lista_figuras:
                print("No hay figuras en la lista.")
            else:
                print("\n--- BUSCAR FIGURA MÁS GRANDE ---")
                print("1. Buscar triángulo más grande")
                print("2. Buscar rectángulo más grande")
                print("3. Buscar círculo más grande")
                sub_opcion = int(input("Selecciona una opción: "))
                
                match sub_opcion:
                    case 1:
                        print("El triángulo más grande es: ")
                        print(f"- {encontrar_figura_mas_grande(encontrar_figura_instancia(lista_figuras, Triangulo))}")
                    case 2:
                        print("El rectángulo más grande es: ")
                        print(f"- {encontrar_figura_mas_grande(encontrar_figura_instancia(lista_figuras, Rectangulo))}")
                    case 3:
                        print("El círculo más grande es: ")
                        print(f"- {encontrar_figura_mas_grande(encontrar_figura_instancia(lista_figuras, Circulo))}")
                    case _:
                        print("Opción no válida.")
        case 0:
            print("Saliendo del programa...")
            break

        case _:
            print("Opción no válida.")

