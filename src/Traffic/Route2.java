package Traffic;

	import java.awt.BasicStroke;
	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.util.ArrayList;

	public class Route2 extends Route {
		public Route2(int x,int y,int w,int h) {
			super(x,y,w,h);
			cars= new ArrayList<Vehicule>();
			carsRtL= new ArrayList<Vehicule>();
			carsLtR= new ArrayList<Vehicule>();
			carsUtD= new ArrayList<Vehicule>();
			carsDtU= new ArrayList<Vehicule>();
		}
		
		public void addCar(Vehicule v) {
			cars.add(v);
		}
		public void addCarLR(Vehicule v) {
			carsLtR.add(v);
		}
		public void addCarRL(Vehicule v) {
			carsRtL.add(v);
		}
		public void addCarUD(Vehicule v) {
			carsUtD.add(v);
		}
		public void addCarDU(Vehicule v) {
			carsDtU.add(v);
		}
		//Drawing Roads 
		public void drawRoundabout(Graphics g) {
			g.setColor(Color.GRAY);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(220));
			g.drawArc(rx, ry, rwidth,rheight, 0, 360);
			for(int i=0;i<360 ;i++) {
				g.setColor(Color.WHITE);
			}
			g2.setStroke(new BasicStroke(2));
		}
		public void carsToRoad(Graphics g) {
			  for(int j=0; j<cars.size();j++) {
					cars.get(j).drawCar(g);
		    	}
		}
	}
