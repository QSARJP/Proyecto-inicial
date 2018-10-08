package conquerWorld;
import java.util.*;
import shapes.*;

/**
 * Write a description of class NationNormal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NormalNation extends Nation
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class NationNormal
     */
    public NormalNation(String shape, int area, String color, int[] position, int armiesNeeded)
    {
        // initialise instance variables
        super(shape,area,color,position,armiesNeeded);
    }
    
    public void removeRoute(String nation){
        rutas.remove(nation);
    }
    public void borrar(){
        Canvas canvas = Canvas.canvas;
        canvas.erase(figura);
    }
   
}
