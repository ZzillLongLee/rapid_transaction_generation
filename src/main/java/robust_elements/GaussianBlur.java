package robust_elements;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GaussianBlur {

    public static BufferedImage applyGaussianBlur(BufferedImage im) {
        int height = im.getHeight();
        int width = im.getWidth();
        // result is transposed, so the width/height are swapped
        BufferedImage temp =  new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
        float[] k = { 0.00598f, 0.060626f, 0.241843f, 0.383103f, 0.241843f, 0.060626f, 0.00598f };
        // horizontal blur, transpose result
        for (int y = 0; y < height; y++) {
            for (int x = 3; x < width - 3; x++) {
                float r = 0, g = 0, b = 0;
                for (int i = 0; i < 7; i++) {
                    int pixel = im.getRGB(x + i - 3, y);
                    b += (pixel & 0xFF) * k[i];
                    g += ((pixel >> 8) & 0xFF) * k[i];
                    r += ((pixel >> 16) & 0xFF) * k[i];
                }
                int p = (int)b + ((int)g << 8) + ((int)r << 16);
                // transpose result!
                temp.setRGB(y, x, p);
            }
        }
        return temp;
    }
}
