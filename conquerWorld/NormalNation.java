package conquerWorld;
import java.util.*;
import shapes.*;

/**
 * clase NationNormal es una nacion sin ninguna especificacion.
 *
 * @author Ospina-Rivera
 * 
 * @version (a version 28/10/18)
 */
public class NormalNation extends Nation
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class NationNormal
     * @param shape forma de la nacion
     * @param area, indica el area que tendra la nacion
     * @param color, indica el color que tendra la nacion
     * @position, indica la posicion en que se va a ubicar la nacion en el conquer world
     * @armiesNeeded, indica las armies necesarios para conquistar la nacion
     */
    public NormalNation(String shape, int area, String color, int[] position, int armiesNeeded)
    {
        super(shape,area,color,position,armiesNeeded);
    }
    /**
     * elimina la ruta de la nacion
     * @param nation, nacion que se eliminará de las rutas
     */
    public void removeRoute(Nation nation){
        elimiateRoute(nation);
    }
    /**
     * Elimina la nacion del conquer wolrd
     */
    public void borrar(){
        Canvas canvas = Canvas.canvas;
        canvas.erase(figura);
    }
   
}
