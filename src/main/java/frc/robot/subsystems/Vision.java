/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.pseudoresonance.pixy2api.*;
import io.github.pseudoresonance.pixy2api.links.*;

public class Vision extends SubsystemBase {

  SPILink spiLink = new SPILink();
  Pixy2 pixy = new Pixy2(spiLink);
  Pixy2CCC pixy2CCC = new Pixy2CCC();
  
  public Vision() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
