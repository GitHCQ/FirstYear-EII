
def f_sucesion(b,c,d,k):
    if k==0:
        return b
    else:
        return c*f_sucesion(b,c,d,k-1)+d

b=int(input("Primer parametro de la sucesion: "))
c=int(input("Parametro de la sucesion: "))
d=int(input("Parametro de la sucesion: "))
k=int(input("Umbral "))
print(f_sucesion(b,c,d,k))