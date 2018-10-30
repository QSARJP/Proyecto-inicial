package conquerWorld; 

import java.util.*; 
import java.lang.*; 
import java.io.*;
import java.util.concurrent.TimeUnit;
/**
 * En ConquerWorldContest se realiza las especificaciones del ciclo 3
 *
 * @author Ospina-Rivera
 * 
 * @version (a version 28/10/18)
 */
public class ConquerWorldContest
{
    // instance variables - replace the example below with your own
 
    final static int INF =999999999;
    private int V;
    private ArrayList<Integer> visitados;
    public ConquerWorld cw;
    
    /**
     * Constructor for objects of class ConquerWorldContest
     */
    public ConquerWorldContest()
    {
      
    }
    /*
     * revisa cuantos nodos tiene y actualiza el dato en una vaiable gobal en la clase
     */  
    private void node(int [][] armies){
        int l=0;
        for (int[] i : armies){
            l+=1;
        }
        V=l;
    }
    /*
     * crea una matriz de 'Inf' dependiendo de los nodos
     */  
    private int[][] crearMatriz(int[][] routes){
        int [] lista ={0,0};
        int dist[][] = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j){
                   dist[i][j] = 0;
                }else {
                    dist[i][j] = INF; 
                }
            }
        }
        for (int i = 0; i < V-1; i++) {
            int result =routes[i][2];
            for (int j = 0; j < 2; j++) {
                lista[j]=routes[i][j];
            }
            dist[lista[0]-1][lista[1]-1]=result;
            dist[lista[1]-1][lista[0]-1]=result;
        }
        return dist;
    }
    /*
     * realiza el algortimo de ruta mas corta floydWrshall
     */  
    private int[][] floydWarshall(int[][] dist){
        for (int k = 0; k < V; k++) 
        { 
            for (int i = 0; i < V; i++) 
            { 
                for (int j = 0; j < V; j++) 
                { 
                    if (dist[i][k] + dist[k][j] < dist[i][j]) 
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                } 
            } 
        } 
        return dist;
    }
    /**
     * Realiza la solucion de la maraton ConquerWorld
     *
     * @param     routes [][]  una matriz de rutas
     * @param     armies [][]  una matriz de armies
     * @return    la solucion del ejercicio
     */
    public int solve(int routes[][],int [][] armies)
    {
        node(armies);
        int dist[][]=crearMatriz(routes);
        dist = floydWarshall(dist);
        ArrayList<Integer> conquistados = new ArrayList<>();
        int node = 0,indice=0,cost=0;
        while (conquistados.size() < V && node < V){
            visitados = new ArrayList<>();     
            while(armies[node][0]<armies[node][1]){
                indice=valorMinimo(dist[node]);
                if (armies[indice][0]>armies[indice][1]){
                    armies[indice][0] -=1;
                    armies[node][0] +=1;
                    cost +=dist[node][indice];
                }else{
                    visitados.add(indice);
                }
            }
            conquistados.add(node);
            node+=1;
        }
        System.out.println(cost);
        return cost;
    }
    /**
     * Simula un ambiente de conquista de mundo pero solo si el numero de nodos es menor al los colores
     *
     * @param     routes [][]  una matriz de rutas
     * @param     armies [][]  una matriz de armies
     * @param     slow si se desa ver la simualcion despacio o rapido
     * @return    la solucion del ejercicio
     */
    public int simulate(int routes[][],int [][] armies,boolean slow){
        node(armies);
        ConquerWorld cw = new ConquerWorld(500, 500);
        cw.addCash(INF);
        int dist[][]=crearMatriz(routes);
        addNations(armies,cw);  
        for (int i = 0 ; i<V ; i++){
            for (int j = i ; j<V; j++){
                if (dist[i][j]!=INF){
                    String [] routa = {cw.getNations().get(i),cw.getNations().get(j)};
                    cw.addRoute(routa,dist[i][j]);
                    if (slow ==true){
                        try
                        {
                            Thread.sleep(250);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }
        int cost = solveSimualte(dist,armies,cw,slow);
        return cost;
    }
    /*
     * registra las naciones graficamento en la simualcion
     */
    private void addNations(int [][] armies,ConquerWorld cw){
        String color [] = {"green","black","blue","yellow","magenta","pink","red","cyan","orange","gray","darkGray","lightGray"};
        String shape [] = {"Circle","Triangle","Rectangle","Elipse","Square"};
        for (int i = 0 ; i<V ; i++){
            int x = (int) (Math.random() * 500) ;
            int y = (int) (Math.random() * 500);
            int pos[] = {x,y};
            int colorR = (int) (Math.random() * 11) ;
            int shapeR = (int) (Math.random() * 4) ;
            while (cw.getNations().contains(color[colorR])){
                colorR = (int) (Math.random() * 9) ;
                shapeR = (int) (Math.random() * 4) ;
            }
            cw.addNation(shape[shapeR],500,color[colorR],pos,armies[i][1]);
            for (int j =0 ; j<armies[i][0];j++){
                cw.addArmy(color[colorR]);
            }
        }
    }
    /*
     * soluciona la simualcion pero teniendo en cuenta el movimeinto de las armies
     */
    private int solveSimualte(int dist[][],int [][] armies,ConquerWorld cw,boolean slow)
    {
        dist = floydWarshall(dist);
        ArrayList<Integer> conquistados = new ArrayList<>();
        int node = 0,indice=0,cost=0;
        while (conquistados.size() < V && node < V){
            visitados = new ArrayList<>();     
            while(armies[node][0]<armies[node][1]){
                indice=valorMinimo(dist[node]);
                if (armies[indice][0]>armies[indice][1]){
                    armies[indice][0] -=1;
                    armies[node][0] +=1;
                    cw.moveArmy(cw.getNations().get(indice),cw.getNations().get(node));
                    cost +=dist[node][indice];
                    if (slow==true){
                        try
                        {
                            Thread.sleep(250);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }else{
                    visitados.add(indice);
                }
            }
            conquistados.add(node);
            node+=1;
        }
        System.out.println(cost);
        return cost;
    }
    /*
     * es el valor minimo de una lista
     */
    private int valorMinimo(int[] lista){
        int min=INF;
        int indice=0;
        for (int i = 0; i<V-1; i++){
            if (min>lista[i] && lista[i]!=0 && visitados.size()>0 ){
                if (!visitados.contains(i)){
                    min = lista[i];
                    indice = i;
                }
               
            }else if (min>lista[i] && lista[i]!=0 ){
                min = lista[i];
                indice = i;
            }
                
        }   
        return indice;
    }
    /*
     * imprime la solucion matricialmente
     */
    private void printSolution(int dist[][]) 
    { 
        for (int i=0; i<V; ++i) 
        { 
            for (int j=0; j<V; ++j) 
            { 
                 System.out.print(dist[i][j]+"   "); 
            } 
            System.out.println(); 
        } 
    } 
}
