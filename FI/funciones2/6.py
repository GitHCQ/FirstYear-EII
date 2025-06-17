import string
def bases(n1,n2):
    en_base=""
    digitos = string.digits + string.ascii_uppercase
    while n1!=0:
        en_base+=digitos[n1 % n2]
        n1//=n2
    return en_base[::-1]

cond=True
while cond:
    n1=int(input("Dame un numero mayor que 0: "))
    n2=int(input("Dame un numero mayor o igual que 2 y menor o igual que 16: "))
    if n1>0 and (n2>=2 and n2<=16):
        cond=False
print(bases(n1,n2))