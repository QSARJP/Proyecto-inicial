package conquerWorld;
import shapes.*;

/**
 * Write a description of class ProactiveArmy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProactiveArmy extends Army
{
    
    /**
     * Constructor for objects of class ProactiveArmy
     */
    public ProactiveArmy(int[] position)
    {
        super(position);
        drawArmy();
    }

    public void drawArmy(){
        
        Figura fig = new Square("orange",100,position[0],position[1]);
        newFigura(fig);
        ejercito.makeVisible();
    }
    
    public int moveArmy(Nation nation,int cash,int cost, Nation toNation){
        acumulado += cost;
        for (int i = 0; i < 2;i++){
            toNation.addArmy(this);
            this.moveSlow(toNation);
            if(i + 1 != 2){
                toNation.removeArmy(toNation.getSizeArmies()-1);
            }
            if(i>0){
                acumulado += toNation.getMenorCosto();
            }
            toNation = toNation.getNation();
        }
        return acumulado;
    }
}
