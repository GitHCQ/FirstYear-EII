#Dado un número natural umbral, escribe un programa que muestre los términos de la
#sucesión de Fibonacci. El primer término de dicha sucesión es 0, el segundo es 1.
#Sucesión de Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, …
umbral=int(input("Introduce un umbral: "))
i=0
a,b=0,1
while i<umbral:
    print(a, end=" ")
    a,b=b,a+b
    i+=1
print()