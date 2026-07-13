package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Teleop", group = "Teleop")
public class SummerCamp extends OpMode {
    DcMotor[][] drivetrain = new DcMotor[2][2];


    @Override
    public void init(){
        drivetrain[0][0] = hardwareMap.get(DcMotor.class, "FL");
        drivetrain[1][0] = hardwareMap.get(DcMotor.class, "FR");
        drivetrain[0][1] = hardwareMap.get(DcMotor.class, "BL");
        drivetrain[1][1] = hardwareMap.get(DcMotor.class, "BR");

        drivetrain[0][0].setDirection(DcMotor.Direction.REVERSE);
        drivetrain[1][0].setDirection(DcMotor.Direction.FORWARD);
        drivetrain[0][1].setDirection(DcMotor.Direction.REVERSE);
        drivetrain[1][1].setDirection(DcMotor.Direction.FORWARD);

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
        drivetrain[0][0].setPower(powerFL);
        drivetrain[1][0].setPower(powerFR);
        drivetrain[0][1].setPower(powerBL);
        drivetrain[1][1].setPower(powerBR);
    }
}


