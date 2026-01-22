# 2. Me gustan los animales. Aunque no estoy muy de acuerdo con los zoológicos, crea un programa que ayude
# a calcular el coste anual para alimentar distintos tipos de animales.
# . Por otro lado, hay animales con comida especial:
# Crea un main de prueba.

# Hay Animales, en general, que comen hierba, fruta, etc. En este caso el coste se realiza multiplicando una
# cantidad de dinero al día por el número de días del año
class Animal():
    
    def coste_comida(self, coste_diario: float, dias_anio: int = 365):
        return coste_diario * dias_anio

# - Osos: 2 veces a la semana comen carne o pescado por lo que, al coste normal (por frutas, verduras...), hay
# que sumarle el coste de esto.
class Oso(Animal):
    
    coste_carne = 15.0
    
    def coste_comida(self, coste_diario: float, dias_anio: int = 365):
        return super().coste_comida(coste_diario, dias_anio) + (Oso.coste_carne * (dias_anio // 7))
    
# - Serpientes: Comen insectos cuyo coste es por el número de insectos que se le dan por lo que cuesta cada
# insecto, pero solo comen dos veces a la semana.
class Serpiente(Animal):

    coste_insectos:float = 2

    def __init__(self, insectos_comidos: int):
        super().__init__()
        self.insectos_comidos = insectos_comidos;

    def coste_comida(self, coste_diario: float, dias_anio: int = 365):
        return super().coste_comida(coste_diario, dias_anio) + (Serpiente.coste_insectos * self.insectos_comidos)
    
# Crea una clase Zoo con métodos que calculen:
class Zoo():
    # - Coste de una serie de animales pasando como parámetro, la cantidad de cada uno de estos tipos.
    def calcular_animales(self, animales: list[Animal], coste_plantas: float):
        return sum(animal.calcular_coste(coste_plantas) for animal in animales)
    
    # - Calcular el descuento que nos hace la empresa suministradora, si gastamos más de una cantidad dada como
    # parámetro entre todos los animales de una lista.
    def calcular_descuento(self, animales: list[Animal], coste_plantas: float, cantidad_limite: float, descuento: float):
        base_porcentaje = 100
        total_coste = Zoo.calcular_animales(animales, coste_plantas)
        if total_coste > cantidad_limite:
            total_coste = total_coste - ((descuento * total_coste) / base_porcentaje)
        return total_coste
    
    # - Gasto del zoo solo en osos.
    def calcular_gasto_osos(self, animales: list[Animal], coste_plantas: float):
        osos: list[Oso] = []
        for animal in animales:
            if type(animal).__name__ == "Oso":
                osos.append(animal);

        return sum(oso.calcular_coste(coste_plantas) for oso in osos)
    

lista_animales = []
mi_zoo = Zoo()

# --- DATOS DE PRUEBA ---
lista_animales.append(Animal()) # Cebra generica
lista_animales.append(Animal()) # Jirafa generica
lista_animales.append(Oso())    # Oso Yogui
lista_animales.append(Oso())    # Oso Panda
lista_animales.append(Serpiente(5)) # Cobra que come 5 insectos por comida
lista_animales.append(Serpiente(2)) # Vibora que come 2 insectos por comida

opcion = -1
coste_diario_base = 10.0 # Coste frutas/verduras al dia

print("--- GESTION DE COSTES DEL ZOO ---")
print(f"Se han cargado {len(lista_animales)} animales por defecto.")

while opcion != 0:
    print("1. Anadir Animal generico (Herbivoro)")
    print("2. Anadir Oso")
    print("3. Anadir Serpiente")
    print("4. Calcular coste total anual sin descuento")
    print("5. Calcular coste total anual con descuento")
    print("6. Calcular solo gasto de Osos")
    print("7. Configurar precios base (Carne/Insectos/Diario)")
    print("0. Salir")
    
    opcion = int(input("Seleccione opcion: "))

    if opcion == 1:
        nuevo = Animal()
        lista_animales.append(nuevo)
        print("Animal generico anadido.")

    elif opcion == 2:
        nuevo = Oso()
        lista_animales.append(nuevo)
        print("Oso anadido.")

    elif opcion == 3:
        ins = int(input("Cuantos insectos come por toma?: "))
        nuevo = Serpiente(ins)
        lista_animales.append(nuevo)
        print("Serpiente anadida.")

    elif opcion == 4:
        total = mi_zoo.calcular_animales(lista_animales, coste_diario_base)
        print(f"Coste total anual: {total} euros")

    elif opcion == 5:
        limite = float(input("A partir de que gasto hay descuento?: "))
        desc = float(input("Porcentaje de descuento (ej. 10): "))
        final = mi_zoo.calcular_descuento(lista_animales, coste_diario_base, limite, desc)
        print(f"Coste final con posible descuento: {final} euros")

    elif opcion == 6:
        osos_total = mi_zoo.calcular_gasto_osos(lista_animales, coste_diario_base)
        print(f"Gasto exclusivo en Osos: {osos_total} euros")

    elif opcion == 7:
        print(f"Actual Base Diario: {coste_diario_base}")
        print(f"Actual Carne (Oso): {Oso.coste_carne}")
        print(f"Actual Insecto (Serpiente): {Serpiente.coste_insectos}")
        
        coste_diario_base = float(input("Nuevo coste diario base: "))
        Oso.coste_carne = float(input("Nuevo coste racion carne: "))
        Serpiente.coste_insectos = float(input("Nuevo coste unidad insecto: "))
        print("Precios actualizados.")

            
print("Programa finalizado.")