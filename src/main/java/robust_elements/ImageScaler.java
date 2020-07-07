package robust_elements;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class ImageScaler {

    public static BufferedImage scaleImg(BufferedImage imageData, int scale){
        int w = imageData.getWidth();
        int h = imageData.getHeight();
        BufferedImage scaledImage = new BufferedImage((w * scale),(h * scale), BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = AffineTransform.getScaleInstance(2.0, 2.0);
        AffineTransformOp ato = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
        scaledImage = ato.filter(imageData, scaledImage);
        return scaledImage;
    }
}
