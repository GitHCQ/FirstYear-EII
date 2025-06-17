lista1=[5,8,10]
lista2=[3,2,9,12,4]
for i in lista1:
    print(i)
for j in reversed(lista2):
    print(j)
suma=0

for i in range(len(lista1)):
    suma+=lista1[i]
print(suma)