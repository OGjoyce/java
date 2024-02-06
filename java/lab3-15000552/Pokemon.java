import java.util.*;
import java.io.*;
public class Pokemon
{
	public String nombre;
	public String tipo;
	public int combat_power;
	public Pokemon(String name, String tipo)
	{
		this.nombre = name;
		this.tipo = tipo;
		this.combat_power = (int)(Math.random() * 1500  + 10);
	}
	public String getName()
	{
		return this.nombre;
	}
	public String getType()
	{
		return this.tipo;
	}
	public int getCombatPower()
	{
		return this.combat_power;
	}
	public String toString()
	{
		return this.nombre;
	}
	public void powerUp(int candy)
	{
		if (this.combat_power < 500) 
		{
			this.combat_power = this.combat_power + (candy * 10);	
		}
		else if (this.combat_power >= 500 && this.combat_power<= 1000) 
		{
			this.combat_power = this.combat_power + (candy * 12);	
		}
		else if(this.combat_power > 1000)
		{
			this.combat_power = this.combat_power + (candy * 14);
		}
	}
}