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
import io.github.pseudoresonance.pixy2api.links.SPILink;

public class Vision extends SubsystemBase {

  // FIELDS
  Pixy2 pixy;
  Pixy2CCC pixyCCC;
  Pixy2Video pixyVideo;
  SPILink link = new SPILink();;

  public Vision() {
    pixy = Pixy2.createInstance(link);
    pixy.init();
    pixyCCC = pixy.getCCC();
    pixyVideo = pixy.getVideo();
  }
  
  /**
   * Gets an arraylist of all the current "blocks" the camera detects and returns true
   * if the largest block's color matches the one inputed
   * 
   * @param color Color to check if the largest block matches it
   * @return Returns true if the colors inputed and of the largest block are the same
   */
  public boolean getRecentBlocks(Color color) {
    // Get data from all blocks and recieve said data
    pixyCCC.getBlocks(true, 255, 255);
    ArrayList<Block> blocks = pixyCCC.getBlocks();

    // Send and gets data from largest block (color)
    Color myColor = getBlockColor(blocks.get(0));
    return(myColor.equals(color));
  }

  /**
   * Given a block, this method will return the color surrounding the 5x5 space of the 
   * x and y coords of the block
   * 
   * @param block Block to use x and y coords and find color of
   * @return Returns the color in the 5x5 area of the x and y coords of the block
   */
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
