import java.awt.Point;

public class PenDriver {

    public static void main(String[] args) {
        // print the Pen class public static field defaultColor
        
        System.out.println("Pen.defaultColor is " + Pen.defaultColor);
        
        // change defaultColor
        Pen.defaultColor = "Cyan";
        
        // print the default color again
        System.out.println("Pen.defaultColor has changed to " + Pen.defaultColor);
        
        // call the static method printDefaults()
        Pen.printDefaults();
        
        // Create an instance of a Pen
        Pen thePen = new Pen();
        
        // print the width:
        int w = thePen.WIDTH;
        System.out.println("thePen has width " + w);
        
        // try changing the width to 5. What happens? why?
        //Width is final so it cannot be changed.
        
        // store the DEFAULT_WIDTH in local variable
        int defW = Pen.DEFAULT_WIDTH;
        
        // print the default width
        System.out.println("Default Width is " + defW);
        
        // Store the x and y coordinates of thePen in local variables x and y
        Point pos = thePen.position;
        int x = pos.x;
        int y = pos.y;
        
        // print x and y
        System.out.println("Position is (" + x + ", " + y + ")");
        
        // change the position of x coordinate
        
        
        // print the position using the toString() method
        System.out.println("Position is " + thePen.toString());
        
        // print the position without calling toString() directly
        // System.out.println will call toString for you
        System.out.println("Position is " + thePen.position);
        
        // print the Pen you created (it will call toString() for you)
        System.out.println(thePen);
        
        // try to access the color field on thePen directly.
        // What happens? why?
        //Color is private
        
        // Store the color in a local variable using the getter
        String col = thePen.getColor();
        
        // print out the color
        System.out.println("The pen color is " + col);
        
        // change the color to Green using the setter
        thePen.setColor("Green");
        col = thePen.getColor();
        
        // print out the new color
        System.out.println("The pen color is " + col);
        
        // create a Blue pen with width 3
        Pen blue3 = new Pen(3, "Blue");
        
        // use the moveTo method to move the bluePen to (3, 67)
        blue3.moveTo(3, 67);
        
        // print the position of the blue pen
        System.out.println("blue pen position is " + blue3.position);

    }

}
