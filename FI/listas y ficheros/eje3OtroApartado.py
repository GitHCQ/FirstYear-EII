def habitantes_cercanos(linea,num):
    habitantes=int(linea.split(";")[1])
    dif=habitantes-num
    if(dif<1000000):
        return True
    else:
        return False

def promedio_hab(linea):
    habitantes=int(linea.split(";")[1])
    return habitantes

f=open("datos-paises.csv")
lineas=f.readlines()
f.close()
suma=0
salida2=open("salida2.txt","w")
for i in range(len(lineas)):
    suma+=promedio_hab(lineas[i])
promedio=suma/len(lineas)

for i in range(len(lineas)):
    if(habitantes_cercanos(lineas[i],promedio)):
        salida2.write(lineas[i])
salida2.close()