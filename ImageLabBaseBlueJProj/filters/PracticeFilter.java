/*Amartya Raybo Ghosh
 * Period 7
 * 5/14/22
 * Filter that inverts the color values of the image
 */
package filters;
import imagelab.*;

public class PracticeFilter implements ImageFilter {

    // Attribute to store the modified image
    ImgProvider filteredImage;

    public void filter (ImgProvider ip) {

        short[][] oR = ip.getRed(); // get a 2D array of all original red values
        short[][] oG = ip.getGreen(); // get a 2D array of all original green values
        short[][] oB = ip.getBlue(); // get a 2D array of all original blue values
        short[][] oA = ip.getAlpha(); // get a 2D array of all original alpha values (transparency)
        
        int height = oR.length; // height is the number of rows which is the length of the outer array
        int width = oR[0].length; // width is the number of columns which is the length of each inner array
        
        short[][] nR = new short[height][(int)(width*1.5)]; // declare a new array of red values of size height rows x width columns
        short[][] nG = new short[height][(int)(width*1.5)]; // declare a new array of green values of size height rows x width columns
        short[][] nB = new short[height][(int)(width*1.5)]; // declare a new array of blue values of size height rows x width columns
        short[][] nA = new short[height][(int)(width*1.5)];

        // Loop through the original image and store the modified
        // version in the newImage array
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width*1.5; col++) {
                if (col < width/3) {
                    short val = 0;
                    if (oR[row][col] > val) {
                        val = oR[row][col];
                    }
                    if (oG[row][col] > val) {
                        val = oG[row][col];
                    }
                    if (oB[row][col] > val) {
                        val = oB[row][col];
                    }
                    nR[row][col] = val;
                    nG[row][col] = val;
                    nB[row][col] = val;
                    nA[row][col] = oA[row][col];
                } else if (col < 2*width/3) {
                    nR[row][col] = oR[row][col + width/3];
                    nG[row][col] = oG[row][col + width/3];
                    nB[row][col] = oB[row][col + width/3];
                    nA[row][col] = oA[row][col + width/3];
                } else if (col < width) {
                    nR[row][col] = oR[row][col - width/3];
                    nG[row][col] = oG[row][col - width/3];
                    nB[row][col] = oB[row][col - width/3];
                    nA[row][col] = oA[row][col - width/3];
                } else {
                    if (row < height/3) {
                        nR[row][col] = oR[row][col - width];
                        if (row - 10 > 0) {
                            nG[row - 10][col] = oG[row][col - width];
                        }
                        nB[row][col] = oB[row][col - width];
                        nA[row][col] = oA[row][col - width];
                    } else if (row < 2*height/3) {
                        if (col+width/4 < width*1.5) {
                            nR[row][col+width/4] = oR[row][col - width];
                        }
                        nG[row][col] = oG[row][col - width];
                        nB[row][col] = oB[row][col - width];
                        nA[row][col] = oA[row][col - width];
                    } else {
                        nR[row][col] = oR[row][col - width];
                        if (row + 10 < height) {
                            nG[row + 10][col] = oG[row][col - width];
                        }
                        nB[row][col] = oB[row][col - width];
                        nA[row][col] = oA[row][col - width];
                    }
                }
                
            }
        }

        filteredImage = new ImgProvider(); // initialize a new ImgProvider object
        filteredImage.setColors(nR, nG, nB, nA); // create the image from the arrays of new color values
        filteredImage.showPix("Practice Filter");
    }

    public ImgProvider getImgProvider() {
        return filteredImage;
    }

    // This is what users see in the Filter menu
    public String getMenuLabel() {
        return "Practice Filter (C)";
    }

}
