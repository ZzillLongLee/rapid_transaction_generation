import hash_algorithm.HashAlgorithm;
import hash_algorithm.HashAlgorithmFactory;
import org.junit.jupiter.api.Test;
import util.Constants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashAlgorithmPerformanceTest {

    @Test
    public void hashPerformanceTest() throws IOException {
        HashAlgorithmFactory hashAlgorithmFactory = HashAlgorithmFactory.getInstance();
        System.out.println("Performance Test is started.");
        System.out.println("-----------------------------------------------");
        String dirName = "D:\\git\\rapid_transaction_generation\\Data\\ImageData";
        File dir = new File(dirName);
        String files[] = dir.list();
        HashMap<String, Double> avgTimeHashMap = new HashMap<String, Double>();
        for (String filePath : files) {
            System.out.println("Test File is : " + filePath);
            List<Long> timeList = new ArrayList<Long>();
            for (int i = 0; i < 100; i++) {
                File file = new File(dirName + "\\" + filePath);
                BufferedImage imageData = ImageIO.read(file);
                long startTime = System.currentTimeMillis();
                HashAlgorithm hashAlgorithm1 = hashAlgorithmFactory.getHashInstance(Constants.Average_Hash);
                BigInteger result1 = hashAlgorithm1.hashFrame(imageData);
                long stopTime = System.currentTimeMillis();
                long duration = (stopTime - startTime);
                timeList.add(duration);
            }
            System.out.println("-----------------------------------------------");
            double avgTime = getAverageTime(timeList);
            avgTimeHashMap.put(filePath, avgTime);
        }
        for (Map.Entry<String, Double> avgTimeValue : avgTimeHashMap.entrySet()) {
            System.out.println("FileName" + avgTimeValue.getKey() + " AverageTime:" + avgTimeValue.getValue());
        }
    }

    private double getAverageTime(List<Long> timeList) {
        Long total = 0L;
        for (Long time : timeList) {
            total = total + time;
        }
        return total / (double) timeList.size();
    }
}
