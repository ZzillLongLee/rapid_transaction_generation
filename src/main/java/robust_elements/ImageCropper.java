package robust_elements;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageCropper {

    public BufferedImage cropImage(BufferedImage imgData, double amount) throws IOException {

        int height = imgData.getHeight();
        int width = imgData.getWidth();

        int targetWidth = (int)(width * amount);
        int targetHeight = (int)(height * amount);
        // Coordinates of the image's middle
        int xc = (width - targetWidth) / 2;
        int yc = (height - targetHeight) / 2;

        // Crop
        BufferedImage croppedImage = imgData.getSubimage(
                xc,
                yc,
                targetWidth, // widht
                targetHeight // height
        );
        return croppedImage;
    }

}
