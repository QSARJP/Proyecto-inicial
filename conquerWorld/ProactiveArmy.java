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
     * @param position indica
     */
    public ProactiveArmy(int[] position)
    {
        super(position);
        drawArmy();
    }
    /**
     * Dibuja el army en el conquer world
     */
    public void drawArmy(){
        
        Figura fig = new Square("orange",100,position[0],position[1]);
        newFigura(fig);
        ejercito.makeVisible();
    }
    /**
     * Mueve el army, dependiendo del tipo de army
     * @param nation desde la nacion
     * @param cash dinero que se tiene para realizar los movimientos
     * @cost costo que tiene el movimiento del army
     * @param toNation Naciona a la que se movera el army
     */    
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
