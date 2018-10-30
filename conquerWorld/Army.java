package conquerWorld;
import shapes.*;

public abstract class Army
{
    // instance variables - replace the example below with your own
    protected int[] position;
    protected Figura ejercito;
    protected int acumulado;
    /**
     * Constructor for objects of class Army
     */
    public Army(int[] position){
        this.position = position;
        this.acumulado = 0;
        
    }
    
    /**
     * Elimina la armie del conquer world
     */
    public void erase(){
        ejercito.makeInvisible();
    }
    
    public int getAcumulado(){
        return acumulado;
    }
    /**
     * Crea el objeto que guarda la figura
     * Param fig figura que se guarda
     */
    public void newFigura(Figura fig){
        ejercito = fig;
    }
    /**
     * Se encarga de mover lentamente el ejercito
     * @param toNation Nacion a la que se va a mover el army
     */
    public void moveSlow(Nation toNation){
        int[] posicionFinal = toNation.getPosition();
        int xDistancia = posicionFinal[0] - position[0];
        int yDistancia = posicionFinal[1] - position[1];
        ejercito.slowMoveHorizontal(xDistancia);
        ejercito.slowMoveVertical(yDistancia);
        changePosition(posicionFinal);
    }
    /**
     * Cambia la posicion del army
     * newPosition nueva posicion del army
     */
    private void changePosition(int[] newPosition){
        position[0]=newPosition[0];
        position[1]=newPosition[1];
    }
    public void setAcumulado(){
        acumulado = 0;
    }
    /**
     * Dibuja el army en el conquer world
     */
    public abstract void drawArmy();
    /**
     * Mueve el army, dependiendo del tipo de army
     * @param nation desde la nacion
     * @param cash dinero que se tiene para realizar los movimientos
     * @cost costo que tiene el movimiento del army
     * @param toNation Naciona a la que se movera el army
     */
    public abstract int moveArmy(Nation nation,int cash,int cost, Nation toNation);
}
