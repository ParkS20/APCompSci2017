import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;


public class BoardSpace  extends JPanel implements Runnable, MouseListener{
    boolean ingame = false;
    boolean laser = false; 
    double laserTimer = 0; 
    private Dimension d;
    int BOARD_WIDTH=500;
    int BOARD_HEIGHT=500;
    boolean playStart = true; 
    int x = 0;
    BufferedImage alienImage;
    BufferedImage shotImage;
    BufferedImage playerImage;
    String message = "Click Board to Start";
    String startLaserMessage = "Click Enter for Laser (only have 1 sec)"; 
    String startShotMessage = "Click Space for Shooting"; 
    String score = "Score: "; 
    String Timer = "";
    private Thread animator;
    Alien[][] a = new Alien[3][10]; 
    int count = 0; 
    int key = 0; 
    GameChar pl = new Player(BOARD_WIDTH/2 -50 , BOARD_HEIGHT - 75); 
    GameChar sh = new Shot(pl.x, pl.y);
    ArrayList<Integer> shotsx= new ArrayList<Integer>();
    ArrayList<Integer> shotsy= new ArrayList<Integer>();
    
    public BoardSpace(){
        addKeyListener(new TAdapter()); 
        addMouseListener(this); 
        setFocusable(true); 
        d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT); 
        setBackground(Color.black); 
        int ax = 10; 
        int ay = 10; 
        for(int r=0; r<a.length;r++){
            for(int c=0; c<a[0].length; c++){
                a[r][c] = new Alien(ax, ay); 
                ax += 49; 
            }
            ax = 10; 
            ay += 30; 
        }
        
        try {
            alienImage = ImageIO.read(this.getClass().getResource("alien.png"));
            shotImage = ImageIO.read(this.getClass().getResource("ashot.png"));
            playerImage = ImageIO.read(this.getClass().getResource("player.png"));
        } catch (IOException e) {
            System.out.println("Image could not be read");
            // System.exit(1);
        }
        if (animator == null || !ingame) {
            animator = new Thread(this);
            animator.start();
        }
                    
  
        setDoubleBuffered(true);
    

    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.white); 
        Font small = new Font("Helvetica", Font.BOLD, 24);
        FontMetrics metr = this.getFontMetrics(small);
        g.setFont(small);
        g.drawString(message, d.width/2-(message.length() * (13/2)), d.height/2);
        
        Font small1 = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr1 = this.getFontMetrics(small1);
        g.setFont(small1);
        g.drawString(score, d.width - 70, 20);
        
        Font small2 = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr2 = this.getFontMetrics(small1);
        g.setFont(small2);
        g.drawString(Timer, 20, 20);
        
        Font small3 = new Font("Helvetica", Font.BOLD, 16);
        FontMetrics metr3 = this.getFontMetrics(small);
        g.setFont(small3);
        g.drawString(startLaserMessage, d.width/2 - (startLaserMessage.length() * (4)), d.height/2 + 20);
        
        Font small4 = new Font("Helvetica", Font.BOLD, 16);
        FontMetrics metr4 = this.getFontMetrics(small);
        g.setFont(small4);
        g.drawString(startShotMessage, d.width/2 - (startShotMessage.length()*(4)), d.height/2 + 40);
        if(playStart){
            int ax = 10; 
            int ay = 10; 
            pl.x = BOARD_WIDTH/2 - 40;
            count = 0; 
            for(int r=0; r<a.length;r++){
                for(int c=0; c<a[0].length; c++){
                    a[r][c].x = ax; 
                    a[r][c].y = ay; 
                    ax += 49; 
                }
                ax = 10; 
                ay += 30; 
            }
            for(int j=shotsy.size()-1; j>0;j--){
                shotsx.remove(j);
                shotsy.remove(j);
            }
            laserTimer = 0.0; 
            Timer= "Laser Time" + laserTimer; 
            playStart = false; 
        }
        if (ingame) {
            if(laser){
                shotsx.add(pl.x + 40); 
                shotsy.add(pl.y -20); 
                laserTimer += 0.05; 
                Timer = "Laser Time" + laserTimer; 
                if(laserTimer >= 1)
                    laser = false; 
            }
            g.setColor(Color.white);
            g.fillOval(10,10,5,5);
            g.fillOval(50,30,5,5);
            g.fillOval(90,120,5,5);
            g.fillOval(10,360,5,5);
            g.fillOval(30,280,5,5);
            g.fillOval(100,20,5,5);
            g.fillOval(100,10,5,5);
            g.fillOval(250,30,5,5);
            g.fillOval(390,120,5,5);
            g.fillOval(410,360,5,5);
            g.fillOval(330,280,5,5);
            g.fillOval(100,200,5,5);
            g.fillOval(160,30,5,5);
            g.fillOval(290,100,5,5);
            g.fillOval(340,390,5,5);
            g.fillOval(130,180,5,5);
            g.fillOval(430,400,5,5);
            g.fillOval(290,300,5,5);
            g.fillOval(320,410,5,5);
            g.fillOval(240,330,5,5);
            g.fillOval(390,440,5,5);
            g.drawImage(playerImage, pl.x, pl.y, 100, 50 ,null);
            for(int r=0; r<a.length;r++){
                for(int c=0; c<a[0].length; c++){
                    g.drawImage(alienImage,a[r][c].x, a[r][c].y, 20, 20, null); 
                }
            }
            for(int r=0; r<a.length;r++){
                for(int c=0; c<a[0].length; c++){
                    if((a[r][c].y-10)%60 ==0){
                        if((a[r][c].x + 14)>(BOARD_WIDTH-13)){
                            a[r][c].y += 30; 
                        }else
                            a[r][c].x += 14; 
                    }else{
                        if((a[r][c].x - 14)<10){
                            a[r][c].y += 30; 
                        }else
                            a[r][c].x -= 14; 
                    }
                    if(a[r][c].y>=BOARD_HEIGHT && a[r][c].y<=(BOARD_HEIGHT+50)){
                        message = "Game Over! Click Again to Play Again"; 
                        ingame=false; 
                        playStart = true; 
                    }
                }
            }
            for(int i=0; i<shotsx.size();i++){
                g.drawImage(shotImage,shotsx.get(i), shotsy.get(i), 20, 20, null);
            }
            for(int j=0; j<shotsy.size();j++){
                shotsy.set(j,shotsy.get(j) - 10);
            }
            for(int i=0; i<shotsx.size();i++){
                for(int r=0; r<a.length;r++){
                    for(int c=0; c<a[0].length; c++){
                        try{
                            if(shotsx.get(i) > a[r][c].x && shotsx.get(i) < (a[r][c].x +15)&& 
                            shotsy.get(i) > a[r][c].y && shotsy.get(i) < (a[r][c].y + 25)){
                                a[r][c].y = 1000;
                                shotsx.remove(i); 
                                shotsy.remove(i);
                                count ++; 
                                score = "Score: " + count; 
                            }
                        }catch(Exception e){
                        }
                    }
                }
            }
            if(count >= (a.length*a[0].length)){
                message = "You Win! Click Again to Play Again"; 
                ingame = false; 
            }
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    private class TAdapter extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == 10){
                laser = false;  
            }
        }
        public void keyPressed(KeyEvent e) {
            //System.out.println( e.getKeyCode());
            int key = e.getKeyCode();
            if(key == 37){
                pl.x -= 10; 
                if(pl.x <= 0)
                    pl.x = 0; 
            }
            if(key == 39){
                pl.x += 10; 
                if(pl.x >= (BOARD_WIDTH-100))
                    pl.x = BOARD_WIDTH-100; 
            }
            if(key == 32){
                shotsx.add(pl.x + 40); 
                shotsy.add(pl.y -20); 
            }
            if(key == 10){
                laser = true;  
                if(laserTimer >= 1)
                    laser = false; 
            }
        }
    }
    
    
    
    
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        message = "";
        startShotMessage = ""; 
        startLaserMessage = ""; 
        ingame = true; 
        playStart = true; 
    }
    
    public void mouseReleased(MouseEvent e) {
        
    }
    
    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
        
    }
    
    public void mouseClicked(MouseEvent e) {
        
    }
    
    public void run() {
        
        long beforeTime, timeDiff, sleep;
        
        beforeTime = System.currentTimeMillis();
        int animationDelay = 30;
        long time = 
        System.currentTimeMillis();
        while (true) {//infinite loop
            // spriteManager.update();
            repaint();
            try {
                time += animationDelay;
                Thread.sleep(Math.max(0,time - 
                System.currentTimeMillis()));
            }catch (InterruptedException e) {
                System.out.println(e);
            }//end catch
        }//end while loop

    


    }//end of run

}//end of class
