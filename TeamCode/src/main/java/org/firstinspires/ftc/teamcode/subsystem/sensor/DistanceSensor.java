package org.firstinspires.ftc.teamcode.subsystems.sensor;

import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.teamcode.config;

public class DistanceSensor extends SubSystem {
    
    private DistanceSensor leftDistanceSensor;
    private DistanceSensor rightDistanceSensor;

    private DistanceUnit defaultDistanceUnit = DistanceUnit.CM;

    @Override
    public void init() {
        leftDistanceSensor = config.hardwareMap.get(DistanceSensor.class,"leftDistanceSensor");
        rightDistanceSensor = config.hardwareMap.get(DistanceSensor.class,"rightDistanceSensor");

        config.telemetry.addData("Left Distance: %0.0i", leftDistanceSensor.getDistance(defaultDistanceUnit));
        config.telemetry.addData("Right Distance: %0.0i", rightDistanceSensor.getDistance(defaultDistanceUnit));
    }

    @Override
    public void update() {        
        config.telemetry.addData("Left Distance: %0.0i", leftDistanceSensor.getDistance(defaultDistanceUnit));
        config.telemetry.addData("Right Distance: %0.0i", rightDistanceSensor.getDistance(defaultDistanceUnit));
    }

    public int getRight(DistanceUnit distanceUnit) {
        try {
            return rightDistanceSensor.getDistance(distanceUnit);
        } catch (Exception e)  {
            return rightDistanceSensor.getDistance(defaultDistanceUnit);   
        }
    }

    public int getLeft(DistanceUnit distanceUnit) {
        try {
            return leftDistanceSensor.getDistance(distanceUnit);
        } catch (Exception e)  {
            return leftDistanceSensor.getDistance(defaultDistanceUnit);   
        }
    }
}