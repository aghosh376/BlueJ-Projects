/*Amartya Raybo Ghosh
 * Period 7
 * 5/14/22
 * Filter that inverts the color values of the image
 */
package filters;
import imagelab.*;

public class InvertColor implements ImageFilter {

    // Attribute to store the modified image
    ImgProvider filteredImage;

    public void filter (ImgProvider ip) {

        short[][] oR = ip.getRed(); // get a 2D array of all original red values
        short[][] oG = ip.getGreen(); // get a 2D array of all original green values
        short[][] oB = ip.getBlue(); // get a 2D array of all original blue values
        short[][] oA = ip.getAlpha(); // get a 2D array of all original alpha values (transparency)
        
        int height = oR.length; // height is the number of rows which is the length of the outer array
        int width = oR[0].length; // width is the number of columns which is the length of each inner array
        
        short[][] nR = new short[height][width]; // declare a new array of red values of size height rows x width columns
        short[][] nG = new short[height][width]; // declare a new array of green values of size height rows x width columns
        short[][] nB = new short[height][width]; // declare a new array of blue values of size height rows x width columns
        short[][] nA = new short[height][width];

        // Loop through the original image and store the modified
        // version in the newImage array
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                nR[row][col] = (short)(255-oR[row][col]);
                nG[row][col] = (short)(255-oG[row][col]);
                nB[row][col] = (short)(255-oB[row][col]);
                nA[row][col] = oA[row][col];
            }
        }

        filteredImage = new ImgProvider(); // initialize a new ImgProvider object
        filteredImage.setColors(nR, nG, nB, nA); // create the image from the arrays of new color values
        filteredImage.showPix("Invert Image");
    }

    public ImgProvider getImgProvider() {
        return filteredImage;
    }

    // This is what users see in the Filter menu
    public String getMenuLabel() {
        return "Invert Image (C)";
    }

}
