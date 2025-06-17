#Dado un número entero n (n≥0), escribir un programa para obtener la cadena de caracteres
#de unos y ceros correspondiente a su representación en binario sin utilizar la función predefinida bin
n=int(input("Introduce un numero para convertir a binario"))
num=n
cad=""
while num>0:
    cad+=str(num%2)
    num=num//2
print(cad[::-1])