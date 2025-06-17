numero=int(input("Introduce un numero: "))
contador=0
suma=0
while numero>=0:
    contador+=1
    suma+=numero
    numero=int(input("Introduce un numero: "))
media=suma/contador
print(media)