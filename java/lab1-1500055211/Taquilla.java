/* Ejercicio #3 - Lab #1 */

/**
	NOTA: No modificar el codigo que ya contiene este ejercicio
**/

import java.io.*;
import java.util.*;

public class Taquilla {
	public static void main(String[] args) throws Exception {

		System.out.println("\n Lab #1 - Ejercicio #3");
		System.out.println("-----------------------\n");
		System.out.print("Ingrese edad: ");
		Scanner sc = new Scanner(System.in);
		int edad = sc.nextInt();
		String precio = "";
		if (edad >= 0 && edad <=10) 
		{
			precio = "Q15.00";
		}
		if (edad >= 11 && edad <=18) 
		{
			precio = "Q20.00";
		}
		if (edad >= 19 && edad <=59) 
		{
			precio = "Q35.00";
		}
		if (edad >= 60) 
		{
			precio = "Q20.00";
		}
		/*
			Ingrese su codigo aca

		*/
		System.out.println();
		System.out.println("Precio: " + precio);


	}
}