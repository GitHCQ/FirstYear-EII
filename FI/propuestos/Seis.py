#Escribir una función que reciba un parámetro, representando una matriz cuadrada.
#La función devuelve True si la matriz es simétrica, False en caso contrario
def simetrica(matriz):
    filas=len(matriz)
    for i in range(filas):
        for j in range(filas):
            if matriz[i][j]!=matriz[j][i]:
                return False
    return True
# Ejemplo de uso
matriz_simetrica = [
    [1, 2, 3],
    [2, 4, 5],
    [3, 5, 6]
]

matriz_no_simetrica = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

print(simetrica(matriz_simetrica))  # True
print(simetrica(matriz_no_simetrica))  # False