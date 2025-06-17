def IMC(altura,peso):
    imc=(peso/(altura**2))
    if(imc<18.50):
        return "Bajo peso"
    elif(imc>=18.50 and imc<25.00):
        return "Normal"
    elif(imc>=25.00):
        return "Sobrepeso"
    elif(imc>=30):
        return "Obesidad"
altura=float(input("Introduzca su altura en metros: "))
peso=float(input("Introduzca su peso en kg: "))
print(IMC(altura,peso))