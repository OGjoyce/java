import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Impuesto
{

	public static void main(String[] args) 
	{
		System.out.print("Ingrese Numero de Placa: ");
		Scanner sc_placa = new Scanner(System.in);
		String str_placa = sc_placa.nextLine();
		System.out.println();
		System.out.print("Ingrese NIT: ");
		Scanner sc_nit = new Scanner(System.in);
		String str_nit = sc_nit.nextLine();
		System.out.println();
		System.out.print("Resultado: ");
		boolean matcher_placas = Pattern.matches("[A-Z&&[^AEIOU]]{3}[0-9]{3}", str_placa);
		boolean matcher_nit = Pattern.matches("[0-9]{1}[0-9]{4,7}[-]([0-9]|[K])",str_nit);
		if (matcher_placas == true && matcher_nit == true){System.out.print("NIT y PLACAS validos");}
		if (matcher_placas == false && matcher_nit == true){System.out.print("NIT valido y PLACA invalida");}
		if (matcher_placas == true && matcher_nit == false){System.out.print("NIT invalido y PLACA valida");}
		if (matcher_placas == false && matcher_nit == false){System.out.print("NIT y PLACA no validos");}

	}
}