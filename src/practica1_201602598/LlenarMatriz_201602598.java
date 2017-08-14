
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
        System.out.println("Ingrese una fila");
        int vfila=sc.nextInt();
        System.out.println("Ingrese una columna");
        int vcolumna=sc.nextInt();
        System.out.println("Esta seguro? Y/N");
        String seguro=sc2.nextLine();
        if(seguro.equalsIgnoreCase("y")){
            impMatrizusuario(vfila,vcolumna);
        }else if(seguro.equalsIgnoreCase("n")){
         impMatriz();   
        }else {System.out.println("Opcion no valida, intente una vez mas");
        System.out.println();    
        voltear();
        }
        
    }//voletar
    
    public void verificarvolter(){
        
    }
    
    public void impMatrizusuario(int f,int c){
        int k;
        if(matrizcontrol[f][c]>=0){
            k=matrizcontrol[f][c];
            if(matrizusuario[f][c]==Integer.toString(k)){
                System.out.println("Ya selecciono esta posicion");
            }else{
                matrizusuario[f][c]=Integer.toString(k);
            }
            
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
        
            for(int i=1;i<fila-1;i++){
                   System.out.println();
                   for(int j=1;j<columna-1;j++){
                       System.out.printf("  [%s]  ",matrizusuario[i][j]); //matriz string para pruebas.
                       //System.out.printf("  [%d]  ",matrizcontrol[i][j]);
                   }//forj
               }//fori
            
            if(matrizcontrol[f][c]<0){
                System.out.println();
                System.out.println("PERDISTE");
                System.out.println("GAME OVER");
            }else{
                System.out.println();
            voltear();
            }
            
    }
   






}
