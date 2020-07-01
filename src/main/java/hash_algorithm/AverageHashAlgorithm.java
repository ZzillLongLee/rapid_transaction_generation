package hash_algorithm;

import com.github.kilianB.hash.Hash;
import com.github.kilianB.hashAlgorithms.AverageHash;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigInteger;

public class AverageHashAlgorithm implements HashAlgorithm {

    private final AverageHash hashAlgorithm;

    public AverageHashAlgorithm(){
        this.hashAlgorithm = new AverageHash(64);
    }

    public BigInteger hashFrame(BufferedImage imageData) throws IOException {
        Hash hashValue = hashAlgorithm.hash(imageData);
        return hashValue.getHashValue();
    }
}
