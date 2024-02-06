import java.util.*;
import java.io.*;
import java.lang.Math;

public class ExtendedIntArray
{
	private int [] arr;
	private int global_data = 0;

	public ExtendedIntArray()
	{
		this.arr = new int[15];
	}
	public ExtendedIntArray(int capacity)
	{
		this.arr = new int[capacity];
	}	
	public int size()
	{ int size=0;
		for (int i =0, h=0; i < this.arr.length ;i++ ) 
		{
			if (this.arr[i]!=0) 
			{
					h++;
					size=h;

			}	
		}
		return size;
	}
	public int capacity()
	{
		return this.arr.length;
	}

	public void add(int dato)
	{
		if (global_data != this.arr.length) 
		{
			this.arr[global_data] = dato;	
		}
		else
		{
			int oldItems[] = new int[(int)(this.arr.length * 1.5)];
			for (int i=0; i<this.arr.length; i++) 
			{
			  oldItems[i] = this.arr[i];
			}
			this.arr = oldItems;
			add(dato);	
		}
		global_data++;
	}
	public Integer remove()
	{

		boolean a = false;
		int removed = this.arr[0];
		int count =1 ;
	for (int i = 0, j = 1, counter = 1; i < this.arr.length ;i++ ) 
	{
	
		if (this.arr[i] == 0 ) 
		{
			counter++;
			count = counter;
		}
		if(j<this.arr.length){
		this.arr[i] = this.arr[j];
		j++;
	}
	}
	if (count == this.arr.length ) {
		if (this.arr[0]==0) {
			return null;
			
		}file:///C:/Users/cmont/Downloads/ExtendedIntArray.java
		else{return this.arr[0];}
	
	}
	else{
	return removed;
}
	}
	public String toString()
	{
		String s = "[";
		for (int i = 0; i< this.arr.length ; i++ ) 
		{
			if (this.arr[i]!=0) 
			{
				s = s + " "+ this.arr[i] + " ";
			}	
		}
		s = s + "]";
		return s;
	}


}