package robust_elements;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GaussianBlur {

    public BufferedImage applyGaussianBlur(String imageFilePath, int width, int height){
        //Loading the OpenCV core library
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
        Mat src = Imgcodecs.imread(imageFilePath);
        //Creating destination matrix
        Mat dst = new Mat(src.rows(), src.cols(), src.type());
        //Applying GaussianBlur on the Image
        Imgproc.GaussianBlur(src, dst, new Size(width, height), 0);
        //Converting matrix to JavaFX writable image
        Image img = HighGui.toBufferedImage(dst);
        WritableImage writableImage= SwingFXUtils.toFXImage((BufferedImage) img, null);
        BufferedImage gaussianBlurredImg = SwingFXUtils.fromFXImage(writableImage, null);
        return gaussianBlurredImg;
    }
}
