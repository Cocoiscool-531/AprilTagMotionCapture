package motioncapture.test

import com.github.sawxos.Webcam-Capture
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

public class AprilTagDetection {
    Map<Integer, Point2D> tagPositions = new HashMap<>();
    List<Integer> robotTags = new arrayList<>();

    Point2D frontLeftPixelLocation;
    double frontLeftHeading;
    Point2D frontRightPixelLocation;
    double frontRightHeading;
    Point2D backLeftPixelLocation;
    double backLeftHeading;
    Point2D backRightPixelLocation;
    double backRightHeading;

    double botHeading;
    Point2D botCenterPosition;

    double fx = 1430; // focal length in pixels
    double fy = 1430; // focal length in pixels
    double cx = 480; // principal point (in pixels)
    double cy = 620; // principal point (in pixels)

    Webcam webcam
    private AprilTagProcessor tagProc;
    private VisionPortal visionPortal;

    public void main(String[] args){
        tagPositions.put(0, new Point2D.Double(-63.5, 63.5))
        tagPositions.put(1, new Point2D.Double(0, 63.5))
        tagPositions.put(2, new Point2D.Double(63.5, 63.5))
        tagPositions.put(3, new Point2D.Double(-36, 36))
        tagPositions.put(4, new Point2D.Double(36, 36))
        tagPositions.put(5, new Point2D.Double(-63.5, 0))
        tagPositions.put(6, new Point2D.Double(0, 0))
        tagPositions.put(7, new Point2D.Double(63.5, 0))
        tagPositions.put(8, new Point2D.Double(-36, -36))
        tagPositions.put(9, new Point2D.Double(36, -36))
        tagPositions.put(10, new Point2D.Double(-63.5, -63.5))
        tagPositions.put(11, new Point2D.Double(-63.5, 0))
        tagPositions.put(12, new Point2D.Double(63.5, -63.5))
        List<AprilTagDetection> currentDetections;
        initAprilTag();
        while(true){
            currentDetections = aprilTag.getDetections();
            for(AprilTagDetection detection : currentDetections){}
                if(detection.id < 13){
                    System.out.printLn(String.format("(X,Y) %3.9f %6.9f (inch)", detection.ftcPose.x, detection.ftcPose.y));
                    System.out.printLn(String.format("Roll %3.9f (deg)", detection.ftcPose.roll,));

                    int tagID = detection.id
                    Point2D pixelPosition = new Point2D(detection.ftcPose.x, detection.ftcPose.y)

                    // Convert pixel coordinates to inches on the field
                    double xField = (pixelPosition.getX() - cx) / fx * fieldPosition.getX();
                    double yField = (pixelPosition.getY() - cy) / fy * fieldPosition.getY();
                }else if(detection.id == 16){
                    frontLeftPixelLocation = new Point2D(detection.ftcPose.x, detection.ftcPose.y)
                    frontLeftHeading = detection.ftcPose.roll
                        
                }else if(detection.id == 17){
                    frontRightPixelLocation = new Point2D(detection.ftcPose.x, detection.ftcPose.y)
                    frontRightHeading = detection.ftcPose.roll
                        
                }else if(detection.id == 18){
                    backLeftPixelLocation = new Point2D(detection.ftcPose.x, detection.ftcPose.y)
                    backLeftHeading = detection.ftcPose.roll

                }else if(detection.id == 19){
                    backRightPixelLocation = new Point2D(detection.ftcPose.x, detection.ftcPose.y)
                    backRightHeading = detection.ftcPose.roll
                }
        }
        botHeading = (backRightHeading + backLeftHeading + frontRightHeading + frontLeftHeading) / 4
        botCenterPosition.x = (backRightPixelLocation.x + backLeftPixelLocation.x + frontRightPixelLocation.x + frontLeftPixelLocation.x) / 4
        botCenterPosition.y = (backRightPixelLocation.y + backLeftPixelLocation.y + frontRightPixelLocation.y + frontLeftPixelLocation.y) / 
        System.out.printLn(String.format("Bot Position: (%9.9f, %9.9f) inches"), botCenterPosition.x, botCenterPosition.y)
        System.out.printLn(String.format("Bot Heading: %3.9", botHeading))
        } 
    }

    private void initAprilTag(){
        webcam = Webcam.getDefault();
        tagProc = new AprilTagProcessor.Builder()
            // The following default settings are available to un-comment and edit as needed.
            .setDrawAxes(true)
            .setDrawCubeProjection(true)
            .setDrawTagOutline(true)
            .setTagFamily(AprilTagProcessor.TagFamily.TAG_36h11)
            .setOutputUnits(DistanceUnit.INCH, AngleUnit.DEGREES)
            .build();

        tagProc.setDecimation(3);

        VisionPortal.Builder b = new VisionPortal.Builder();
        b.stCamera(webcam);
        b.addProcessor(tagProc);
        visionPortal = b.build();
        visionPortal.startStreaming();
    }
}