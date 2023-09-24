/*Amartya Raybo Ghosh
 * Period 7
 * 5/12/22
 * Filter that increases or decreases contrast based on user input
 */
package filters;
import imagelab.*;
import javax.swing.JOptionPane;

public class ContrastBW implements ImageFilter {

    // Attribute to store the modified image
    ImgProvider filteredImage;

    public void filter (ImgProvider ip) {

        // Grab the pixel information and put it into a 2D array
        short[][] im = ip.getBWImage();

        // Make variables for image height and width
        int height = im.length;
        int width  = im[0].length;

        //Get number of colors the image will have
        String answer = JOptionPane.showInputDialog("Enter value between 0.0 and 2.0: ");
        double conVal = Double.parseDouble(answer);

        // Create a new array to store the modified image
        short[][] newImage = new short[height][width];

        // Loop through the original image and store the modified
        // version in the newImage array
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                double temp = im[row][col]/255.0;
                temp -= 0.5;
                temp *= conVal;
                temp += 0.5;
                temp *= 255;
                if (temp > 255) temp = 255;
                if (temp < 0) temp = 0;
                
                newImage[row][col] = (short)(temp);
            }
        }

        // Create a new ImgProvider and set the filtered image to our new image
        filteredImage = new ImgProvider();
        filteredImage.setBWImage(newImage);

        // Show the new image in a new window with title "Flipped Horizontally"
        filteredImage.showPix("Contrast Image");
    }

    public ImgProvider getImgProvider() {
        return filteredImage;
    }

    // This is what users see in the Filter menu
    public String getMenuLabel() {
        return "Contast Image (BW)";
    }

}
