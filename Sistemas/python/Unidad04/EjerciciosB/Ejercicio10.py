# 1. La Clase Base: Pedido
# Debes crear una clase padre llamada Pedido que tenga los siguientes atributos comunes:
# id_pedido (int): Identificador único.
# cliente (str): Nombre del cliente.
# distancia_km (float): Distancia a recorrer para la entrega.
# precio_base (float): El coste fijo de manipulación del paquete.
# Esta clase debe tener un método llamado calcular_total() que, por defecto, devuelva el precio base más un coste de 0.50€ por km.
# 2. Tipos de Pedidos (Herencia y Polimorfismo)
# Debes implementar tres clases hijas que hereden de Pedido y reescriban (override) el método calcular_total() aplicando las siguientes reglas de negocio:
# PedidoEstandar:
# Funciona igual que el padre (precio base + 0.50€/km).
# No tiene recargos adicionales.
# PedidoExpress:
# Este envío es urgente.
# El cálculo es: (precio base + 0.50€/km) multiplicado por una tasa de urgencia del 20% (es decir, el total x 1.20).
# PedidoInternacional:
# Este envío es más costoso por el transporte aéreo.
# El coste por km sube a 2.00€/km.
# Además, se suma una tasa fija de aduanas de 50€ al final.
# Fórmula: precio_base + (distancia_km * 2.0) + 50.
# 3. Gestión y Estadísticas: GestorPedidos
# Crea una clase llamada GestorPedidos que no hereda de nadie. Esta clase debe:
# Tener un atributo (lista) para almacenar los objetos de tipo Pedido.
# Tener un método agregar_pedido(pedido) para guardar nuevos pedidos.
# Métodos Estadísticos:
# calcular_total_facturado(): Suma el precio final de todos los pedidos.
# media_distancia(): Calcula la media de kilómetros de todos los envíos.
# buscar_pedidos_cliente(nombre_cliente): Devuelve una lista con todos los pedidos de un cliente específico.
# contar_tipo_pedido(clase): Recibe un tipo de clase (ej. PedidoExpress) y devuelve cuántos pedidos de ese tipo hay registrados.

class Pedido:

    def __init__(self, id_pedido: int, cliente: str, distancia_km: float, precio_base: float, coste_km: float):
        self.id_pedido = id_pedido
        self.cliente = cliente
        self.distancia_km = distancia_km
        self.precio_base = precio_base
        self.coste_km = coste_km

    def precio_total(self) -> float:
        return self.precio_base + (self.coste_km * self.distancia_km)
    
    def __str__(self):
        return f'PEDIDO: {self.id_pedido} | CLIENTE {self.cliente} | DISTANCIA(KM): {self.distancia_km} kms | PRECIO BASE: {self.precio_base} € | COSTE(x KM): {self.coste_km} € | PRECIO TOTAL: {self.precio_total()} €'
    

class PedidoEstandar(Pedido):
    def __init__(self, id_pedido, cliente, distancia_km, precio_base, coste_km):
        super().__init__(id_pedido, cliente, distancia_km, precio_base, coste_km)

    def precio_total(self):
        return super().precio_total()
    
    def __str__(self):
        return super().__str__()
    
class PedidoExpress(Pedido):
    def __init__(self, id_pedido, cliente, distancia_km, precio_base, coste_km, porcentaje_envio: float):
        super().__init__(id_pedido, cliente, distancia_km, precio_base, coste_km)
        self.porcentaje_envio = porcentaje_envio

    def precio_total(self) -> float:
        return super().precio_total() + (super().precio_total() * self.porcentaje_envio / 100) 
    
    def __str__(self):
        return f'PEDIDO: {self.id_pedido} | CLIENTE {self.cliente} | DISTANCIA(KM): {self.distancia_km} kms | PRECIO BASE: {self.precio_base} € | COSTE(x KM): {self.coste_km} € | PRECIO TOTAL: {self.precio_total()} € | PORCENTAJE ENVIO: {self.porcentaje_envio}'
    
class PedidoInternacional(Pedido):
    def __init__(self, id_pedido, cliente, distancia_km, precio_base, coste_km, tasa_aduana: float):
        super().__init__(id_pedido, cliente, distancia_km, precio_base, coste_km)
        self.tasa_aduana = tasa_aduana
    
    def precio_total(self):
        return self.precio_base + (self.coste_km * self.distancia_km) + self.tasa_aduana
    
    def __str__(self):
        return f'PEDIDO: {self.id_pedido} | CLIENTE {self.cliente} | DISTANCIA(KM): {self.distancia_km} kms | PRECIO BASE: {self.precio_base} € | COSTE(x KM): {self.coste_km} € | PRECIO TOTAL: {self.precio_total()} € | TASA ADUANA: {self.tasa_aduana} €'

class GestorPedidos:
    def __init__(self, lista_pedidos: list):
        self.lista_pedidos = lista_pedidos

    def agregar_pedido(self, pedido: Pedido):
        self.lista_pedidos.append(pedido)

    def calcular_todo_facturado(self) -> float:
        return sum(pedido.precio_total() for pedido in self.lista_pedidos)
    
    def calcular_media_distancia(self) -> float:
        total_km = sum(pedido.distancia_km for pedido in self.lista_pedidos)
        return total_km / len(self.lista_pedidos) 
    
    def buscar_pedidos_cliente(self, nombre_cliente: str) -> list:
        pedidos_cliente = [pedido for pedido in self.lista_pedidos if pedido.cliente == nombre_cliente]

        return pedidos_cliente
    
    def contar_tipo_pedido(self, tipo_clase) -> int:
        pedidos_tipo = [pedido for pedido in self.lista_pedidos if isinstance(pedido, tipo_clase)]

        return len(pedidos_tipo)
    
    def buscar_pedido_id(self, id: int) -> Pedido:
        pedido_buscado = next((pedido for pedido in self.lista_pedidos if pedido.id_pedido == id), None)
        
        return pedido_buscado
    
p1 = PedidoEstandar(1, "Juan Pérez", 100.0, 10.0, 0.50)
p2 = PedidoExpress(2, "Tech Solutions", 50.0, 15.0, 0.50, 20.0) 
p3 = PedidoInternacional(3, "Global Imports", 1500.0, 50.0, 2.0, 100.0)
lista_inicial = [p1, p2, p3]
gestor = GestorPedidos(lista_inicial)

opcion = 0
tipo_opcion = 0
contador_id = 4
pedido_id = 0
cliente = ""
distancia = 0.0
precio_base = 0.0
pedido_nuevo = None
pedido_buscado = None
pedidos = []
tipo_clase = None
nombre_tipo = ""
cantidad_pedidos = 0

print("Bienvenido al sistema de gestión de pedidos")

while True:
    print("\nSISTEMA DE GESTIÓN DE PEDIDOS")
    print("0. Salir")
    print("1. Crear Pedido Estándar")
    print("2. Crear Pedido Express")
    print("3. Crear Pedido Internacional")
    print("4. Ver todos los pedidos")
    print("5. Calcular total facturado")
    print("6. Calcular media de distancia")
    print("7. Buscar pedidos por cliente")
    print("8. Contar pedidos por tipo")
    print("9. Ver detalles de un pedido")

    opcion = int(input("Seleccione una opción: "))

    match opcion:
        case 0:
            print("Saliendo...")
            break
            
        case 1:
            cliente = input("Nombre del cliente: ")
            distancia = float(input("Distancia en km: "))
            precio_base = float(input("Precio base: "))
                    
            pedido_nuevo = PedidoEstandar(contador_id, cliente, distancia, precio_base, 0.50)
            gestor.agregar_pedido(pedido_nuevo)
            print(f"Pedido Estándar #{contador_id} creado correctamente")
            print(f"Total: {round(pedido_nuevo.precio_total(), 2)}€")
            contador_id += 1

        case 2:
            cliente = input("Nombre del cliente: ")
            distancia = float(input("Distancia en km: "))
            precio_base = float(input("Precio base: "))
                    
            pedido_nuevo = PedidoExpress(contador_id, cliente, distancia, precio_base, 0.50, 20)
            gestor.agregar_pedido(pedido_nuevo)
            print(f"Pedido Express #{contador_id} creado correctamente")
            print(f"Total con recargo urgencia (20%): {round(pedido_nuevo.precio_total(), 2)}€")
            contador_id += 1

        case 3:
            cliente = input("Nombre del cliente: ")
            distancia = float(input("Distancia en km: "))
            precio_base = float(input("Precio base: "))
            
            pedido_nuevo = PedidoInternacional(contador_id, cliente, distancia, precio_base, 2.0, 50)
            gestor.agregar_pedido(pedido_nuevo)
            print(f"Pedido Internacional #{contador_id} creado correctamente")
            print(f"Total con tasa aduanas: {round(pedido_nuevo.precio_total(), 2)}€")
            contador_id += 1

        case 4: 
            if not gestor.lista_pedidos:
                print("No hay pedidos registrados")
            else:
                print("---------LISTA DE PEDIDOS---------")
                for pedido in gestor.lista_pedidos:
                    print(pedido)
                    print("-" * 60)

        case 5:
            if not gestor.lista_pedidos:
                print("No hay pedidos registrados")
            else:
                print(f"Total facturado: {round(gestor.calcular_todo_facturado(), 2)} €")

        case 6:
            if not gestor.lista_pedidos:
                print("No hay pedidos registrados")
            else:
                print(f"Media de distancias: {round(gestor.calcular_media_distancia(), 2)} kms")

        case 7:
            if not gestor.lista_pedidos:
                print("No hay pedidos registrados")
            else:
                nombre = input("Introduzca el nombre del cliente")
                pedidos = gestor.buscar_pedidos_cliente(nombre)

                if not pedidos:
                    print(f"El cliente {nombre} no tiene pedidos")
                else:
                    print(f"PEDIDOS DE {nombre.upper()}")
                    for pedido in pedidos:
                        print(pedido)

        case 8:
            if not gestor.lista_pedidos:
                print("No hay pedidos registrados")
            else:
                print("\nSeleccione el tipo de pedido:")
                print("1. Pedido Estándar")
                print("2. Pedido Express")
                print("3. Pedido Internacional")

                tipo_opcion = int(input("Indique el tipo de pedido: "))

                match tipo_opcion:
                    case 1:
                        tipo_clase = PedidoEstandar
                        nombre_tipo = "Estándar"

                    case 2:
                        tipo_clase = PedidoExpress
                        nombre_tipo = "Express"
                    case 3:
                        tipo_clase = PedidoInternacional
                        nombre_tipo = "Internacional"
                    case _:
                        print("Opción inválida")
                        continue

                cantidad_pedidos = gestor.contar_tipo_pedido(tipo_clase)
                print(f"Hay {cantidad_pedidos} pedidos de tipo {nombre_tipo}")

        case 9:
            if not gestor.lista_pedidos:
                print("No hay pedidos registrados")
            else:
                pedido_id = int(input("Indique el id de pedido: "))
                pedido_buscado = gestor.buscar_pedido_id(pedido_id)
                
                if pedido_buscado == None:
                    print("Pedido no encontrado")
                else:
                    print("Pedido encontrado: ")
                    print(pedido_buscado)
        
        case _:
            print("Opción inválida")





