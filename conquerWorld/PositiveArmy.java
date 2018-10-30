package conquerWorld;
import shapes.*;

/**
 * Write a description of class NormalArmy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PositiveArmy extends Army{
    public PositiveArmy(int[] position){
        super(position);
        drawArmy();
    }
    /**
     * Dibuja el army en el conquer world
     */    
    public void drawArmy(){
        Figura fig = new Triangle("green",100,position[0],position[1]);
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
        toNation.addArmy(this);
        moveSlow(toNation);
        acumulado -= cost;
        return acumulado;
    }
    
}