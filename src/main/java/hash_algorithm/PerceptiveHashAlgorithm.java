package hash_algorithm;

import com.github.kilianB.hash.Hash;
import com.github.kilianB.hashAlgorithms.PerceptiveHash;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigInteger;

public class PerceptiveHashAlgorithm implements HashAlgorithm {

    private final PerceptiveHash hashAlgorithm;

    public PerceptiveHashAlgorithm(){
        this.hashAlgorithm = new PerceptiveHash(64);
    }

    public BigInteger hashFrame(BufferedImage imageData) throws IOException {
        Hash hashValue = hashAlgorithm.hash(imageData);
        return hashValue.getHashValue();
    }
}
