# 1. Me flipan los yogures y son muy fan de contar calorías, mi vicio inconfesable. Realiza un programa que
# mezcle estas dos grandes pasiones que calcule las calorías de yogures. Sabemos que un yogur normal,
# caracterizado por su sabor, marca y si es con trocitos, siempre tiene 120.5 calorías por cada 100 ml. Crea un
# método que calcule las calorías dependiendo del tamaño que se pasará como parámetro.
# Por otro lado, sabemos que hay yogures desnatados donde las calorías se calculan como un porcentaje de las
# de un yogur normal, es decir, 30 % menos de calorías, por ejemplo. También hay algo parecido llamados
# postres de proteínas que tienen las mismas calorías de uno normal más una cantidad concreta por la parte
# proteica.
# Crea una clase para contar calorías con métodos para contar las calorías de un yogur pasado como parámetro,
# otro para calcular las calorías de un conjunto de yogures (a veces por la noche me como 3 seguidos) y otro que
# calcule solo las calorías aportadas por uno de los tipos.
# Prueba todo en una clase principal donde se lean los datos de los parámetros por teclado.

class yogur_normal():
    
    
    def __init__(self, sabor: str, marca: str, trocitos: bool, calorias_cien:float = 120.5):
        self.calorias_cien = calorias_cien
        self.sabor = sabor
        self.marca = marca
        self.trocitos = trocitos
    
    def calcular_calorias(self,tamanio: float):
        base_calorias = 100
        return (tamanio * self.calorias_cien) / base_calorias

class yogur_proteico(yogur_normal):
    
    def __init__(self, sabor: str, marca: str, trocitos: bool, calorias_cien:float,extra_proteinas: float):
        super().__init__(sabor, marca, trocitos, calorias_cien)
        self.extra_proteinas: float = extra_proteinas
        
    def calcular_calorias(self, tamanio):
        return super().calcular_calorias(tamanio) + self.extra_proteinas

class yogur_desnatado(yogur_normal):
    
    def __init__(self, sabor: str, marca: str, trocitos: bool, calorias_cien:float,descuento_calorico: float = 30):
        super().__init__(sabor, marca, trocitos,calorias_cien)
        self.descuento_calorico = descuento_calorico
        
    def calcular_calorias(self, tamanio:float):
        base_porcentaje = 100
        base_calorias = super().calcular_calorias(tamanio)
        return base_calorias - ( base_calorias * self.descuento_calorico ) / base_porcentaje
    
class calculadora_calorias():
    
    def calcular_individuales(self, yogur: yogur_normal, tamanio: float,): 
        return yogur.calcular_calorias(tamanio)
    
    def calcular_grupo(self, yogures: dict[yogur_normal: float]):
        return sum(y.calcular_calorias(t) for y,t in yogures.items())
    
    def calcular_segregado(self, yogures: dict[yogur_normal: float], objetivo_segregacion):
        lista_yogures: dict = {}
        for y in yogures:
            if type(y).__name__ == objetivo_segregacion:
                lista_yogures[y] = yogures[y]
        return sum(y.calcular_calorias(t) for y,t in lista_yogures.items())

opcion = -1
cesta_yogures = {}
calc = calculadora_calorias()

# --- DATOS POR DEFECTO ---
y1 = yogur_normal("Natural", "Danone", False)
y2 = yogur_proteico("Fresa", "Hacendado", False,120.5, 10.0)
y3 = yogur_desnatado("Limon", "Activia", True,120.5,30.0)
y4 = yogur_normal("Coco", "Oikos", True)

cesta_yogures[y1] = 125.0
cesta_yogures[y2] = 150.0
cesta_yogures[y3] = 125.0
cesta_yogures[y4] = 200.0

print("--- SISTEMA DE CALORIAS DE YOGURES (Diccionario) ---")
print(f"Se han cargado {len(cesta_yogures)} yogures por defecto.")

while opcion != 0:
    print("1. Agregar yogur normal")
    print("2. Agregar yogur proteico")
    print("3. Agregar yogur desnatado")
    print("4. Calcular calorias de un yogur especifico")
    print("5. Calcular calorias totales de la cesta")
    print("6. Calcular calorias solo de un tipo")
    print("0. Salir")
    
    try:
        opcion = int(input("Seleccione una opcion: "))
    except ValueError:
        opcion = -1
        
    if 1 <= opcion <= 3:
        sabor = input("Sabor: ")
        marca = input("Marca: ")
        trocitos_in = input("Tiene trocitos (s/n): ")
        trocitos = True if trocitos_in.lower() == 's' else False
        tamanio = float(input("Tamanio del envase (ml): "))
        
        if opcion == 1:
            nuevo = yogur_normal(sabor, marca, trocitos)
        elif opcion == 2:
            extra = float(input("Calorias extra por proteina: "))
            nuevo = yogur_proteico(sabor, marca, trocitos, extra)
        elif opcion == 3:
            desc = float(input("Porcentaje de descuento (ej. 30): "))
            nuevo = yogur_desnatado(sabor, marca, trocitos, desc)
            
        cesta_yogures[nuevo] = tamanio
        print("Yogur agregado al diccionario.")
        
    elif opcion == 4:
        if not cesta_yogures:
            print("La cesta esta vacia.")
        else:
            print("Seleccione el yogur de la cesta:")
            lista_claves = list(cesta_yogures.keys())
            
            for i, y in enumerate(lista_claves):
                tam = cesta_yogures[y]
                print(f"{i}. {type(y).__name__} - {y.sabor} ({tam} ml)")
            
            try:
                idx = int(input("Indice: "))
                if 0 <= idx < len(lista_claves):
                    yogur_selec = lista_claves[idx]
                    tamanio_registrado = cesta_yogures[yogur_selec]
                    
                    res = calc.calcular_individuales(yogur_selec, tamanio_registrado)
                    print(f"Calorias totales ({tamanio_registrado}ml): {res}")
                else:
                    print("Indice incorrecto.")
            except ValueError:
                print("Entrada invalida.")
                
    elif opcion == 5:
        if not cesta_yogures:
            print("La cesta esta vacia.")
        else:
            total = calc.calcular_grupo(cesta_yogures)
            print(f"Total calorias de toda la cesta: {total}")
            
    elif opcion == 6:
        if not cesta_yogures:
            print("La cesta esta vacia.")
        else:
            tipo = input("Tipo exacto (yogur_normal, yogur_proteico, yogur_desnatado): ")
            total = calc.calcular_segregado(cesta_yogures, tipo)
            print(f"Total calorias para {tipo}: {total}")  

print("Programa finalizado.")