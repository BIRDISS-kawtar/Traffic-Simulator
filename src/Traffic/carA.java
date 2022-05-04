package Traffic;
import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class carA extends Vehicule {
	
	Image ca;
	public carA(int xx,int yy) {
		super(xx,yy);
		speed = 14;
		width = 100;
		height = 50;
		try{
			ca = ImageIO.read(new File("images/car2.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public void drawCar(Graphics g) {
		g.drawImage(ca,vx,vy,null);	
	}
	public void changeDirection(Graphics g,int n) {
		if(n==1) {
				try {
					ca= ImageIO.read(new File("images/RenvCar2.png"));
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				g.drawImage(ca,vx,vy,null);
			}
	}
	public void Accelerate(int STA) {
		speed=speed+STA;
		vx=vx+speed;
	}
	public void Decelerate(int STA) {
		speed=speed-STA;
		vx=vx+speed;
	}
}
