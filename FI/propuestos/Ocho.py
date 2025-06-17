#Escribir una función que reciba una lista de listas de números representando una
#matriz y que devuelva una lista con el máximo de cada fila por separado
def max_fila(matriz):
    fila=len(matriz)
    maximo=[0]*fila
    for i in range(fila):
        maximo[i]=max(matriz[i])
    return maximo
lst=[[1,2,3],[4,5,6],[7,8,9]]
print(max_fila(lst))
