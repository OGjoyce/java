import java.util.*;
import java.io.*;

public class PhoneContact
{
	private String apellido;
	private String nombre;
	private String telefono;
	private boolean favorito;
	public PhoneContact(String apellido, String nombre, String telefono)
	{
		this.apellido = apellido;
		this.nombre = nombre;
		this.telefono = telefono;
		this.favorito = false;
	}
	public String getLastName()
	{
		return this.apellido;
	}	
	public String getFirstName()
	{
		return this.nombre;
	}
	public String getPhoneNumber()
	{
		return this.telefono;
	}
	public boolean isFavorite()
	{
		return this.favorito;
	}
	public void setAsFavorite()
	{
		this.favorito = true;
	}
	public boolean equals(PhoneContact objeto)
	{
		if(this.telefono.equals(objeto.telefono)){return true;}
		else {return false;}
	}
	public String toString()
	{	
		if(this.favorito)
		{
			return (this.telefono +" - " + this.apellido+", "+this.nombre+" **");
		}
		else
		{
			return (this.telefono +" - " + this.apellido+", "+this.nombre);
		}
		
	}
}