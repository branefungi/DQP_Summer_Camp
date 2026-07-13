package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Teleop", group = "Teleop")
public class SummerCamp extends OpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    double myVariable = 1;
    @Override
    public void init(){
        frontLeft = hardwareMap.get(DcMotor.class, "FL");
        frontRight = hardwareMap.get(DcMotor.class, "FR");
        backLeft = hardwareMap.get(DcMotor.class, "BL");
        backRight = hardwareMap.get(DcMotor.class, "BR");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);

    }


    @Override
    public void loop(){
        double y = -gamepad1.left_stick_y * 0.8;
        double x = gamepad1.left_stick_x * 0.8;
        double rx = gamepad1.right_stick_x * 0.6;
        double powerFL = y + x + rx;
        double powerFR = y - x - rx;
        double powerBL = y - x + rx;
        double powerBR = y + x - rx;
        double max = Math.max(powerFL, powerFR);
        max = Math.max(max, powerBL);
        max = Math.max(max, powerBR);
        if(max > 0.8){
            powerFL /= max;
            powerFR /= max;
            powerBL /= max;
            powerBR /= max;
        }

        frontLeft.setPower(powerFL);
        frontRight.setPower(powerFR);
        backLeft.setPower(powerBL);
        backRight.setPower(powerBR);
    }
}


