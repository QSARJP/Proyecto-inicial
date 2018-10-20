package conquerWorld;
import java.util.*;
import shapes.*;

/**
 * Write a description of class ArmyNation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArmyNation extends Nation
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class ArmyNation
     */
    public ArmyNation(String shape, int area, String color, int[] position, int armiesNeeded)
    {
        super(shape,area,color,position,armiesNeeded);
        newArmy("normal");
        newArmy("proactive");
        newArmy("wanderer");
    }

    public void borrar(){
        Canvas canvas = Canvas.canvas;
        canvas.erase(figura);
    }
    
    public void removeRoute(Nation nation){
        elimiateRoute(nation);
    }
    
}
