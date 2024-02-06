/* CC2-2018 - lab8 */

public class Algorithms {

	public static void bubbleSortAsc(Ordenable[] arr) {
		for (int i=0; i<(arr.length-1); i+=1) {
			for (int j=(i+1); j<arr.length; j+=1) {
				if (arr[j].menorQue(arr[i])) {
					Ordenable x = arr[i];
					arr[i] = arr[j];
					arr[j] = x;
				}
			}
		}
	}

	public static void bubbleSortDesc(Ordenable[] arr) {
		for (int i=0; i<(arr.length-1); i+=1) {
			for (int j=(i+1); j<arr.length; j+=1) {
				if (arr[j].mayorQue(arr[i])) {
					Ordenable x = arr[i];
					arr[i] = arr[j];
					arr[j] = x;
				}
			}
		}
	}
}