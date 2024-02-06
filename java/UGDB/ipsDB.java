import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.io.*;
import java.util.*;
public class ipsDB{
	String ip, nombre;
	boolean interfaz =true;
	public ipsDB()
	{	
		while(interfaz){
		System.out.println("Por favor selecione una opción:");
		System.out.println("[0]: Ver lista de direccions y nombres de servidores");
		System.out.println("[1]: Agregar nueva dirección");
		System.out.println("[2]: Seleccionar direccion");
		System.out.println("[3]: salir de interfaz");

		Scanner sc = new Scanner(System.in);
		String opcion = sc.nextLine();
		switch(opcion){
			case "0": 	
						vista();
						break;
			case "1": 
						agregar();
						break;
			case "2": 
						seleccionar();
						break;

			case "3": 
						this.interfaz = false;
						break;
		}
		}
	}
	public void seleccionar()
	{
		vista();
		System.out.println("***** INGRESE EL ID DE LA DIRECCION QUE DESEA SELECCIONAR**********");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		String sql = "select * from servers where id="+id+"";
		try{
		DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.out.println("Error en db"+myDb.getError());
			System.exit(0);
		}
		myDb.executeQuery(sql, "rs2");
		while(myDb.next("rs2"))
		{
			this.ip = myDb.getString("direccion_ip","rs2").toString();
			this.nombre = myDb.getString("nombre_server", "rs2").toString();
		}
	}
	catch(Exception e)
	{
		System.out.println(e.getClass());
             System.out.println(e.getMessage());
	}



	}
	public void vista(){
		try{
		DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.out.println("Error en db"+myDb.getError());
			System.exit(0);
		}
		System.out.println(myDb.executeQuery("select * from servers","rs1")); //execute selectQuery using executeQuery method, I will save this query's results in 'rs1'
		int i =0;
		while(myDb.next("rs1"))//next method makes tuple fetch, if there are no more tuples method returns false
			System.out.print("id= "+myDb.getString("id","rs1")+" direccion= "+myDb.getString("direccion_ip","rs1")+" nombre= "+myDb.getString("nombre_server","rs1")+"\n"); 	

		myDb.close();//close connection
	}
	catch(Exception e){
		System.out.println(e.getClass());
             System.out.println(e.getMessage());
	}
	}
	public void agregar(){
		try{
			DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.out.println("Error en db"+myDb.getError());
			System.exit(0);
		}
			  System.out.println("Ingrese la direccion ip");
		Scanner sc = new Scanner(System.in);
		String nombre = sc.nextLine();
		System.out.println("Ingrese el nombre del servidor");
		Scanner sc1 = new Scanner(System.in);
		String psw = sc1.nextLine();
		System.out.println("executing insert");//AQUI PODRIAMOS GUARDAR LA TABLA PERO HAY QUE APREDNDER A USARLA
		System.out.println(myDb.executeNonQuery("insert into servers (direccion_ip, nombre_server) values ('"+nombre+"','"+psw+"')"));//insert statement, notice i use executeNonQuery method
		myDb.close();
		}
		catch(Exception e){
			System.out.println(e.getClass());
             System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {

	       
}
}

/*			String sql = "CREATE TABLE IF NOT EXISTS servers (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	direccion_ip text NOT NULL,\n"
                + "	nombre_server text NOT NULL\n"
                + ");";
                myDb.executeNonQuery(sql);*/