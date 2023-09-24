/*Amartya Raybo Ghosh
 * Period 7
 * 5/14/22
 * Filter that doubles width of image
 */
package filters;
import imagelab.*;

public class DoubleWideColor implements ImageFilter {

    ImgProvider filteredImage;

    public void filter (ImgProvider ip) {
	short[][] oR = ip.getRed(); // get a 2D array of all original red values
	short[][] oG = ip.getGreen(); // get a 2D array of all original green values
	short[][] oB = ip.getBlue(); // get a 2D array of all original blue values
	short[][] oA = ip.getAlpha(); // get a 2D array of all original alpha values (transparency)

	int height = oR.length; // height is the number of rows which is the length of the outer array
	int width = oR[0].length; // width is the number of columns which is the length of each inner array
	
	short[][] nR = new short[height][width*2]; // declare a new array of red values of size height rows x width columns
	short[][] nG = new short[height][width*2]; // declare a new array of green values of size height rows x width columns
	short[][] nB = new short[height][width*2]; // declare a new array of blue values of size height rows x width columns
	short[][] nA = new short[height][width*2]; // declare a new array of alpha values of size height rows x width columns
	
	for (int row = 0; row < height; row++) { // loop through all the rows
	    for (int col = 0; col < width; col++) { // for each row, loop through all the columns
	        nR[row][2*col] = oR[row][col];
	        nG[row][2*col] = oG[row][col];
	        nB[row][2*col] = oB[row][col];
	        nA[row][2*col] = oA[row][col];
	        nR[row][2*col+1] = oR[row][col];
	        nG[row][2*col+1] = oG[row][col];
	        nB[row][2*col+1] = oB[row][col];
	        nA[row][2*col+1] = oA[row][col];
	    }
	}
	
	filteredImage = new ImgProvider(); // initialize a new ImgProvider object
	filteredImage.setColors(nR, nG, nB, nA); // create the image from the arrays of new color values
        filteredImage.showPix("DoubleWide Image");
    }

    public ImgProvider getImgProvider() {
        return filteredImage;
    }

    // This is what users see in the Filter menu
    public String getMenuLabel() {
        return "DoubleWide Image (C)";
    }

}
