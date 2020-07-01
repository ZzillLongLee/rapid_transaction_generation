package opencv;

import org.opencv.core.Core;

public class FrameExtractorTest {
    public static void main(String[] args) {
        String input = "D:\\git\\rapid_transaction_generation\\Data\\KakaoTalk_20200629_085029699.mp4";
        FrameExtractor frameExtractor = new FrameExtractor();
        frameExtractor.extractFrames(input);
    }
}
