import java.util.*;
import java.io.*;
public class WordsCounter
{
	public static void main(String[] args) throws Exception {
		System.out.print("Ingrese oracion: ");
		Scanner sc = new Scanner(System.in);
		int aux = 0;
		int palabras =1;
		boolean bol = false;
		String str = sc.nextLine();
		for (char ch: str.toCharArray()) 
		{ 
			str = Character.toString(ch);

			if (!str.isEmpty()) 
			{	
				str = str.toLowerCase();
				if(str.contains("a")){aux++;}
				if(str.contains("e")){aux++;}
				if(str.contains("i")){aux++;}
				if(str.contains("o")){aux++;}
				if(str.contains("u")){aux++;}
				if(str.contains(" ")){palabras++;}
				
				bol = true;
			}
			else
			{
				bol=false;
				
			}
		}
			
		
		if (bol==true)
		{
			System.out.println();
		System.out.println("Cantidad de Palabras: " + palabras);
		System.out.println("Cantidad de Vocales: " + aux);
			
		}
		else{System.out.println("String vacio");}
	}
}