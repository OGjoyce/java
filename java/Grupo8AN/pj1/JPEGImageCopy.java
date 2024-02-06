import java.io.*;

public class JPEGImageCopy extends ImageHandler {
	protected byte[] filebytes;
	/**
	*	File name that will be given to the copy of the original file
	**/
	protected String copyname;
	public String name;

	public JPEGImageCopy(String imagename) {
		super(imagename);
		
		int index_point = imagename.indexOf('.');
		String formato = imagename.substring(index_point, imagename.length());
		String nombre = imagename.substring(0, index_point);
		if (nombre.equals("jpg") || nombre.equals("jpeg") || nombre.equals("JPG") || nombre.equals("JPEG")) {	
		
		this.name = imagename;
		this.copyname = "copy-" + imagename;	}
		else
		{System.out.println("Ingrese un formato valido!!! ERR");}
	}







	public void readFile() throws Exception {
		FileInputStream input = new FileInputStream(this.handledFileName);
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
		FileOutputStream output = new FileOutputStream(copyname);
		output.write(filebytes);
		output.close();
		System.out.println("Imagen generada: " + copyname);
	}
}