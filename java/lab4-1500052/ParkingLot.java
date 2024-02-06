import java.util.*;
import java.io.*;
public class ParkingLot
{	
	public int[] parqueo;
	public ParkingLot(int total)
	{	
		int[] anArray = new int[total];
		this.parqueo = anArray;
	}
	public int size()
	{	
		return this.parqueo.length;
	}
	public int parkInRandomSpace()
	{	Random rand = new Random();
		int size = this.parqueo.length;
		int randomNum = rand.nextInt((size-1 - 0) + 1) + 0;
		int aux = 0;
		for (int i=0;i<size ;i++ ) 
		{
			if (i==randomNum) 
			{
				if(this.parqueo[i] == 0)
				{
					this.parqueo[i]=1;
					aux = i +1;	
					break;	
				}
				else
				{
					aux= -1;
					break;
				}
				
			}	
		}
		return aux;
	}
	public boolean parkInLot(int parking)
	{	
		if(parking<= this.parqueo.length)
		{
			parking = parking-1;
			if(this.parqueo[parking]==0)
			{
				this.parqueo[parking] = 1;
				return true;
			}
			else{ return false;}
		}
		else{return false;}
	}
	public void emptyLot(int parking)
	{
		if(this.parqueo[parking]!=0){this.parqueo[parking]=0;}
	}
	public boolean isFull()
	{
		boolean full = true;
		for (int i=0 ;i<this.parqueo.length ;i++ ) 
		{
			if (this.parqueo[i]==0) 
			{
			 full = false;
			 break;

			}
				
		}
		return full;
	}
	public boolean isEmpty()
	{	
		boolean f=true;
		for (int i =0;i<this.parqueo.length ;i++ ) 
		{
			if (this.parqueo[i]!=0) 
			{
				f = false;
				break;	
			}
		}
		return f;
	}
	public boolean isValidParking(int parking)
	{
		if(1 <= parking && parking <= this.parqueo.length){return true;}
		else{return false;}
	}
	public boolean isEmpty(int parking)
	{	parking = parking-1;
		if(this.parqueo[parking]==0){return true;}
		else{return false;}
	}
	public String toString()
	{	String s = "";
		for (int i = 0;i< this.parqueo.length ;i++ ) 
		{
			
			s = s.concat(" | ");
			if(this.parqueo[i]==0){s = s.concat(Integer.toString(i+1));}
			else{s = s.concat("X");}
			if (i+1 == this.parqueo.length) 
			{
				s = s.concat(" | ");	
			}
			
		}
		return s;
	}
}