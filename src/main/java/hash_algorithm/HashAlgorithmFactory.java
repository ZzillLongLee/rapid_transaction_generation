package hash_algorithm;

import util.Constants;

import static util.Constants.*;
import static util.Constants.Average_Hash;
import static util.Constants.Difference_Hash;

public class HashAlgorithmFactory {
    public HashAlgorithm getHashInstance(int type) {
        //use the switch statement to get various type of hash algorithm through the factory method pattern
        switch (type){
            case Average_Hash:
                return new AverageHashAlgorithm();
            case Difference_Hash:
                return new DifferenceHashAlgorithm();
            case Perceptive_Hash:
                return new PerceptiveHashAlgorithm();
            case Median_Hash:
                return new MedianHashAlgorithm();
            case Wavelet_Hash:
                return new WaveletHashAlgorithm();
            case MD5_Hash:
                return new MD5HashAlgorithm();
            case SHA256_Hash:
                return new SHA256Algorithm();
            case SHA512_Hash:
                return new SHA512Algorithm();
        }
        throw new NullPointerException();
    }
}
