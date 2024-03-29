package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmServos;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class RedDuckIntakeCommand extends SequentialCommandGroup {

    public RedDuckIntakeCommand(Lift lift, Intake intake, ArmServos armServos, Drivetrain drivetrain) {
        addRequirements(lift, intake, armServos, drivetrain);
        addCommands(
//                new WaitUntilCommand(sensorColor::freightInBox).withTimeout(700),

                        new SequentialCommandGroup(
                                new InstantCommand(intake::autoIntake),
                                new DriveForwardCommand(drivetrain, -8),

                                new WaitCommand(100),
//                                new InstantCommand(armServos::boxClose),
//                                new InstantCommand(armServos::armHighDrop),
                                new TurnToCommand(drivetrain, 180),
                                new DriveForwardCommand(drivetrain,14),

                                new TurnToCommand(drivetrain, 168),
                                new DriveForwardCommand(drivetrain,-9)
                        ),
                        new SequentialCommandGroup(
                                new TurnToCommand(drivetrain, 130),
                                new DriveForwardCommand(drivetrain, 5),
//                                new InstantCommand(armServos::boxClose),
//                                new InstantCommand(armServos::armHighDrop),

                                new DriveForwardCommand(drivetrain, -8),
                                new TurnToCommand(drivetrain, 180),
                                new DriveForwardCommand(drivetrain,-14),

                                new TurnToCommand(drivetrain, 270),
                                new DriveForwardCommand(drivetrain,-9)
                        )

//                new InstantCommand(armServos::boxClose)

        );
    }
}
