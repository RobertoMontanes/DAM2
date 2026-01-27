qualitas = {
    "Sistemas de Gestion Empesarial": {
        ## INICIO PRIMERA EVALUACION ##
        "UD1 Test": {
            "6.1" : 10
            },
        "UD1 Examen": {
            "6.1" : 9.5
            },
        "UD2 Examen": {
            "6.2" : 9.5
            },
        "UD3 Test1": {
            "6.3" : 10
        },
        ## FIN PRIMERA EVALUACION ##
        ## INICIO SEGUNDA EVALUACION ##
        "UD3 Act. Listado 1" : {
            "6.3" : 10
        }
        },
    "Optativa": {
        ## INICIO PRIMERA EVALUACION ##
        "UD1 Examen": {
            "2.5": 10,
            "2.4": 10,
            "1.6": 10,
            "1.2": 10,
            "1.5": 7,
        },
        "UD2 Proyecto": {
            "2.5":10,
            "3.2":10,
            "2.4":10,
            "4.1":10,
            "4.2":10,
            "5.1":10,
        }   
        ## FIN PRIMERA EVALUACION ##
    },
    "Ingles" : {
        "Vocabulary 1 (UD 1)" : {
            "Criterio 3.c": 8.32,
        },
        "Vocabulary 2 (UD 1)" : {
            "Criterio 4.d": 10,
        },
        "Fichas interactivas (Vocabulary UD 1)" : {
            "Criterio 1.h": 9.18,
        },
        "Cuestionario Moodle (Vocabulary UD 1)" : {
            "Criterio 2.i": 9.4,
        },
        "Reading 1 (Vocabulary UD 1)" : {
            "Criterio 2.a": 9.18,
        },
        "Reading 2 (UD 1)" : {
            "Criterio 2.i" : 9.18
        },
        "Listening 1 (UD 1)" : {
            "Criterio 1.a" : 9.18
        },
        "Listening 2 (UD 1)" : {
            "Criterio 1.c" : 10
        },
        "Cuestionario Moodle (Listening UD 1)" : {
            "Criterio 1.b" : 9
        },
        "Grammar 1 (UD 1)" : {
            "Criterio 4.c" : 6.68
        },
        "Fichas Interactivas (Grammar UD 1)" : {
            "Criterio 3.a" : 10
        },
        "Cuestionario Moodle (Grammar UD 1)" : {
            "Criterio 4.a" : 9.5
        },
        "Writting 1 (UD 1)" : {
            "Criterio 4.e" : 9.18
        },
        "Speaking 1 'Introducing Yourself' (UD 1)" : {
            "Criterio 3.i" : 9,
            "Criterio 3.g" : 9,
        },
        "Vocabulary 3 (UD 2)" : {
            "Criterio 3.d" : 9.18,
        },
        "Vocabulary 4 (UD 2)" : {
            "Criterio 3.e" : 10,
        },
        "Fichas Interactivas (Vocabulary UD 2)" : {
            "Criterio 2.h" : 9.18,
        },
        "Cuestionario Mooodle (Vocabulary UD 2)" : {
            "Criterio 4.b" : 10,
        },
        ## FIN PRIMER TRIMESTRE ## 
        ## INICIO SEGUNDO TRIMESTRE ##
        "Reading 3 (UD 2)" : {
            "Criterio 2.c" : 9.18,
        },
        "Reading 4 (UD 2)" : {
            "Criterio 2.d" : 10,
        },
        "Cuestionario Moodle (Reading UD 2)" : {
            "Criterio 2.g" : 9.3,
        },
        "Listening 3 (UD 2)" : {
            "Criterio 1.f" : 10,
        },
        "Cuestionario Moodle (Listening UD 2)" : {
            "Criterio 1.g" : 9.17,
        },
        "Grammar 2 (UD 2) - Modal Verbs 1" : {
            "Criterio 4.g" : 9.18,
        },
        "Grammar 2 (UD 2) - Modal Verbs 2" : {
            "Criterio 3.b" : 10,
        },
        "Ficheros Interactivas (Modal Verbs)" : {
            "Criterio 5.c" : 9.18,
        },
        "Cuestionario Moodle (Grammar UD2)" : {
            "Criterio 4.h" : 6.4,
        },
    }
}

def calcularNotas(qualitas):
    for asignatura in qualitas:
        print(f"Trabajando: {asignatura}")
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
        
        print(f"La nota es: {round(total/cont,2)}")

calcularNotas(qualitas)