package hash_algorithm;

import com.github.kilianB.hash.Hash;
import com.github.kilianB.hashAlgorithms.DifferenceHash;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigInteger;

public class DifferenceHashAlgorithm implements HashAlgorithm {

    private final DifferenceHash hashAlgorithm;

    public DifferenceHashAlgorithm(){
        this.hashAlgorithm = new DifferenceHash(64, DifferenceHash.Precision.Double);
    }

    public BigInteger hashFrame(BufferedImage imageData) throws IOException {
        Hash hashValue = hashAlgorithm.hash(imageData);
        return hashValue.getHashValue();
    }
}
