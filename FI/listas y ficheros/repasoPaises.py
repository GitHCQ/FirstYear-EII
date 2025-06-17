f=open("datos-paises.csv")
datos=f.readlines()
salida=open("salida-iria.txt","w")
for i in range(len(datos)):
    pais=datos[i].split(";")[0]
    habitante=datos[i].split(";")[1]
    telefono=datos[i].split(";")[2]
    promedio=float(float(telefono)/float(habitante))
    salida.write(pais+str(promedio))
    #print(pais+ ";"+ str(promedio)+"\n")