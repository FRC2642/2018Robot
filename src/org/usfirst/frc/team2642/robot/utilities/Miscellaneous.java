package org.usfirst.frc.team2642.robot.utilities;

public class Miscellaneous {
    public static double map(double oldMin, double oldMax, double newMin, double newMax, double value) {
        return (((value - oldMin) * (newMax - newMin)) / (oldMax - oldMin)) + newMin;
    }
}
