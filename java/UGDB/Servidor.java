import java.net.*;
import java.io.*;
import java.util.*;

public class Servidor {

	//DNS
	public static int puerto_dns;
	public static String direccion_ip;

	ArrayList<String> contacts = new ArrayList<String>();
	int contacts_n;
	int mails_n;
	//MAILS
	String subject;
	String body;
	ArrayList<String> to = new ArrayList<String>();
	ArrayList<String> to2 = new ArrayList<String>();
	boolean sending_mail =false;
	boolean send_mail_contacto = false;
	boolean sub = false;
	boolean bod = false;
	//ENDOF MAIS
	Hashtable<String,ArrayList<String>> contenedor=new Hashtable<String,ArrayList<String>>();
	 String servername = "@caml25.com";
	//PERSONAL
	String usuario, psw, id;
	boolean matches =false;
	//ENDOF PERSONAL
	//NEWCONT
	String nombre_newcnt;
	String id_verified;
	boolean exist_newcontact = false;
	boolean session, usr, pwd;//Si existe en la tabla estos tres son true
	public Servidor(String usuario, String psw) //recibimos el usuario y la contrasena
	{
		this.usuario = usuario;
		this.psw = psw;
		verificar();
	}public Servidor() //recibimos el usuario y la contrasena
	{	

		this.session = false;
	}
	//LOGOUT
	public void logout(){
		this.session = false;
	}
	//ADDCONTACT
	public void addContact()
	{
		System.out.println("LOG[0]: Agregando contactos...");
				try{
		DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.exit(0);
		}


		myDb.executeNonQuery("insert into Contactos (id_user, nombre_usuario, id_user_contact, contact) values('"+this.id+"', '"+this.usuario+"', '"+this.id_verified+"', '"+this.nombre_newcnt+"') "); //execute selectQuery using executeQuery method, I will save this query's results in 'rs1'				
		myDb.close();//close connection

	
			
	 }catch(Exception e){
             System.out.println(e.getClass());
             System.out.println(e.getMessage());}
	}
	//NEWCONT
	public void verifycont(){
		System.out.println("LOG[1]: Verificando contactos...");
		try{
		DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.exit(0);
		}


		myDb.executeQuery("SELECT COUNT(nombre) AS C, nombre, id FROM Usuarios where nombre='"+this.nombre_newcnt+"'","rs1"); //execute selectQuery using executeQuery method, I will save this query's results in 'rs1'
		//next method makes tuple fetch, if there are no more tuples method returns false
			//System.out.print("id= "+myDb.getString("id","rs1")+" nombre= "+myDb.getString("nombre","rs1")+" contrasena= "+myDb.getString("password","rs1")+"\n");
		int number = Integer.parseInt(myDb.getString("C", "rs1").toString());
		this.id_verified = myDb.getString("id","rs1").toString();
			if(number>0){
				System.out.println("TRUE CONTACT");
				this.exist_newcontact = true;

			}
			
		
			

		myDb.close();//close connection

	
			
	 }catch(Exception e){
             System.out.println(e.getClass());
             System.out.println(e.getMessage());}

	}
	//SEND MAILS
	public void sendMail(){
			System.out.println("LOG[2]: Enviando correos....");
	
			
					 try{
		DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.exit(0);
		}


			Iterator<String> nombreIterator = this.to.iterator();
					int i =0;
					while(nombreIterator.hasNext()){
						i++;
						String elemento = nombreIterator.next();
						String elemento2 = "";
						if (elemento.contains("@")) 
						{
						elemento2 = elemento.substring(0,elemento.indexOf("@"));
							
						}
						else{
							elemento2 = elemento;
						}
						String sql2 = "select * from Usuarios where nombre='"+elemento2+"'";
	
						if(myDb.executeQuery(sql2,"rs1")){ //execute selectQuery using executeQuery method, I will save this query's results in 'rs1'
				
							while(myDb.next("rs1")){//next method makes tuple fetch, if there are no more tuples method returns false
							
								this.to2.add(myDb.getString("id", "rs1").toString());
							
							}

					}
					Iterator<String> nombreIt = this.to2.iterator();
					while(nombreIt.hasNext()){
						String element = nombreIt.next();
						String sql = "insert into mails (id_user, id_sender, subject, body, leido) values('"+this.id+"', '"+element+"', '"+this.subject+"', '"+this.body+"', '0');";
					
						System.out.println(myDb.executeNonQuery(sql));
					}
					this.send_mail_contacto = true;
				}
		
			

		myDb.close();//close connection

	
			
	 }catch(Exception e){
             System.out.println(e.getClass());
             System.out.println(e.getMessage());}
			
		
	}



	public void contactlist(){
		System.out.println("LOG[3]: fetching contactlist...");
		  try{
		DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.exit(0);
		}


		System.out.println(myDb.executeQuery("select * from Contactos where nombre_usuario='"+this.usuario+"'","rs1")); //execute selectQuery using executeQuery method, I will save this query's results in 'rs1'
		int i =0;
		while(myDb.next("rs1")){//next method makes tuple fetch, if there are no more tuples method returns false
		
			this.contacts.add(myDb.getString("contacto", "rs1").toString());
			i++;
		}
		this.contacts_n = i;
			
		
			

		myDb.close();//close connection

	
			
	 }catch(Exception e){
             System.out.println(e.getClass());
             System.out.println(e.getMessage());}
	}
	public void getMails(){
		System.out.println("LOG[4]: Obteniendo correos....");
		 try{
		DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.out.println("Error en db"+myDb.getError());
			System.exit(0);
		}
		
	
		System.out.println(myDb.executeQuery("select * from usuarios where nombre='"+this.usuario+"' and password ='"+this.psw+"'","rs1")); 	
		while(myDb.next("rs1")){//next method makes tuple fetch, if there are no more tuples method returns false
			this.id = myDb.getString("id","rs1").toString();
		}
		System.out.println(myDb.executeQuery("select U.nombre, M.id_user, U.id, M.id_sender, M.subject, M.body from mails M, usuarios U where M.id_user ='"+id+"' AND U.id=M.id_sender","rs1")); 	
		this.mails_n =0;
		while(myDb.next("rs1")){//next method makes tuple fetch, if there are no more tuples method returns false
			String sender = myDb.getString("nombre","rs1").toString();
			ArrayList<String> ar = new ArrayList<String>();
			ar.add(myDb.getString("subject","rs1").toString());
			ar.add(myDb.getString("body","rs1").toString());
			this.contenedor.put(sender, ar);
			this.mails_n++;
			
		}
		myDb.close();//close connection
	
			
	 }catch(Exception e){
             System.out.println(e.getClass());
             System.out.println(e.getMessage());}
	}
	public void verificar(){
		System.out.println("LOG[5]: Iniciando sesion...");
		   try{
		DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.exit(0);
		}


		myDb.executeQuery("SELECT COUNT(nombre) AS C, nombre, password FROM Usuarios where nombre='"+this.usuario+"' AND password ='"+this.psw+"'","rs1"); //execute selectQuery using executeQuery method, I will save this query's results in 'rs1'
		//next method makes tuple fetch, if there are no more tuples method returns false
			//System.out.print("id= "+myDb.getString("id","rs1")+" nombre= "+myDb.getString("nombre","rs1")+" contrasena= "+myDb.getString("password","rs1")+"\n");
		int number = Integer.parseInt(myDb.getString("C", "rs1").toString());

			if(number>0){
				if (myDb.getString("nombre","rs1").equals(this.usuario)) {
				this.usr = true;
				this.pwd = true;
				this.session = true;
				this.matches = true;
				}

			}
			
		
			

		myDb.close();//close connection

	
			
	 }catch(Exception e){
             System.out.println(e.getClass());
             System.out.println(e.getMessage());}

             
    }
	
public static void addDNS()
{	
	Servidor dns_server = new Servidor();
	try{
		System.out.println("INGRESE EL PUERTO");
	Scanner sc1 = new Scanner(System.in);
	 int puerto = sc1.nextInt();
	 System.out.println("IGRESE LA DIRECCION");
	Scanner sc2 = new Scanner(System.in);
	 String direccion = sc2.nextLine();
	Socket socket = new Socket(direccion, puerto);
	dns_server.direccion_ip = direccion; 
	dns_server.puerto_dns = puerto;
			// Se abren los canales de comunicacion
			// Usar PrintWriter y BufferedReader para evitar tener problemas al comunicarse con otros grupos!
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader intr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			boolean bol = true;
			String saliente = "";
				String entrante = "";
			System.out.println("IGRESE SU DIRECCION IP");
			Scanner sc3 = new Scanner(System.in);
	 		String direccion2 = sc3.nextLine();
			saliente = "ONLINE "+dns_server.servername+" "+direccion;
			out.println(saliente);
			entrante = intr.readLine();
			System.out.println(entrante);

		
		}
			catch(Exception e){
				System.out.println(e);
			}
}
public static void addUSERS()
{
	// String sql6 = "";
	 try{
		DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.exit(0);
		}

		System.out.println("****ESTA APUNTO DE AGREGAR UN USUARIO******");
		System.out.println("Ingrese el usuario: ");
		Scanner sc_u = new Scanner(System.in);
		String usr = sc_u.nextLine();
		System.out.println("Ingrese la contrasena: ");
		Scanner sc_p = new Scanner(System.in);
		String psw = sc_p.nextLine();
		myDb.executeQuery("insert into Usuarios (nombre, password) values('"+usr+"','"+psw+"')"); //execute selectQuery using executeQuery method, I will save this query's results in 'rs1'
		//next method makes tup.le fetch, if there are no more tuples method returns false
		
			

		myDb.close();//close connection

	
			
	 }catch(Exception e){
             System.out.println(e.getClass());
             System.out.println(e.getMessage());}
}
public static void getUSERS()
{
	try{
		DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.exit(0);
		}

		System.out.println("****CUIDADO VERA TODOS LAS CONTRASENAS DE LOS USUARIOS DISPONIBLES EN EL SERVIDOR******");
		System.out.println(myDb.executeQuery("select * from Usuarios","rs1")); 	
		while(myDb.next("rs1"))//next method makes tuple fetch, if there are no more tuples method returns false
			System.out.print("id= "+myDb.getString("id","rs1")+" nombre_usuario= "+myDb.getString("nombre","rs1")+" psw ="+myDb.getString("password","rs1")+"\n");
		
			

		myDb.close();//close connection

	
			
	 }catch(Exception e){
             System.out.println(e.getClass());
             System.out.println(e.getMessage());}
}
public static void showContacts()
{
	
	try{
		DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.exit(0);
		}
		System.out.println("Ingrese el id de usuario");
		Scanner sc29 = new Scanner(System.in);
		String id = sc29.nextLine();
		System.out.println("****Lista de contactos******");
		System.out.println(myDb.executeQuery("select * from Contactos where id_user='"+id+"'","rs1")); 	
		while(myDb.next("rs1"))//next method makes tuple fetch, if there are no more tuples method returns false
			System.out.print("id= "+myDb.getString("id","rs1")+" id_user= "+myDb.getString("id_user","rs1")+" nombre_usuario ="+myDb.getString("nombre_usuario","rs1")+"id_contacto= "+myDb.getString("id_user_contact","rs1")+" nombre_contacto ="+myDb.getString("contacto","rs1")+"\n");
		
			

		myDb.close();//close connection

	
			
	 }catch(Exception e){
             System.out.println(e.getClass());
             System.out.println(e.getMessage());}
}
public static void showMails()
{
	try{
		DB myDb = new DB("MailServer.db");//create one DB connection object
		if(!myDb.connect()){//create actual connection to db
			System.exit(0);
		}
		System.out.println("Ingrese el id de usuario");
		Scanner sc29 = new Scanner(System.in);
		String id = sc29.nextLine();
		System.out.println("****Lista de correos******");
		System.out.println(myDb.executeQuery("select U.nombre, M.id_user, U.id, M.id_sender, M.subject, M.body from mails M, usuarios U where M.id_user ='"+id+"' AND U.id=M.id_sender","rs1")); 	
		int iterator = 0;
		while(myDb.next("rs1")){//next method makes tuple fetch, if there are no more tuples method returns false
			System.out.print("id= "+myDb.getString("id_user","rs1")+" sender= "+myDb.getString("nombre","rs1")+" subject= "+myDb.getString("subject","rs1")+" body="+myDb.getString("body", "rs1")+"\n");
			
		}
		myDb.close();//close connection

	
			
	 }catch(Exception e){
             System.out.println(e.getClass());
             System.out.println(e.getMessage());}
}
public static void makeClient(){
	System.out.println("INGRESE EL PUERTO");
	Scanner sc1 = new Scanner(System.in);
	 int puerto = sc1.nextInt();
	 System.out.println("IGRESE LA DIRECCION");
	Scanner sc2 = new Scanner(System.in);
	 String direccion = sc2.nextLine();

		

		try {
			// El intento de conexion solo funcionara si el servidor ya esta funcionando
			Socket socket = new Socket(direccion, puerto);

			// Se abren los canales de comunicacion
			// Usar PrintWriter y BufferedReader para evitar tener problemas al comunicarse con otros grupos!
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader intr = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String saliente = "";
			String entrante = "";
			//COMUNICACION
			boolean bol =true;
				System.out.println("[0]: Agregar IP de DNS");
				System.out.println("Ingrese un comando != 0");
				Scanner sc5 = new Scanner(System.in);
				String direccion5= sc5.nextLine();
				saliente = direccion5;
				out.println(saliente);
				entrante = intr.readLine();
				System.out.println(entrante);
				if (direccion.equals("0")) 
				{
					bol= false;	
				}
			

			

		


		} catch (Exception e) {
			System.out.println("Ocurrio un problema!"+ e);
		}
			
}


	public static void main (String[] args) {
		Servidor instancia = new Servidor();
		if (args.length != 1) {
			System.out.println("Uso: java Servidor numeroDePuerto");
			System.exit(1);
		}

		int puerto = Integer.parseInt(args[0]);
		boolean interfaz = true;
		while(interfaz){
		System.out.println("Por favor selecione una opción:");
		System.out.println("[0]: Agregar IP de DNS");
		System.out.println("[1]: Agregar usuarios");
		System.out.println("[2]: Ver usuarios");
		System.out.println("[3]: Cambiar puerto");
		System.out.println("[4]: Ver contactos de usuario especifico");
		System.out.println("[5]: Ver Correos de usuario especifico");
		System.out.println("[6]: Cerrar interfaz y encender servidor");
		System.out.println("[7]: Entrar a modo cliente");


		Scanner sc = new Scanner(System.in);
		String opcion = sc.nextLine();
		switch(opcion){
			case "0": 	
						addDNS();
						break;
			case "1": 
						addUSERS();
						break;
			case "2": 
						getUSERS();
						break;

			case "3": 
						System.out.println("Ingrese el numero de puerto");
						Scanner sc1 = new Scanner(System.in);
						puerto = sc.nextInt();
						break;
			case "4": 
						showContacts();
						break;
			case "5": 
						showMails();
						break;
			case "6": 
						interfaz = false;
						break;
			case "7": 
						makeClient();
						break;
		}
		}

		try {
				System.out.println("ESCUCHANDO AL CLIENTE...");
			// Se crea el servidor
			ServerSocket serverSocket = new ServerSocket(puerto);
			// Se espera que se conecte un cliente
			Socket clientSocket = serverSocket.accept();

			// Se abren los canales de comunicacion
			// Usar PrintWriter y BufferedReader para evitar tener problemas al comunicarse con otros grupos!
			// Esta parte es el equivalente al (define-values (in out) ...) en Racket
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			// Usamos readLine() para leer lo que el cliente nos envie
			String mensajeRecibido = in.readLine();
			
			
			

			// Mientras sigan llegando mensajes validos del cliente...
			int ix = 0;
			while (mensajeRecibido != null) {
			
				
				System.out.println("LOG_CLIENT["+ix+++"]: "+mensajeRecibido);
				int first_ocurrence  = mensajeRecibido.length();

					if (mensajeRecibido.contains(" ")) 
				{
			 		first_ocurrence = mensajeRecibido.indexOf(' ');
					
				}
				if (mensajeRecibido.equals("NOOP")) 
				{
					instancia.logout();
					out.println("OK NOOP");	
				}
				if (mensajeRecibido.equals("LOGOUT")) 
				{
					instancia.logout();
					out.println("OK LOGOUT");	
				}
				if (mensajeRecibido.substring(0, first_ocurrence).equals("NEWCONT")) 
				{
					System.out.println("NEWCONT SCOPE");
					String newcont = mensajeRecibido.substring(first_ocurrence+1, mensajeRecibido.length());
					instancia.nombre_newcnt = newcont;
					instancia.verifycont();
					if (instancia.exist_newcontact) 
					{
						out.println("OK NEWCONT "+instancia.nombre_newcnt);
					}
					else{
						out.println("NEWCONT ERROR 109 "+instancia.nombre_newcnt);
					}
				}

				if (mensajeRecibido.substring(0,first_ocurrence).equals("SEND")) 
				{	
					int segunda_ocurrencia = mensajeRecibido.lastIndexOf(' ');
					if (mensajeRecibido.substring(first_ocurrence+1, mensajeRecibido.length()).equals("MAIL")) {

						instancia.sending_mail = true;
					}
					else{
						break;
					}
				}
				if (mensajeRecibido.substring(0,first_ocurrence).equals("MAIL") && instancia.sending_mail) 
				{
					
					int segunda_ocurrencia = mensajeRecibido.lastIndexOf(' ');
					String parse = mensajeRecibido.substring(first_ocurrence+1, mensajeRecibido.length());
					if(mensajeRecibido.substring(first_ocurrence+1,segunda_ocurrencia).equals("TO"))
					{
						String quien = mensajeRecibido.substring(segunda_ocurrencia+1, mensajeRecibido.length());
						if (mensajeRecibido.substring(segunda_ocurrencia+1, mensajeRecibido.length()).equals(quien)) 
						{
							
							instancia.to.add(quien);
						}
						
					}
					//System.out.println(parse.substring(0, parse.indexOf(" ")));
					if(parse.substring(0, parse.indexOf(" ")).equals("SUBJECT")){
						instancia.subject = mensajeRecibido.substring(mensajeRecibido.indexOf("'")+1,mensajeRecibido.length()-1);
						out.println("SUBJECT IS RIGHT");
						instancia.sub = true;
					}
					
					
						//System.out.println(mensajeRecibido.substring(first_ocurrence+1, comilla-1));
					if(parse.substring(0, parse.indexOf(" ")).equals("BODY")){
						instancia.body = mensajeRecibido.substring(mensajeRecibido.indexOf("'")+1, mensajeRecibido.length()-1);
						out.println("BODY IS RIGHT");
						instancia.bod = true;
						
					}
					
				
				
						
					if (instancia.sub && instancia.bod) 
					{
						
						instancia.sendMail();
						out.println("OK SEND MAIL");	
					}
					
					
					
				}
				if (mensajeRecibido.equals("END SEND MAIL")) 
				{
					instancia.sending_mail =false;
					
				}
				if (mensajeRecibido.substring(0,first_ocurrence).equals("CLIST")) 
				{

					if (instancia.session) 
					{
						instancia.contactlist();	
						Iterator<String> nombreIterator = instancia.contacts.iterator();

					int i =0;
				
					while(nombreIterator.hasNext()){
						i++;
						String elemento = nombreIterator.next();
						if(i!=instancia.contacts_n){
							
						
						out.println("OK CLIST "+elemento);
						}else{
							out.println("OK CLIST "+elemento+"*");
						}
					}
					}
					else{
						out.println("CLIST ERROR 103");
					}
					
					
				}

				if (mensajeRecibido.substring(0,first_ocurrence).equals("GETNEWMAILS")) 
				{
					if (instancia.session) 
					{
							instancia.getMails();
							Set<String> keys = instancia.contenedor.keySet();
							 Iterator<String> itr = keys.iterator();
							 String str ="";
							    //Displaying Key and value pairs
							 int iterator = 0;
							    while (itr.hasNext()) { 
							       // Getting Key
							       str = itr.next();

							       /* public V get(Object key): Returns the value to which 
							        * the specified key is mapped, or null if this map 
							        * contains no mapping for the key.
							        */
							        iterator++;
							       if (iterator == instancia.mails_n) {
							       	
							       out.println("OK GETNEWMAILS "+str+" "+instancia.contenedor.get(str).get(0)+" "+instancia.contenedor.get(str).get(1)+"*");
							       }
							       else{
							       	out.println("OK GETNEWMAILS "+str+" "+instancia.contenedor.get(str).get(0)+" "+instancia.contenedor.get(str).get(1));
							       }
							      
							    } 
							
					}
					else{
						out.println("LOGIN NEEDED");
					}
					
					
				}
				
			
			
				if (mensajeRecibido.substring(0,first_ocurrence).equals("LOGIN")) 
			{	
				int segunda_ocurrencia = mensajeRecibido.lastIndexOf(' ');
				String user = mensajeRecibido.substring(first_ocurrence+1, segunda_ocurrencia);
				String pass = mensajeRecibido.substring(segunda_ocurrencia+1, mensajeRecibido.length());
				instancia = new Servidor(user, pass);
				if (instancia.usr && instancia.pwd) 
             {
             	if (!instancia.matches) 
             	{
             		out.println("ERROR LOGIN 102");
             	}else{
             	out.println("OK LOGIN");	
             		
             	}

             }
             else{
             	out.println("LOGIN ERROR 101");
             }
			}
					


				// Nos detenemos cuando se despida
				if (mensajeRecibido.equals("Adios")) {
					break;
				}
			

				// Seguimos leyendo mas mensajes
				mensajeRecibido = in.readLine();
			}

		} catch (Exception e) {
			System.out.println("Ocurrio un problema!"+ e);
		}


	}
}