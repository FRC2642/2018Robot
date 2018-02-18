package org.usfirst.frc.team2642.robot;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;

public class TapeTargetInfo {
	private static int numTargets = 0;
	private static Rect tapeRec1;
	private static final Object tapeImgLock = new Object();
	private static double tapeCenterX = Double.MAX_VALUE;
	private static double tapeCenterY = Double.MAX_VALUE;
	private static double tapeCenterTargetArea = Double.MAX_VALUE;

	public static void setFilterContours(ArrayList<MatOfPoint> matOfPoints) {
		synchronized (tapeImgLock) {
			if (matOfPoints.size() >= 1) {
				numTargets = 1;
				tapeRec1 = Imgproc.boundingRect(matOfPoints.get(0));
				tapeCenterX = 2 * tapeRec1.x + tapeRec1.width - (RobotMap.IMG_WIDTH / 2);
				tapeCenterY = 2 * tapeRec1.y + tapeRec1.height - (RobotMap.IMG_HEIGHT / 2);
				tapeCenterTargetArea = tapeRec1.area();
			} else {
				numTargets = 0;
				tapeCenterX = Double.MAX_VALUE;
				tapeCenterY = Double.MAX_VALUE;
				tapeCenterTargetArea = Double.MAX_VALUE;
			}
		}
	}

	public static double getTapeCenterX() {
		return tapeCenterX;
	}

	public static double getTapeCenterY() {
		return tapeCenterY;
	}

	public static double getTapeCenterTargetArea() {
		return tapeCenterTargetArea;
	}

	public static int getNumTargets() {
		return numTargets;
	}
}
