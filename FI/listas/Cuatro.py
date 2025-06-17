def potencia(lista,n):
    suma=0
    for i in range(len(lista)):
        suma+=lista[i]**n
    return suma
lista=[2,1,8]
n=2
print(potencia(lista,n))