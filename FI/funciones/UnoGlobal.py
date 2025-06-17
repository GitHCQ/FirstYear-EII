def lee_entero():
    numero=int(input("Introduzca un numero entero: "))
    return numero

def mayor(num1,num2):
    return max(num1,num2)
num1=lee_entero()
num2=lee_entero()
resultado=mayor(num1,num2)
print(resultado)