def cambiar_ceros(lista):
    for i in range(len(lista)):
        if lista[i]<0:
            lista[i]=0
    return lista
datos = [ 3, -4, 5, 7, -1, 8 ]
print(datos)
print(cambiar_ceros(datos))
