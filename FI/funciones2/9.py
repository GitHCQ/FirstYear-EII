def fibonnaci(n):
    if n==0 or n==1:
        return 1
    return fibonnaci(n-1)+fibonnaci(n-2)
n=int(input("Dame un numero: "))
fib=fibonnaci(n)
print(f"Para n = {n} -> {fib}")