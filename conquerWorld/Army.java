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
    
    public int getAcumulado(){
        return acumulado;
    }
    
    public void moveSlow(Nation toNation){
        System.out.println(ejercito);
        ejercito.makeVisible();
        int[] posicionFinal = toNation.getPosition();
        int xDistancia = posicionFinal[0] - position[0];
        int yDistancia = posicionFinal[1] - position[1];
        ejercito.slowMoveHorizontal(xDistancia);
        ejercito.slowMoveVertical(yDistancia);
        ejercito.makeInvisible();
    }
    
    public void setAcumulado(){
        acumulado = 0;
    }
    
    public abstract void drawArmy();
    
    public abstract int moveArmy(int cost, Nation toNation);
}
