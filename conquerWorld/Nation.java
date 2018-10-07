package conquerWorld;
import java.util.*;
import shapes.*;

/**
 * Write a description of class Nation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Nation
{
    private String name;
    private String shape;
    private int area;
    private String color;
    private int[] position;
    private int armiesNeeded;
    private ArrayList<Army> armies = new ArrayList<Army>();
    private ArrayList<String> rutas = new ArrayList<String>();
    public static double PI=3.1416;
    private Object figura;
    /**
     * Constructor for objects of class Nation
     * @param shape Indica la forma de la nacion
     * @param area Indica el area que tendra la nacion en el conquerWorld
     * @param color Indica el color y el nombre de la nación
     * @param position Indica las coordenas x y y donde se ubicará la nación
     * @param armiesNeeded Indica los ejercitos que son necesarios para conquistar la nación
     */
    public Nation(String shape, int area, String color, int[] position, int armiesNeeded)
    {
       this.shape = shape;
       this.area = area;
       this.color = color;
       this.position = position;
       this.armiesNeeded = armiesNeeded;
       
    }
    public String getName(){
        return color;
    }
    /**
     * Agrega un ejercito a la nacion actual
     */
    public void addArmy(){
        armies.add(new Army());
    }
    /**
     * Remueve un ejercito de la nacion actual
     */
    public void removeArmy(){
        armies.remove(0);
    }
    /**
     * Limpia la lista de ejercitos de la nación actual
     */
    public void clearArmies(){
        armies.clear();
    }
    /**
     * Agrega a la lista de rutas, la nacion de destino de la nación actual
     */
    public void addRoute(String nation){
        rutas.add(nation);
    }
    /**
     * Remueve la nacion de la lista de rutas de la nacion actual
     */
    public void removeRoute(String nation){
        rutas.remove(nation);
    }
    public int getSizeArmies(){
        return armies.size();
    }
    public int getSizeRoutes(){
        return rutas.size();
    }
    public ArrayList<String> getRoutes(){
        Collections.sort(rutas);
        return rutas;
    }
    public int[] getPosition(){
        return position;
    }
    /**
     * Devuelve true si la nacion actual esta conquistada, false de lo contrario
     */
    public boolean conquered(){
        if (getSizeArmies() >= armiesNeeded){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Crea la figura correspondienta a la nación
     * @param shape Indica la forma de la nacion
     * @param area Indica el area que tendra la nacion en el conquerWorld
     * @param color Indica el color y el nombre de la nación
     * @param position Indica las coordenas x y y donde se ubicará la nación
     */
    public void crear(String shape, int area, String color, int[] position){
        
        
        if (shape.equals("Circle")){
            Figura figura = new Circle(color,area,position[0],position[1]);
        }
        else if (shape.equals("Rectangle")){
            Figura figura = new Rectangle(color,area,position[0],position[1]);
        }
        else if (shape.equals("Square")){
            Figura figura = new Square(color,area,position[0],position[1]);
        }
        else if (shape.equals("Triangle")){
            Figura figura = new Triangle(color,area,position[0],position[1]);
        }
        else if (shape.equals("Elipse")){
             Figura figura = new Elipse(color,area,position[0],position[1]);
        }
        this.area=area;
        figura.makeVisible();
    }
    public int getArmiesNeeded(){
        return armiesNeeded;
    }
    public int getArea(){
        return area;
    }
    public String getShape(){
        return shape;
    }
    /**
     * Elimina la figura
     */
    public void borrar(){
        Canvas canvas = Canvas.canvas;
        canvas.erase(figura);
    }
    
    /**
     * reset todas las arrayList que contiene el objeto Nation
     */
    public void reset(){
        ArrayList<Army> armies = null;
        ArrayList<String> rutas = null;;
    }
}
