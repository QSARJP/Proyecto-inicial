package shapes;


/**
 * Abstract class Shape - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Shape
{
    protected int xPosition;
    protected int yPosition;
    protected String color;
    private double area;
    protected boolean isVisible;
    public Shape(String color, double area, int xPosition, int yPosition){
        this.color = color;
        this.area = area;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
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
        /**
     * Erase the circle on screen.
     */
    private void erase(){
        if(isVisible) {
            Canvas circle = Canvas.canvas;
            circle.erase(this);
        }
    }
    /**
     * Dibuja la figura
     */
    public abstract void draw();
}
