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
    private static boolean selector = true;
    
    public static void init() {
    	try {
    		server = CameraServer.getInstance();
    		server.setQuality(50);
    		axisCamera = new AxisCamera("10.47.95.11");
    		axisCamera.writeExposurePriority(0);
    		
    		usbCamera = new USBCamera("cam0");
    		usbCamera.openCamera();
    		usbCamera.setFPS(15);
    		usbCamera.updateSettings();
    		image = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    		
    		//usbCamera.startCapture();
    	} catch(Exception ignored) {}
    }
    
    public static void update() {
    	try {
    		if(selector) {
    			axisCamera.getImage(image);
    		} else {
    			usbCamera.getImage(image);
    		}
    		server.setImage(image);
    	} catch(Exception ignored) {}
    }
    
    public static void toggle() {
    	try {
    		if(selector) {
    			usbCamera.startCapture();
    		} else {
    			usbCamera.stopCapture();
    		}
    		selector = !selector;
    	} catch(Exception ignored) {}
    }
    
}
