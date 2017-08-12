
package practica1_201602598;

import java.util.Random;

/**
 *
 * @author Hector
 */
public class LlenarMatriz_201602598 {

    private int fila;
    private int columna;
    Random ale=new Random();
    private String matrizusuario[][];
    private int matrizcontrol[][];
    private int filar,columnar;
    public LlenarMatriz_201602598(int fila, int columna){
        
        this.fila=fila;
        this.columna=columna;
        
        
    }
    
   /* public void generarMatriz(){
        matrizusuario=new String[fila][columna];
        matrizcontrol=new int[fila][columna];
        
    }*/
    
    public void randomMatriz(){
        matrizusuario=new String[fila][columna];
        matrizcontrol=new int[fila][columna];
        
        int contador=1;
        while(contador<5){
           
        filar=1+ale.nextInt(fila-1);
        columnar=1+ale.nextInt(columna-1);
        System.out.println(filar+" "+columnar);
        if(matrizcontrol[filar][columnar]==0){
            matrizcontrol[filar][columnar]=-1;
            contador=contador+1;
        }
        
        }
        
        for(int i=1;i<fila;i++){
            
            for(int j=1;j<columna;j++){
                
            if(matrizcontrol[i][j]==-1){
                matrizusuario[i][j]="*";
            }
                
            }
        
        }
        
        impMatriz();
    }

    public void impMatriz(){
   
        for(int i=1;i<fila;i++){
            System.out.println();
            for(int j=1;j<columna;j++){
                System.out.printf("[%s]",matrizusuario[i][j]);
                //System.out.printf("[%d]",matrizcontrol[i][j]);
            }
        }
    }
}
