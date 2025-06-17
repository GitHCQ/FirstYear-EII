def contorno_cuadrado(ch,n):
    cuadrado=""
    for i in range(n):
        if i==0 or i==n-1:
            cuadrado+=ch*(2*n)+"\n"
        else:
            cuadrado+=ch+" "*(2*n-2)+ch+"\n"
    return cuadrado
print(contorno_cuadrado("*",6))