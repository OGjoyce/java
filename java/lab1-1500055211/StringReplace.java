/* Ejercicio #1 - Lab #1 */

/**
	NOTA: No modificar el codigo que ya contiene este ejercicio
**/

import java.io.*;
import java.util.*;

public class StringReplace {
	public static void main(String[] args) throws Exception {

		System.out.println("\n Lab #1 - Ejercicio #1");
		System.out.println("-----------------------\n");
		System.out.print("Ingrese String: ");

		/* Escriba su codigo aca para leer el String del usuario */
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.toLowerCase();
		str = str.replace('A', 'a');
		str = str.replace('a', '*');
		

		System.out.print("\nResultado: ");

		/* Escriba su codigo aca para desplegar el resultado de reemplazo 
		   Recuerde de usar println y no print */
		   System.out.print(str);
		System.out.println();

	}
}