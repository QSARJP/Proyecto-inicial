package conquerWorld;
import shapes.*;

/**
 * clase uniqueArmy cuando llega a la otra nacion elimina todas las armies de la otra nacion.
 *
 * @author Ospina-Rivera
 * 
 * @version (a version 28/10/18)
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
    /**
     * Dibuja el army en el conquer world
     */
    public void drawArmy(){
        Figura fig = new Circle("red",200,position[0],position[1]);
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
        toNation.clearArmies();
        toNation.addArmy(this);
        return acumulado;
    }
}
