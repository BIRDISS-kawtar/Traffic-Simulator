package Traffic;
import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class carE extends Vehicule {
	
	Image ce;
	public carE(int xx,int yy) {
		super(xx,yy);
		speed = -9;
		width = 50 ;
		height = 66;
		try{
			ce = ImageIO.read(new File("images/car4.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public void drawCar(Graphics g) {
		g.drawImage(ce,vx,vy,null);
		
	}
	public void changeDirection(Graphics g,int n) {
		if(n==1) {
				try {
					ce= ImageIO.read(new File("images/Renvvcar4.png"));
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				g.drawImage(ce,vx,vy,null);
			}
		if(n==2) {
			try {
				ce= ImageIO.read(new File("images/RenvCar4.png"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			g.drawImage(ce,vx,vy,null);
		}
		
	}
	public void Accelerate(int STA) {
		speed=speed-STA;
		vy=vy+speed;
	}
	public void Decelerate(int STA) {
		speed=speed+STA;
		vy=vy+speed;
	}
}