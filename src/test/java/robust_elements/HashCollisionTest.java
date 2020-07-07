package robust_elements;

import hash_algorithm.HashAlgorithm;
import hash_algorithm.HashAlgorithmFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.Constants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class HashCollisionTest {


    @Test
    public void hashCollisionPerformanceTest() throws IOException {

        HashAlgorithmFactory hashAlgorithmFactory = HashAlgorithmFactory.getInstance();
        HashAlgorithm hashAlgorithm = hashAlgorithmFactory.getHashInstance(Constants.Average_Hash);

        String dirName = "D:\\git\\rapid_transaction_generation\\Data\\ImageData";
        File dir = new File(dirName);
        String files[] = dir.list();
        for (String filePath : files) {
            System.out.println("File Name" + filePath);
            String fullFilePath = dirName + "\\" + filePath;
            File file = new File(fullFilePath);
            BufferedImage imageData = ImageIO.read(file);
            BufferedImage brightAndContrast = BrightnessAndContrast.adjustBrightnessAndContrast(imageData, 0.2f, 0.2f);
            BigInteger hashValue1 = hashAlgorithm.hashFrame(brightAndContrast);

            BufferedImage gammaCorrectionValue = GammaCorrection.gammaCorrect(imageData, 0.4);
            BigInteger hashValue2 = hashAlgorithm.hashFrame(gammaCorrectionValue);

            BufferedImage gaussianBlurValue = GaussianBlur.applyGaussianBlur(imageData);
            BigInteger hashValue3 = hashAlgorithm.hashFrame(gaussianBlurValue);

            BufferedImage croppedImg = ImageCropper.cropImage(imageData,0.05);
            BigInteger hashValue4 = hashAlgorithm.hashFrame(croppedImg);

            BufferedImage scaledImg = ImageScaler.scaleImg(imageData,5);
            BigInteger hashValue5 = hashAlgorithm.hashFrame(scaledImg);

            BufferedImage makredImg = WaterMarkGenerator.addWaterMark(imageData);
            BigInteger hashValue6 = hashAlgorithm.hashFrame(makredImg);

            System.out.println("compare Bright & Contrast's hash value  with others");
            assertNotSame(hashValue2, hashValue1);
            assertNotSame(hashValue3, hashValue1);
            assertNotSame(hashValue4, hashValue1);
            assertNotSame(hashValue5, hashValue1);
            assertNotSame(hashValue6, hashValue1);

            System.out.println("compare gamma correction's hash value  with others");
            assertNotSame(hashValue1, hashValue2);
            assertNotSame(hashValue3, hashValue2);
            assertNotSame(hashValue4, hashValue2);
            assertNotSame(hashValue5, hashValue2);
            assertNotSame(hashValue6, hashValue2);

            System.out.println("compare gaussian blur's hash value  with others");
            assertNotSame(hashValue1, hashValue3);
            assertNotSame(hashValue2, hashValue3);
            assertNotSame(hashValue4, hashValue3);
            assertNotSame(hashValue5, hashValue3);
            assertNotSame(hashValue6, hashValue3);

            System.out.println("compare Image cropping's hash value  with others");
            assertNotSame(hashValue1, hashValue4);
            assertNotSame(hashValue2, hashValue4);
            assertNotSame(hashValue3, hashValue4);
            assertNotSame(hashValue5, hashValue4);
            assertNotSame(hashValue6, hashValue4);

            System.out.println("compare Image scaling's hash value  with others");
            assertNotSame(hashValue1, hashValue5);
            assertNotSame(hashValue2, hashValue5);
            assertNotSame(hashValue3, hashValue5);
            assertNotSame(hashValue4, hashValue5);
            assertNotSame(hashValue6, hashValue5);

            System.out.println("compare Image water mark's hash value  with others");
            assertNotSame(hashValue1, hashValue6);
            assertNotSame(hashValue2, hashValue6);
            assertNotSame(hashValue3, hashValue6);
            assertNotSame(hashValue4, hashValue6);
            assertNotSame(hashValue5, hashValue6);

        }
    }
}
