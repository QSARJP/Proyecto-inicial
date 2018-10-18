package conquerWorld;
import java.util.*;
import shapes.*;

/**
 * Write a description of class Nation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Nation
{
    private String name;
    private String shape;
    private int area;
    private String color;
    private int[] position;
    private int armiesNeeded;
    private ArrayList<Army> armies = new ArrayList<Army>();
    protected TreeMap<Integer,Nation> rutas = new TreeMap<Integer,Nation>();
    public static double PI=3.1416;
    protected Figura figura;
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
    public void newArmy(String type){
        if (type.equals("normal")){
            armies.add(new NormalArmy(position));
        }
        else if(type.equals("steady")){
            armies.add(new SteadyArmy(position));
        }
        else if (type.equals("proactive")){
            armies.add(new ProactiveArmy(position));
        }
    }
    public void addArmy(Army ejercito){
        armies.add(ejercito);
    }
    /**
     * Remueve un ejercito de la nacion actual
     */
    public Army removeArmy(int valor){
        return armies.remove(valor);
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
    public void addRoute(int cost,Nation nation){
        rutas.put(cost,nation);
    }
    /**
     * Remueve la nacion de la lista de rutas de la nacion actual
     */
    public abstract void removeRoute(String nation);
    
    public int getMenorCosto(){
        return rutas.firstKey();
    }
    
    public Nation getNation(){
        return rutas.get(getMenorCosto());
    }
    
    public int getSizeArmies(){
        return armies.size();
    }
    public int getSizeRoutes(){
        return rutas.size();
    }
    public ArrayList<String> getRoutes(){
        ArrayList<String> listaRutas = new ArrayList<String>();
        for (int i: rutas.keySet()){
            Nation n = rutas.get(i);
            listaRutas.add(n.getName());
        }
        Collections.sort(listaRutas);
        return listaRutas;
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
            figura.makeVisible();
        }
        else if (shape.equals("Rectangle")){
            Figura figura = new Rectangle(color,area,position[0],position[1]);
            figura.makeVisible();
        }
        else if (shape.equals("Square")){
            Figura figura = new Square(color,area,position[0],position[1]);
            figura.makeVisible();
        }
        else if (shape.equals("Triangle")){
            Figura figura = new Triangle(color,area,position[0],position[1]);
            figura.makeVisible();
        }
        else if (shape.equals("Elipse")){
            Figura figura = new Elipse(color,area,position[0],position[1]);
            figura.makeVisible();
        }
        
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
    public abstract void borrar();
    
    /**
     * reset todas las arrayList que contiene el objeto Nation
     */
    public void reset(){
        ArrayList<Army> armies = null;
        ArrayList<String> rutas = null;;
    }
}
