package Traffic;
import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
public class carC extends Vehicule {
	Image cc;
	public carC(int xc,int yc) {
		super(xc,yc);
		speed = -6; 
		width = 100;
		height= 50;
		try {
			cc= ImageIO.read(new File("images/car7.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void drawCar(Graphics g) {
		g.drawImage(cc,vx,vy,null);
	}
	public void changeDirection(Graphics g,int n) {
		if(n==1) {
					try {
					cc= ImageIO.read(new File("images/carRenv7.png"));
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				g.drawImage(cc,vx,vy,null);
			}
		if(n==2) {
			try {
			cc= ImageIO.read(new File("images/carRenvo7.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		g.drawImage(cc,vx,vy,null);
	}
}
	public void Accelerate(int STA) {
		speed=speed-STA;
		vx=vx+speed;
	}
	public void Decelerate(int STA) {
		speed=speed+STA;
		vx=vx+speed;
	}
}
