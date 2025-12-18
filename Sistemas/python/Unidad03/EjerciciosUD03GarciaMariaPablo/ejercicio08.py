# Crea una función maraton_series(horas) que reciba un número de horas vistas de series y devuelva
# una tupla con (dias, horas_restantes).
# Ejemplo: 27 horas → (1, 3).

def maraton_series(horas):
    horas_dia = 24
    dias = horas // horas_dia
    horas = horas - (dias * horas_dia) 
    return (dias,horas)
    
print(maraton_series(27))
print(maraton_series(59))
print(maraton_series(26))
print(maraton_series(12))
print(maraton_series(5))