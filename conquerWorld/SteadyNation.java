package conquerWorld;

import java.util.*;
import shapes.*;
/**
 * Write a description of class NationSteady here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SteadyNation extends Nation
{
    // instance variables - replace the example below with your own
    String type;
    /**
     * Constructor for objects of class NationSteady
     */
    public SteadyNation(String shape, int area, String color, int[] position, int armiesNeeded,String newType)
    {
        // initialise instance variables
        super(shape,area,color,position,armiesNeeded);
        type = newType;
        
    }
    
    public void removeRoute(Nation nation){
        
    }
    
    public void borrar(){
        
    }

}
