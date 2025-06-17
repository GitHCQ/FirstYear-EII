def suma_columnas(matriz):
    # Obtener las dimensiones de la matriz
    filas = len(matriz)
    columnas = len(matriz[0])

    # Inicializar la lista para almacenar las sumas de las columnas
    sumas_columnas = []
    # Calcular la suma de cada columna
    for j in range(columnas):
        suma_columna = 0
        for i in range(filas):
            suma_columna += matriz[i][j]
        sumas_columnas.append(suma_columna)

    return sumas_columnas

# Ejemplo de uso
matriz_ejemplo = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

resultado_sumas = suma_columnas(matriz_ejemplo)
print(resultado_sumas)