package opencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.List;

public class FrameExtractor {

    public List<byte[]> extractFrames(String videoFilePath) {
        List<byte[]> frameList = new ArrayList<byte[]>();

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture cap = new VideoCapture(videoFilePath);
        ArrayList<byte[]> frames = new ArrayList<byte[]>();

        Mat frame = new Mat();
        if (cap.isOpened()) {
            System.out.println("Video is opened");
            System.out.println("Converting Video...");

            int idx = 0;
            while (true) {
                if (cap.read(frame)) {
                    System.out.println("Frame Obtained");
                    System.out.println("Captured Frame Width " +
                            frame.width() + " Height " + frame.height());
                    byte[] data = matToBufferedImage(frame);
                    frameList.add(data);
                    System.out.println("OK");
                    idx++;
                    break;
                }
            }
            cap.release();
        }
            return frameList;
        }

    private byte[] matToBufferedImage(Mat frame) {
        int type = 0;
        if (frame.channels() == 1) {
            type = BufferedImage.TYPE_BYTE_GRAY;
        } else if (frame.channels() == 3) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        BufferedImage image = new BufferedImage(frame.width(), frame.height(), type);
        WritableRaster raster = image.getRaster();
        DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
        byte[] data = dataBuffer.getData();
        return data;
    }
    }
