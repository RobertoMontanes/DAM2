# 12. Escribe una función contador_likes(*likes_por_dia) que reciba un número variable de enteros (likes
# de cada día) y devuelva: (Si no lo sabes, busca qué significa el asterisco como parte del parámetro de
#una función en Python)
# - El total de likes.
# - La media de likes.
# - El día con más likes 

def contador_likes(*likes_por_dia):
    total = 0
    contLikes = 0
    most_likes = 0
    most_liked_day = 0
    
    for like in likes_por_dia:
        total += like
        contLikes+=1
        if like > most_likes:
            most_likes = like
            most_liked_day = contLikes
    return (total, (total / contLikes), (f"Dia: {most_liked_day}", most_likes))
    
print(contador_likes(5,9,8,2,65,39,25,12,36,95))