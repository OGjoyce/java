import java.util.*;
import java.io.*;

public class OddNumbers
{
	public static void main(String[] args) {
		System.out.print("Ingrese numero entero: ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int cont = 0;
		int aux = 0;
		System.out.println();
		if(number<=1){System.out.println("Numero ingresado no valido");}
		else
		{ 
			System.out.print("Numeros pares: ");
			for (int i = 0;i < number ; i++) 
			{
				int random = (int )(Math.random() * 100);
				if(random % 2 == 0){ System.out.print(random); System.out.print(" "); aux++;}
				cont = i;
			}
		System.out.println();
		System.out.print("Cantidad de numeros impares: "); System.out.print(cont - aux +1);
		}
	}
}