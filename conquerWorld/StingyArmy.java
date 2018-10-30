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
    /**
     * Dibuja el army en el conquer world
     */
    public void drawArmy(){
        Figura fig = new Rectangle("green",100,position[0],position[1]);
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
        
        if (nation.getNation() == toNation){
            toNation.addArmy(this);
            moveSlow(toNation);
            acumulado += cost;
            return acumulado;
        }else{
            return 0;
        }
        
    }
}
