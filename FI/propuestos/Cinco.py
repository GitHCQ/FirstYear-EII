#Escribir una función que reciba un parámetro, representando una matriz cuadrada.
#La función devuelve True si la matriz es diagonal, False en caso contrario
def diagonal(matriz):
    filas=len(matriz)
    for i in range(filas):
        for j in range(filas):
            if i != j and matriz[i][j] != 0:
                return False
    return True
# Ejemplo de uso
matriz_diagonal = [
    [1, 0, 0],
    [0, 2, 0],
    [0, 0, 3]
]

matriz_no_diagonal = [
    [1, 0, 1],
    [0, 2, 0],
    [0, 0, 3]
]

print(diagonal(matriz_diagonal))  # True
print(diagonal(matriz_no_diagonal))  # False
