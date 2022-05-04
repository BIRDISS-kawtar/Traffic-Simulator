package Traffic;
import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class carF extends Vehicule {
	
	Image cf;
	public carF(int xx,int yy) {
		super(xx,yy);
		speed = -5;
		width = 50 ;
		height = 66;
		try{
			cf = ImageIO.read(new File("images/car5.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public void drawCar(Graphics g) {
		g.drawImage(cf,vx,vy,null);
		
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