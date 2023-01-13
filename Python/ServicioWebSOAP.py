from zeep import Client

cliente = Client('http://localhost:8080/ServicioWeb_SOAP/WSOperaciones?WSDL');

#Funcion 1 "Loguearse"
if cliente.service.Loguin("Adrisher","Aigz17"):
    print("Credenciales correctas")
else:
    print("Credenciales incorrectas")


#Funcion 2 "Procesar pago"
if cliente.service.ProcesarPago(5000, 6000) != -1:
    print("Pago exitosamente realizado!!")
    print("Su vuelto es de: " + str (cliente.service.ProcesarPago(5000, 6000)))
else:
    print("Dinero insuficiente")



