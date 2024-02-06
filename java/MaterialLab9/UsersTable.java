/* CC2 - 2018 - lab9 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;
import java.lang.reflect.*;
public class UsersTable {
	// declare sus campos aqui
	public String key;
	public User value;
	public HashMap<String,User> Hmap;
	public int it = 0;

	public UsersTable() {
		// implemente instrucciones de constructor aqui
		this.Hmap = new HashMap<String, User>(25);	
	
	}

	public void insert(String uname, String n, String p) throws Exception {
		// primero verifica si el username ya existe

		if (this.search(uname)) {
			throw new UserAlreadyExistsException();
		} else {
			// Escriba aqui su codigo para insertar un usuario a la tabla
			User noob = new User(uname, n, p);
			this.Hmap.put(uname, noob);
			this.it++;


		}
	}

	public String delete(String username) {
		// implemente aqui su codigo
		if (this.Hmap.containsValue(username)) 
		{
			String s = username;
			this.Hmap.remove(s);
			return s;
		}
		else{
			return null;
		}
	}
	

	private User get(String username)throws Exception{
		// implemente aqui su codigo	
		String us ="";
		String n = "";
		String p = "";
		for (Map.Entry<String, User> entry: this.Hmap.entrySet() ) 
		{
			

			if (entry.getKey()==username) 
			{	
				Field nombre = entry.getClass().getDeclaredField("name");
					nombre.setAccessible(true);
					String name = nombre.toString();
					Field pass = entry.getClass().getDeclaredField("password");
					pass.setAccessible(true);
					String pwd = nombre.toString();
					us = entry.getKey();
					n = name;
					p = pwd;
					
			}
			else
			{
				us = null;
				n = null;
				p = null;
			}
			
		}
			 User m = new User(us, n,p);
			 return m;
	
	
	}

	/* ** No modifique este codigo ** */
	public String userToString(String username) throws Exception {
		return this.get(username).toString();
	}
	/* *********************************/

	public String getPassword(String username) throws Exception {
String r = new String();
		// implemente aqui su codigo
		for (Map.Entry<String, User> entry: this.Hmap.entrySet() ) 
		{
			if (entry.getKey()==username) 
			{
					Field field1 = entry.getClass().getDeclaredField("password");
					field1.setAccessible(true);
					String pwd = field1.toString();
					r = pwd;

			}
			else
			{
				r = null;
			}
		}
		return r;
	}

	public String getName(String username) throws Exception {
		// implemente aqui su codigo
		String s = new String();
		for (Map.Entry<String, User> entry: this.Hmap.entrySet() ) 
		{
			if (entry.getKey()==username) 
			{
					Field field1 = entry.getClass().getDeclaredField("username");
					field1.setAccessible(true);
					String pwd = field1.toString();
					s = pwd;
			}
			else
			{
				s = null;;
			}
		}
		return s;
	}
	
	public boolean search(String username) {
		// implemente aqui su codigo
		if (this.Hmap.containsValue(username)) 
		{
			return true;	
		}
		else{return false;}
	}

	public ArrayList<String> getAllUsernames() {
		// implemente aqui su codigo
		ArrayList<String> al = new ArrayList<String>();
		for (Map.Entry<String, User> entry: this.Hmap.entrySet() ) 
		{
			al.add(entry.getKey());
		}
		return al;
	}

/* ** No modifique este codigo ** */
	public String toString() {
		String str = ""; 
		for (String uname: this.getAllUsernames()) {
try{
			str += uname + " -> " + this.get(uname).getName() + "\n";
		}
		catch(Exception e){
			return "Excp";
		}
		
		
		}
		return str;
	}
/* *********************************/
}

/* ** No modifique este codigo ** */
class UserAlreadyExistsException extends Exception {

}
/* *********************************/