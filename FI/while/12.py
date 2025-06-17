#Dado un número natural n, escribe un algoritmo para determinar si éste es o no primo (el 1
#no es un número primo
import math
n = int(input("Introduce un número: "))
i = 2
while i <= math.sqrt(n):
    if n % i == 0:
        print(n, "no es primo")
        break
    i += 1
else:
    print(n, "es primo")
