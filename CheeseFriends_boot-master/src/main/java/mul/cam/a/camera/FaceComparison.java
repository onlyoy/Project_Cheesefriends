package mul.cam.a.camera;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;

public class FaceComparison {
	  private static final int IMAGE_WIDTH = 300;
	    private static final int IMAGE_HEIGHT = 300;
	    private static final Size WINDOW_SIZE = new Size(128, 128);
	    private static final Size BLOCK_SIZE = new Size(64, 64);
	    private static final Size BLOCK_STRIDE = new Size(32, 32);
	    private static final Size CELL_SIZE = new Size(32, 32);
	    private static final int NUM_BINS = 9;
	    private static final double EPS = 1e-7;
	    
    public static double compareFaces(String imgPath1, String imgPath2) {
        // 비교할 이미지 불러오기 
        Mat img1 = Imgcodecs.imread(imgPath1);
        Mat img2 = Imgcodecs.imread(imgPath2);
        

        // 색상 관련
        Mat grayImg1 = new Mat();
        Mat grayImg2 = new Mat();
        Imgproc.cvtColor(img1, grayImg1, Imgproc.COLOR_BGR2GRAY);
        Imgproc.cvtColor(img2, grayImg2, Imgproc.COLOR_BGR2GRAY);

        // 이미지 사이즈를 같은 크기로 자르기
      //Imgproc.resize(grayImg1, grayImg1, new Size(200, 200));
      //Imgproc.resize(grayImg2, grayImg2, new Size(200, 200));

        // 이미지 사이의 차이 계산하기 
        Mat diff = new Mat();
        Core.absdiff(grayImg1, grayImg2, diff);

       
        Mat sqrDiff = new Mat();
        Core.pow(diff, 2, sqrDiff);
        Scalar mse = Core.mean(sqrDiff);

        // 유사도 계산하기
        double similarity = 1 - (mse.val[0] / 255);

        return similarity;
    }
    
    public static Mat computeHOG(Mat image) {
        // HOG Descriptor 계산을 위한 HOGDescriptor 객체 생성
        HOGDescriptor hogDescriptor = new HOGDescriptor(
            WINDOW_SIZE,
            BLOCK_SIZE,
            BLOCK_STRIDE,
            CELL_SIZE,
            NUM_BINS,
            1,
            -1,
            HOGDescriptor.DEFAULT_NLEVELS,
            HOGDescriptor.DESCR_FORMAT_ROW_BY_ROW
        );

        // 입력 이미지의 크기를 300x300 으로 조정
        Mat resizedImage = new Mat();
        Imgproc.resize(image, resizedImage, new Size(IMAGE_WIDTH, IMAGE_HEIGHT));

        // HOG Descriptor 계산
        MatOfFloat descriptor = new MatOfFloat();
        hogDescriptor.compute(resizedImage, descriptor);

        // 계산된 HOG Descriptor를 1차원 벡터로 변환
        Mat hogDescriptorMat = new Mat();
        descriptor.copyTo(hogDescriptorMat);

        // L2-Normalization을 적용
        Core.normalize(hogDescriptorMat, hogDescriptorMat);

        // 반환
        return hogDescriptorMat.reshape(1, 1);
    }
    
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        String imgPath1 = "path/to/image1.jpg";
        String imgPath2 = "path/to/image2.jpg";

        double similarity = compareFaces(imgPath1, imgPath2);
        System.out.println("유사도: " + similarity);
    }
}
