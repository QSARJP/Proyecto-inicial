package shapes;
import java.awt.*;
import java.awt.geom.*;
import java.util.Calendar;
import java.lang.*;


/**
 * Write a description of class Elipse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public  class Square extends Figura
{
    public static double PI=3.1416;
    private int side;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    
    
    public Square(String color, double area, int xPosition, int yPosition)
    {
        super(color, area, xPosition, yPosition);
    }

    /*
     * Draw the circle with current specifications on screen.
     */
    public void draw(){
        if(isVisible) {
            double height = calcularLado(area);
            Canvas rectangle = Canvas.canvas;
            rectangle.draw(this, color,
                new java.awt.Rectangle(xPosition, yPosition,(int) height,(int)height));
           
        }
    
    }
    private double calcularLado(double area){
        return Math.pow(area,0.5);
    }


}