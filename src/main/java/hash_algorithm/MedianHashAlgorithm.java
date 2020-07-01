package hash_algorithm;

import com.github.kilianB.hash.Hash;
import com.github.kilianB.hashAlgorithms.MedianHash;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigInteger;

public class MedianHashAlgorithm implements HashAlgorithm {

    private final MedianHash hashAlgorithm;

    public MedianHashAlgorithm(){
        this.hashAlgorithm = new MedianHash(64);
    }

    public BigInteger hashFrame(BufferedImage imageData) throws IOException {
        Hash hashValue = hashAlgorithm.hash(imageData);
        return hashValue.getHashValue();
    }
}
