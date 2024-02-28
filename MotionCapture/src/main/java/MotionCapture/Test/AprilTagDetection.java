package motioncapture.test

import com.github.sawxos.Webcam-Capture
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

public class AprilTagDetection {
    Webcam webcam
    private AprilTagProcessor tagProc;
    private VisionPortal visPortal;

    public void main(String[] args){

    }

    private void initAprilTag(){
        webcam = Webcam.getDefault();
        tagProc = new AprilTagProcessor.Builder()
            // The following default settings are available to un-comment and edit as needed.
            .setDrawAxes(false)
            .setDrawCubeProjection(true)
            .setDrawTagOutline(true)
            .setTagFamily(AprilTagProcessor.TagFamily.TAG_36h11)
            .setOutputUnits(DistanceUnit.INCH, AngleUnit.DEGREES)
            .build();

            VisionPortal.Builder b = new VisionPortal.Builder();
            b.setCamera(webcam);
            b.addProcessor(tagProc);
            VisionPortal = b.build();
    }
}