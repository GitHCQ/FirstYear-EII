def coincide_apellido(linea,apellido):
    apellidos=linea.split(", ")[0]
    nombre=linea.split(", ")[1]
    if apellido in apellidos:
        return True
    else:
        return False
def contar_fernandez(fichero,apellido):
    f=open(fichero)
    lineas=f.readlines()
    suma=0
    for i in range(len(lineas)):
        if(coincide_apellido(lineas[i],apellido)):
            suma+=1
    return (suma/len(lineas))*100
def palabras_en_nombre(linea):
    apellidos=linea.split(", ")[0]
    nombre=linea.split(", ")[1]
    numNombres=nombre.split(" ")
    return len(numNombres)

f=open("alumnos.txt")
lineas=f.readlines()
numero_palabras=[0,0,0,0,0,0,0,0]
for i in range(len(lineas)):
    if(palabras_en_nombre(lineas[i])==1):
        numero_palabras[0]+=1
    if(palabras_en_nombre(lineas[i])==2):
        numero_palabras[1]+=1
    if(palabras_en_nombre(lineas[i])==3):
        numero_palabras[2]+=1
    if(palabras_en_nombre(lineas[i])==4):
        numero_palabras[3]+=1
for i in range(1,len(numero_palabras)):
    if(i==1):
        print("Hay "+str(numero_palabras[i])+" nombres con " + str(i) +" palabra")
    else:
        print("Hay "+str(numero_palabras[i])+" nombres con " + str(i) +" palabras")


