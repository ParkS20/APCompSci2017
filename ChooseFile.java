import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.filechooser.*;
import java.io.*;






public class ChooseFile extends JPanel implements ActionListener {
    JButton go;
    String sourceFolder="";
    String theFile="";
    JFileChooser chooser;
    String choosertitle;
    public ChooseFile() {
        go = new JButton("Choose Folder");
        go.addActionListener(this);
        add(go);
    }

    public void actionPerformed(ActionEvent e) {
 
        System.out.println("Button Clicked");
        chooser = new JFileChooser(); 
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "JPG, PNG & GIF Images", "jpg", "gif", "png");
        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
            String dirr = "" + chooser.getCurrentDirectory();
            File file = chooser.getSelectedFile();
            if(dirr.substring(dirr.length()-1,dirr.length()).equals(".")){
                dirr = dirr.substring(0,dirr.length()-1);
                sourceFolder=""+dirr + "" + file.getName();
            }else{
                
                sourceFolder=""+dirr + "/" + file.getName();
            }
            
            System.out.println("Folder path: " + dirr + " | File Name: " + file.getName());
            System.out.println(sourceFolder);
            ExamineImage.lum(sourceFolder);
            
        }else {
            System.out.println("No Selection ");
        }
    }
    
    public Dimension getPreferredSize(){
        return new Dimension(200, 200);
    }
    
    public static void main(String s[]) {
        JFrame frame = new JFrame("");
        ChooseFile panel = new ChooseFile();
        frame.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        frame.getContentPane().add(panel,"Center");
        frame.setSize(panel.getPreferredSize());
        frame.setVisible(true);
    }
}