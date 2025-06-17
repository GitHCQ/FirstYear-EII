#Escribe un programa que lea por teclado enteros positivos número a número y proporcione
#el mayor de ellos y la posición en la que éste se introdujo. La lectura de números terminará si se introduce
#el valor 0.
#Ejemplo de salida para la entrada: 100 25 36 596 3 15 0
numero=int(input("Introduce un numero"))
mayor=0
i=0
pos_mayor=0
while numero!=0:
    i+=1
    if(numero>mayor):
        mayor=numero
        pos_mayor=i
    numero=int(input("Introduce un numero"))
print("El mayor numero introducido es %d y en la posicion %d" %(mayor,pos_mayor))