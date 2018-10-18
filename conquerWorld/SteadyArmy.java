package conquerWorld;
import shapes.*;

/**
 * Write a description of class SteadyArmy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SteadyArmy extends Army
{
    // instance variables - replace the example below with your own
    public SteadyArmy(int[] position){
        super(position);
        drawArmy();
    } 
    
    public void drawArmy(){
        ejercito = new Rectangle("orange",100,position[0],position[1]);
    }
    
    public int moveArmy(int cost,Nation toNation){
        return 0;
    }
}