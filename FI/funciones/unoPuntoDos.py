def mayor():
    num1=int(input("Introduzca un numero: "))
    num2=int(input("Introduzca un numero: "))
    if num1>num2:
        return num1
    else:
        return num2
mayor_a_imprimir=mayor()
print(mayor_a_imprimir)