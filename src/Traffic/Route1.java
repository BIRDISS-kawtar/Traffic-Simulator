package Traffic;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;

public class Route1 extends Route {
	Lights carrefour1= new Lights(rx+rwidth-165,ry+rheight-11,30);
	Lights carrefour2= new Lights(rx-14,ry-14,30);
	Lights carrefour3= new Lights(rx+rwidth-19,ry-14,30);
	Lights carrefour4= new Lights(rx-20,ry+rheight-20,30);
	public Route1(int x,int y,int w,int h) {
		super(x,y,w,h);
		cars= new ArrayList<Vehicule>();
		carsRtL= new ArrayList<Vehicule>();
		carsLtR= new ArrayList<Vehicule>();
		carsUtD= new ArrayList<Vehicule>();
		carsDtU= new ArrayList<Vehicule>();
		Accidents= new ArrayList<String>();
		lights = new ArrayList<>();
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
	// Drawing horizontal roads
	public void drawRoadH1(Graphics g,Color c,int n) {
		g.setColor(c);
		g.fillRect(rx,ry,rwidth,rheight);
		g.setColor(Color.yellow);
		g.drawLine(rx+rx/18,ry+rheight/2, rx+rwidth-145, ry+rheight/2);
		for(int i=0,j=1;i<rwidth && j<n ;i=i+66,j++) {
			g.setColor(Color.WHITE);
			g.fillRect(rx+rx/18+i,ry+rheight/4,40,10);
			g.fillRect(rx+rx/18+i,ry+3*rheight/4,40,10);
			
		}
	
		}
	public void drawRoadH2(Graphics g,Color c) {
		g.setColor(c);
		g.fillRect(rx,ry,rwidth,rheight);
		g.setColor(Color.yellow);
		g.drawLine(rx+rx/18,ry+rheight/2, rx+rwidth-145, ry+rheight/2);
		for(int i=0,j=1;i<rwidth && j<3 ;i=i+66,j++) {
			g.setColor(Color.WHITE);
			g.fillRect(rx,ry+rheight/4,40,10);
			g.fillRect(rx,ry+3*rheight/4,40,10);
			
		}
	
		}
	// Drawing vertical roads
	public void drawRoadV1(Graphics g,int number) {
		g.setColor(Color.GRAY);
		g.fillRect(rx,ry,rwidth,rheight);
		g.setColor(Color.yellow);
		g.drawLine(rx+rwidth/2,ry+rheight/18, rx+rwidth/2, ry+rheight);
		for(int i=0,j=1;i<rheight-50 && j<=number;i=i+56,j++) {
			g.setColor(Color.WHITE);
			g.fillRect(rx+rwidth/4,ry+ry/18+i,10,40);
			g.fillRect(rx+3*rwidth/4,ry+ry/18+i,10,40);
		}
	}
	
	public void carsToRoad(Graphics g) {
		  for(int j=0; j<cars.size();j++) {
				cars.get(j).drawCar(g);
	    	}
	}
	// Collisions management
	// Left to Right 
	public boolean collisionsHLR(int x, int y, int w, Vehicule v) {
		for(int i=0;i<carsLtR.size();i++) {
		Vehicule vhh = carsLtR.get(i);
			if( v.getx()+ v.getw() > vhh.getx() && vhh.getx()+ vhh.getw() > v.getx() ) {
				return true;
			}
			if( vhh.gety()+vhh.geth()<v.gety() && vhh.gety()<v.gety()+v.geth()) {
				return true;
			}
		}
		return false;
	}
	// Right to Left 
	public boolean collisionsHRL(int x, int y, int w, Vehicule v) {
	for(int j=0;j<carsRtL.size();j++) {
		Vehicule vhh1 = carsRtL.get(j);
			if( v.getx()+ v.getw() > vhh1.getx() && vhh1.getx()+ vhh1.getw() > v.getx() ) {
				return true;
			}
			if( vhh1.gety()+vhh1.geth()<v.gety() && vhh1.gety()<v.gety()+v.geth()) {
				return true;
			}
	}
		return false;
	}
	// Down to Up 
	public boolean collisionsVDU(int x,int y,int w,Vehicule v) {
		for(int j=0;j<carsDtU.size();j++) {
			Vehicule vhh2 = carsDtU.get(j);
				if(v.getx()<=vhh2.getw()+vhh2.getx() && v.getx()>=vhh2.getx()-v.getw()) {
					return true;
				}
				if(v.gety()<=vhh2.geth()+vhh2.gety() && v.gety()>=vhh2.gety()-v.geth()) {
					return true;
				}
		}
		return false;
	}
	public boolean collisionsVUD(int x,int y,int w,Vehicule v) {
		for(int j=0;j<carsUtD.size();j++) {
			Vehicule vhh2 = carsUtD.get(j);
				if(v.getx()<=vhh2.getw()+vhh2.getx() && v.getx()>=vhh2.getx()-v.getw()) {
					return true;
				}
				if(v.gety()<=vhh2.geth()+vhh2.gety() && v.gety()>=vhh2.gety()-v.geth()) {
					return true;
				}
			}
		return false;
	}
	public void createCarrefour() {
		lights.add(carrefour1);
		lights.add(carrefour2);
	}
	public void createCarrefourV() {
		lights.add(carrefour3);
		lights.add(carrefour4);
	}
	
	public ArrayList<Lights> getC1() {
		ArrayList<Lights> t1=new ArrayList<Lights>();
		t1.add(carrefour1);
		t1.add(carrefour2);
		return t1;
	}
	public Lights getC2() {
		return carrefour3;
	}
	public Lights getC3() {
		return carrefour4;
	}
	
}