package shapes;
import java.awt.*;
import java.awt.geom.*;
import java.util.Calendar;
import java.lang.*;



/**
 * Se realiza la superclase figura la cual contiene todos los emtodos necesarios para su representacion
 *
 * @author Ospina-Rivera
 * 
 * @version (a version 28/10/18)
 */
public abstract class Figura
{
    protected int xPosition;
    protected int yPosition;
    protected String color;
    protected double area;
    protected boolean isVisible;
    public Figura(String color, double area, int xPosition, int yPosition){
        this.color = color;
        this.area = area;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.isVisible = false;
    }
        /**
     * vuelve visible la figura
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    /**
     * vuelve invisible el figura
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    /**
     * Cambia de color dependiendo el nombre    
     * @param newColor nombre del color.
     */
    public void changeColor(String newColor){
        color = newColor;
        draw();
    }
    /**
     * Slowly move the figura horizontal
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int xDistance){
        int delta;
        if(xDistance < 0) {
            delta = -1;
            xDistance = -xDistance;
        } else {
            delta = 1;
        }
  
        for(int i = 0; i < xDistance; i++){
            xPosition += delta;
            try
            {
              Thread.sleep(5);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            draw();
        }
    }
    
        /**
     * Slowly move the figura vertically
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance){
        int delta;
        if(distance < 0) {
            delta = -1;
            distance = -distance;
        }else {
            delta = 1;
        }
        
        for(int i = 0; i < distance; i++){
            yPosition += delta;
            try
            {
              Thread.sleep(5);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            draw();
        }
    }
    
    /**
     * Erase the figura on screen.
     */
    private void erase(){
        if(isVisible) {
            Canvas shape = Canvas.canvas;
            shape.erase(this);
        }
    }
    public int[] getPosition(){
        int[] posiciones = {xPosition,yPosition};
        return posiciones;
    }
    /**
     * Dibuja la figura
     */
    public abstract void draw();
    
}

