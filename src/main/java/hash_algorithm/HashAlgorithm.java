package hash_algorithm;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigInteger;

public interface HashAlgorithm {
    BigInteger hashFrame(BufferedImage imageData) throws IOException;
}
