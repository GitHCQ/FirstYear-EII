#Numeros perfectos entre 2 y umbral (numero perfecto suma divisores==numero)
def divisores(n):
    suma=0
    for i in range(1,n):
        if(n%i==0):
            suma+=i
    return suma

umbral=int(input("Dame un numero: "))
perfectos=""
for i in range(2,umbral):
    if(divisores(i)==i):
        perfectos+=str(i)+ " "
print(f"Umbral = {umbral} --> {perfectos}")

