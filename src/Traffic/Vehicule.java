package Traffic;

import java.awt.Graphics;


public class Vehicule {
	
	protected int vx;
	protected int vy;
	protected int width;
	protected int height;
	protected String identity;
	protected Route1 PremiereRoutePos;
	protected Route1 RoutePos;
	protected boolean Block;
	protected float AttenteCarrefour=1100;
	
	protected int speed;
	public 	Vehicule(int nx,int ny) {
		vx=nx;
		vy=ny;
	}
	public void drawCar( Graphics vg) {} 
	public int getx() {
		return vx;
	}
	public float getAttenteCarr() {
		return AttenteCarrefour;
	}
	public void setAttenteCarr(float rr) {
		AttenteCarrefour=rr;
	}
	public boolean getBlock() {
		return Block;
	}
	public void setBlock(int rr) {
		if(rr==1) {
			Block=false;
		}
		if(rr==2) {
			Block=true;
		}
	}
	public Route1 getPRoute() {
		return PremiereRoutePos;
	}
	public void setPRoute(Route1 rr) {
		PremiereRoutePos= rr;
	}
	public Route1 getRoute() {
		return RoutePos;
	}
	public void setRoute(Route1 rr) {
		RoutePos= rr;
	}
	public int gety() {
		return vy;
	}
	public int getw() {
		return width;
	}
	public int geth() {
		return height;
	}
	public int getSpeed() {
		return speed;
	}
	public String getIdentity() {
		return identity;
	}
	public void setx(int xo) {
		vx=xo;
	}
	public void sety(int yo) {
		vy=yo;
	}
	public void setw(int w) {
		width=w;
	}
	public void seth(int h) {
		height=h;
	}
	
	public void setSpeed(int s) {
		speed = s;
	}
	public void setIdentity(int index,String type) {
		identity = type+" N"+index; 
	}
	public void changeDirection(Graphics g,int a) {}
	public void Accelerate(int SpeedToAdd) {}
	public void Decelerate(int SpeedToAdd) {}
	public void Stop() {
		speed=0;
	}
	
}
