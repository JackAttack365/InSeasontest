package org.firstinspires.ftc.teamcode.autos;

public class SpikeparkBlueside extends Auto{
    public int forward = 2000;
    public int sRightLeft = 800;
    public int sLeftright2 = 4000;
    public int side = 1000;
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();

        waitForStart();
        // TODO: Add movement times. Uncomment
//        moveForward();
    moveForward(forward);
    strafeRight(sRightLeft);
    // Place spike
        strafeLeft(sLeftright2);
        spinCounterClockwise(side);
        //place on board
        //park



    }

}
