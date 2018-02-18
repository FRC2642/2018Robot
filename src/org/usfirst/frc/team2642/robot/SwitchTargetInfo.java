package org.usfirst.frc.team2642.robot;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;

public class SwitchTargetInfo {
	private static int numTargets = 0;
	private static Rect switchRec1;
	private static final Object switchImgLock = new Object();
	private static double switchCenterX = Double.MAX_VALUE;
	private static double switchCenterY = Double.MAX_VALUE;
	private static double switchCenterTargetArea = Double.MAX_VALUE;

	public static void setFilterContours(ArrayList<MatOfPoint> matOfPoints) {
		synchronized (switchImgLock) {
			if (matOfPoints.size() >= 1) {
				numTargets = 1;
				switchRec1 = Imgproc.boundingRect(matOfPoints.get(0));
				switchCenterX = 2 * switchRec1.x + switchRec1.width - (RobotMap.IMG_WIDTH / 2);
				switchCenterY = 2 * switchRec1.y + switchRec1.height - (RobotMap.IMG_HEIGHT / 2);
				switchCenterTargetArea = switchRec1.area();
			} else {
				numTargets = 0;
				switchCenterX = Double.MAX_VALUE;
				switchCenterY = Double.MAX_VALUE;
				switchCenterTargetArea = Double.MAX_VALUE;
			}
		}
	}

	public static double getSwitchCenterX() {
		return switchCenterX;
	}

	public static double getSwitchCenterY() {
		return switchCenterY;
	}

	public static double getSwitchCenterTargetArea() {
		return switchCenterTargetArea;
	}

	public static int getNumTargets() {
		return numTargets;
	}
}
