#Escribir una función que reciba como parámetros una lista y un valor escalar. La
#función devuelve el índice que ocupa la última aparición del valor escalar dentro de la lista o None
#si no se encuentra
def encuentra_valor(lista,num):
    if num not in lista:
        return None
    else:
        mayor=0
        for i in range(len(lista)):
            if(lista[i]==num):
                mayor=i
        return mayor
lista=[1,2,3,3,6]
num=3
print(encuentra_valor(lista,7))

