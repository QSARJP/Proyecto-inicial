package conquerWorld;

import java.util.*;
import shapes.*;
/**
 * clase NationSteady no se puede eliminar ni mover.
 *
 * @author Ospina-Rivera
 * 
 * @version (a version 28/10/18)
 */
public class SteadyNation extends Nation
{
    // instance variables - replace the example below with your own
    String type;
    /**
     * Constructor for objects of class NationSteady
     * @param shape forma de la nacion
     * @param area, indica el area que tendra la nacion
     * @param color, indica el color que tendra la nacion
     * @position, indica la posicion en que se va a ubicar la nacion en el conquer world
     * @armiesNeeded, indica las armies necesarios para conquistar la nacion
     */
    public SteadyNation(String shape, int area, String color, int[] position, int armiesNeeded,String newType)
    {
        // initialise instance variables
        super(shape,area,color,position,armiesNeeded);
        type = newType;
        
    }
    /**
     * Clase abstracta, se encarga de remover la ruta de la nacion
     * @param nation, remueve la nation de las rutas de la nacion
     */
    public void removeRoute(Nation nation){
        
    }
    
    /**
     * Elimina la nacion del conquer world
     */
    public void borrar(){
        
    }

}
