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
public  class Elipse extends Figura
{
    public static double PI=3.1416;
    
    public Elipse(String color, double area, int xPosition, int yPosition)
    {
        super(color, area, xPosition, yPosition);
    }

    /*
     * Draw the circle with current specifications on screen.
     */
    public void draw(){
        if(isVisible) {
            double diameter = calcularLado(area);
            double side = 2*diameter;
            Canvas circle = Canvas.canvas;
            circle.draw(this, color, 
                new Ellipse2D.Double(xPosition, yPosition, 
                (int)diameter, side));
        }
    }
    private double calcularLado(double area){
        return Math.pow(area/2*PI,0.5);
    }


}
