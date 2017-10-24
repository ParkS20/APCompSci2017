import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ExamineImage{

    public static void lum(String ffile) {
        BufferedImage img=null;
   
        File myFile = new File(ffile);
        //  File[] listOfFiles = myFolder.listFiles();
        double averageLum = 0; 
        try{

            if (myFile.isFile()) {
                img = ImageIO.read(myFile);
                int width=0;
                int height=0;
                
                int count=0;
                double avg=0;
                if(img!=null){
                    width  = img.getWidth();
                    height  = img.getHeight();
                }
                System.out.println("Width " + width + " " +  height);
                for(int x=0; x < width; x++){
                    for (int y=0;y < height;y++){
                        int pixelCol = img.getRGB(x, y);
                        int a = (pixelCol >>> 24) & 0xff;
                        int r = (pixelCol >>> 16) & 0xff;
                        int g = (pixelCol >>> 8) & 0xff;
                        int b = pixelCol & 0xff;
                        
                        
                        double lum=   (0.2126*r) + (0.7152*g) + (0.0722*b);
                        
                        averageLum += lum; 
                        
                    }
                }  
                
                averageLum = averageLum / (height * width); 
                System.out.println("The average luminance is " + averageLum);
                
                
            }
        }catch(Exception e){
            System.out.println("THERE WAS A PROBLEM " + e);
        }
    }//end of lumanance method
}//end of class