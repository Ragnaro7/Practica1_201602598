
package practica1_201602598;
import java.util.*;
/**
 *
 * @author Hector
 */
public class Menu_201602598 {
    
    LlenarMatriz_201602598 LM=new LlenarMatriz_201602598(0,0,0);
    private int f;
    private int c;
    private int m;
    
    public void pantallaInicio(){
        System.out.printf("%s%n%s%n%s%n%s%n","Hector Mendizabal","201602598",""
                + "IPC1 A PRACTICA 1","BUSCAMINAS");
        String start;
        Scanner scp=new Scanner(System.in);
        start=scp.nextLine();
        menuPrincipal();
    }
    
    public void nulo(){
        System.out.printf("%n%s%n%s%n%n","Saliendo del juego.","Gamer Over");
    }
    
    public void menuPrincipal(){
        
    System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n",
            "---------------------------",
             "BUSCAMINAS",
             "1. Principiante",
             "2. Intermedio",
             "3. Experto",
             "4. Salir",
             "Ingrese una opcion: ",
             "---------------------------");
             swiMenuPrincipal();
    }
    
    public void swiMenuPrincipal(){
        Scanner sc=new Scanner(System.in);
        int opcion=sc.nextInt();
        switch(opcion){
            case 1:
                f=6;
                c=6;
                m=4;
                System.out.println("\nHa elegido PRINCIPIANTE\n");
                principiante(f,c,m,"Principiante");
                break;
                
            case 2:
                f=8;
                c=8;
                m=8;
                System.out.println("\nHa elegido INTERMEDIO\n");
                principiante(f,c,m,"Intermedio");
                break;
                
            case 3:
                f=10;
                c=10;
                m=12;
                System.out.println("\nHa elegido AVANZADO\n");
                principiante(f,c,m,"Avanzado");
                break;
                
            case 4:
                System.out.printf("%n%s%n%s%n%n","Saliendo del juego.","Gamer Over");
               System.exit(0);
                break;
                
            default:
                System.out.println("\nComando no valido, intente de nuevo.");
                swiMenuPrincipal();
                break;
        }//switch
    }//swiMenuPrincipal
    
    public void principiante(int f, int c, int m, String dificultad){
        LlenarMatriz_201602598 LM=new LlenarMatriz_201602598(f,c,m);
        System.out.println("\n---------------------------"
                + "\nNivel: "+dificultad);
                
               LM.randomMatriz();
               //System.out.println("\n---------\nVoltear: v\nReiniciar: R\nSalir: s");
    }
}//public class
