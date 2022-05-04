package Traffic;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
public class PriorityMark extends Carrefour {
	Image picture,picture1,picture2,picture3;
	// NB: give d=-1 if it's not used
	public PriorityMark(int x,int y,int d) {
		super(x,y,d);
		roadsConnected=1;
		try{
			picture = ImageIO.read(new File("images/PRIORITY.png"));
			picture1 = ImageIO.read(new File("images/PRIORITY1.png"));
			picture2= ImageIO.read(new File("images/PRIORITY2.png"));
			picture3 = ImageIO.read(new File("images/PRIORITY3.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void drawCarrefour(Graphics g,int n) {
		if(n==0) {
			g.drawImage(picture,cx,cy,null);
		} 
		if(n==1) {
			g.drawImage(picture1,cx,cy,null);
		} 
		if(n==2) {
			g.drawImage(picture2,cx,cy,null);
		} 
		if(n==3) {
			g.drawImage(picture3,cx,cy,null);
		} 
	}
}
