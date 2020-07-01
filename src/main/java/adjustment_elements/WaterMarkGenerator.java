package adjustment_elements;

import BufferedImageGeneration.BufferedImageGenerator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WaterMarkGenerator {

    public BufferedImage addWaterMark(BufferedImage imageData) throws IOException {
            String text = "This is a water mark";
            Graphics2D g2d = (Graphics2D) imageData.getGraphics();
            // initializes necessary graphic properties
            AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f);
            g2d.setComposite(alphaChannel);
            g2d.setColor(Color.BLUE);
            g2d.setFont(new Font("Arial", Font.BOLD, 64));
            FontMetrics fontMetrics = g2d.getFontMetrics();
            Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);

            // calculates the coordinate where the String is painted
            int centerX = (imageData.getWidth() - (int) rect.getWidth()) / 2;
            int centerY = imageData.getHeight() / 2;

            // paints the textual watermark
            g2d.drawString(text, centerX, centerY);

            File newFile = new File("Data\\WatermarkedImage.png");
            ImageIO.write(imageData, "png", newFile);
            g2d.dispose();
            BufferedImage markedImgFile = BufferedImageGenerator.extractBufferedImage(newFile.getPath());
            return markedImgFile;
    }
}
