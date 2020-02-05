/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import java.awt.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2Video;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import io.github.pseudoresonance.pixy2api.Pixy2Video.RGB;
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
    pixyVideo = pixy2Video(pixy);
  }
  
  public boolean getRecentBlocks(Color color) {
    // Get data from all blocks and recieve said data
    pixyCCC.getBlocks(true, 255, 255);
    ArrayList<Block> blocks = pixyCCC.getBlocks();

    // Send gets data from largest block (color)
    Color myColor = getBlockColor(blocks.get(0));
    return(myColor.equals(color));
  }

  // Gets a color for a block
  public Color getBlockColor(Block block) {
    int x = block.getX();
    int y = block.getY();
    RGB myRGB = pixyVideo.new RGB(0, 0, 0);
    pixyVideo.getRGB(x, y, myRGB, false);
    return myRGB.getColor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
