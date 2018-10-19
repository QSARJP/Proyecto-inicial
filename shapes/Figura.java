package shapes;
import java.awt.*;
import java.awt.geom.*;
import java.util.Calendar;
import java.lang.*;



/**
 * Abstract class Shape - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
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
     * vuelve invisible el circulo
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
            draw();
        }
    }
    
        /**
     * Slowly move the circle vertically
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
            draw();
        }
    }
    
    /**
     * Erase the circle on screen.
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

