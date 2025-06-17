def suma_elementos(lista):
    suma=0
    for i in range(len(lista)):
        suma+=lista[i]
    return suma
lista=[5,8,10]
print(suma_elementos(lista))