/* CC2 - 2018 - lab9 */

import java.util.HashMap;

public class TestUser {
	public static void main(String[] args) {
		HashMap<String,Boolean> users = new HashMap<String,Boolean>();
		users.put("user1@gmail.com",false);
		users.put("jperez@gmail.com",true);
		users.put("12345678@gmail.com",false);
		users.put("abc_345@gmail.com",true);
		users.put("_juanito@gmail.com",false);
		users.put("a_bcd@gmail.com",false);
		users.put("usuario@.com",false);
		users.put("usuario@ABC.com",false);
		users.put("Usuario@gmail.com",false);
		users.put("usuario@a.com",true);
		users.put("usuario@123.com", false);
		users.put("usuario@ABC.com", false);
		users.put("usuario@dominio.a", true);
		users.put("usuario@dominio.ab", true);
		users.put("algo",false);
		users.put("usuario.otracosa",false);
		users.put("usuario@dominio",false);
		users.put("pa labra@dominio.com", false);
		users.put("usuario.dominiocom", false);


		for(String user: users.keySet()) {
			System.out.print("Verificando " + user + " - resultado : ");
			boolean result = User.validUser(user);
			String iscorrect = result == users.get(user).booleanValue() ? "correcto!" : "incorrecto :(";
			System.out.println(" - " + result + " - " + iscorrect);
		}

	}
}