/** CC2 - 2018
    Ejercicio #1 - Lab #5  **/

import java.io.*;
import java.util.*;

public class ValidDate {

	/*** ESTE ES EL METODO QUE TIENE QUE IMPLEMENTAR ***/
	public static boolean isValidDate(String date) 
	{
		boolean bol = false;
		String date_expr = "[0-3][0-9]/[0-1][0-9]/[0-9]{4}";
		String dia =  date.substring(0,2);
		String mes = date.substring(3,5);
			int result = Integer.parseInt(mes);
			int dias = Integer.parseInt(dia);
		if(date.matches(date_expr))
		{

			if (result == 2) 
			{
				
				if (dias <= 28) 
				{
						bol = true;
					}	
			}
			if (result == 1 || result == 3 || result == 5 || result == 7 || result == 8 || result == 10 || result == 12) 
			{
				if (dias <=31) 
				{
					bol = true;	
				}
			}
			if (result == 4 || result == 6 || result == 9 || result == 11) 
			{
				if (dias<=30) {
						bol = true;
					}	
			}


		}
		return bol;
		 
	}


	/*** Para probar que su metodo funciona **/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Prueba de Valid Date: ");
		while(true) {
			System.out.println("Ingrese fecha a evaluar o solo presione enter para terminar: ");
			String fecha = br.readLine();
			if (fecha.length() == 0) {
				System.out.println("Saliendo...");
				return;
			} else {
				System.out.println("Fecha valida: " + isValidDate(fecha));
			}
		}
	}
}