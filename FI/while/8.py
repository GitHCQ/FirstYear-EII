#Dado un número entero n>0, escribe un programa que imprima sus cifras de la menos a la
#más significativa.
#Ejemplo de salida del programa para la entrada: 7249:
num=int(input("Dame un numero mayor que 0: "))
cad=""
while num>0:
    cad+=str(num%10) + " "
    num=num//10
print(f"La secuencia de cifras de - a + sig de {num} es {cad}")

