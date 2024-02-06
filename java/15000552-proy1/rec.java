/*********************************************
 *Informatica 3                              *
 * @author Carlos Alejandro Montiel Lorenzana*
 * 15000552                                  *
 * Universidad Galileo                       *
 *********************************************
 */



public class rec{
		public static int factorial (int m){
			if(m>0) {
				System.out.println(" "+ m*factorial(m-1));
				 return m*factorial(m-1);
			}
			else{ 
				System.out.println(1);
				return 1;
			}

}


		     public static int ack(int m, int n) {
		     	   if (m == 0) {
      			   return n + 1;
   				 } else if (n == 0) {
   				 	System.out.println("Ack("+ack (m-1, 1)+")");
    		    return ack(m - 1, 1);
   				 } else {
   				 	System.out.println("Ack("+ack(m-1, ack(m, n-1))+")");
     		   return ack(m - 1, ack(m, n - 1));
  			 }

		     }
		     public static int fibonacci(int n)  {
			    if(n == 0){
			        return 0;
			   } else if(n == 1){
			      return 1;
			  }
			   else{
			   	System.out.println((n-1)+"+"+(n-2)+" = "+fibonacci(n-1)+fibonacci(n-2));
			      return fibonacci(n - 1) + fibonacci(n - 2);
			  }
}
		public static int factorialR (int m){
			if(m>0) {
				 return m*factorialR(m-1);
			}
			else{ 
				return 1;
			}

}


		     public static int ackR(int m, int n) {
		     	   if (m == 0) {
      			   return n + 1;
   				 } else if (n == 0) {
    		    return ackR(m - 1, 1);
   				 } else {
     		   return ackR(m - 1, ackR(m, n - 1));
  			 }

		     }
		     public static int fibonacciR(int n)  {
			    if(n == 0){
			        return 0;
			   } else if(n == 1){
			      return 1;
			  }
			   else{
			      return fibonacciR(n - 1) + fibonacciR(n - 2);
			  }
}
		      

		 
	public static void main (String[] args) {
	String pos0 = args[0]; //guarda a -d o a la funcion
	String pos1 = args[1]; //guarda la funcion o un entero
	String pos2; // guarda un entero
	if (args.length>2){
		pos2 = args[2];
	}
	String pos3;
	if(args.length==4){
		pos3 = args[3];

	}
	

	if (pos0.equals("-d")){
		System.out.print("Imprimiendo");
		if (pos1.equals("fac")){
			System.out.print(" factorial de "+args[2]);
			System.out.println(factorial(Integer.parseInt(args[2])));
				}
		else if (pos1.equals("ack")){
			System.out.print(" Ackermann de ("+args[2]+", "+args[3]+")");
			System.out.println(" = " + ack(Integer.parseInt(args[2]), Integer.parseInt(args[3])));
		}
		else if (pos1.equals("fib")){
			System.out.print(" fibonacci de "+args[2]);
			System.out.println(" = "+fibonacci(Integer.parseInt(args[2])));
		}
			
	}else{
		if (pos0.equals("fac")){
			System.out.println(factorialR(Integer.parseInt(args[1])));
				}
		else if (pos0.equals("ack")){
			int respuesta = ackR(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
			System.out.println(respuesta);
			
		}
		else if (pos0.equals("fib")){
			System.out.println(fibonacciR(Integer.parseInt(args[1])));
		}

	}

	
}
}
