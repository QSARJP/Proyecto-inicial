package conquerWorld; 

import java.util.*; 
import java.lang.*; 
import java.io.*;
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
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int solve(int routes[][],int [][] armies)
    {
        node(armies);
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
