
public class Card{
	byte carta;
	byte n_carta;
	public Card(byte n, byte s){
		this.n_carta = n;
		if ((byte)1 <= n && n <= (byte)12 ) 
		{
			this.carta = s;
		}
	}
	public char getNumero()
	{	char c = '4';
		if (this.n_carta>=(byte)10) 
		{
				if (this.n_carta == (byte)10) 
				{
					c = 'J';
				}
				if (this.n_carta == (byte)11) {
					c = 'Q';
					
				}
				if (this.n_carta == (byte)12) {
					c = 'K';
					
				}
		}
		if (this.n_carta==(byte)1) 
		{
			c = 'A';	
		}
		if (this.n_carta==(byte)2) 
		{
			c = '2';	
		}
		if (this.n_carta==(byte)3) 
		{
			c = '3';	
		}
		if (this.n_carta==(byte)4) 
		{
			c = '4';	
		}
		if (this.n_carta==(byte)5) 
		{
			c = '5';	
		}
		if (this.n_carta==(byte)6) 
		{
			c = '6';	
		}
		if (this.n_carta==(byte)7) 
		{
			c = '7';	
		}
		if (this.n_carta==(byte)8) 
		{
			c = '8';	
		}
		if (this.n_carta==(byte)9) 
		{
			c = '9';	
		}
		return c;
	}
	public String getSimbolo(){
		if (this.carta == 1) 
		{
			return "spades";	
		}
		if (this.carta == 2) {
			return "hearts";
		}
		if (this.carta == 3) {
			return "diamonds";
		}
		else{
			return "clubs";
		}
	}
	public String toString(){
		return getNumero()+ " : "+ getSimbolo(); 
	}

}