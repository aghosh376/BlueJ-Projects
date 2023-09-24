public class RectangleDriver{
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        
        int w = rect.getWidth();
        int h = rect.getHeight();
        double a = rect.getArea();
        System.out.println("W = " + w + " H = " + h + " A = " + a);
        
        rect.print();
        
        Rectangle big = new Rectangle(10,5);
        
        System.out.println("W = " + big.getWidth() + " H = " + big.getHeight() + " A = " + big.getArea());
                
        big.print();
        
        big.setHeight(8);
        big.setWidth(3);
        
        
        System.out.println("W = " + big.getWidth() + " H = " + big.getHeight() + " A = " + big.getArea());

    }
}