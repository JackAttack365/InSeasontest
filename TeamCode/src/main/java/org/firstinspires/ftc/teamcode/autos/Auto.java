package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;
import org.firstinspires.ftc.teamcode.subsystem.DriveTrain;

// Auto superclass. Has useful movement methods that can be used in all of our autos
public abstract class Auto extends LinearOpMode {
    protected DcMotor leftFrontDrive;
    protected DcMotor leftBackDrive;
    protected DcMotor rightFrontDrive;
    protected DcMotor rightBackDrive;

    // Initialize. Similar to SubSystem.init();
    protected void initMotors() {
        leftFrontDrive = hardwareMap.get(DcMotor.class, Config.LEFT_FRONT_DRIVE);
        leftBackDrive = hardwareMap.get(DcMotor.class, Config.LEFT_BACK_DRIVE);
        rightFrontDrive = hardwareMap.get(DcMotor.class, Config.RIGHT_FRONT_DRIVE);
        rightBackDrive = hardwareMap.get(DcMotor.class, Config.RIGHT_BACK_DRIVE);

        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE); // DO NOT CHANGE
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE); // DO NOT CHANGE
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD); // DO NOT CHANGE
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD); // DO NOT CHANGE
    }

    public void moveBackward(long milliseconds, double speed) {
        leftFrontDrive.setPower(-speed);
        leftBackDrive.setPower(-speed);
        rightFrontDrive.setPower(-speed);
        rightBackDrive.setPower(-speed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }

    public void strafeRight(long milliseconds, double speed) {
        leftFrontDrive.setPower(speed);
        leftBackDrive.setPower(-speed);
        rightFrontDrive.setPower(-speed);
        rightBackDrive.setPower(speed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }

    public void strafeLeft(long milliseconds, double speed) {
        leftFrontDrive.setPower(-speed);
        leftBackDrive.setPower(speed);
        rightFrontDrive.setPower(speed);
        rightBackDrive.setPower(-speed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }

    public void moveForward(long milliseconds, double speed) {
        leftFrontDrive.setPower(speed);
        leftBackDrive.setPower(speed);
        rightFrontDrive.setPower(speed);
        rightBackDrive.setPower(speed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }

    public void spinCounterClockwise(long milliseconds, double speed) {
        leftFrontDrive.setPower(-speed);
        leftBackDrive.setPower(-speed);
        rightFrontDrive.setPower(speed);
        rightBackDrive.setPower(speed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }

    public void spinClockwise(long milliseconds, double speed) {
        leftFrontDrive.setPower(speed);
        leftBackDrive.setPower(speed);
        rightFrontDrive.setPower(-speed);
        rightBackDrive.setPower(-speed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }

    public void moveBackward(long milliseconds) {
        leftFrontDrive.setPower(-defaultMovementSpeed);
        leftBackDrive.setPower(-defaultMovementSpeed);
        rightFrontDrive.setPower(-defaultMovementSpeed);
        rightBackDrive.setPower(-defaultMovementSpeed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void strafeRight(long milliseconds) {
        leftFrontDrive.setPower(defaultMovementSpeed);
        leftBackDrive.setPower(-defaultMovementSpeed);
        rightFrontDrive.setPower(-defaultMovementSpeed);
        rightBackDrive.setPower(defaultMovementSpeed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void strafeLeft(long milliseconds) {
        leftFrontDrive.setPower(-defaultMovementSpeed);
        leftBackDrive.setPower(defaultMovementSpeed);
        rightFrontDrive.setPower(defaultMovementSpeed);
        rightBackDrive.setPower(-defaultMovementSpeed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void moveForward(long milliseconds) {
        leftFrontDrive.setPower(defaultMovementSpeed);
        leftBackDrive.setPower(defaultMovementSpeed);
        rightFrontDrive.setPower(defaultMovementSpeed);
        rightBackDrive.setPower(defaultMovementSpeed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }

    public void spinCounterClockwise(long milliseconds) {
        leftFrontDrive.setPower(-defaultMovementSpeed);
        leftBackDrive.setPower(-defaultMovementSpeed);
        rightFrontDrive.setPower(defaultMovementSpeed);
        rightBackDrive.setPower(defaultMovementSpeed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
    public void spinClockwise(long milliseconds) {
        leftFrontDrive.setPower(defaultMovementSpeed);
        leftBackDrive.setPower(defaultMovementSpeed);
        rightFrontDrive.setPower(-defaultMovementSpeed);
        rightBackDrive.setPower(-defaultMovementSpeed);
        sleep(milliseconds);
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }
}
