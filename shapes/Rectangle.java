package shapes;


/**
 * Abstract class Rectangle - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public class Rectangle extends Figura
{
    public Rectangle(String color, double area, int xPosition, int yPosition){
        super(color, area, xPosition, yPosition);
    }
    
    public void draw(){
        if(isVisible) {
            double medida = calcularMedida(area);
            Canvas rectangle = Canvas.canvas;
            rectangle.draw(this, color,
                new java.awt.Rectangle(xPosition, yPosition, (int)medida, (int)medida*2));
           
        }
    }
    
    public double calcularMedida(double area){
        return Math.pow(area/2,0.5);
    }
}
