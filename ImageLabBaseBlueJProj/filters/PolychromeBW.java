/*Amartya Raybo Ghosh
 * Period 7
 * 5/12/22
 * Filter that depicts the image with a user requested number of colors
 * More colors gives greater detail
 */
package filters;
import imagelab.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PolychromeBW implements ImageFilter {

    // Attribute to store the modified image
    ImgProvider filteredImage;

    public void filter (ImgProvider ip) {

        // Grab the pixel information and put it into a 2D array
        short[][] im = ip.getBWImage();

        // Make variables for image height and width
        int height = im.length;
        int width  = im[0].length;
        
        //Get number of colors the image will have
        String answer = JOptionPane.showInputDialog("Enter number of colors: ");
        int numCol = Integer.parseInt(answer);

        // Create a new array to store the modified image
        short[][] newImage = new short[height][width];

        // Loop through the original image and store the modified
        // version in the newImage array
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                for(int i = 0; i < numCol; i++) {
                    if (im[row][col] > (i*(255/numCol)) && im[row][col] <= ((i+1)*(255/numCol)) && numCol > 2){
                        if (i + 1 == numCol) {
                            newImage[row][col] = (255);
                        } else {
                            newImage[row][col] = (short)((i)*(255/(numCol - 1)));
                        }
                    } else if (numCol <= 2) {
                        if (im[row][col] <= 256/2) {
                            newImage[row][col] = 0;
                        } else {
                            newImage[row][col] = 255;
                        }
                    }
                }
            }
        }

        // Create a new ImgProvider and set the filtered image to our new image
        filteredImage = new ImgProvider();
        filteredImage.setBWImage(newImage);

        // Show the new image in a new window with title "Flipped Horizontally"
        filteredImage.showPix("Polychrome Image");
    }

    public ImgProvider getImgProvider() {
        return filteredImage;
    }

    // This is what users see in the Filter menu
    public String getMenuLabel() {
        return "Polychrome Image (BW)";
    }

}
