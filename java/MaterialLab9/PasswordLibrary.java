/* CC2 - 2018 - lab9 */

import java.io.*;

public class PasswordLibrary {
	public static void main(String[] args) throws Exception {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		UsersTable tabla = new UsersTable();
		tabla.insert("jperez@gmail.com", "Juan Perez", "mipassword");
		tabla.insert("mjbarillas@gmail.com", "Maria Jose Barillas", "1234mjb");

		System.out.println("Welcome to PASSWORD LIBRARY ");
		System.out.println("--------------------------- ");
		// Menu
		int opcion = -1;
		do {
			System.out.println("MENU PRINCIPAL: ");
			System.out.println("1: Ingrese usuario nuevo");
			System.out.println("2. Busqueda de passwords");
			System.out.println("3. Remover usuario");
			System.out.println("4: Lista de usuarios");
			System.out.println("5: Salir\n");
			System.out.print("Ingrese su opcion: ");
			try {
				opcion = Integer.parseInt(teclado.readLine());
				System.out.println("\n------------------------");
				switch (opcion) {
					case 1: {
						boolean flag1 = false;
						System.out.println("INGRESO USUARIO: ");
						while (!flag1) {
							System.out.print("Ingrese username: ");
							String username = teclado.readLine();
							System.out.print("Ingrese nombre: ");
							String name = teclado.readLine();
							System.out.print("Ingrese password: ");
							String pwd = teclado.readLine();
							if (username.equals("") || name.equals("") || pwd.equals("")) {
								System.out.println("Error: uno de los datos es vacio... trate de nuevo\n");
							} else {
								try {
									tabla.insert(username,name,pwd);
									System.out.println("\nUsuario ingresado exitosamente!");
									System.out.println(tabla.userToString(username) + "\n");
									System.out.println("\n------------------------");
									flag1 = true;
								} catch (UserAlreadyExistsException uaee) {
									System.out.println("Error: username ya existe ... trate de nuevo\n");
								} catch (InvalidUsernameException iue) {
									System.out.println("Error: useaneme invalido ... trate de nuevo\n");
								}
							}	
						}
						break;	
					}
					case 2: {
						boolean flag2 = false;
						System.out.println("REMOVER USUARIO: ");
						while (!flag2) {
							System.out.print("Ingrese username: ");
							String username = teclado.readLine();
							if (username.equals("")) {
								System.out.println("Error: ingreso username vacio ... trate de nuevo\n");
							} else if (tabla.search(username)) {
								System.out.println("\n Se ha encontrado password para");
								System.out.println("Username = " + username + ", Nombre = " + tabla.getName(username));
								System.out.println("Password = " + tabla.getPassword(username));
								System.out.println("\n------------------------");
								flag2 = true;
							} else {
								System.out.println("\n No se encontro password asociado a ese usuario");
								System.out.println("\n------------------------");
								flag2 = true;						
							}						
						}
						break;
					}
					case 3: {
						boolean flag3 = false;
						System.out.println("BUSQUEDA DE PASSWORDS: ");
						while (!flag3) {
							System.out.print("Ingrese username: ");
							String username = teclado.readLine();
							if (username.equals("")) {
								System.out.println("Error: ingreso username vacio ... trate de nuevo\n");
							} else if (tabla.search(username)) {
								System.out.println("\nSe ha encontrado el usuario ...");
								String removido = tabla.delete(username);
								System.out.println("Se ha removido: " + removido);
								System.out.println("\n------------------------");
								flag3 = true;
							} else {
								System.out.println("\n No se encontro usuario");
								System.out.println("\n------------------------");
								flag3 = true;	
							}
						}
						break;
					}
					case 4: {
						System.out.println("LISTADO DE USUARIOS: ");
						System.out.println("Los usuarios para los que el sistema tiene");
						System.out.println("asociado un password son: ");
						System.out.println(tabla);
						break;
					}
					case 5: {

						System.out.println("Saliendo del programa\n\n");
						break;
					}
				}

			} catch (NumberFormatException nfe) {
				System.out.println("Error: Opcion ingresada no es un numero. Regresando a menu principal...\n");
				opcion = -1;
			}
		} while (opcion != 5);

	}
}