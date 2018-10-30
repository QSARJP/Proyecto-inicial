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
     * @param shape forma de la nacion
     * @param area, indica el area que tendra la nacion
     * @param color, indica el color que tendra la nacion
     * @position, indica la posicion en que se va a ubicar la nacion en el conquer world
     * @armiesNeeded, indica las armies necesarios para conquistar la nacion
     */
    public ArmyNation(String shape, int area, String color, int[] position, int armiesNeeded)
    {
        super(shape,area,color,position,armiesNeeded);
        newArmy("normal");
        newArmy("proactive");
        newArmy("wanderer");
    }
    /**
     * Borra la nacion del conquer world
     */
    public void borrar(){
        Canvas canvas = Canvas.canvas;
        canvas.erase(figura);
    }
    /**
     * Remueve la nacion de las rutas de la nacion
     */
    public void removeRoute(Nation nation){
        elimiateRoute(nation);
    }
    
}
