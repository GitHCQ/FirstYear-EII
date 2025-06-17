def es_primo(n):
    if(n==1):
        return False
    for i in range(2,n):
        if(n%i==0):
            return False
    return True
num=1
while num>0:
    num=int(input("Introduzca un numero: "))
    if num<=0:
        break
    if(es_primo(num)):
        print(f"El numero {num} es primo")
    else:
        print(f"El numero {num} no es primo")
