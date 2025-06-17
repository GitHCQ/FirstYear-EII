fpares=open("pares.txt","w")
fimpares=open("impares.txt","w")
n=int(input("Introduzca un numero"))
while n>=0:
    numero_y_salto = str(n)+"\n"
    if n%2==0:
        fpares.write(numero_y_salto)
    else:
        fimpares.write(numero_y_salto)
    n=int(input("Introduzca un numero"))
    if n<0:
        break
fpares.close()
fimpares.close()




