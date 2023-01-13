using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ServicioWeb_WCF
{
    internal class Program
    {
        static void Main(string[] args){

            Console.WriteLine("Bienvenido a mi primer consumo con C#");
            Service.WSOperacionesClient servicioC = new Service.WSOperacionesClient();

            //Funcion numero 1 de loguearse

            if (servicioC.Loguin("Adrisher", "Aigz1752"))
            {
                Console.WriteLine("Credenciales Correctas");
            }
            else {
                Console.WriteLine("Credenciales incorrectas");
            }


            //Funcion numero 2 de procesar el pago
            if (servicioC.ProcesarPago(5000, 50) != -1)
            {
                Console.WriteLine("Pago exitosamente realizado!!");
                Console.WriteLine("Su vuelto es: " + servicioC.ProcesarPago(5000, 50));
            }
            else
            {
                Console.WriteLine("Saldo insuficiente");
            }
        }
    }
}
