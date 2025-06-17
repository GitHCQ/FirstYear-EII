def linea(ch,n):
    return ch*n
n=int(input("Dimensiones del cuadrado: "))
ch=input("Relleno del cuadrado: ")
for i in range(n):
    print(linea(ch,n))