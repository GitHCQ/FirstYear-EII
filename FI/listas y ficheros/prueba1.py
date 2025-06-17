def suma_en_fichero(fichero):
    f=open("datos.txt")
    lineas=f.readlines()
    suma=0
    for i in range(len(lineas)):
        suma+=int(lineas[i])
    f.close()
    return suma

print(suma_en_fichero("datos.txt"))
