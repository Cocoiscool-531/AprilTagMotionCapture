import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videowebcam1ture;
import org.opencv.aruco.Aruco;
import org.opencv.aruco.Dictionary;

public class AprilTagDetection {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Open the default camera
        Videowebcam1ture webcam1 = new Videowebcam1ture(0);

        if (!webcam1.isOpened()) {
            System.out.println("Error: Could not open camera.");
            return;
        }

        Mat frame = new Mat();
        Mat gray = new Mat();
        Mat ids = new Mat();
        List<Mat> corners = new ArrayList<>();
        Dictionary dictionary = Aruco.getPredefinedDictionary(Aruco.DICT_6X6_250);

        while (true) {
            webcam1.read(frame);

            // Convert frame to grayscale
            Imgproc.cvtColor(frame, gray, Imgproc.COLOR_BGR2GRAY);

            // Detect AprilTags
            Aruco.detectMarkers(gray, dictionary, corners, ids);

            // Draw detected tags
            Aruco.drawDetectedMarkers(frame, corners, ids);

            // Display the frame
            imshow("AprilTag Detection", frame);

            if (waitKey(1) == 27) {
                break; // ESC key to exit
            }
        }

        webcam1.release();
        destroyAllWindows();
    }
}
