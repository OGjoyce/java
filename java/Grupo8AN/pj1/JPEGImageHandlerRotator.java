import java.io.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class JPEGImageHandlerRotator extends ImageHandler{
		protected byte[] filebytes;
	/**
	*	File name that will be given to the copy of the original file
	**/
	public FileInputStream finput;
	protected String copyname;
	public String name;
	public FileOutputStream foutput;
	public BufferedImage bfi_glbl;


	public JPEGImageHandlerRotator(String imagename){
		super(imagename);
		this.name = imagename;
		try{
			readFile();
			make_Hrotation();
			generateFiles();
			make_Vrotation();
			generateFiles();
		   }
		catch(Exception e){
			System.out.println("Invalid name");

		}
	}
	public void make_Hrotation() throws Exception
	{
		this.copyname = "Hrotation-" + this.name;
		FileInputStream fi = new FileInputStream(this.name);
		BufferedImage img = ImageIO.read(new File(this.name));
		int[][] matriz1 = getPixeles(img);
		int[][] matriz2 = new int[matriz1.length][matriz1[0].length];
		for (int x = 0, i = matriz1[0].length-1 ; x<=matriz1[0].length-1 ;x++){
			for (int y = 0, y_i = matriz1.length-1 ; y<= matriz1.length-1 ;y++, y_i-- ) {
				//	System.out.println(y+", "+y_i);
				matriz2[y_i][x] = matriz1[y][x];
	
			}
		
		}
		 BufferedImage bufferImage2= getBufferedImage(matriz2);
		 int[][] matrix1 = getPixeles(bufferImage2);
		int[][] matrix2 = getPixeles(bufferImage2);

		/*lo rotamos nuevamente 90 grados a favor de las manecillas del reloj */

		 for (int j = matrix1.length-1, h = 0; j>=0 ;j--, h++ ) 
		{
		
				for (int i = 0, m=matrix1[0].length-1; i <= matrix1[0].length-1 ;i++, m-- ) 
			{
				matrix2[j][i] = matrix1[h][i]; 
		
			}
		}
		BufferedImage bufferImage2_new= getBufferedImage(matrix2);
		this.bfi_glbl = bufferImage2_new;
		 FileOutputStream imagen_Hrotation = new FileOutputStream("Hrotation-" + this.name);
		 this.foutput = new FileOutputStream("Hrotation-" + this.name);
		 
		

		  


	}
	public void make_Vrotation() throws Exception 
	{
		this.copyname = "Vrotation-" + this.name;
		FileInputStream fi2 = new FileInputStream(this.name);
		File filename2 = new File(this.name);
		BufferedImage img = ImageIO.read(filename2);
		int[][] matriz1 = getPixeles(img);
		int[][] matriz2 = getPixeles(img);
		
		/* Lo rotamos 90 grados a favor de las manecillas y despues una reflexion en el eje x */

		for (int x = 0, i = matriz1[0].length-1 ; x<=matriz1[0].length-1 ;x++, i-- ) 
		{	
			
					
			for (int y = 0 ; y<= matriz1.length-1 ;y++ ) {
				if (matriz2[y][i]==matriz1[y][x]) {
				matriz2[y][i] = matriz1[y][x];

						}		
			}
		
		}
		 BufferedImage bufferImage2= getBufferedImage(matriz2);
		 int[][] matrix1 = getPixeles(bufferImage2);
		int[][] matrix2 = getPixeles(bufferImage2);

		/*lo rotamos nuevamente 90 grados a favor de las manecillas del reloj */

		 for (int j = matrix1.length-1, h = 0; j>=0 ;j--, h++ ) 
		{
		
				for (int i = 0, m=matrix1[0].length-1; i <= matrix1[0].length-1 ;i++, m-- ) 
			{
				matrix2[j][i] = matrix1[h][i]; 
		
			}


	}
			BufferedImage bufferImage2_new= getBufferedImage(matrix2);
			this.bfi_glbl = bufferImage2_new;
			FileOutputStream imagen_Hrotation = new FileOutputStream("Vrotation-" + filename2);
		 	this.foutput = new FileOutputStream("Vrotation-" + this.name);
}


	public void readFile() throws Exception {
		FileInputStream input = new FileInputStream(this.handledFileName);
		this.finput = input;
		filebytes = new byte[input.available()];
		input.read(filebytes);
		input.close();
		System.out.println("Imagen leida: " + this.handledFileName);
	}
	/**
	*	Generates a copy file from the original file. The name of the generated
	* 	file will be build by the same name preceeded of "copy-"
	**/	
	public void generateFiles() throws Exception {
		ImageIO.write(this.bfi_glbl, "bmp", this.foutput);
		this.foutput.close();
		System.out.println("Imagen generada: " + copyname);
	}
	public int[][] getPixeles(BufferedImage image) { //de buffred a arreglo
      int width = image.getWidth();
      int height = image.getHeight();
      int[][] result = new int[height][width];

      for (int row = 0; row < height; row++) {
         for (int col = 0; col < width; col++) {
            result[row][col] = image.getRGB(col, row);
         }
      }

      return result;
   }
   public BufferedImage getBufferedImage(int[][] pixelarray){
   	BufferedImage imagen = new BufferedImage(pixelarray.length, pixelarray[0].length, 5 );
   	for (int i = 0; i <= pixelarray.length-1 ;i++ ) 
   	{
   		for (int j = 0;j <= pixelarray[0].length-1 ;j++ ) 
   		{
   				imagen.setRGB(i, j, pixelarray[i][j]);
   		}	
   	}
   	return imagen;
   }
}
	
