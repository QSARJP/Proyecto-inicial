package conquerWorld;
import shapes.*;

/**
 * Write a description of class uniqueArmy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UniqueArmy extends Army
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class uniqueArmy
     */
    public UniqueArmy(int[] position)
    {
        super(position);
        drawArmy();
    }

    public void drawArmy(){
        Figura fig = new Circle("red",200,position[0],position[1]);
        newFigura(fig);
        ejercito.makeVisible();
    }
    
    public int moveArmy(Nation nation,int cash,int cost, Nation toNation){
        return 0;
    }
}
