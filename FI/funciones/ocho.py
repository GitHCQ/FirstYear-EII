import math
def distance(x,y):
    radio=math.sqrt(math.pow(x,2)+math.pow(y,2))
    return 2*math.pi*radio
puntoAbcisas=float(input("Introduzca la coordenada de abcisas del punto: "))
puntoOrdenadas=float(input("Introduzca la coordenada de ordenadas del punto: "))

print(distance(puntoAbcisas,puntoOrdenadas))