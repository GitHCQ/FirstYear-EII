#] Escribir una función que reciba como parámetros una lista y un valor escalar. La
#función devuelve una lista con los índices de cada aparición del valor escalar dentro de la lista o
#None si no se encuentra.
def lista_indices(lista,num):
    if num not in lista:
        return None
    else:
        indices=[]
        for i in range(len(lista)):
            if(lista[i]==num):
                indices.append(i)
        return indices
lista=[1,1,1,1,3,4,5,6]
print(lista_indices(lista,1))
