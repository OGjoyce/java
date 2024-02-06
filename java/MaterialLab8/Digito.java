/* CC2-2018 - lab8 */

public class Digito extends Numero {

	protected byte valor;

	public Digito(byte x) {
		this.valor = (byte)(x % 10);
	}

	/*
		Escriba su codigo aqui
	*/
	public boolean isZero(){
		Byte b = new Byte(this.valor);
		int compare = b.intValue();
		boolean x = false;
		if (compare == 0) 
		{
			x = true;
		}
		else{
			x = false;
		}
		return x;
	}
	public String toString()
	{
		Byte b = new Byte(this.valor);
		int intval = b.intValue();
		String s = Integer.toString(intval);
		return s;
	}
	public Digito add(Numero n)
	{
		String h = n.toString();
		int foo = Integer.parseInt(h);
		Byte b = new Byte(this.valor);
		int intval = b.intValue();
		int valor = foo + intval;
		Digito d = new Digito((byte)valor);
		return d;

	}
	public Digito extract(Numero n)
	{
		String h = n.toString();
		int foo = Integer.parseInt(h);
		Byte b = new Byte(this.valor);
		int intval = b.intValue();
		int valor = foo - intval;
		Digito d = new Digito((byte)valor);
		return d;

	}
	public Digito multiply(Numero n)
	{
		String h = n.toString(); //convertimos a string el numero n
		int foo = Integer.parseInt(h); //parseamos a int el numero n
		Byte b = new Byte(this.valor); // creamos un nuevo byte
		int intval = b.intValue(); //obtenemos el vaalor entero del byte
		int valor = foo * intval; // hacemos la operacion
		Digito d = new Digito((byte)valor); //convertimos a objetoo tipo digito
		return d;
	}
	public void increase()
	{
		
		this.valor = (byte) (this.valor + 1);
	}
	public void decrease()
	{
		
		this.valor = (byte) (this.valor - 1);
	}


	
}