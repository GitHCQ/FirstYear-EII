def calificacion(x):
    if(nota>=0.0 and nota<5.0):
        return "Suspenso"
    if(nota>=5.0 and nota<7.0):
        return "Aprobado"
    if(nota>=7.0 and nota<9.0):
        return "Notable"
    if(nota>=9.0 and nota<10.0):
        return "Sobresaliente"
    if(nota==10):
        return "Matricula de honor"
nota=float(input("Introduzca su nota: "))
print(calificacion(nota))