import math
def distance(x,y):
    return math.sqrt(math.pow(x,2)+math.pow(y,2))

puntoAbcisas=int(input("Introduzca la coordenada de abcisas del punto: "))
puntoOrdenadas=int(input("Introduzca la coordenada de ordenadas del punto: "))

print(distance(puntoAbcisas,puntoOrdenadas))