<?php

//Creacion de cliente
$cliente = new SoapClient('http://localhost:8080/ServicioWeb_SOAP/WSOperaciones?WSDL');

//Método de pago
$resultado_pago = $cliente->ProcesarPago([
    "total" => 1000,
    "pago" => 5000
])->return;

if ($resultado_pago >= 0) {
    echo 'Pago exitosamente realizado!! :D';
} else {
    echo 'Saldo insuficiente, vuelva a cuando tenga plata';
}

?>