package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@Disabled
public class Reference extends LinearOpMode{

    @Override
    public void runOpMode() {

        // Setup a motor
        // Change "motorName" to match the name of the motor in the driver station configuration
        DcMotor motorName;
        motorName = hardwareMap.get(DcMotor.class, "motorName");
        motorName.setDirection(DcMotorSimple.Direction.FORWARD); //

        // Setup a servo
        // Change "servoName" to match the name of the servo in the driver station configuration
        Servo servoName;
        servoName = hardwareMap.get(Servo.class, "servoName");
        servoName.setDirection(Servo.Direction.FORWARD);


        waitForStart();

        while(opModeIsActive()){

            // Gamepad Buttons
            // left_stick_x     Type: double
            // left_stick_y     Type: double
            // right_stick_x    Type: double
            // right_stick_y    Type: double

            // left_trigger     Type: double
            // left_bumper      Type: boolean
            // right_trigger    Type: double
            // right_bumper     Type: boolean

            // a    Type: boolean
            // x    Type: boolean
            // y    Type: boolean
            // b    Type: boolean


            // stores a value from a gamepad button
            // replace "left_stick_x" with the button that you want
            // replace "double" with the button type
            double myVariable = gamepad1.left_stick_x;


            // Ensure that a variable is between two values (between -1 and 1 in this example)
            // If a variable is less than -1, it will be set to -1
            // If it is greater than 1, it will be set to 1
            myVariable = Range.clip(myVariable, -1, 1);


            // Set the power of a motor
            // Ranges from -1.0 (spin backwards at full power) to 1.0 (spin forwards at full power)
            motorName.setPower(0);


            // Set the position of a servo
            // Ranges from 0.0 to 1.0
            servoName.setPosition(0);
        }
    }
}
