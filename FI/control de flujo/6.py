#Dado un número natural n, escribe un programa que proporcione la siguiente salida:
#1
#1 2
#. . . . .
#1 2 3 ... n-1
#1 2 3 ... n-1 n
cadena=""
n=int(input("Dame un numero: "))
for i in range(1,n+1):
    for j in range(1,i+1):
        cadena+=str(j)+" "
        if(i==j):
            cadena+="\n"
print(cadena)