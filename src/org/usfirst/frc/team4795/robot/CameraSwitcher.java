package org.usfirst.frc.team4795.robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.AxisCamera;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class CameraSwitcher {
    
    private static CameraServer server;
    private static AxisCamera axisCamera;
    private static USBCamera usbCamera;
    private static Image image;
    private static boolean selector = false;
    
    public static void init() {
        server = CameraServer.getInstance();
        server.setQuality(50);
        axisCamera = new AxisCamera("10.47.95.89");
        axisCamera.writeExposurePriority(0);
        usbCamera = new USBCamera("cam1");
        usbCamera.openCamera();
        usbCamera.setFPS(15);
        usbCamera.updateSettings();
        image = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        
        usbCamera.startCapture();
    }
    
    public static void update() {
        if(selector) {
            axisCamera.getImage(image);
        } else {
            usbCamera.getImage(image);
        }
        server.setImage(image);
    }
    
    public static void toggle() {
        if(selector) {
            usbCamera.startCapture();
        } else {
            usbCamera.stopCapture();
        }
        selector = !selector;
    }
    
}
