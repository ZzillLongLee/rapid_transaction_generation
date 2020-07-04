package robust_elements;

import BufferedImageGeneration.BufferedImageGenerator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class JPEGCompression {

    public BufferedImage compressImage(BufferedImage image, String jpegFilePath, float quality) throws IOException {
        // save jpeg image with specific quality. "1f" corresponds to 100% , "0.7f" corresponds to 70%
        ImageWriter jpgWriter = ImageIO.getImageWritersByFormatName("jpeg").next();

        ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();
        jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpgWriteParam.setCompressionQuality(quality);

        File file = new File(jpegFilePath);
        OutputStream os = new FileOutputStream(file);
        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        jpgWriter.setOutput(ios);

        IIOImage outputImage = new IIOImage(image, null, null);
        jpgWriter.write(null, outputImage, jpgWriteParam);
        os.close();
        ios.close();
        jpgWriter.dispose();
        BufferedImage compressedImgFile = BufferedImageGenerator.extractBufferedImage(file.getPath());
        return compressedImgFile;
    }

}
