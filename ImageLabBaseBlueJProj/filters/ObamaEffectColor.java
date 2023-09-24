/*Amartya Raybo Ghosh
 * Period 7
 * 5/14/22
 * Filter that shifts color to be more blue or red depending on darkness
 */
package filters;
import imagelab.*;

public class ObamaEffectColor implements ImageFilter {

    ImgProvider filteredImage;

    public void filter (ImgProvider ip) {
        short[][] oR = ip.getRed(); // get a 2D array of all original red values
        short[][] oG = ip.getGreen(); // get a 2D array of all original green values
        short[][] oB = ip.getBlue(); // get a 2D array of all original blue values
        short[][] oA = ip.getAlpha(); // get a 2D array of all original alpha values (transparency)
        short[][] oBW = ip.getBWImage(); //get a 2D array of the black and white pixels
        
        int height = oR.length; // height is the number of rows which is the length of the outer array
        int width = oR[0].length; // width is the number of columns which is the length of each inner array
        
        short[][] nR = new short[height][width]; // declare a new array of red values of size height rows x width columns
        short[][] nG = new short[height][width]; // declare a new array of green values of size height rows x width columns
        short[][] nB = new short[height][width]; // declare a new array of blue values of size height rows x width columns
        short[][] nA = new short[height][width]; // declare a new array of alpha values of size height rows x width columns
        
        for (int row = 0; row < height; row++) { // loop through all the rows
            for (int col = 0; col < width; col++) { // for each row, loop through all the columns
                if (oBW[row][col] > 127 + 20) {
                    nR[row][col] = oR[row][col];
                    nG[row][col] = (short)(oBW[row][col]*0.25);
                    nB[row][col] = (short)(oBW[row][col]*0.25);
                    nA[row][col] = oA[row][col];
                } else if(oBW[row][col] < 127 - 20) {
                    nR[row][col] = (short)(oBW[row][col]*0.25);
                    nG[row][col] = (short)(oBW[row][col]*0.25);
                    nB[row][col] = oB[row][col];
                    nA[row][col] = oA[row][col];
                } else {
                    nR[row][col] = (short)(oBW[row][col]*0.5);
                    nG[row][col] = (short)(oBW[row][col]*0.5);
                    nB[row][col] = (short)(oBW[row][col]*0.5);
                    nA[row][col] = (short)(oBW[row][col]*0.5);
                }
            }
        }
        
        filteredImage = new ImgProvider(); // initialize a new ImgProvider object
        filteredImage.setColors(nR, nG, nB, nA); // create the image from the arrays of new color values
        filteredImage.showPix("Obama Image");
    }

    public ImgProvider getImgProvider() {
        return filteredImage;
    }

    // This is what users see in the Filter menu
    public String getMenuLabel() {
        return "Obama Image (C)";
    }

}
