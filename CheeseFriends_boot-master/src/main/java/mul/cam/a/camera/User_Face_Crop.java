package mul.cam.a.camera;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class User_Face_Crop {
    private CascadeClassifier faceDetector;
    private static final String FACE_CASCADE_PATH = "C:\\Users\\User\\Downloads\\opencv\\opencv\\sources\\data\\haarcascades_cuda\\haarcascade_frontalface_alt.xml";
    
    public User_Face_Crop() {
        // 얼굴 검출기 초기화
        faceDetector = new CascadeClassifier(FACE_CASCADE_PATH);
        if (faceDetector.empty()) {
            System.out.println("얼굴 검출기 로딩 실패");
            System.exit(1);
        }
    }
    
    
    // 얼굴 크롭 메서드
    public boolean cropUserFace(String imagePath, String outputImagePath) {
        // 이미지 로딩
        Mat image = Imgcodecs.imread(imagePath);
        if (image.empty()) {
            System.out.println("이미지 로딩 실패");
            return false;
        }

        // 그레이 스케일 변환
        Mat gray = new Mat();
        Imgproc.cvtColor(image, gray, Imgproc.COLOR_BGR2GRAY);

        // 얼굴 검출
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(gray, faceDetections);

        if (faceDetections.toArray().length != 1) {
            System.out.println("얼굴 검출 실패");
            return false;
        }

        // 얼굴 크롭
        Rect faceRect = faceDetections.toArray()[0];
        Mat cropped = new Mat(image, faceRect);
        Mat resized = new Mat();
        Size size = new Size(300, 300);
        Imgproc.resize(cropped, resized, size);

        // 이미지 저장
        Imgcodecs.imwrite(outputImagePath, resized);
        
        // 데이터 증강
        List<Mat> augmentedImages = new ArrayList<>();
        
        // 이미지 수평 뒤집기
        Mat flipped = new Mat();
        Core.flip(resized, flipped, 1);
        augmentedImages.add(flipped);
        
        // 이미지 회전
        Mat rotated = new Mat();
        for (int i = 1; i <= 3; i++) {
            Core.rotate(resized, rotated, i);
            augmentedImages.add(rotated.clone());
        }
        
        
     // 이미지 블러링
        Mat blurred = new Mat();
        Imgproc.GaussianBlur(resized, blurred, new Size(5, 5), 0);
        augmentedImages.add(blurred);
        
     // 이미지 노이즈 추가
        Mat noise = new Mat(resized.size(), resized.type());
        Core.randn(noise, 0, 50); // 표준편차 50인 노이즈 생성
        Mat noisyImage = new Mat();
        Core.add(resized, noise, noisyImage);
        augmentedImages.add(noisyImage);
       
        // 증강된 이미지 저장
        
     // 증강된 이미지 저장
        for (int i = 0; i < augmentedImages.size(); i++) {
            String outputImagePathWithIndex = outputImagePath.replace(".jpg", "_"+ i + ".jpg");
            Imgcodecs.imwrite(outputImagePathWithIndex, augmentedImages.get(i));
        }
        return true;
    }
}
