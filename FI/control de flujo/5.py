#Dado un número natural n, escribe un programa que muestre en pantalla todos los números
#naturales menores que n que sean iguales a la suma de las cifras de sus cubos.
n=int(input("Dame un numero: "))
numeros=""
for i in range(1,n):
    numerosSumados=0
    for digit in str(i):
        numerosSumados+=int(digit)**3
    if numerosSumados==i:
        numeros+=str(i)+" "
print(numeros)