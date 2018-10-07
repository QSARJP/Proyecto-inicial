package shapes;
import java.awt.*;
import java.awt.geom.*;
import java.util.Calendar;
import java.lang.*;

/**
 * Abstract class Circle - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Circle extends Shape
{
    private double diameter;
    public Circle(String color, double area, int positionX, int positionY){
       super(color,area,positionX,positionY);
    }
   
    public void draw(){
            if(isVisible) {
            circle.draw(this, color, 
                new Ellipse2D.Double(xPosition, yPosition, 
                diameter, diameter));
        }
    }
}
