package BufferedImageGeneration;

import com.github.kilianB.hashAlgorithms.AverageHash;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class BufferedImageGenerator {

    public static BufferedImage extractBufferedImage (String imageFilePath) throws IOException {
        // open image
        File imgPath = new File(imageFilePath);
        BufferedImage bufferedImage = ImageIO.read(imgPath);
        return bufferedImage;
    }

    public static BufferedImage getBufferedImage(byte[] imageData){
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
