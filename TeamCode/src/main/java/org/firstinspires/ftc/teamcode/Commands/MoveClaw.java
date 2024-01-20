package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.util.Timing;
import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;

import java.util.concurrent.TimeUnit;

public class MoveClaw extends CommandBase {

    private Claw claw;
    private double ClawMotorPosition;
    private Timing.Timer timer;

    public MoveClaw(Claw subsystem, double ClawMotorPosition) {
        claw = subsystem;
        this.ClawMotorPosition = ClawMotorPosition;
        timer = new Timing.Timer(1000, TimeUnit.SECONDS);
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        claw.ClawPosition(ClawMotorPosition);
        //timer.start();
    }


    @Override
    public boolean isFinished() {
        claw.ClawPosition(0);
        return timer.done(); //Will not be done as timer has been disabled
    }
}


