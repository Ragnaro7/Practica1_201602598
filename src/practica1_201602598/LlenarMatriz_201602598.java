
package practica1_201602598;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Hector
 */
public class LlenarMatriz_201602598 {

    private int fila;
    private int columna;
    private int minas;
    Random ale=new Random();
    private String matrizusuario[][];
    private int matrizcontrol[][];
    private int filar,columnar;
    private int ganar;
    private boolean condganar;
    public LlenarMatriz_201602598(int fila, int columna,int minas){
        
        this.fila=fila;
        this.columna=columna;
        this.minas=minas;
        
        matrizusuario=new String[fila][columna];
        matrizcontrol=new int[fila][columna];
        
        for(int i=1;i<fila;i++){
            for(int j=1;j<columna;j++){
                matrizusuario[i][j]="x";
            }//for j
        }//for i*/
    }
    
   /* public void generarMatriz(){
        matrizusuario=new String[fila][columna];
        matrizcontrol=new int[fila][columna];
        
    }*/
    
    public void reiniciarnivel(){
        
       System.out.println("\nReiniciando tablero");
               Menu_201602598 wq=new Menu_201602598();
               if(matrizcontrol.length==6){
                   System.out.println("\nUd. Ha reiniciado el tablero");
                   wq.principiante(6, 6, 4, "Principiante");
               }else if(matrizcontrol.length==8){
                   System.out.println("\nUd. Ha reiniciado el tablero");
                    wq.principiante(8, 8, 8, "Intermedio");
               }
               else{
                   System.out.println("\nUd. Ha reiniciado el tablero");
                    wq.principiante(10, 10, 12, "Avanzado");
               }
               randomMatriz();
        
    }
    
    public void ganar(){
        condganar=false;
        
          for(int i=1;i<fila-1;i++){
            for(int j=1;j<columna-1;j++){
                
                if(matrizcontrol[i][j]>=0){
                  if(!(matrizusuario[i][j].equalsIgnoreCase(Integer.toString(matrizcontrol[i][j])))){
                      condganar=true;
                  }
              }  
            }//for j
        }//for i*/
          
        if(condganar==false){
            System.out.println("    FELICIDADES\n   GANASTE\n");
            reiniciarJuego();
        }else{
            
        voltear();
        
        }
    }
    
    public void usuariosx(){
        
         for(int i=1;i<fila-1;i++){
            for(int j=1;j<columna-1;j++){
                matrizusuario[i][j]="x";
            }//for j
        }//for i*/
        for(int i=1;i<fila-1;i++){
            System.out.println();
            for(int j=1;j<columna-1;j++){
                System.out.printf("  [%s]  ",matrizusuario[i][j]); //matriz string para pruebas.
                //System.out.printf("  [%d]  ",matrizcontrol[i][j]);
            }//forj
        }//fori
        voltear();
    }
    
    public void randomMatriz(){
        
        while(minas>0){
           
        filar=1+ale.nextInt(fila-1-1);
        columnar=1+ale.nextInt(columna-1-1);
        //System.out.println(filar+" "+columnar);
        if(matrizcontrol[filar][columnar]==0){
            matrizcontrol[filar][columnar]=-50;
            minas=minas-1;
        }
        
        }
        igualarMatriz();
        //minasAlrededor();
    }//random

    public void igualarMatriz(){
        
        for(int i=1;i<fila-1;i++){
            
            for(int j=1;j<columna-1;j++){
                
            if(matrizcontrol[i][j]<0){
                matrizusuario[i][j]="*";
            }
                
            }//for j
        
        }//for i
        minasAlrededor();
    }//igualarMatriz
    
    public void sol(){
        System.out.println("    <Solucion del tablero.>");
        String matrizusuario2[][]=new String [fila][columna];
        
        for(int i=1;i<fila-1;i++){
            
            for(int j=1;j<columna-1;j++){
                
            matrizusuario2[i][j]=Integer.toString(matrizcontrol[i][j]);
            if(matrizcontrol[i][j]<0){
                matrizusuario2[i][j]="*";
            }    
            }//for j
        
        }//for i
         
          for(int i=1;i<fila-1;i++){
            System.out.println();
            for(int j=1;j<columna-1;j++){
                System.out.printf("  [%s]  ",matrizusuario2[i][j]); //matriz string para pruebas.
                //System.out.printf("  [%d]  ",matrizcontrol[i][j]);
            }//forj
        }//fori
          System.out.println("\n");
          voltear();
    }
    
    public void solucion(){
         for(int i=1;i<fila-1;i++){
            
            for(int j=1;j<columna-1;j++){
                
            matrizusuario[i][j]=Integer.toString(matrizcontrol[i][j]);
            if(matrizcontrol[i][j]<0){
                matrizusuario[i][j]="*";
            }    
            }//for j
        
        }//for i
         
          for(int i=1;i<fila-1;i++){
            System.out.println();
            for(int j=1;j<columna-1;j++){
                System.out.printf("  [%s]  ",matrizusuario[i][j]); //matriz string para pruebas.
                //System.out.printf("  [%d]  ",matrizcontrol[i][j]);
            }//forj
        }//fori
       reiniciarJuego();
    }
    
    public void reiniciarJuego(){
        
           Scanner scsol=new Scanner(System.in);
         System.out.printf("%n%s%n","¿Desea volver al menu principal (Y/N)");
         String fin=scsol.nextLine();
         if(fin.equalsIgnoreCase("y")){
             System.out.println();
             Menu_201602598 men=new Menu_201602598();
             men.pantallaInicio();
         }else if(fin.equalsIgnoreCase("n")){
             System.out.println("\nSaliendo del juego.");
            System.exit(0);
         }else{
             System.out.println("Opcion no valida, intente nuevamente");
             reiniciarJuego();
         }
        
    }
    public void impMatriz(){
   
        for(int i=1;i<fila-1;i++){
            System.out.println();
            for(int j=1;j<columna-1;j++){
                System.out.printf("  [%s]  ",matrizusuario[i][j]); //matriz string para pruebas.
                //System.out.printf("  [%d]  ",matrizcontrol[i][j]);
            }//forj
        }//fori
        voltear();
    }//impMatriz
    
    
    public void minasAlrededor(){
    
        for(int i=1;i<fila-1;i++){
            for(int j=1;j<columna-1;j++){
                if(matrizcontrol[i][j]<0){
                    matrizcontrol[i-1][j]+=1;
                    matrizcontrol[i+1][j]+=1;
                    matrizcontrol[i][j-1]+=1;
                    matrizcontrol[i][j+1]+=1;
                    matrizcontrol[i-1][j-1]+=1;
                    matrizcontrol[i-1][j+1]+=1;
                    matrizcontrol[i+1][j-1]+=1;
                    matrizcontrol[i+1][j+1]+=1;
                    
                }
            }
        }
        //desde ac actrolz
        
        
        usuariosx();
        //impMatriz();
    }//minasAlrededor


    public void voltear(){
        //Menu_201602598 menu=new Menu_201602598();
        Scanner sc3=new Scanner(System.in);
        Scanner sc=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);
        
        System.out.println("\n---------------------------\nVoltear: v\nReiniciar: r\nSalir: s\nIngrese "
                + "una opcion");
        String op3=sc3.nextLine();
        if(op3.equalsIgnoreCase("v")){
            
        System.out.println("\n  \nIngrese una fila");
        int vfila=sc.nextInt();
        if(vfila>fila-2 || vfila<=0){
            System.out.printf("%n%s%n","Fila no valida, intente de nuevo");
            voltear();
        }
        System.out.println("\n  \nIngrese una columna");
        int vcolumna=sc.nextInt();
        if(vcolumna>columna-2 || vcolumna<=0){
            System.out.printf("%n%s%n","Columna no valida\nPara evitar errores ingrese nuevamente "
                    + "AMBOS datos");
            voltear();
        }
        System.out.println("Esta seguro? Y/N");
        String seguro=sc2.nextLine();
        if(seguro.equalsIgnoreCase("y")){
            //impMatrizusuario(vfila,vcolumna);
            verificarvolter(vfila,vcolumna);
        }else if(seguro.equalsIgnoreCase("n")){
         impMatriz();   
        }else {System.out.println("Comando no valido, intente de nuevo");
        System.out.println();    
        voltear();
        }
        
        }else if(op3.equalsIgnoreCase("r")){
            reiniciarnivel();
        }else if(op3.equalsIgnoreCase("s")){
            System.out.println("\nSaliendo del juego.");
            System.exit(0);
        }else if(op3.equalsIgnoreCase("sol")){
            sol();
        }
        
          else{
            System.out.println("Opcion no valida.");
            voltear();
        }
        
    }//voletar
    public void s(){
        System.out.println("\nSaliendo del juego.");
    }
    
    public void verificarvolter(int f,int c){
        int k;
        k=matrizcontrol[f][c];
        if(matrizusuario[f][c].equals(Integer.toString(k))){
                System.out.printf("%n%s%n","La casilla ya se muestra en pantalla,ingrese otra.");
                impMatrizusuario(f,c,true);
            }else{
                    
        impMatrizusuario(f,c,false);
        }
    }
    
    public void impMatrizusuario(int f,int c,boolean a){
        if(a==false){
            
        int k;
        if(matrizcontrol[f][c]>=0){
            k=matrizcontrol[f][c];
            matrizusuario[f][c]=Integer.toString(k);
        }else{
            matrizusuario[f][c]="*";
        }    
        
        if(matrizcontrol[f-1][c]>=0 && matrizcontrol[f][c]>=0){
            k=matrizcontrol[f-1][c];
             matrizusuario[f-1][c]=Integer.toString(k);
            
        }
        
        if(matrizcontrol[f+1][c]>=0 && matrizcontrol[f][c]>=0){
        k=matrizcontrol[f+1][c];
        matrizusuario[f+1][c]=Integer.toString(k);
       }
       
        if(matrizcontrol[f][c-1]>=0 && matrizcontrol[f][c]>=0){
        k=matrizcontrol[f][c-1];
        matrizusuario[f][c-1]=Integer.toString(k);
            
        }
        
        if(matrizcontrol[f][c+1]>=0 && matrizcontrol[f][c]>=0){
        k=matrizcontrol[f][c+1];
        matrizusuario[f][c+1]=Integer.toString(k);
            
        }
        
        
        }//if false
            for(int i=1;i<fila-1;i++){
                   System.out.println();
                   for(int j=1;j<columna-1;j++){
                       System.out.printf("  [%s]  ",matrizusuario[i][j]); //matriz string para pruebas.
                       //System.out.printf("  [%d]  ",matrizcontrol[i][j]);
                   }//forj
               }//fori
            
            if(matrizcontrol[f][c]<0){
                System.out.printf("%n%s%n%s%n","           Perdiste","          GAME OVER");
                System.out.println("        Solucion:");
                solucion();
                //Aca metodo para imprimir solucion
            }else{
                System.out.println();
                
            ganar();
            }
            
    }
   






}
