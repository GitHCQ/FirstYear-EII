#Dados dos números naturales m y n, escribe un programa que muestre en pantalla la
#siguiente matriz de m filas y n columnas:

#A11 A12 … A1n
#A21 A22 … A2n
#. . . . . . .
#Am1 Am2 … Amn
n=int(input("Dame el numero de filas: "))
m=int(input("Dame el numero de columnas: "))
for i in range(n):
    print()
    for j in range(m):
        print("A"+str(i)+str(j),end=" ")