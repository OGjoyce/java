import java.util.*;
import java.io.*;

public class TarjetaCredito
{
	public String numero;
	public String nombre;
	public double limite;
	public double interes;
	public double saldo;

	public TarjetaCredito(String n, String name, double lim, double interes)
	{
		if (n.matches("[0-9]{4}[-][0-9]{4}[-][0-9]{4}[-][0-9]{4}")) 
		{
			this.numero = n;
			this.nombre = name;
			this.limite = lim;
			this.interes = interes;
			this.saldo = 0.00d;	
		}
		else
		{
			this.numero = numberGenerator();
		}
		

	}
	public String numberGenerator()
	{
		int elbow = (int)(Math.random() * 9999 + 1000);
		int hand = (int)(Math.random() * 9999 + 1000);
		int finger = (int)(Math.random() * 9999 + 1000);
		int shoulder = (int)(Math.random() * 9999 + 1000);

		return Integer.toString(elbow).concat("-").concat(Integer.toString(hand).concat("-").concat(Integer.toString(finger).concat("-").concat(Integer.toString(shoulder))));
	}
	public double getLimiteCredito()
	{
		return this.limite;
	}
	public String getNombre()
	{
		return this.nombre;
	}
	public double getTasaInteres()
	{
		return this.interes;
	}
	public String getNumero()
	{
		return this.numero;
	}
	public double getSaldoActual()
	{
		return this.saldo;
	}
	public double getSaldoDisponible()
	{
		return this.limite - this.saldo;
	}
	public boolean comprar(double monto)
	{
		if (getSaldoDisponible()>monto) 
		{
			this.saldo = this.saldo + monto;
			return true;
		}
		else{return false;}
	}
	public boolean pagar(double monto)
	{
		if (monto>=getSaldoActual()) 
		{
			this.saldo = this.saldo-monto;
			return true;	
		}
		else{ return false;}
	}
	public void corte()
	{
		this.saldo = (this.saldo * this.interes) + this.saldo;
	}
	public String toString()
	{
		String saldo_actual = Double.toString(getSaldoActual());
		String saldo_disponible = Double.toString(getSaldoDisponible());
		String limite_credito = Double.toString(getLimiteCredito());
		String tasa_de_interes = Double.toString(getTasaInteres());
		return this.numero+", "+this.nombre+", "+saldo_actual+", "+saldo_disponible+", "+limite_credito+", "+tasa_de_interes;
	}

}