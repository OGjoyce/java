import java.io.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class JPEGImageHandlerColors extends ImageHandler
{
	protected byte[] filebytes;
	/**
	*	File name that will be given to the copy of the original file
	**/
	public FileInputStream finput;
	protected String copyname;
	public String name;
	public FileOutputStream foutput;
	public JPEGImageHandlerColors(String imagename)
	{
		super(imagename);
		this.name = imagename;
		try{
			readFile();
			make_rojo();
			make_sepia();
			make_azul();
			make_verde();
			generateFiles();
		   }
		catch(Exception e){
			System.out.println("Invalid name");

		}
	}


	public void make_rojo() throws Exception
	{	

		this.copyname = "Red-" + this.name;
		byte[] imagen = this.filebytes;
		FileOutputStream imagen_rojo = new FileOutputStream(this.copyname);
		this.finput = new FileInputStream(this.name);
		for(int i=0; i<54; i++)
        {
            imagen_rojo.write(this.finput.read()); // ponemos el header ya tiene el header (nombre, tipo de imagen, etc...)
        }
        for(int x=54; x<imagen.length; x++) // no lo entiendo (es azul verde rojo)
        {
        	int azul = this.finput.read();
        	int verde = this.finput.read();
        	int rojo = this.finput.read();

            imagen_rojo.write(0);//0
            imagen_rojo.write(0);//0
            imagen_rojo.write(rojo);
        }
        this.foutput = imagen_rojo;
        imagen_rojo.close();
	
	}
	
	public void make_sepia() throws Exception
	{
		this.copyname = "Sepia-" + this.name;
		byte[] imagen = this.filebytes;
		FileOutputStream imagen_sepia = new FileOutputStream(this.copyname);
		this.finput = new FileInputStream(this.name);
		for(int i=0; i<54; i++)
        {
            imagen_sepia.write(this.finput.read()); // ponemos el header ya tiene el header (nombre, tipo de imagen, etc...)
        }
        for(int x=54; x<imagen.length; x++) // no lo entiendo (es azul verde rojo)
        {
        	int azul = this.finput.read();
        	int verde = this.finput.read();
        	int rojo = this.finput.read();
            azul = (int)(0.131*azul + 0.534*verde + 0.272*rojo);
            verde = (int)(0.168*azul + 0.686*verde + 0.349*rojo);
            rojo = (int)(0.189*azul + 0.769*verde + 0.393*rojo);
            if(rojo > 255)
            {
                rojo = 255;
            }else if(rojo ==0){
                rojo = 0;
            }else{
                rojo=rojo;
            }
             if(verde > 255)
            {
                verde = 255;
            }else if(verde == 0){
                verde = 0;
            }else{
                verde=verde;
            }
             if(azul > 255)
            {
                azul = 255;
            }else if(azul ==0){
                azul = 0;
            }else{
                azul=azul;
            }

            imagen_sepia.write(azul);//0
            imagen_sepia.write(verde);//0
            imagen_sepia.write(rojo);
        }
        this.foutput = imagen_sepia;
        imagen_sepia.close();
	
	}
	public void make_azul() throws Exception
	{
		this.copyname = "Blue-" + this.name;
		byte[] imagen = this.filebytes;
		FileOutputStream imagen_azul = new FileOutputStream(this.copyname);
		this.finput = new FileInputStream(this.name);
		for(int i=0; i<54; i++)
        {
            imagen_azul.write(this.finput.read()); // ponemos el header ya tiene el header (nombre, tipo de imagen, etc...)
        }
        for(int x=54; x<imagen.length; x++) // no lo entiendo (es azul verde rojo)
        {
        	int azul = this.finput.read();
        	int verde = this.finput.read();
        	int rojo = this.finput.read();

            imagen_azul.write(azul);
            imagen_azul.write(0);//0
            imagen_azul.write(0);//0
        }
        this.foutput = imagen_azul;
        imagen_azul.close();
	
	}
	public void make_verde() throws Exception
	{	
		this.copyname = "Green-" + this.name;
		byte[] imagen = this.filebytes;
		FileOutputStream imagen_verde = new FileOutputStream(this.copyname);
		this.finput = new FileInputStream(this.name);
		for(int i=0; i<54; i++)
        {
            imagen_verde.write(this.finput.read()); // ponemos el header ya tiene el header (nombre, tipo de imagen, etc...)
        }
        for(int x=54; x<imagen.length; x++) // no lo entiendo (es azul verde rojo)
        {
        	int azul = this.finput.read();
        	int verde = this.finput.read();
        	int rojo = this.finput.read();

            imagen_verde.write(0);
            imagen_verde.write(verde);//0
            imagen_verde.write(0);//0
        }
        this.foutput = imagen_verde;
        imagen_verde.close();
	
	}
	public void readFile() throws Exception 
	{
		FileInputStream input = new FileInputStream(this.name);
		this.finput = new FileInputStream(this.name);
		this.filebytes = new byte[input.available()];
		this.finput.read(filebytes);
		this.finput.close();
		System.out.println("Imagen leida: " + this.name);
	}
	/**
	*	Generates a copy file from the original file. The name of the generated
	* 	file will be build by the same name preceeded of "copy-"
	**/	
	public void generateFiles() throws Exception {
		this.foutput.close();
		System.out.println("Imagenes generadas: [Red && Blue && Green][-]" + this.name);
	}
}