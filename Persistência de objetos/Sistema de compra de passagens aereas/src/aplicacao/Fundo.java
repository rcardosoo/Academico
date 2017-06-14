package aplicacao;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Fundo extends JPanel {
	    private BufferedImage img = null;    
	    private int x = 135;  
	    private int y = 60;  
	    public Fundo(String urlImg) throws IOException    {  
	        this.img = ImageIO.read(new File(urlImg));  
	    }  
	    
	    @Override  
	    public void paintComponent(Graphics g) {  
	        super.paintComponent(g);        
	        Graphics gr = (Graphics2D)g.create();  
	        //gr.drawImage(img, x, y,this.getWidth(),this.getHeight(),this); 
	        gr.drawImage(img, x, y,150,150,this); 
	        gr.dispose();     
	    }  


}
