letra=input("introduzca una letra: ")
contador=0
palabra=""
while letra!=".":
    if(letra=="a"):
        contador+=1
    palabra+=letra
    print(palabra)
    letra=input("introduzca una letra: ")
print(contador)
