package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

// Mechanisms Import
import org.firstinspires.ftc.teamcode.Commands.MoveBand;
import org.firstinspires.ftc.teamcode.Commands.MoveIntake;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

@TeleOp
public class MainSystem extends LinearOpMode {
    Chassis chassis;
    Band band;
    Elevator elevator;
    Claw claw;
    Intake intake;
    GamepadEx driverOp;
    GamepadEx toolOp;

    @Override
    public void runOpMode() {


        chassis     = new Chassis(hardwareMap);     // Create an instance of Chassis
        elevator    = new Elevator(hardwareMap);    // Create an instance of Elevator
        intake      = new Intake(hardwareMap, "intake");      // Create an instance of Intake
        band        = new Band(hardwareMap);        // Create an instance of Band
        claw        = new Claw(hardwareMap);        // Create an instance of Claw
        //shooter     = new Shooter(hardwareMap);     // Create an instance of Shooter
         driverOp = new GamepadEx(gamepad1);
         toolOp = new GamepadEx(gamepad2);

        Button buttonA = driverOp.getGamepadButton(GamepadKeys.Button.A);

        buttonA.whenPressed(new MoveIntake(intake,1));



        waitForStart();

        while (opModeIsActive()) {
            // Chassis
//            chassis.setSpeed(driverGamepad.left_stick_y, driverGamepad.right_stick_x);
//                //SlowMode
//                if (driverGamepad.left_bumper) {
//                    chassis.setSpeed(-driverGamepad.left_stick_y * 0.3,
//                            -driverGamepad.right_stick_x * 0.3);
//                } else {
//                    chassis.setSpeed(-driverGamepad.left_stick_y, -driverGamepad.right_stick_x);
//                }

            /*/ Intake
            if (operatorGamepad.right_bumper) {
                intake.IntakeVoltage(2); // Voltage Pendant to Adjust
            } else if (operatorGamepad.left_bumper) {
                intake.IntakeVoltage(-2); // Voltage Pendant to Adjust
            } else {
                intake.IntakeVoltage(0);
            }
            */

            // Claw
//            if (operatorGamepad.x) {
//                claw.ClawVoltage(1); // Voltage Pendant to Adjust
//
//            } else if(operatorGamepad.y) {
//                claw.ClawVoltage(0); // Voltage Pendant to Adjust
//            }

            /*/ Band
            if (operatorGamepad.dpad_up) {
                band.BandVoltage(1); // Voltage Pendant to Adjust
            } else if (operatorGamepad.dpad_down) {
                band.BandVoltage(-1); // Voltage Pendant to Adjust
            } else{
                band.BandVoltage(0); // Voltage Pendant to Adjust
            }
             */

            // Elevator
//            if (operatorGamepad.triangle) {
//                elevator.ElevatorVoltageMotor1(1); // Voltage TBD
//                elevator.ElevatorVoltageMotor2(1); // Voltage TBD
//
//            } else if (operatorGamepad.circle) {
//                elevator.ElevatorVoltageMotor1(-1); // Voltage TBD
//                elevator.ElevatorVoltageMotor2(-1); // Voltage TBD
//            } else {
//                elevator.ElevatorVoltageMotor1(0);
//                elevator.ElevatorVoltageMotor2(0);
//            }

            /*
            // Shooter
                if (driverGamepad.right_bumper) {
                    shooter.ShooterVoltage(1); // Voltage Pendant to Adjust
                }   else {
                    shooter.ShooterVoltage(0); // Voltage Pendant to Adjust
                }*/


            // -- TELEMETRY -- //

            telemetry.addData("Status", "Enabled.");

//            // Velocities
//            telemetry.addData("LinearVel", -driverGamepad.left_stick_y);
//            telemetry.addData("AngularVel", -driverGamepad.right_stick_x);

            // Distance per side in CM
            telemetry.addData("RightDistance", chassis.rightDistance());
            telemetry.addData("LeftDistance", chassis.leftDistance());


            // Update Telemetry
            telemetry.update();
        }
    }
}