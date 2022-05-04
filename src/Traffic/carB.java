package Traffic;
import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class carB extends Vehicule{
	Image cb;
	public carB(int xx,int yy) {
		super(xx,yy);
		speed = 14;
		width =100;
		height = 50;
		try{
			cb = ImageIO.read(new File("images/car8.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void drawCar(Graphics g) {
		g.drawImage(cb,vx,vy,null); 
		
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
