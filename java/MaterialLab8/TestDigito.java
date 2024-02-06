public class TestDigito {

	public static void main(String[] args) {
		System.out.println("------------------------------------");
		System.out.println("  TEST DIGITO: ");
		System.out.println("------------------------------------\n");
		System.out.println("PROBANDO LA SUMA: \nEl digito tiene que ir cambiando correctamente");
		System.out.println("conforme se vaya sumando uno.\n");
		Digito d1 = new Digito((byte)5);
		Digito d2 = new Digito((byte)5);
		System.out.println("Digito inicial: " + d1.toString());
		for (int i=0; i<=7; i+=1) {
			d1.increase();
			System.out.println("+1 : " + d1.toString());
		}
		System.out.println("\n------------------------------------\n");
		System.out.println("PROBANDO LA RESTA: \nEl digito tiene que ir cambiando correctamente");
		System.out.println("conforme se vaya restando uno.\n");
		System.out.println("Digito inicial: " + d2.toString());
		for (int i=0; i<=7; i+=1) {
			d2.decrease();
			System.out.println("-1 : " + d2.toString());
		}
		System.out.println("\n------------------------------------\n");
		System.out.println("PROBANDO LA SUMA Y MULTIPLICACION:");
		Digito cero = new Digito ((byte)0);
		Digito cinco = new Digito ((byte)5);
		Digito siete = new Digito ((byte)7);
		Digito suma = cero.add(cinco);
		System.out.println("Suma de 0 + 5: " + suma.toString());
		suma = cinco.add(siete);
		System.out.println("Suma de 5 + 7: " + suma.toString());
		Digito multi = cero.multiply(cinco);
		System.out.println("Multiplicacion de 0 * 5: " + multi.toString());
		multi = cinco.multiply(siete);
		System.out.println("Multiplicacion de 5 * 7: " + multi.toString());
		System.out.println("\n------------------------------------\n");
		System.out.println("PROBANDO IS ZERO?:");
		System.out.println("0 is zero? " + cero.isZero());
		System.out.println("5 is zero? " + cinco.isZero());
		System.out.println("7 is zero? " + siete.isZero());
	}
}