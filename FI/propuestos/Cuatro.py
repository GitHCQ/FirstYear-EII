#Escribir una función que reciba un parámetro, representando el tamaño de una
#matriz cuadrada. La función devuelve una lista de listas que contiene la matriz identidad.
def matriz_identidad(tamano):
    matriz = []
    for i in range(tamano):
        fila = []
        for j in range(tamano):
            # Llenar la diagonal principal con unos, el resto con ceros
            if i == j:
                fila.append(1)
            else:
                fila.append(0)
        matriz.append(fila)
    return matriz
tamano_matriz = 8
matriz_resultante = matriz_identidad(tamano_matriz)
print(matriz_resultante)