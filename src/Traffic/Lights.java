package Traffic;
import java.awt.*;
import javax.swing.*;
public class Lights extends Carrefour {

	private static final long serialVersionUID = 1L;

	protected int iValue;
	protected int iValue2 ;
	protected int topLightHeight;
	protected Color Color;
	public Lights(int x,int y,int d) {
		super(x,y,d);
		 iValue = 0;
		 iValue2 = 4;
		 topLightHeight=10; 
		 roadsConnected=1;
	}
	public int getX() {
		return cx;
	}
	public int getY() {
		return cy;
	}
	public int getD() {
		return cd;
	}
	public Color getColor() {
		return this.Color;
	}

	public int getValue() {
		return this.iValue;
	}
	public int getValue2() {
		return this.iValue2;
	}

	public void incrementValue() {
		if (this.iValue == 25) {
			this.iValue = -1;
		}

		this.iValue = this.iValue + 1;
	}
	public void incrementValue2() {
		if (this.iValue2 == 25) {
			this.iValue2 = -1;
		}

		this.iValue2 = this.iValue2 + 1;
	}

}


