/* Ejercicio #2 - Lab #1 */

/**
	NOTA: No modificar el codigo que ya contiene este ejercicio
**/

import java.io.*;
import java.util.*;
import java.io.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.String;

public class NewCitizen {
	public static void main(String[] args) throws Exception {

		System.out.println("\n Lab #1 - Ejercicio #2");
		System.out.println("-----------------------\n");

		/*
			INSERTE SU CODIGO ACA

		*/
			System.out.print("Ingrese Apellido de Padre: ");
		Scanner sc = new Scanner(System.in);
		String a1 = sc.nextLine();
		System.out.print("Ingrese Apellido de Madre: ");
		Scanner sc1 = new Scanner(System.in);
		String a2 = sc1.nextLine();
		System.out.print("Ingrese Primer Nombre: ");
		Scanner sc2 = new Scanner(System.in);
		String nm1 = sc2.nextLine();
		System.out.print("Ingrese Segundo Nombre: ");
		Scanner sc3 = new Scanner(System.in);
		String nm2 = sc3.nextLine();
		System.out.print("Ingresar fecha de nacimiento (dd-mm-aaa): ");
		String dateFormat = "dd-mm-aaaa";
    	Scanner scanner = new Scanner(System.in);
    	String fechaComoTexto = scanner.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-aaaa");
		System.out.println();
		System.out.print("Nombre: ");
			System.out.println(a1.concat(" ").concat(a2).concat(", ").concat(nm1).concat(" ").concat(nm2));
			System.out.print("Nacimiento: ");
			System.out.println(fechaComoTexto);
		 	System.out.print("Iniciales: ");
	   		String str = nm1.substring(0,1).concat(nm2.substring(0,1).concat(a1.substring(0,1).concat(a2.substring(0,1))));
	   		System.out.println(str);
	   		System.out.print("ID: ");
	   		System.out.println(str.concat("-").concat(fechaComoTexto.substring(6,10)));

		System.out.println();

	}
}