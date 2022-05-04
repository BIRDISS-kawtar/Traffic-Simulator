package Traffic;
import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class carG extends Vehicule {
	
	Image cg;
	public carG(int xx,int yy) {
		super(xx,yy);
		speed = 6;
		width = 50;
		height = 66;
		try{
			cg = ImageIO.read(new File("images/car6.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public void drawCar(Graphics g) {
		g.drawImage(cg,vx,vy,null);
		
	}
	public void changeDirection(Graphics g,int n) {
		if(n==1) {
				try {
					cg= ImageIO.read(new File("images/RenvCar6.png"));
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				g.drawImage(cg,vx,vy,null);
			}
		if(n==2) {
			try {
				cg= ImageIO.read(new File("images/car6.png"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			g.drawImage(cg,vx,vy,null);
		}
		if(n==3) {
			try {
				cg= ImageIO.read(new File("Renvvcar6.png"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			g.drawImage(cg,vx,vy,null);
		}
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