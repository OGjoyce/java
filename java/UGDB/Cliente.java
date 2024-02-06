import java.net.*;
import java.io.*;
import java.util.*;
public class Cliente {
	

	public static void main (String[] args) {
		boolean shot =true;
		if (args.length != 1) {
			System.out.println("Uso: java Cliente numeroDePuerto");
			System.exit(1);
		}

		int puerto = Integer.parseInt(args[0]);
		String direccion = "localhost";
		ipsDB obj = new ipsDB();
		

		try {
			// El intento de conexion solo funcionara si el servidor ya esta funcionando
			Socket socket = new Socket(direccion, puerto);

			// Se abren los canales de comunicacion
			// Usar PrintWriter y BufferedReader para evitar tener problemas al comunicarse con otros grupos!
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader intr = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String saliente = "";
			String entrante = "";
			//COMUNICACION

			while(shot){

			saliente = "LOGIN Carlos 12345";
			out.println(saliente);
			entrante = intr.readLine();
			System.out.println(entrante);
			saliente = "CLIST Carlos";
			out.println(saliente);
			entrante = intr.readLine();
			System.out.println(entrante);
			saliente = "GETNEWMAILS Carlos";
			out.println(saliente);
			entrante = intr.readLine();
			System.out.println(entrante);
			saliente = "SEND MAIL";
			out.println(saliente);
			entrante = intr.readLine();
			System.out.println(entrante);
			saliente = "MAIL TO Carlos";
			out.println(saliente);
			entrante = intr.readLine();
			System.out.println(entrante);
			saliente = "MAIL SUBJECT 'Prueba'";
			out.println(saliente);
			entrante = intr.readLine();
			System.out.println(entrante);
			saliente = "MAIL BODY 'PRUEBABODYadsfasdf'";
			out.println(saliente);
			entrante = intr.readLine();
			System.out.println(entrante);
			saliente = "END SEND MAIL";
			out.println(saliente);
			entrante = intr.readLine();
			System.out.println(entrante);
			saliente = "NEWCONT Invoker";
			out.println(saliente);
			entrante = intr.readLine();
			System.out.println(entrante);
			saliente = "LOGOUT";
			out.println(saliente);
			entrante = intr.readLine();
			System.out.println(entrante);
			saliente = "NOOP";
			out.println(saliente);
			entrante = intr.readLine();
			System.out.println(entrante);
			saliente = "Adios";
			out.println(saliente);
			entrante = intr.readLine();
			System.out.println(entrante);
			}

			

		


		} catch (Exception e) {
			System.out.println("Ocurrio un problema!");
		}
			
			}
		public static void mostrar(){
			System.out.println("*****Lista de comandos*****");
			System.out.println("LOGIN [user] [password]");
			System.out.println("CLIST [user]");

		}	
}