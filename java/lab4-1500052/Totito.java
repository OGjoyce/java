import java.util.*;
import java.io.*;

public class Totito
{
	public String player1 = "";
	public String player2 = "";
	public String[] totito = new String[9];
	public int turno = 0;
	public String pj1 = "";
	public String pj2 = "";
	public String toString()
	{
		String s = "";
		for (int i = 0;i<this.totito.length ;i++ ) 
		{
			if(i<3)
			{
				if(this.totito[i] == null)
				{
					s = s.concat(Integer.toString(i+1));
				}
				else{s = s.concat(this.totito[i]);}

			
			if(i<2)
			{
				s = s.concat(" | ");
			}
			}
			
			if (i<6 && i >= 3) 
			{
				if(i==3)
				{
					s = s.concat("\n");
					s = s.concat("--+---+---");
					s = s.concat("\n");
					
				if(this.totito[i] == null)
				{
					s = s.concat(Integer.toString(i+1));
				}
				else{s = s.concat(this.totito[i]);}
				}
				if (i==4) 
				{
					s = s.concat(" | ");
					
				if(this.totito[i] == null)
				{
					s = s.concat(Integer.toString(i+1));
				}
				else{s = s.concat(this.totito[i]);}
					s = s.concat(" | ");	
				}
				if (i==5) 
				{
					
				if(this.totito[i] == null)
				{
					s = s.concat(Integer.toString(i+1));
				}
				else{s = s.concat(this.totito[i]);}		
				}	
			}
			if (i>=6) 
			{
				
				if(i==6)
				{
					s = s.concat("\n");
					s = s.concat("--+---+---");
					s = s.concat("\n");
					
				if(this.totito[i] == null)
				{
					s = s.concat(Integer.toString(i+1));
				}
				else{s = s.concat(this.totito[i]);}
				}
				if (i==7) 
				{
					s = s.concat(" | ");
					
				if(this.totito[i] == null)
				{
					s = s.concat(Integer.toString(i+1));
				}
				else{s = s.concat(this.totito[i]);}
					s = s.concat(" | ");	
				}
				if (i==8) 
				{
					
				if(this.totito[i] == null)
				{
					s = s.concat(Integer.toString(i+1));
				}
				else{s = s.concat(this.totito[i]);}		
				}	
			}
		}
		return s;
	}
	public void add(int jugador, int casilla)
	{
		int c = casilla-1;
		if (jugador == 1) 
		{
			this.totito[c] = "X"; 
		}
		if (jugador == 2) 
		{
			this.totito[c] = "O"; 
		}
	}
	public boolean won(int tirador)
	{
		boolean p1 = false;
		boolean p2 = false;
		boolean ganador = false;
		for (int i = 0; i<this.totito.length ;i++ ) 
		{
			if (i<3) 
			{
				if (this.totito[i]!= null && this.totito[i] == this.totito[0] && this.totito[i] == this.totito[1] && this.totito[i] == this.totito[2]) 
				{
					if(tirador == 1)
					{
						p1 = true;

					}
					if(tirador == 2)
					{
						p2 = true;
					}
				}	
			}
			if (i>=3 && i <6) 
			{
				if (this.totito[i]!= null && this.totito[i] == this.totito[3] && this.totito[i] == this.totito[4] && this.totito[i] == this.totito[5]) 
				{
					if(tirador == 1)
					{
						p1 = true;

					}
					if(tirador == 2)
					{
						p2 = true;
					}
				}	
			}	
			if (i>=6 && i <9) 
			{
				if (this.totito[i]!= null && this.totito[i] == this.totito[6] && this.totito[i] == this.totito[7] && this.totito[i] == this.totito[8]) 
				{
					if(tirador == 1)
					{
						p1 = true;

					}
					if(tirador == 2)
					{
						p2 = true;
					}
				}	
			}
			if(i==0 || i == 3 || i ==6){
				if(this.totito[i]!= null && this.totito[0] ==this.totito[3] && this.totito[i] == this.totito[6])
				{
					if (tirador ==1) {
						p1 = true;
						
					}
					if(tirador==2)
					{
						p2 = true;
					}
				}
			}
			if(i==1 || i == 4 || i ==7){
				if(this.totito[i]!= null && this.totito[1] ==this.totito[4] && this.totito[i] == this.totito[7])
				{
					if (tirador ==1) {
						p1 = true;
						
					}
					if(tirador==2)
					{
						p2 = true;
					}
				}
			}
			if(i==2 || i == 5 || i ==8){
				if(this.totito[i]!= null && this.totito[2] ==this.totito[5] && this.totito[i] == this.totito[8])
				{
					if (tirador ==1) {
						p1 = true;
						
					}
					if(tirador==2)
					{
						p2 = true;
					}
				}
			}
			if(i==0 || i == 4 || i ==8){
				if(this.totito[i]!= null && this.totito[0] ==this.totito[4] && this.totito[i] == this.totito[8])
				{
					if (tirador ==1) {
						p1 = true;
						
					}
					if(tirador==2)
					{
						p2 = true;
					}
				}
			}
			if(i==6 || i == 4 || i ==2){
				if(this.totito[i]!= null && this.totito[6] ==this.totito[4] && this.totito[i] == this.totito[2])
				{
					if (tirador ==1) {
						p1 = true;
						
					}
					if(tirador==2)
					{
						p2 = true;
					}
				}
			}
			
		}
		if (p1) 
		{
			ganador = p1;	
		}
		if(p2){
			ganador = p2;
		}
		return ganador;

	}
	public boolean isfull()
	{
		boolean full = false;
		for (int i = 0;i < this.totito.length ;i++ ) 
		{
			if(this.totito[i] != null)
			{
				full = true;
			}
			else{
				full = false;
			}	
		}
		return full;
	}
	public static void main(String[] args) 
	{
	System.out.print("Player 1: ");
	Scanner sc = new Scanner(System.in);
	String username = sc.nextLine();
	System.out.print("player 2: ");
	Scanner scanner = new Scanner(System.in);
	String username1 = scanner.nextLine();
	Totito tot = new Totito();
	Random rand = new Random();
	int randomNum = rand.nextInt((1 - 0) + 1) + 0;
	System.out.println(tot.toString());
	if (randomNum==0) 
	{
		tot.player1 = "X";
		tot.player2 = "O";
		tot.pj1 = username;
		tot.pj2 = username1;
		tot.turno = 1;
	}
	else
	{
		tot.player2 = "X";
		tot.player1 = "O";
		tot.pj1 = username1;
		tot.pj2 = username;
		tot.turno = 1;
	}

	boolean ciclo = true;
	while(ciclo)
	{
		if (tot.turno == 1) 
		{
			System.out.println("Turno de: "+ tot.pj1 );
			Scanner turno1 = new Scanner(System.in);
			int casilla = sc.nextInt();
			tot.add(tot.turno, casilla);
			System.out.println(tot.toString());
			
			if(tot.won(tot.turno))
			{
			System.out.println( tot.pj1+" " + " gana");
			break;
			}
		
			tot.turno++;
		}
		if(tot.turno ==2)
		{
			System.out.println("Turno de: "+ tot.pj2 );
			Scanner turno2 = new Scanner(System.in);
			int casilla2 = sc.nextInt();
			tot.add(tot.turno, casilla2);
			System.out.println(tot.toString());
			
			if (tot.won(tot.turno)) 
			{
			System.out.println( tot.pj2+" " + " gana");
			break;
			}
		
			tot.turno--;
		}
		if(tot.isfull())
		{
			System.out.println("Tablero lleno");
			break;
		}
	}
	}

}