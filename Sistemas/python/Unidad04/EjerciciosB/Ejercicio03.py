import datetime as dt

def calcularPrecioInmueble(ano, metros, habitaciones, garaje, zona):
    precio = 0
    now = dt.date.today()

    antiguedad = now.year - ano 
    
    if(zona == 'A'):
        precio +=  (metros*1000 + habitaciones*5000 + garaje*15000) * (1-antiguedad/100)
    else:
        precio +=  (metros*1000 + habitaciones*5000 + garaje*15000) * (1-antiguedad/100) * 1.5

    return precio

def obtenerInmuebles(inmuebles, precio):
    inmueblesObtenidos = []

    for inmueble in inmuebles:
        precioInmueble = calcularPrecioInmueble(inmueble.get('ano'), inmueble.get('metros'), inmueble.get('habitaciones'), inmueble.get('garaje'), inmueble.get('zona'))
        if(precioInmueble <= precio):
            inmueble["precio"] = precioInmueble
            inmueblesObtenidos.append(inmueble)

    
    return inmueblesObtenidos




inmuebles = [{'ano': 2000, 'metros': 100, 'habitaciones': 3, 'garaje': True, 'zona': 'A'},
{'ano': 2012, 'metros': 60, 'habitaciones': 2, 'garaje': True, 'zona': 'B'},
{'ano': 1980, 'metros': 120, 'habitaciones': 4, 'garaje': False, 'zona': 'A'},
{'ano': 2005, 'metros': 75, 'habitaciones': 3, 'garaje': True, 'zona': 'B'},
{'ano': 2015, 'metros': 90, 'habitaciones': 2, 'garaje': False, 'zona': 'A'}]

precio = 0
inmueblesDisponibles = []


print("Bienvenido al Housing")
precio = float(input("Introduzca su presupuesto: \n"))


print("Casas disponibles por debajo del presupuesto:")
inmueblesDisponibles = obtenerInmuebles(inmuebles, precio)
for inmueble in inmueblesDisponibles:
    print(inmueble)