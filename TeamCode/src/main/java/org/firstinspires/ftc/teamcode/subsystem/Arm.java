package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

public class Arm extends SubSystem {

    private DcMotor lowerArmMotorRight;
    //private DcMotor lowerArmMotorLeft;
    private DcMotor upperArmMotor;
    // TODO: Tune Values
    private int lowerArmEncoderPositionScore = -2064;
    private int lowerArmEncoderPositionGrab = 0;
    //TODO: TUNE
    private int upperArmEncoderPositionScore = -700;
    private int upperArmEncoderPositionGrab = 0;
    private double upperArmPower = 0.3;
    public Arm (Config config) {
        super(config);
    }

    public Arm(Config config, boolean isOneController) {
        super(config, isOneController);
    }

    @Override
    public void init() {
        lowerArmMotorRight = config.hardwareMap.get(DcMotor.class, Config.RIGHT_LOW_ARM_MOTOR);
        //lowerArmMotorLeft = config.hardwareMap.get(DcMotor.class, Config.LEFT_LOW_ARM_MOTOR);
        upperArmMotor = config.hardwareMap.get(DcMotor.class, Config.UP_ARM_MOTOR);

        upperArmMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public void update() {


        // TODO: TUNE SPEED
        // TODO: Add 1 controller mode for run to position
        if(isOneController) {
            if (config.gamePad1.dpad_down){
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                lowerArmMotorRight.setPower(-1);

            } else if (config.gamePad1.dpad_up){
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                lowerArmMotorRight.setPower(1);

            } else {
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                lowerArmMotorRight.setPower(0);

            }
                //upperArmMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                upperArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            if (config.gamePad1.x) {
                //upperArmMotor.setTargetPosition(upperArmMotor.getCurrentPosition()+10);
                //upperArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                  upperArmMotor.setPower(upperArmPower);

            } else if (config.gamePad1.y) {
                //upperArmMotor.setTargetPosition(upperArmMotor.getCurrentPosition()-10);
                //upperArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                upperArmMotor.setPower(-upperArmPower);
            } else {
                upperArmMotor.setPower(0);
            }

        }
        else {

            double maxSpeed = 1;

            double lowerArmSpeed = config.gamePad2.left_stick_y / 1.5;
            if (lowerArmSpeed > maxSpeed) {
                lowerArmSpeed = maxSpeed;
            }
            lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            lowerArmMotorRight.setPower(lowerArmSpeed);

            if (config.gamePad2.y) {
                // Positions the arm into scoring position
                lowerArmMotorRight.setTargetPosition(lowerArmEncoderPositionScore);
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                lowerArmMotorRight.setPower(1);

            } else if (config.gamePad2.x) {
                // Positions arm into grabbing position
                lowerArmMotorRight.setTargetPosition(lowerArmEncoderPositionGrab);
                lowerArmMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                lowerArmMotorRight.setPower(1);

            }
        //    upperArmMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                upperArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            if (config.gamePad2.dpad_up) {
                //upperArmMotor.setTargetPosition(upperArmMotor.getCurrentPosition()+10);
                //upperArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                upperArmMotor.setPower(upperArmPower);

            } else if (config.gamePad2.dpad_down) {
                //upperArmMotor.setTargetPosition(upperArmMotor.getCurrentPosition()-10);
                //upperArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                upperArmMotor.setPower(-upperArmPower);
            }
            else {
                upperArmMotor.setPower(0);
            }

        }



        // Syncs both lower arm motors
        //lowerArmMotorLeft.setPower(lowerArmMotorRight.getPower());

        // Telemetry to help tune encoder values
        //config.telemetry.addData("Lower Arm Motor Encoder Position", lowerArmMotorRight.getCurrentPosition());
    }
}
