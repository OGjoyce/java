/* CC2 - 2018 - lab9 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.*;

public class User {
	/* ** No modifique este codigo ** */
	private String username, name, password;

	public User(String username, String nombre, String pwd) throws Exception{
		if (username == null) {
			throw new NullPasswordExcception();
		} else if (validUser(username)) {
			this.username = username;
			this.name = nombre;
			this.password = pwd;
		} 
	}
	/* *********************************/

	public static boolean validUser(String username) {
		// escriba su codigo de verificacion de usuario valido aca
		String s = "[a-z][a-z|0-9|_]{6,14}[@][a-z]{1,}+[.][a-z]{1,3}";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(username);
		boolean b = m.matches();
		if (b){
			return true;

		}else{
			return false;
		}
	}		

	/* ** No modifique este codigo ** */
	public String getUsername() {
		return this.username;
	}

	public String getName() {
		return this.name;
	}

	public String getPwd() {
		return this.password;
	}

	public String toString() {
		return "[ " + this.username + " : " + this.name + " ]";
	}
	/* *********************************/
}

/* ** No modifique este codigo ** */
class InvalidUsernameException extends Exception {
}

class NullPasswordExcception extends Exception {
}
/* *********************************/
