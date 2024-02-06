public class TestDinero {

	public static void main(String[] args) {
		Dinero d1 = new Dinero(1.25);
		Dinero d2 = new Dinero(1.38);
		System.out.println("------------------------------------");
		System.out.println("  TEST DINERO: ");
		System.out.println("------------------------------------\n");
		System.out.println("PROBANDO LA SUMA: \nLa cantidad tiene que ir cambiando correctamente");
		System.out.println("conforme se vaya sumando uno.\n");
		System.out.println("Cantidad inicial: " + d1.toString());
		for (int i=0; i<=7; i+=1) {
			d1.increase();
			System.out.println("+1 : " + d1.toString());
		}
		System.out.println("\n------------------------------------\n");
		System.out.println("PROBANDO LA RESTA: \nLa cantidad tiene que ir cambiando correctamente");
		System.out.println("conforme se vaya restando uno.\n");
		System.out.println("Cantidad Inicial: " + d2.toString());
		for (int i=0; i<=7; i+=1) {
			d2.decrease();
			System.out.println("-1 : " + d2.toString());
		}
		System.out.println("\n------------------------------------\n");
		System.out.println("PROBANDO LA SUMA Y MULTIPLICACION:");
		d1 = new Dinero(1.25);
		d2 = new Dinero(1.38);
		Dinero cero = new Dinero(0.0);
		Dinero suma = cero.add(d1);
		System.out.println("Suma 0.0 + 1.25: " + suma.toString());
		suma = d1.add(d2);
		System.out.println("Suma 1.25 + 1.38: " + suma.toString());
		Dinero multi = d1.multiply(d2);
		System.out.println("Multiplicacion 0.0 * 1.25: " + multi.toString());
		multi = d1.multiply(d2);
		System.out.println("Multiplicacion 1.25 * 1.38: " + multi.toString());
		System.out.println("\n------------------------------------\n");
		System.out.println("PROBANDO IS ZERO?:");
		System.out.println("0.0 is zero? " + cero.isZero());
		System.out.println("1.25 is zero? " + d1.isZero());
		System.out.println("1.38 is zero? " + d2.isZero());
	}
}