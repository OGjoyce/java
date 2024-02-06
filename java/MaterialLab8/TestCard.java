/* CC2-2018 - Lab8 */

import java.util.*;

public class TestCard {

	public static void printArray(Card[] arr) {
		System.out.println("Cartas: " + Arrays.toString(arr));
	}

	public static void main(String[] args) {
		Card[] cartas = new Card[10];
		Random r = new Random();
		for (int i=0; i<cartas.length; i+=1) {
			byte s = (byte)(r.nextInt(4) + 1);
			byte n = (byte)(r.nextInt(12) + 1);
			cartas[i] = new Card(n,s);
		}
		System.out.println("------------------------------");
		System.out.println("Arreglo de cartas construido: ");
		printArray(cartas);
		System.out.println("Ordenando ascendentemente: ");
		Algorithms.bubbleSortAsc(cartas);
		printArray(cartas);
		cartas = new Card[10];
		for (int i=0; i<cartas.length; i+=1) {
			byte s = (byte)(r.nextInt(4) + 1);
			byte n = (byte)(r.nextInt(12) + 1);
			cartas[i] = new Card(n,s);
		}
		System.out.println("------------------------------");
		System.out.println("Arreglo de cartas construido: ");
		printArray(cartas);
		System.out.println("Ordenando descendentemente: ");
		Algorithms.bubbleSortDesc(cartas);
		printArray(cartas);
	}
}