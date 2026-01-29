que falla en este decorador
def comprobar_puntuacion(func):
        def wrapper(*args, **kwargs):
            puntuacion_final = func(args, kwargs)
            if puntuacion_final < Interaccion.puntuacion_minima:
                return Interaccion.puntuacion_minima
            return puntuacion_final
        return wrapper(func)

PS C:\Users\garcia.mapab24_trian\Documents\REPOSITORIOS\DAM2\Sistemas\python\ExamenUD3> & C:/Users/garcia.mapab24_trian/AppData/Local/Programs/Python/Python313/python.exe c:/Users/garcia.mapab24_trian/Documents/REPOSITORIOS/DAM2/Sistemas/python/ExamenUD3/examenT3PabloGarcia.py
Traceback (most recent call last):
  File "c:\Users\garcia.mapab24_trian\Documents\REPOSITORIOS\DAM2\Sistemas\python\ExamenUD3\examenT3PabloGarcia.py", line 1, in <module>
    class Interaccion():
    ...<25 lines>...
            print("Finalizando gestor de contexto...")
  File "c:\Users\garcia.mapab24_trian\Documents\REPOSITORIOS\DAM2\Sistemas\python\ExamenUD3\examenT3PabloGarcia.py", line 17, in Interaccion
    @comprobar_puntuacion
     ^^^^^^^^^^^^^^^^^^^^
  File "c:\Users\garcia.mapab24_trian\Documents\REPOSITORIOS\DAM2\Sistemas\python\ExamenUD3\examenT3PabloGarcia.py", line 15, in comprobar_puntuacion
    return wrapper(func)
  File "c:\Users\garcia.mapab24_trian\Documents\REPOSITORIOS\DAM2\Sistemas\python\ExamenUD3\examenT3PabloGarcia.py", line 11, in wrapper
    puntuacion_final = func(args, kwargs)
TypeError: Interaccion.calcular_valor() missing 1 required positional argument: 'argumentoReproduccion'
PS C:\Users\garcia.mapab24_trian\Documents\REPOSITORIOS\DAM2\Sistemas\python\ExamenUD3> 


Como hacer para pasar ese gestor de contexto con el 5 como parametro
def __enter__(self):
    self.dias_puntuacion = 5
    return self

    # def __exit__(*args):
    #     pass