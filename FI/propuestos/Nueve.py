#Escribir una función que reciba una lista de listas de números representando una
#matriz y que devuelva una lista con el máximo de cada columna por separado
def max_columna(matriz):
    fila=len(matriz)
    columna=len(matriz[0])
    maximoColumna=[]
    for j in range(columna):
        maximo_columna = max(matriz[i][j] for i in range(fila))
        maximoColumna.append(maximo_columna)
    return maximoColumna

lst=[[1,2,3],[4,5,6],[7,8,9]]
print(max_columna(lst))