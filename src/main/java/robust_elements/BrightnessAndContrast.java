package robust_elements;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class BrightnessAndContrast {

    public static BufferedImage adjustBrightnessAndContrast(BufferedImage imageData, float contrastRate, float brightnessRate ){
    // scaleFactor give a effect to the contrast and offset give a effect to the brightness.
        RescaleOp rescaleOp = new RescaleOp(contrastRate, brightnessRate, null);
        BufferedImage adjustedData = rescaleOp.filter(imageData, imageData);  // Source and destination are the same.
        return adjustedData;
    }
}
