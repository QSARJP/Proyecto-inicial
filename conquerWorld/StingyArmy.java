package conquerWorld;
import shapes.*;

/**
 * Write a description of class stingyArmy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StingyArmy extends Army
{
    // instance variables - replace the example below with your own
 

    /**
     * Constructor for objects of class stingyArmy
     */
    public StingyArmy(int[] position)
    {
        super(position);
        drawArmy();
    }

    public void drawArmy(){
        Figura fig = new Rectangle("green",100,position[0],position[1]);
        newFigura(fig);
        ejercito.makeVisible();
    }
    
    public int moveArmy(int cash,int cost, Nation toNation){
        return 0;
    }
}
