#Dados dos enteros a≥0 y b>0, escribe un programa que calcule el cociente y el resto de su
#división entera utilizando para ello el método de restas sucesivas y mostrar el resultado en la forma:
a=int(input("Introduce el dividendo"))
b=int(input("Introduce el divisor"))
#Cociente: 17 // 3 = 5
#Resto: 17 % 3 = 2
cociente=0
resto=a
while resto>=b:
    cociente+=1
    resto-=b
print(cociente)
print(resto)