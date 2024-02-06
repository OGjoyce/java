import java.util.Scanner;
import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class AFDMachine{

static int contador;
static String h;
static ArrayList<String> arregloAlfabeto = new ArrayList<String>();
static int x = 0;


  public static void getEstadosF(String linea){
                System.out.println("Los estados finales son:"+" " + linea);
                

                 int n = linea.length();
                 n = n-1;
                
                 Scanner s = new Scanner(linea).useDelimiter(",");
                 

                for(int i =0; n >= i; i++){
                    while (s.hasNext()){

                   
                  
                    contador = s.nextInt();
                    

                  
                        

                    
                }
                

                
                    
                 }
             
                  
            }

    public static void alfabeto(String linea2){
        System.out.println(" {" + " " + linea2+"}");
        Scanner s = new Scanner(linea2).useDelimiter(",|\n");
        int n = linea2.length();
        for (int i = 0; n >= i; i++){
            while(s.hasNext()){
            String m = s.next();
              arregloAlfabeto.add(m);
            
            
        }
        }


    }

    public static void makeMatrix(String linea3){
        System.out.println("Tabla de transicion de estados: ");
        System.out.println(linea3);
       
        Scanner s = new Scanner(linea3).useDelimiter(",|\n");
        int n = linea3.length();
        for (int i = 0; i<= n/2; i++){
            while(s.hasNext()){
                
        int estados = s.nextInt();
    
        verificarEstado(estados);
    }
    }
    }

    public static void verificarEstado(int estado){
        
        String nuevo = Integer.toString(estado);
       int numero = arregloAlfabeto.size();
       for (int i = 0; i<= numero-1; i++){
        boolean t = nuevo.equals(arregloAlfabeto.get(i));
        
       // System.out.println(arregloAlfabeto.get(i) + " " + t);
        if (t=true){
            x++;
            //System.out.println(x);
         if(numero==x){
            display(true);
        }
        }

       
        
    }
    x = 0;

    
    }

    public static void display(Boolean as){
        if(as=true){
            System.out.println("ACEPTADA");
        }
        if (as=false){
            System.out.println("RECHAZADA");
}

    }






    
    public static void main(String[] args) throws Exception {
         
            System.out.println("parametros de ejecucion: java afd example.afd -i para modo interactivo...");
            System.out.println("parametros de ejecucion: java afd example.afd -f archivo.txt para modo batch....");
            System.out.println("Presione enter para continuar....");
        
        if(args[1].equals("-i")|| args[1].equals("-f")){
        
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
            

    
            try (BufferedReader br = new BufferedReader(new FileReader(args[0])))
        {

            
        String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
            

                switch(x){
                case 0: 
                getEstadosF(sCurrentLine);
                x++;
                break;
                case 1: 
                alfabeto(sCurrentLine);
                x++;
                break;
                case 2: makeMatrix(sCurrentLine);
                x++;
                break;
                case 3: makeMatrix(sCurrentLine);
                x++;
                break;
                case 4: makeMatrix(sCurrentLine);
                x++;
                break;
                case 5: makeMatrix(sCurrentLine);
                x++;
                break;
                case 6: makeMatrix(sCurrentLine);
                x++;
                break;
                case 7: makeMatrix(sCurrentLine);
                x++;
                break;
                case 8: makeMatrix(sCurrentLine);
                x++;
                break;

            }
        



                //System.out.println(sCurrentLine);


  

            }

        } catch (IOException e) {
            e.printStackTrace();
     

    

}
          

}
}
}

