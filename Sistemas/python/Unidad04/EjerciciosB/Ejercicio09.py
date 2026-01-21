import random

class Droid:
    def __init__(self, nombre:str, energia_base: float):
        self.nombre = nombre
        self.energia_base = energia_base
        pass

    def saludar(self):
        print("Hola soy un "+ type(self).__name__)

    def atacar(self):
        return random.randint(0,10)

    def desplazarse(self):
        self.energia_base -= 1

    def anunciar_desplazamiento(self):
        print("El droide camina lentamente")

class ProtocolDroid(Droid):
    def __init__(self, nombre: str, energia_base: float):
        super().__init__(nombre, energia_base)

    def saludar(self):
        return super().saludar()
    
    def atacar(self):
        return super().atacar() / 2

    def desplazarse(self):
        super().desplazarse()

    def anunciar_desplazamiento(self):
        print("El droide da pasos elegantes")

class AstromechDroid(Droid):
    def __init__(self, nombre, energia_base):
        super().__init__(nombre, energia_base)

    def saludar(self):
        return super().saludar()
    
    def atacar(self):
        return super().atacar() * 1.5
    
    def desplazarse(self):
        super().desplazarse()
        self.energia_base -= 5

    def anunciar_desplazamiento(self):
        print("El droide rueda sobre sus orugas")

class SuperDroid(ProtocolDroid, AstromechDroid):
    def __init__(self, nombre, energia_base):
        super().__init__(nombre, energia_base)

    def saludar(self):
        return super().saludar()

    def atacar(self):
        return ProtocolDroid.atacar(self) + AstromechDroid.atacar(self)
    
    def desplazarse(self):
        super().desplazarse()

    def anunciar_desplazamiento(self):
        ProtocolDroid.anunciar_desplazamiento(self)
        AstromechDroid.anunciar_desplazamiento(self)

class HyperDroid(ProtocolDroid, AstromechDroid):
    def __init__(self, nombre, energia_base):
        super().__init__(nombre, energia_base)

    def atacar(self):
        dano_protocolo = ProtocolDroid.atacar(self)
        dano_astro = AstromechDroid.atacar(self)
        
        return max(dano_astro, dano_protocolo)
    
    def desplazarse(self):
        pass

    def anunciar_desplazamiento(self):
        print("El droide levita a gran velocidad")

opcion = 0
nombre = ""
energia = 0.0
droide_actual = None
lista_droides = []

print("Bienvenido al controlador de droides")

while True:
    print("\nMENÚ DE PRUEBA DE DROIDES")
    print("0. Salir")
    print("1. Crear Droid básico")
    print("2. Crear ProtocolDroid")
    print("3. Crear AstromechDroid")
    print("4. Crear SuperDroid")    
    print("5. Crear HyperDroid")    
    print("6. Seleccionar droide")
    print("7. Saludar")
    print("8. Atacar con el droide")
    print("9. Desplazar al droide")
    print("10. Ver estado del droide")
    print("11. Ver todos los droides")

    opcion = int(input("Escoja una opción: "))

    match(opcion):
        case 0:
            print("Saliendo...")
            break
        
        case 1:
            nombre = input("Nombre del Droid: ")
            energia = float(input("Energía base: "))
            nuevo_droid = Droid(nombre, energia)
            lista_droides.append(nuevo_droid)
            droide_actual = nuevo_droid
            print(f"Droid '{nombre}' creado y añadido a la lista")

        case 2:
            nombre = input("Nombre del ProtocolDroid: ")
            energia = float(input("Energía base: "))
            nuevo_droid = ProtocolDroid(nombre, energia)
            lista_droides.append(nuevo_droid)
            droide_actual = nuevo_droid
            print(f"ProtocolDroid '{nombre}' creado y añadido a la lista")
        
        case 3:
            nombre = input("Nombre del AstromechDroid: ")
            energia = float(input("Energía base: "))
            nuevo_droid = AstromechDroid(nombre, energia)
            lista_droides.append(nuevo_droid)
            droide_actual = nuevo_droid
            print(f"AstromechDroid '{nombre}' creado y añadido a la lista")

        case 4:
            nombre = input("Nombre del SuperDroid: ")
            energia = float(input("Energía base: "))
            nuevo_droid = SuperDroid(nombre, energia)
            lista_droides.append(nuevo_droid)
            droide_actual = nuevo_droid
            print(f"SuperDroid '{nombre}' creado y añadido a la lista")

        case 5:
            nombre = input("Nombre del HyperDroid: ")
            energia = float(input("Energía base: "))
            nuevo_droid = HyperDroid(nombre, energia)
            lista_droides.append(nuevo_droid)
            droide_actual = nuevo_droid
            print(f"HyperDroid '{nombre}' creado y añadido a la lista")

        case 6:
            if not lista_droides:
                print("No hay droides en la lista")
            else:
                print("\nLista de droides:")
                for i, droid in enumerate(lista_droides):
                    print(f"{i+1}. {droid.nombre} ({type(droid).__name__}) - Energía: {droid.energia_base}")
                
                seleccion = int(input("Seleccione un droide: ")) - 1
                if 0 <= seleccion < len(lista_droides):
                    droide_actual = lista_droides[seleccion]
                    print(f"Droide '{droide_actual.nombre}' seleccionado")
                else:
                    print("Número inválido")

        case 7:
            if droide_actual:
                droide_actual.saludar()
            else:
                print("Primero seleccione o cree un droide")

        case 8:
            if droide_actual:
                dano = droide_actual.atacar()
                print(f"{droide_actual.nombre} ataca causando {dano:.2f} de daño")
            else:
                print("Primero seleccione o cree un droide")

        case 9:
            if droide_actual:
                print(f"Energía antes: {droide_actual.energia_base}")
                droide_actual.desplazarse()
                droide_actual.anunciar_desplazamiento()
                print(f"Energía después: {droide_actual.energia_base}")
            else:
                print("Primero seleccione o cree un droide")

        case 10:
            if droide_actual:
                print(f"\nEstado del droide:")
                print(f"Nombre: {droide_actual.nombre}")
                print(f"Tipo: {type(droide_actual).__name__}")
                print(f"Energía: {droide_actual.energia_base}")
            else:
                print("Primero seleccione o cree un droide")

        case 11:
            if not lista_droides:
                print("No hay droides en la lista")
            else:
                print("\nTodos los droides:")
                for i, droid in enumerate(lista_droides):
                    print(f"{i+1}. {droid.nombre} ({type(droid).__name__}) - Energía: {droid.energia_base}")

        case _:
            print("Opción no válida")
