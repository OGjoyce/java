import java.util.*;
import java.io.*;

public class MarketQueue
{
	private int correlativo = 0;
	private int capacidad = 0;
	public static int cantidad_colas = 0;
	public static int mayor = 0;
	public static MarketQueue cola;
	public int getQueueNumber()
	{
		return this.correlativo;
	}
	public int getCapacity()
	{
		return this.capacidad;
	}
	public MarketQueue(int capacidad)
	{
		this.capacidad = capacidad;
		this.correlativo = MarketQueue.cantidad_colas + 1;
		MarketQueue.cantidad_colas = MarketQueue.cantidad_colas + 1;
		if(capacidad > MarketQueue.mayor)
		{
			MarketQueue.mayor = capacidad;
			MarketQueue.cola = this;
		}

	}
	public static int getNumberOfQueues()
	{
		return MarketQueue.cola.cantidad_colas;
	}

	public static MarketQueue getMaxCapacityQueue()
	{
		return MarketQueue.cola;
	}
	public String toString()
	{
		String s = "Correlativo: "+  Integer.toString(this.correlativo) + " Capacidad: " + Integer.toString(this.capacidad);
		return s;
	}

}