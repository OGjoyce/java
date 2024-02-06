import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.io.*;
import java.util.*;
public class UsuariosDB{
	public static void main(String[] args) {
	        try{
		DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.out.println("Error en db"+myDb.getError());
			System.exit(0);
		}
		
//insert statement, notice i use executeNonQuery method
System.out.println(myDb.executeQuery("select U.nombre, M.id_user, U.id, M.id_sender, M.subject, M.body from mails M, usuarios U where M.id_user ='6' AND U.id=M.id_sender","rs1")); 	
		int iterator = 0;
		while(myDb.next("rs1")){//next method makes tuple fetch, if there are no more tuples method returns false
			System.out.print("yo_soy= "+myDb.getString("id_user","rs1")+" sender= "+myDb.getString("nombre","rs1")+" subject= "+myDb.getString("subject","rs1")+" body="+myDb.getString("body", "rs1")+"\n");

			
		}
     String sql6 = "insert into Contactos (id_user, nombre_usuario,id_user_contact, contacto) values('11','Invoker@caml25','1','Carlos')";
     String sql7 = "insert into Contactos (id_user, nombre_usuario,id_user_contact, contacto) values('11','Invoker@caml25','9','shinhisako@caml25')";
     String sql8 = "insert into Contactos (id_user, nombre_usuario,id_user_contact, contacto) values('11','Invoker@caml25','10','zezima@caml25')";
     String sql9 = "insert into Contactos (id_user, nombre_usuario,id_user_contact, contacto) values('11','Invoker@caml25','11','Invoker@caml25')";
     myDb.executeNonQuery(sql6);
              myDb.executeNonQuery(sql7);
              myDb.executeNonQuery(sql8);
              myDb.executeNonQuery(sql9);
    System.out.println(myDb.executeQuery("select * from Contactos where nombre_usuario='Invoker@caml25'","rs1"));
      while(myDb.next("rs1"))//next method makes tuple fetch, if there are no more tuples method returns false
      System.out.print("id= "+myDb.getString("id_user","rs1")+" nombre_usuario= "+myDb.getString("nombre_usuario","rs1")+" psw ="+myDb.getString("contacto","rs1")+"\n");

 


		System.out.println(myDb.executeQuery("select * from Contactos","rs1")); 	
		while(myDb.next("rs1"))//next method makes tuple fetch, if there are no more tuples method returns false
			System.out.print("id= "+myDb.getString("id_user","rs1")+" nombre_usuario= "+myDb.getString("nombre_usuario","rs1")+" psw ="+myDb.getString("contacto","rs1")+"\n");

		myDb.close();//close connection


			
	 }catch(Exception e){
             System.out.println(e.getClass());
             System.out.println(e.getMessage());}
    }
}

/*		   String sql = "CREATE TABLE IF NOT EXISTS Contactos (\n"
                + " id integer PRIMARY KEY,\n"
                + " id_user integer NOT NULL,\n"
                + " nombre_usuario text NOT NULL,\n"
                + " id_user_contact integer NOT NULL,\n"
                + " contacto text NOT NULL,\n"
                + "FOREIGN KEY (id_user) REFERENCES Usuarios(id));";
                myDb.executeNonQuery(sql);
        String sql1 = "CREATE TABLE IF NOT EXISTS Usuarios (\n"
                + "	id integer PRIMARY NOT NULL,\n"
                + "	nombre text,\n"
                + "	password text\n"
                + ");";
                myDb.executeNonQuery(sql1);



                	 String sql2 = "insert into Usuarios (nombre, password) values('Sergio','12345')";
		 String sql3 = "insert into Usuarios (nombre, password) values('Mario','12345')";
		 String sql4 = "insert into Usuarios (nombre, password) values('Loiis','12345')";
		 String sql5 = "insert into Usuarios (nombre, password) values('Maiev','carros221')";
		 String sql6 = "insert into Usuarios (nombre, password) values('Invoker','proPhet')";
              myDb.executeNonQuery(sql2);
              myDb.executeNonQuery(sql3);
              myDb.executeNonQuery(sql4);
              myDb.executeNonQuery(sql5);
              myDb.executeNonQuery(sql6);


              String sql = "CREATE TABLE IF NOT EXISTS mails (\n"
                + "	id integer PRIMARY KEY NOT NULL,\n"
                + "	id_user integer NOT NULL,\n"
                + "	id_sender integer NOT NULL,\n"
                + "	subject text NOT NULL,\n"
                + "	body text \n, leido text"
                + ");";

                 String sql2 = "insert into mails (id_user, id_sender, subject, body) values('6','1','Asunto2','QUE DIJISTEEEEEEEEEEEEEEEE?')";
                    String sql6 = "insert into Contactos (id_user, nombre_usuario,id_user_contact, contacto) values('1','Carlos','2','Sergio')";
     String sql7 = "insert into Contactos (id_user, nombre_usuario,id_user_contact, contacto) values('1','Carlos','9','shinhisako@caml25')";
     String sql8 = "insert into Contactos (id_user, nombre_usuario,id_user_contact, contacto) values('1','Carlos','10','zezima@caml25')";
     String sql9 = "insert into Contactos (id_user, nombre_usuario,id_user_contact, contacto) values('1','Carlos','11','Invoker@caml25')";
     myDb.executeNonQuery(sql6);
              myDb.executeNonQuery(sql7);
              myDb.executeNonQuery(sql8);
              myDb.executeNonQuery(sql9);
            
*/