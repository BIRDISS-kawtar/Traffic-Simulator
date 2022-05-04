package Traffic;
import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class carH extends Vehicule {
	
	Image ch;
	public carH(int xx,int yy) {
		super(xx,yy);
		speed = 4;
		width = 50 ;
		height = 66;
		try{
			ch = ImageIO.read(new File("images/car9.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public void drawCar(Graphics g) {
		g.drawImage(ch,vx,vy,null);
		
	}
	public void Accelerate(int STA) {
		speed=speed+STA;
		vy=vy+speed;
	}
	public void Decelerate(int STA) {
		speed=speed-STA;
		vy=vy+speed;
	}
}