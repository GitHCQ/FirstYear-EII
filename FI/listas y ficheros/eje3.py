def tele_habitante(linea):
    habitantes=int(linea.split(";")[1])
    telefonos=int(linea.split(";")[2])
    return str(telefonos/habitantes)
def leer_pais(linea):
    return linea.split(";")[0]

f=open("datos-paises.csv")
lineas=f.readlines()
fichero_salida = open('salida.txt', 'w', encoding='utf-8')
for i in range(len(lineas)):
    fichero_salida.write(leer_pais(lineas[i])+";"+tele_habitante(lineas[i])+"\n")
f.close()
fichero_salida.close()