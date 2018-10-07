package shapes;
import java.awt.*;
import java.awt.geom.*;
import java.util.Calendar;
import java.lang.*;

/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle extends Figura
{
    // instance variables - replace the example below with your own
    
    public static double PI = 3.1416;
    /**
     * Constructor for objects of class Circle
     */
    public Circle(String color, double area, int xPosition, int yPosition)
    {
        super(color, area, xPosition, yPosition);
    }

    public void draw(){
        if(isVisible) {
            double diameter = calcularDiametro(area);
            Canvas circle = Canvas.canvas;
            circle.draw(this, color, 
                new Ellipse2D.Double(xPosition, yPosition, 
                diameter, diameter));
        }
    }
    
    private double calcularDiametro(double area){
        return Math.pow(4*area/PI, 0.5);
    }
    
}
