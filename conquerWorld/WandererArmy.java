package conquerWorld;
import shapes.*;

/**
 * Write a description of class wandererArmy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WandererArmy extends Army
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class wandererArmy
     */
    public WandererArmy(int[] position)
    {
        super(position);
        drawArmy();
    }

    public void drawArmy(){
        Figura fig = new Triangle("orange",100,position[0],position[1]);
        newFigura(fig);
        ejercito.makeVisible();
    }
    
    public int moveArmy(int cash,int cost, Nation toNation){
        acumulado += cost;
        int i =0;
        while (cash<toNation.getMenorCosto()){
            toNation.addArmy(this);
            moveSlow(toNation);
            if(i + 1 != 2){
                toNation.removeArmy(toNation.getSizeArmies()-1);
            }
            if(i>0){
                acumulado += toNation.getMenorCosto();
            }
            toNation = toNation.getNation();
            i+=1;
        }
        return acumulado;
    }
}