/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2Video;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import io.github.pseudoresonance.pixy2api.links.Link;
import io.github.pseudoresonance.pixy2api.links.SPILink;

public class Vision extends SubsystemBase {

  // FIELDS
  Pixy2 pixy;
  Pixy2CCC pixyCCC;
  Pixy2Video pixyVideo;

  public Vision(Link link) {
    pixy.init();
    pixy = Pixy2.createInstance(link);
    pixyCCC = pixy.getCCC();
    pixyVideo = pixy(pixy);
  }
  
  public void getRecentBlocks() {
    // Get data from all blocks and recieve said data
    pixyCCC.getBlocks(true, 255, 255);
    ArrayList<Block> blocks = pixyCCC.getBlocks();

    // Send largest blocks to a method to get their color
    for (int i = 0; i < 5; i++) {
      getBlockColor(blocks.get(i));
    }
  }

  public Color getBlockColor(Block block) {
    int x = block.getX();
    int y = block.getY();
    pixyVideo.
    return null;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
