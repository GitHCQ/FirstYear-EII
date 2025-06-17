def fibonnaci(n):
    if n==0 or n==1:
        return 1
    return fibonnaci(n-1)+fibonnaci(n-2)

m=int(input("Dame un umbral: "))
suma=0
print(f"Para m = {m} -> ",end="")
for i in range(m+1):
    suma+=fibonnaci(i)
    print(suma,end=" ")
