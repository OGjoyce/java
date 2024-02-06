/* CC2-2018 - lab8 */

public class Dinero extends Numero {

	protected double valor;

	public Dinero(double x) {
		this.valor = truncate(x);
	}

	private double truncate(double x) {
		double r = (double)Math.floor(x * 100.0) / 100.0;
		return r;
	}

	/* 
		Escriba aqui su codigo
	*/
		public boolean isZero(){
		Double d = new Double(this.valor);
		boolean x = false;
		if (d > 0 || d < 0) 
		{
			x = false;
		}
		else{
			x = true;
		}
		return x;
	}
	public String toString()
	{
		String total2 = String.valueOf(this.valor);
		return total2;
	}
	public Dinero add(Numero n)
	{
		String h = n.toString();
		double value = Double.parseDouble(h);
		double d = new Double(this.valor);
		double resultado = this.valor + value;
		Dinero obj_dinero = new Dinero(resultado);
		return obj_dinero;

	}
	public Dinero extract(Numero n)
	{
		String h = n.toString();
		double value = Double.parseDouble(h);
		double d = new Double(this.valor);
		double resultado = this.valor - value;
		Dinero obj_dinero = new Dinero(resultado);
		return obj_dinero;

	}
	public Dinero multiply(Numero n)
	{
		String h = n.toString();
		double value = Double.parseDouble(h);
		double d = new Double(this.valor);
		double resultado = this.valor * value;
		Dinero obj_dinero = new Dinero(resultado);
		return obj_dinero;
	}
	public void increase()
	{
		
		this.valor = (double) (this.valor + 0.01d);
	}
	public void decrease()
	{
		
		this.valor = (double) (this.valor - 0.01d);
	}

}