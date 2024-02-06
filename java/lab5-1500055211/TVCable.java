import java.util.*;
import java.io.*;
public class TVCable
{
	int cantidad;
	String[] canales;
	int vivo;
	String viendo;
	public TVCable(String[] s)
	{
		this.cantidad = s.length;
		this.canales = s;
		
	}
	public TVCable(int n)
	{
		this.cantidad = n;
		String[] arr = new String[n];
		this.canales = arr;
	}

	public int getCapacidad()
	{
		return this.canales.length;
	}
	public String getCanal(int n)
	{
		String canal = "";
		if (n < getCapacidad()) 
		{
			
			canal = this.canales[n];
		}
		return canal;
	}

	public void setCanal(int n, String c)
	{
		if(n<this.canales.length){
				this.canales[n] = c;
			
		}
	}
	public String toString()
	{
		String s = "Canales ";
		for (int i = 0; i<this.canales.length ;i++ ) 
		{
			s = s +"[";
			int x = i;
			x = x +1;
			s = s + Integer.toString(x);
			if(this.canales[i]!=null)
			{
			s = s + " | "+ this.canales[i];
			}
			else{
				s = s + " | "+ "N/A";
			}
			s = s + "] ";	
		}
		return s;
	}
	public boolean equals(TVCable c)
	{
		boolean t = true;
		if (this.canales.length == c.canales.length) 
		{
			for (int i = 0;i<c.canales.length ;i++ ) 
			{
				if (this.canales[i]!=null) 
				{
					
				
				if (this.canales[i].equals(c.canales[i])) 
				{
					t = true;
				}
				else{ t = false; break;}
				}
				else{ t = false; break;}
			}
		}
		else{ t = false; }
		return t;
	}
}