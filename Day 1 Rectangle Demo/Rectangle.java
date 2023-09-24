public class Rectangle{
    
    int width;
    int height;
    
    public Rectangle() {
        width = 1;
        height = 1;
    }
    
    public Rectangle(int w, int h) {
        width = w;
        height = h;
    }
    
    public double getArea() {
        double a = width * height;
        return a;
    }
    
    public void print() {
        for (int i = 0; i < height; i++) {
            printNStr(width, "*");
        }
    }
    
    public void printNStr(int n, String str) {
        for (int i = 0; i < n; i++) {
            System.out.print(str);
        }
        System.out.println();
        //System,out.print("\n");
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void setWidth(int w) {
         width = w;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public void setHeight(int h) {
         height = h;
    }
}