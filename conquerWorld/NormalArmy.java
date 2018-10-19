package conquerWorld;
import shapes.*;

/**
 * Write a description of class NormalArmy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NormalArmy extends Army{
    public NormalArmy(int[] position){
        super(position);
        drawArmy();
    }
    
    public void drawArmy(){
        Figura fig = new Circle("orange",100,position[0],position[1]);
        newFigura(fig);
        ejercito.makeVisible();
    }
    
    public int moveArmy(Nation nation,int cash,int cost, Nation toNation){
        toNation.addArmy(this);
        moveSlow(toNation);
        acumulado += cost;
        return acumulado;
    }
    
}