#Dados dos números naturales n y a, escribe un programa que obtenga y muestre en pantalla,
#si existe, el menor entero del rango [1, n] cuyo número de divisores sea igual a a.
n=int(input("Dame un numero para finalizar el rango: "))
a=int(input("Dame un numero: "))
menor=1
for i in range(1,n+1):
    divisores=0
    for j in range(1,i+1):
        if(i%j==0):
            divisores+=1
    if(divisores==a):
        menor=i
        break
print(menor)
