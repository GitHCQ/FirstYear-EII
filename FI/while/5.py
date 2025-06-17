numero=int(input("Introduce un numero"))
i=1
raiz=1
while (i*i)<=numero:
    i+=1
    raiz=i-1
print("La raiz cuadrada de %d es %d" %(numero,raiz))