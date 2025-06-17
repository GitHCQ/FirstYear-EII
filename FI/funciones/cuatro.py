def es_bisiesto(año):
    if (año%4==0 and año&100!=0) or año%400==0:
        return True
    else:
        return False
año=int(input("Introduzca un año: "))

if(es_bisiesto(año)):
    print("El año ",año,"es bisiesto")
else:
    print("El año ",año,"no es bisiesto")
