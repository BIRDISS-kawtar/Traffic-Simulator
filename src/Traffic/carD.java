package Traffic;
import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class carD extends Vehicule {
	
	Image cd;
	public carD(int xx,int yy) {
		super(xx,yy);
		speed = -7;
		width = 100;
		height = 50;
		try{
			cd = ImageIO.read(new File("images/car1.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public void drawCar(Graphics g) {
		g.drawImage(cd,vx,vy,null);
		
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