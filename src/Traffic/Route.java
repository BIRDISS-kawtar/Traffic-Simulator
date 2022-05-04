package Traffic;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;

// On utilise JPanel pour pouvoir dessiner la route
public class Route extends JPanel{
	protected ArrayList<Vehicule> cars;
	protected ArrayList<Vehicule> carsRtL;
	protected ArrayList<Vehicule> carsLtR;
	protected ArrayList<Vehicule> carsUtD;
	protected ArrayList<Vehicule> carsDtU;
	protected ArrayList<Lights> lights;
	protected ArrayList<String> Accidents;
	protected int rx;
	protected int ry;
	protected int rwidth;
	protected int rheight;
	protected String Identity;
	public Route() {
		super();
	}
	public Route(int xx,int yy,int rw,int rh) {
		rx=xx;
		ry=yy;
		rwidth=rw;
		rheight=rh;
		
	}
	
	public void setIdentity(int index,String roadType) {
		Identity = roadType+" N"+index;
	}
	public void setRx(int x) {
		rx=x;
	}
	public void setRy(int y) {
		ry=y;
	}
	public int getRx() {
		return rx;
	}
	public int getRy() {
		return ry;
	}
	public void setRh(int h) {
		rheight=h;
	}
	public int getRh() {
		return rheight;
	}
	public void setRw(int w) {
		rwidth=w;
	}
	public int getRw() {
		return rwidth;
	}
	public String getIdentity() {
		if(Identity==null) {
			Identity="BORDS";
		}
		return Identity ;
	}
	public void addCar(Vehicule v) {};
	public void carsToRoad(Graphics g) {};	
}
