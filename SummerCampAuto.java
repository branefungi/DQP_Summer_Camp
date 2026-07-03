package org.firstinspires.ftc.teamcode.Autos;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.ImuOrientationOnRobot;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Timer;

@Autonomous(name = "Auto", group = "Autos")
public class SummerCampAuto extends OpMode {
    private DcMotor[][] drivetrain = new DcMotor[2][2];
    private IMU imu;
    private ElapsedTime opModeTimer;


    @Override
    public void init(){
        drivetrain[0][0] = hardwareMap.get(DcMotor.class, "FL");
        drivetrain[1][0] = hardwareMap.get(DcMotor.class, "FR");
        drivetrain[0][1] = hardwareMap.get(DcMotor.class, "BL");
        drivetrain[1][1] = hardwareMap.get(DcMotor.class, "BR");

        imu = hardwareMap.get(IMU.class, "imu");
        ImuOrientationOnRobot controlHubDirection = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,RevHubOrientationOnRobot.UsbFacingDirection.UP);
        imu.initialize(new IMU.Parameters(controlHubDirection));
        opModeTimer = new ElapsedTime();
    }
    @Override
    public void start(){
        opModeTimer.reset();
    }
    @Override
    public void loop(){
        double angle = Math.toDegrees(imu.getRobotYawPitchRollAngles().getYaw());
        telemetry.addData("angle", angle);
        double error = angle/180.0;
        drivetrain[0][0].setPower(0.5 + error);
        drivetrain[0][1].setPower(0.5 + error);

        drivetrain[1][0].setPower(0.5 - error);
        drivetrain[1][1].setPower(0.5 - error);
        if(opModeTimer.seconds() > 3){
            stop();
        }
    }
    @Override
    public void stop(){
        drivetrain[0][0].setPower(0);
        drivetrain[1][0].setPower(0);
        drivetrain[0][1].setPower(0);
        drivetrain[1][1].setPower(0);
    }
}


