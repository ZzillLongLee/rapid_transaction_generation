package hash_algorithm;

import com.github.kilianB.hash.Hash;
import com.github.kilianB.hashAlgorithms.WaveletHash;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigInteger;

public class WaveletHashAlgorithm implements HashAlgorithm {
    private final WaveletHash hashAlgorithm;

    public WaveletHashAlgorithm(){
        this.hashAlgorithm = new WaveletHash(64, 2);
    }

    public BigInteger hashFrame(BufferedImage imageData) throws IOException {
        Hash hashValue = hashAlgorithm.hash(imageData);
        return hashValue.getHashValue();
    }
}
