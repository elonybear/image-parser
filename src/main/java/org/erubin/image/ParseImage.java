package org.erubin.image;

import com.google.common.io.Resources;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ParseImage {

  public static void main(String[] args) throws IOException {
    final BufferedImage image = ImageIO.read(Resources.getResource("IMG_5845.jpg"));

    Graphics2D graph = image.createGraphics();

    graph.setColor(Color.GREEN);

    for (int y = 0; y < image.getHeight(); y++) {
      for (int x = 0; x < image.getWidth(); x++) {
        int  clr   = image.getRGB(x, y);
        int  red   = (clr & 0x00ff0000) >> 16;
        int  green = (clr & 0x0000ff00) >> 8;
        int  blue  =  clr & 0x000000ff;

        if(red > green && red > blue) {
          graph.drawRect(x - 5, y - 5, 10, 10);
        }
      }
    }

    try {
      ImageIO.write(image, "jpg", new File("altered.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
