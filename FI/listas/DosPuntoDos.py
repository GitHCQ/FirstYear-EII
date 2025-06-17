def indice_mayor(lista):
    mayor=0
    for i in range(len(lista)):
        if lista[i]>mayor:
            mayor=lista[i]
            indiceMayor=i
    return indiceMayor
lista=[4,2,7,1,3]
print(indice_mayor(lista))
