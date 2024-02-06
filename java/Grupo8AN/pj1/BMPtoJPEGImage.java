import java.io.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class BMPtoJPEGImage extends ImageHandler{
	protected byte[] filebytes;
	public FileInputStream finput;
	protected String copyname;
	public String name;
	public FileOutputStream foutput;
	public String formato;
	public String nombre;

	public BMPtoJPEGImage(String imagename){
		super(imagename);
		this.name = imagename;
		try{
		readFile();
		if (this.formato.equals("bmp") || this.formato.equals("BMP"))
		 {	
		 	generateFiles();
			}
	else
		{System.out.println("Ingrese un formato valido!!! ERR");}
	}
	catch(Exception e){
		System.out.println("Ingrese un formato valido!!! ERR");
	}
	}
	public void readFile(){
		int index_point = this.name.indexOf('.');
		String forma = this.name.substring(index_point+1, this.name.length());
		this.formato = forma;
		String nombre = this.name.substring(0, index_point);
		this.nombre = nombre;
	}
	public void generateFiles() throws Exception{
		this.nombre = "converted-" + this.nombre;
		File input = new File(this.name);
		BufferedImage image = ImageIO.read(input);
		FileOutputStream output = new FileOutputStream(this.nombre+".jpeg");
		ImageIO.write(image, "jpeg", output);
		output.close();
		
	}
}