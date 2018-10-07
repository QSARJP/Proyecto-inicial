package shapes;
import java.awt.*;
import java.awt.geom.*;
import java.util.Calendar;
import java.lang.*;

/**
 * Abstract class Triangle - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public class Triangle extends Figura
{
    public Triangle(String color, double area, int xPosition, int yPosition){
        super(color, area , xPosition, yPosition);
    }
    
    public void draw(){
        if(isVisible) {
            double medida = calcularMedida(area);
            Canvas medidor = Canvas.canvas;
            int[] xpoints = { xPosition, xPosition + (((int) Math.pow(5,0.5)*(int)medida/2)/2), xPosition - (((int) Math.pow(5,0.5)*(int)medida/2)/2) };
            int[] ypoints = { yPosition, yPosition + (int)medida, yPosition + (int)medida };
            medidor.draw(this, color, new Polygon(xpoints, ypoints, 3));
        }        
    }
    
    private double calcularMedida(double area){
        return Math.pow(4*area/Math.pow(3,0.5),0.5);
    }
}
