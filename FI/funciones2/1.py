def factorial(n):
    factorial=1
    for i in range(1,n+1):
        factorial*=i
    return factorial
n=int(input("Dame un numero para calcular el factorial: "))
print(f"El factorial de {n} ({n}!) es: " + str(factorial(n)))