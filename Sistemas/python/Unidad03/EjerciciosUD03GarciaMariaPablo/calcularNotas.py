qualitas = {
    "Sistemas de Gestion Empesarial": {
        "UD1 Test": {
            "6.1": 10
            },
        "UD1 Examen": {
            "6.1": 9.5
            },
        "UD2 Examen": {
            "6.2": 9.5
            },
        "UD3 Test1": {
            "6.3":10
        }
        },
    "Optativa": {
        "UD1 Examen": {
            "2.5": 10
        },
        "UD2 Proyecto": {
            "2.5":10,
            "3.2":10,
            "2.4":10,
            "4.1":10,
            "4.2":10,
            "5.1":10,
        }
    }
}

def calcularNotas(qualitas):
    
    
    for asignatura in qualitas:
        resultadosAprendizaje = {}
        notasFin = {}
        for ejercicio in qualitas[asignatura]:
            for ra in qualitas[asignatura][ejercicio]:
                
                if (resultadosAprendizaje.get(ra, None) != None):
                    resultadosAprendizaje[ra].append(qualitas[asignatura][ejercicio][ra])
                else:
                    resultadosAprendizaje[ra] = [qualitas[asignatura][ejercicio][ra]]
        
        for ra in resultadosAprendizaje:
            cont = 0
            total = 0
            for nota in resultadosAprendizaje[ra]:
                cont+=1
                total+= nota
            
            notasFin[ra] = total / cont
        
        cont = 0
        total = 0
        for notaRA in notasFin:
            cont+=1
            total += notasFin[notaRA]
        
        print("La nota es: ", total/cont)
                
            
calcularNotas(qualitas)