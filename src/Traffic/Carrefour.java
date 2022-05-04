package Traffic;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;


public class Carrefour extends JPanel{
	
	protected int cx;
	protected int cy;
	protected int cd;
	protected int roadsConnected;
	
	
	public Carrefour(int x,int y,int d) {
		cx=x;
		cy=y;
		cd=d;
	}
	
}
