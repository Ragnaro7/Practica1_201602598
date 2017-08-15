
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
    
    public void randomMatriz(){
        
        while(minas>0){
           
        filar=1+ale.nextInt(fila-1-1);
        columnar=1+ale.nextInt(columna-1-1);
        System.out.println(filar+" "+columnar);
        if(matrizcontrol[filar][columnar]==0){
            matrizcontrol[filar][columnar]=-50;
            minas=minas-1;
        }
        
        }
        //igualarMatriz();
        minasAlrededor();
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
    
    public void impMatriz(){
   
        for(int i=1;i<fila-1;i++){
            System.out.println();
            for(int j=1;j<columna-1;j++){
                System.out.printf("  [%s]  ",matrizusuario[i][j]); //matriz string para pruebas.
                //System.out.printf("  [%d]  ",matrizcontrol[i][j]);
            }//forj
        }//fori
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
        
        
        voltear();
        //impMatriz();
    }//minasAlrededor


    public void voltear(){
        Scanner sc=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);
        System.out.println("\nIngrese una fila");
        int vfila=sc.nextInt();
        if(vfila>fila-2 || vfila<=0){
            System.out.printf("%n%s%n","Fila no valida, intente de nuevo");
            voltear();
        }
        System.out.println("\nIngrese una columna");
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
        
    }//voletar
    
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
            
        int k;//desde aqui pendejo solo borra el if
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
                System.out.println("Solucion:\n");
                //Aca metodo para imprimir solucion
            }else{
                System.out.println();
            voltear();
            }
            
    }
   






}
