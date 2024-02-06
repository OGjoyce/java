/* CC2 - 2018 - PJ1 */

public class JPEGHandler {

	public static void runHandler(ImageHandler imgh) throws Exception {
		/** NO CAMBIE ESTE CODIGO **/
		System.out.println("--------------------------------------");
		System.out.println(imgh.getClass().getTypeName().toUpperCase() + ": ");
		System.out.println("\nLeyendo imagen : " + imgh.getFileName());
		imgh.readFile();
		System.out.println("Proceso de lectura de imagen terminado!");
		System.out.println("\nGenerando imagenes : ");
		imgh.generateFiles();
		System.out.println("Proceso de generacion de archivos terminado!");
		System.out.println("\n--------------------------------------");
		/** --------------------- **/
	}


	public static void main(String[] args) throws Exception {
		String runoption = args[0];
		String filename = args[1];
		switch(runoption) {
			case "-copy": {
				BmpHandlerCopy bhc = new BmpHandlerCopy(filename);
				runHandler(bhc);
				break;
			}
			case "-tobmp": {

				JPEGtoBMPImage bmp = new JPEGtoBMPImage(filename);
				break;
			}
			case "-tojpeg": {

				BMPtoJPEGImage jpg = new BMPtoJPEGImage(filename);
				break;
			}
			case "-colors": {

				JPEGImageHandlerColors colors = new JPEGImageHandlerColors(filename);

				break;
			}
			case "-rotate": {
				JPEGImageHandlerRotator rotations = new JPEGImageHandlerRotator(filename);
				

				break;
			}
			case "-all": {
				JPEGImageHandlerRotator rotations = new JPEGImageHandlerRotator(filename);
				JPEGImageHandlerColors colors = new JPEGImageHandlerColors(filename);
				break;
			}
			case "-help": {
				System.out.println("*************************");
				System.out.println("* Command List:          *");
				System.out.println("* -tobmp                 *");
				System.out.println("* -tojpeg                *");
				System.out.println("* -colors                *");
				System.out.println("* -rotate                *");
				System.out.println("* -all                   *");
				System.out.println("* -copy                  *");
				System.out.println("*i.e:  > java JPEGHandler -rotate imagexample.jpeg*");
				System.out.print("*************************");


				break;
			}	
			default: {
				System.out.println("Opcion de ejecucion invalida");
			}
		}
	}
}