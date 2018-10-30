package conquerWorld;
import shapes.*;

/**
 * clase wandererArmy solamente se mueve hasta que se queda sin cash.
 *
 * @author Ospina-Rivera
 * 
 * @version (a version 28/10/18)
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
    /**
     * Dibuja el army en el conquer world
     */
    public void drawArmy(){
        Figura fig = new Triangle("orange",100,position[0],position[1]);
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
        int cash2 = cash;
        int i =0;
        acumulado += cost;
        while (cash2>=nation.getMenorCosto()){
            toNation.addArmy(this);
            moveSlow(toNation);
            cash2-=nation.getMenorCosto();
            if(cash2 - nation.getMenorCosto() >= 0 ){
                toNation.removeArmy(toNation.getSizeArmies()-1);
            }
            if(i>0){
                acumulado += nation.getMenorCosto();
            }
            nation = toNation;
            toNation = toNation.getNation();
            i+=1;
        }
        return acumulado;
    }
}
