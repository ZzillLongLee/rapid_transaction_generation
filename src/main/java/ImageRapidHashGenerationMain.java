import BufferedImageGeneration.BufferedImageGenerator;
import hash_algorithm.HashAlgorithm;
import hash_algorithm.HashAlgorithmFactory;
import util.Constants;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigInteger;

public class ImageRapidHashGenerationMain {

    public static void main(String[] args) throws IOException {
        String input = "D:\\git\\rapid_transaction_generation\\Data\\Cat03.jpg";
        BufferedImage imageData = BufferedImageGenerator.extractBufferedImage(input);
        HashAlgorithmFactory hashAlgorithmFactory = new HashAlgorithmFactory();

        HashAlgorithm hashAlgorithm1 = hashAlgorithmFactory.getHashInstance(Constants.Average_Hash);
        BigInteger result1 = hashAlgorithm1.hashFrame(imageData);
        System.out.println(result1);

        HashAlgorithm hashAlgorithm2 = hashAlgorithmFactory.getHashInstance(Constants.Difference_Hash);
        BigInteger result2 = hashAlgorithm2.hashFrame(imageData);
        System.out.println(result2);

        HashAlgorithm hashAlgorithm3 = hashAlgorithmFactory.getHashInstance(Constants.Perceptive_Hash);
        BigInteger result3 = hashAlgorithm3.hashFrame(imageData);
        System.out.println(result3);

        HashAlgorithm hashAlgorithm4 = hashAlgorithmFactory.getHashInstance(Constants.Median_Hash);
        BigInteger result4 = hashAlgorithm4.hashFrame(imageData);
        System.out.println(result4);

        HashAlgorithm hashAlgorithm5 = hashAlgorithmFactory.getHashInstance(Constants.Wavelet_Hash);
        BigInteger result5 = hashAlgorithm5.hashFrame(imageData);
        System.out.println(result5);

        HashAlgorithm hashAlgorithm6 = hashAlgorithmFactory.getHashInstance(Constants.MD5_Hash);
        BigInteger result6 = hashAlgorithm6.hashFrame(imageData);
        System.out.println(result6);

        HashAlgorithm hashAlgorithm7 = hashAlgorithmFactory.getHashInstance(Constants.SHA256_Hash);
        BigInteger result7 = hashAlgorithm7.hashFrame(imageData);
        System.out.println(result7);

        HashAlgorithm hashAlgorithm8 = hashAlgorithmFactory.getHashInstance(Constants.SHA512_Hash);
        BigInteger result8 = hashAlgorithm8.hashFrame(imageData);
        System.out.println(result8);
    }

}
