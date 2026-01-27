import csv

def calcular_media_filtrada(lista_registros, trimestres_aceptados):
    """
    Función auxiliar que calcula la nota media siguiendo la lógica:
    Agrupar por Criterio -> Media del Criterio -> Media de las Medias
    Solo incluye registros cuyo trimestre esté en 'trimestres_aceptados'.
    """
    # 1. Agrupar notas por Criterio (RA)
    agrupacion_criterios = {}
    
    for registro in lista_registros:
        if registro['trimestre'] in trimestres_aceptados:
            criterio = registro['criterio']
            nota = registro['nota']
            
            if criterio not in agrupacion_criterios:
                agrupacion_criterios[criterio] = []
            agrupacion_criterios[criterio].append(nota)
    
    if not agrupacion_criterios:
        return None # No hay notas para esta evaluación

    # 2. Calcular media de cada criterio
    medias_criterios = []
    for criterio, notas in agrupacion_criterios.items():
        media = sum(notas) / len(notas)
        medias_criterios.append(media)

    # 3. Calcular media total (media de las medias)
    return sum(medias_criterios) / len(medias_criterios)


def calcularNotasPorTrimestre(archivo_csv):
    # Estructura: datos[Persona][Asignatura] = [ {trimestre, criterio, nota}, ... ]
    datos = {}

    try:
        with open(archivo_csv, mode='r', newline='', encoding='utf-8') as f:
            reader = csv.DictReader(f)
            
            for row in reader:
                persona = row['Persona']
                asignatura = row['Asignatura']
                trimestre = row['Trimestre']
                # Normalizamos 'Primero', 'Segundo', etc. para evitar errores de mayúsculas
                trimestre = trimestre.capitalize() 
                criterio = row['Criterio']
                nota = float(row['Nota'])

                if persona not in datos:
                    datos[persona] = {}
                
                if asignatura not in datos[persona]:
                    datos[persona][asignatura] = []

                # Guardamos el registro completo en una lista para procesarlo luego
                datos[persona][asignatura].append({
                    'trimestre': trimestre,
                    'criterio': criterio,
                    'nota': nota
                })

    except FileNotFoundError:
        print(f"Error: No se encuentra el archivo '{archivo_csv}'")
        return
    except KeyError as e:
        print(f"Error: Falta la columna {e}. Verifica las cabeceras del CSV.")
        return

    # --- Lógica de cálculo y visualización ---
    print("====== BOLETÍN DE NOTAS ======")
    
    for persona, asignaturas in datos.items():
        print(f"\n>> ALUMNO/A: {persona.upper()}")
        
        for asignatura, registros in asignaturas.items():
            print(f"   [Asignatura: {asignatura}]")
            
            # --- DEFINICIÓN DE REGLAS ACUMULATIVAS ---
            # 1ª Eval: Solo Primero
            nota_1 = calcular_media_filtrada(registros, ['Primero'])
            
            # 2ª Eval: Primero + Segundo
            nota_2 = calcular_media_filtrada(registros, ['Primero', 'Segundo'])
            
            # 3ª Eval: Primero + Segundo + Tercero
            nota_3 = calcular_media_filtrada(registros, ['Primero', 'Segundo', 'Tercero'])

            # --- IMPRESIÓN ---
            val_1 = f"{round(nota_1, 2)}" if nota_1 is not None else "-"
            val_2 = f"{round(nota_2, 2)}" if nota_2 is not None else "-"
            val_3 = f"{round(nota_3, 2)}" if nota_3 is not None else "-"

            print(f"      1ª Evaluación: {val_1}")
            print(f"      2ª Evaluación: {val_2}")
            print(f"      3ª Evaluación: {val_3}")

# Ejecutar la función
calcularNotasPorTrimestre('notas-trim.csv')