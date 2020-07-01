package hash_algorithm;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA512Algorithm implements HashAlgorithm {

    private MessageDigest md;

    public SHA512Algorithm(){
        try {
            this.md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public BigInteger hashFrame(BufferedImage imageData) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(imageData, "jpg", baos);
        baos.flush();
        byte[] bytes = baos.toByteArray();
        baos.close();
        byte[] result = md.digest(bytes);
        BigInteger bi = new BigInteger(1, result);
        return bi;
    }
}
