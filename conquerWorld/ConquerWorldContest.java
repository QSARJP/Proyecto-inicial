package conquerWorld; 

import java.util.*; 
import java.lang.*; 
import java.io.*;
import java.util.concurrent.TimeUnit;
/**
 * Write a description of class ConquerWorldContest here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
    private void node(int [][] armies){
        int l=0;
        for (int[] i : armies){
            l+=1;
        }
        V=l;
    }
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        
        int cost = solveSimualte(dist,armies,cw);
        return cost;
    }
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
            System.out.println(armies[i][0]);
            if (armies[i][0] <1){
            }else if (armies[i][0] <2){
                cw.addArmy(color[colorR]);
            }else{
                for (int j =0 ; j<armies[i][0];j++){
                    cw.addArmy(color[colorR]);
                }
            }
        }  
    }
    private int solveSimualte(int dist[][],int [][] armies,ConquerWorld cw)
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
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
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
