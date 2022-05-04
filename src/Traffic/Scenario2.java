package Traffic;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/************************************ Le Scenario des Ronds-points ***********************************/

public class Scenario2 extends JPanel {
	
	Image roundaboutMark,Building1,Building2,Building4,Building5;
	// List of roads 
	protected ArrayList<Route1> roads= new ArrayList<Route1>();
	// List of Vehiculs 
	protected ArrayList<Vehicule> allCars= new ArrayList<Vehicule>();
	// Average time of waiting
	protected ArrayList<Float> Laps= new ArrayList<Float>();
	
	public void paintComponent(Graphics g ) {
		super.paintComponent(g);
		// Roundabouts
		Route2 ra= new Route2(200,350,500,500);
		ra.drawRoundabout(g);
		ra.setIdentity(7, "First Roundabout");
		Route2 ra1= new Route2(1300,350,500,500);
		ra1.drawRoundabout(g);
		ra.setIdentity(8, "Second Roundabout");
		// Horizontal Roads
		Route1 rh1= new Route1(0,473,205,225);
		rh1.drawRoadH1(g, Color.GRAY,3);
		roads.add(rh1);
		Route1 rh2= new Route1(698,473,604,237);
		rh2.drawRoadH1(g, Color.GRAY,8);
		roads.add(rh2);
		Route1 rh3= new Route1(1846,473,170,237);
		rh3.drawRoadH1(g, Color.GRAY,5);
		roads.add(rh3);
		// Vertical Roads 
		Route1 rv1= new Route1(323,0,225,357);
		rv1.drawRoadV1(g,6);
		roads.add(rv1);
		Route1 rv2= new Route1(323,350+500-7,225,357);
		rv2.drawRoadV1(g,6);
		roads.add(rv2);
		Route1 rv3= new Route1(200+123+604+500,0,225,357);
		rv3.drawRoadV1(g,6);
		roads.add(rv3);
		Route1 rv4= new Route1(200+123+604+500,350+500-7,225,357);
		rv4.drawRoadV1(g,6);
		roads.add(rv3);	
		// Adding vehicules into roads 
		for(int i=0;i<roads.size();i++){
			Route a= roads.get(i);
			a.carsToRoad(g);
	    }
		// CrossRoad Signs 
		PriorityMark panneau1= new PriorityMark(35,707,-1);
		panneau1.drawCarrefour(g,0);
		PriorityMark panneau2= new PriorityMark(787,400,-1);
		panneau2.drawCarrefour(g,1);
		PriorityMark panneau3= new PriorityMark(250,200,-1);
		panneau3.drawCarrefour(g,2);
		PriorityMark panneau4= new PriorityMark(550,944,-1);
		panneau4.drawCarrefour(g,3);
		PriorityMark panneau6= new PriorityMark(787+1100,400,-1);
		panneau6.drawCarrefour(g,1);
		PriorityMark panneau5= new PriorityMark(35+1100,707+15,-1);
		panneau5.drawCarrefour(g,0);
		PriorityMark panneau7= new PriorityMark(250+1100,200,-1);
		panneau7.drawCarrefour(g,2);
		PriorityMark panneau8= new PriorityMark(550+1100+20,944,-1);
		panneau8.drawCarrefour(g,3);
		Color frame=new Color(240,171,43);
		Color floor=new Color(57,98,30);
		g.setColor(frame);
		g.fillOval(305,460,290,290);
		g.fillOval(305+1100,460,290,290);
		g.setColor(floor);
		g.fillOval(329,485,240,240);
		g.fillOval(329+1100,485,240,240);
		try {
			roundaboutMark= ImageIO.read(new File("images/roundaboutMark.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		g.drawImage(roundaboutMark,334,490,null);
		g.drawImage(roundaboutMark,334+1100,490,null);
		// Town
		try {
			Building1= ImageIO.read(new File("images/Town1.png"));
			Building2= ImageIO.read(new File("images/Town2.png"));
			Building4= ImageIO.read(new File("images/Town4.png"));
			Building5= ImageIO.read(new File("images/Town5.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		g.drawImage(Building1,730,75,null);
		g.drawImage(Building2,60,75,null);
		g.drawImage(Building5,1700,75,null);
		g.drawImage(Building4,740,1000,null);
		g.drawImage(Building5,1700,1000,null);
		g.drawImage(Building2,60,950,null);
		/********** Affect identity to each road (Horizontal Road or Vertical Road)***********/
		for(int l=0;l<3;l++) {
			Route1 rr=roads.get(l);
			rr.setIdentity(l, "Horizontal Road");
		}
		for(int l=3;l<7;l++) {
			Route1 rr=roads.get(l);
			rr.setIdentity(l, "Vertical Road");
		}
	}	
	// Generate an integer
	public int genererInt(int borneInf, int borneSup){
	   Random random = new Random();
	   int nb;
	   nb = borneInf+random.nextInt(borneSup-borneInf);
	   return nb;
	}
		
	/************** Vehicles Generation **************/
		
	// Deux listes vehicules qui aide a gerer ces dernieres aux ronds points grace a leur acces directe
	ArrayList<Vehicule> RA=new ArrayList<Vehicule>(); 
	ArrayList<Vehicule> RA1=new ArrayList<Vehicule>(); 
		
	// Generate cars
	public void generateCar2(int cercle) {
		Route1 rh=roads.get(0);
		Route1 rh1=roads.get(2);
		Route1 rv=roads.get(3);
		Route1 rv1=roads.get(6);
		int xh=-100,xh1=200+123+604+500+350+80+30,xv1=350,yv1=-40,yh=500,yh1=350+250+60,xv=1550,yv=1200;
		// NB : the "cercle" is defined in Environnement
		if(cercle==0) {// Direction Left to the right
				Vehicule vta = new carA(xh,yh1);
				rh.addCarLR(vta);
				rh.addCar(vta);
				allCars.add(vta);
				int identity= allCars.indexOf(vta);
				vta.setIdentity(identity,"Car A");
		}// Direction right to left
		if(cercle==1) {
				Vehicule  vta = new carC(xh1,yh);
				rh1.addCarRL(vta);
				rh1.addCar(vta);
				allCars.add(vta);
				int identity= allCars.indexOf(vta);
				vta.setIdentity(identity,"Car C");
		}//Direction Down to Up
		if(cercle==2) {
				Vehicule  vta = new carE(xv,yv);
				rv.addCarDU(vta);
				rv.addCar(vta);
				allCars.add(vta);
				RA.add(vta);
				int identity= allCars.indexOf(vta);
				vta.setIdentity(identity,"Car E");
		}//Direction Up to Down 
		if(cercle==3) {
				Vehicule  vta = new carG(xv1,yv1);
				rv1.addCarUD(vta);
				rv1.addCar(vta);
				allCars.add(vta);
				RA1.add(vta);
				int identity= allCars.indexOf(vta);
				vta.setIdentity(identity,"Car G");
		}
	}
	
	/******Movement management and Detection of entrance of vehicles to the Roundabouts******/
	// panneau 8
	public boolean enterRa(Vehicule veh) {
		boolean enter=false;
		int x=veh.getx(),y=veh.gety();
		if(y>=944 && y<954) {
			enter=true;
			
		}
		return enter;
	}
	// panneau 6
	public boolean enterRa1(Vehicule veh) {
		boolean enter1=false;
		int x=veh.getx(),y=veh.gety();
		if(x>=1850 && x<=1870) {
			enter1=true;
		}
		return enter1;
	}
	// panneau 3
	public boolean enterRa2(Vehicule veh) {
		boolean enter2=false;
		int x=veh.getx(),y=veh.gety();
		if(y>=240 && y<=290) {
			enter2=true;
		}
		return enter2;
	}
	// panneau 1
	public boolean enterRa3(Vehicule veh) {

		boolean enter3=false;
		int x=veh.getx(),y=veh.gety();
		if(x+60>=55 && x+60<=85) {
			enter3=true;
		}
		return enter3;
	}
	
	/******************Accidents in Roundabouts*******************/
	
	public void createAccident() {
		ArrayList<Vehicule> Round1=new ArrayList<Vehicule>();
		ArrayList<Vehicule> Round2=new ArrayList<Vehicule>();
		for(int i=0;i<allCars.size();i++) {
			Vehicule say=allCars.get(i);
			int x=say.getx(),y=say.gety();
			if(x>=80 && x<=80+760 && y>=270 && y<=270+670) {
				Round1.add(say);
			}
			if(x>=80+1100 && x<=80+760+1100 && y>=270 && y<=270+670) {
				Round2.add(say);
			}			
		}
		int choix=genererInt(0,2);
		if(choix==0)	{
		  		int index1=genererInt(0,Round1.size()-1);
		  		Vehicule veho=Round1.get(index1);
				int xo=veho.getx(),yo=veho.gety();
				Vehicule vta= new carC(xo,yo);
				allCars.add(vta);
				Route1 ddd=roads.get(3);
				ddd.addCarRL(vta);
				ddd.addCar(vta);
				allCars.add(vta);
				vta.setIdentity(allCars.indexOf(vta),"Car C");
				ddd.Accidents.add("-- "+vta.getIdentity()+","+"First Roundabout");
				ddd.Accidents.add("-- "+veho.getIdentity()+","+"First Roundabout");
				veho.setBlock(2);
				vta.setBlock(2);
				veho.Stop();
				vta.Stop();
		 }
		 if(choix==1)	{
			  int index2=genererInt(0,Round2.size()-1);
		  		Vehicule veho=Round2.get(index2);
				int xo=veho.getx(),yo=veho.gety();
				Vehicule vta= new carC(xo+8,yo);
				allCars.add(vta);
				Route1 ddd=roads.get(6);
				ddd.addCarDU(vta);
				ddd.addCar(vta);
				allCars.add(vta);
				vta.setIdentity(allCars.indexOf(vta),"Car E");
				ddd.Accidents.add("-- "+vta.getIdentity()+","+"First Roundabout");
				ddd.Accidents.add("-- "+veho.getIdentity()+","+"First Roundabout");
				veho.setBlock(2);
				vta.setBlock(2);
				veho.Stop();
				vta.Stop();
		 }
									
	}
	/***************Movement of vehicles in function of roads*****************/
	public void moveRoad(Route1 p) {
		
		// Direction Right to Left
		for(int j=0;j<p.carsRtL.size();j++) {
			Vehicule veh=p.carsRtL.get(j);
			int x=veh.getx(),y=veh.gety();
				boolean enter1=enterRa1(veh);
				 if(enter1==true ) {
					 veh.setAttenteCarr(veh.getAttenteCarr()+100);
					 boolean free1=false;
					 boolean moveOrNo=veh.getBlock();
					 for(int a=0;a<RA.size();a++) {
						 Vehicule veh1=RA.get(a);
						 int x1=veh1.getx(),y1=veh1.gety();
						 if(x1>=1690 && x1<1690+260 && y1>=400 && y1<750) {
							 free1=true;
							 break;
						 }
					 }
					 if(free1==true) {
						 System.out.println("STOP, YOU NEED TO CHECK YOUR LEFT (1)");
					 }
					 if(free1==false) {
						 if(moveOrNo==false)
						 veh.setx(veh.getx()+veh.getSpeed());
					 }
					 
				 }
				else {
					 boolean moveOrNo=veh.getBlock();
					if(moveOrNo==false) {
					if(x>=1800) {//0
							veh.setx(veh.getx()+veh.getSpeed());
						}
					
						if(x>=1620 && x<1800) {//1
							veh.setx(veh.getx()-20);
							veh.sety(veh.gety()-15);
						}
						if(x>=1420 && x<1620) {//2
							veh.setx(veh.getx()+veh.getSpeed()-7);
						}
						if(x>=1300 && x<1420) {//3
							veh.setx(veh.getx()-53);
							veh.sety(veh.gety()+50);
						}
						if(x>=700 && x<1300) {//4
							veh.setx(veh.getx()+veh.getSpeed()-20);
						}
						if(x>=480 && x<700 && y>280 ) {//5
							veh.setx(veh.getx()-30);
							veh.sety(veh.gety()-33);
						}
						if(y<=300) {//6
							veh.changeDirection(this.getGraphics(),1);
							veh.sety(veh.gety()+veh.getSpeed()-10);
						}
				 }
			
				}
				
		} 	
		// Direction Left to Right
		for(int k=0;k<p.carsLtR.size();k++) {
			 Vehicule veh=p.carsLtR.get(k);
			 int x=veh.getx(),y=veh.gety();
			 boolean enter4=enterRa3(veh);
			 if(enter4==true) {
				 veh.setAttenteCarr(veh.getAttenteCarr()+400);
				 boolean free4=false;
				 boolean moveOrNo=veh.getBlock();
				 for(int c=0;c<RA1.size();c++) {
					 Vehicule veh2=RA1.get(c);
					 int x2=veh2.getx(),y2=veh2.gety();
					 if(x2>=110 && x2<=110+350 && y2>=110 && y2<=110+600 ) {
						 free4=true;
						 break;
					 }
				 }
				 if(free4==true) {
					 System.out.println("STOP, YOU NEED TO CHECK YOUR LEFT (4)");
				 }
				 if(free4==false) {
					 if(moveOrNo==false) {
					 veh.setx(veh.getx()+veh.getSpeed());}
				 }
			
			 }
			 else {
				 boolean moveOrNo=veh.getBlock();
				 if(moveOrNo==false) {
				 if(x<=200) {//1
					 veh.setx(veh.getx()+veh.getSpeed());
				 }
				 if(x>200 && x<=380) {//2
					 veh.setx(veh.getx()+20);
					veh.sety(veh.gety()+18);
				 }
				 if(x>380 && x<=480) {
					 veh.setx(veh.getx()+veh.getSpeed());
				 }
				 if(x>480 && x<=700) {//3
					veh.setx(veh.getx()+20);
					veh.sety(veh.gety()-18);
				 }
				 if(x>700 && x<=1280) {//4
					 veh.setx(veh.getx()+veh.getSpeed()+20);
				 }
				 if(x>1280 && x<=1420) {//5
					veh.setx(veh.getx()+17);
					veh.sety(veh.gety()+18);
					
				 }	
				if(x>1420 && y>=750) {//6
					veh.changeDirection(this.getGraphics(),1);
					 veh.sety(veh.gety()+veh.getSpeed());
				 }
				 }
			 }
			
		}
		// Direction Down to Up
		for(int e=0;e<p.carsDtU.size();e++) {
			 Vehicule veh=p.carsDtU.get(e);
			 int x=veh.getx(),y=veh.gety();
			 boolean enter2=enterRa(veh); 
			 if(enter2==true ) {
				 veh.setAttenteCarr(veh.getAttenteCarr()+450);
				 	Route1 r=roads.get(2);
				 	boolean free=false;
				 	boolean moveOrNo=veh.getBlock();
					for(int j=0;j<r.carsRtL.size();j++) {
						Vehicule k=r.carsRtL.get(j);
						int xk=k.getx();
						if(xk>=1550 && xk<1600) {
							free=true;
							break;
						}
					}
					if(free == true) {
						 System.out.println("STOP, YOU NEED TO CHECK YOUR LEFT (2)");
					}
					if(free==false) {
						if(moveOrNo==false) {
							 veh.sety(veh.gety()+veh.getSpeed()); }
					}

			 }
			 else {
				 boolean moveOrNo=veh.getBlock();
				 if(moveOrNo==false) {
				 if(y>843) {//1
				  veh.sety(veh.gety()+veh.getSpeed()); }
				 if( y<=843 && y>=504 && x>1420){//2
					 veh.changeDirection(this.getGraphics(),1);
					 veh.setx(veh.getx()+20);
					 veh.sety(veh.gety()-28);
				 }	
				 if( y<504 && y>=350 && x>1620){//3
					 veh.changeDirection(this.getGraphics(),2);
					 veh.setx(veh.getx()-20);
					 veh.sety(veh.gety()-28);
								 }		
				 if(x<=1730 && x>1420 && y<504) {//4
					 veh.changeDirection(this.getGraphics(),2);
					 veh.setx(veh.getx()+veh.getSpeed());
				 }
				 if(x<=1420 && x>=1293 && y<604) {//5
					 veh.setx(veh.getx()-30);
					 veh.sety(veh.gety()+30);
				 }
				 if(x<1293 && x>=700) {//6
					 veh.setx(veh.getx()+veh.getSpeed()-30);
				 }
				 if(x>=480 && x<700) {//7
						veh.setx(veh.getx()-30);
						veh.sety(veh.gety()-23);
					}
				 if(x<480 && x>=280) {//8
					 veh.setx(veh.getx()+veh.getSpeed());
				 }
				 if(x<280 && x>=120) {//9
						veh.setx(veh.getx()-30);
						veh.sety(veh.gety()+32);
				 }
				 if(x<120) {//10
					 veh.setx(veh.getx()+veh.getSpeed());
				 }
			 }
		}
		}
		//Direction Up to down 
		for(int u=0;u<p.carsUtD.size();u++) {
			Vehicule veh=p.carsUtD.get(u);
			int x=veh.getx(),y=veh.gety();
			boolean enter3=enterRa2(veh);
			if(enter3==true) {
				veh.setAttenteCarr(veh.getAttenteCarr()+50);
				boolean free3=false;
				boolean moveOrNo=veh.getBlock();
				for(int b=0;b<RA.size();b++) {
					Vehicule veh2=RA.get(b);
					int x2=veh2.getx(),y2=veh2.gety();
					if(x2>=190 && x2<=190+590 && y2>=300 && y2<=650) {
						free3=true;
						break;
					}
				}
				if(free3==true) {
					 System.out.println("STOP, YOU NEED TO CHECK YOUR LEFT (3)");
				}
				if(free3 == false) {
					if(moveOrNo==false) {
					 veh.sety(veh.gety()+veh.getSpeed()+6);}
				}
			}
			else {
				boolean moveOrNo=veh.getBlock();
			
				if(moveOrNo==false) {
				if(y<=350) {
					 veh.sety(veh.gety()+veh.getSpeed()+6);
					
				}
				if(y>350 && y<568 && x>=110) {
					veh.setx(veh.getx()-20);
					veh.sety(veh.gety()+35);
					
				}
				if(y>=566 && x<568 && x>=230 && y<840) {
					veh.changeDirection(this.getGraphics(), 1);
					veh.setx(veh.getx()+20);
					veh.sety(veh.gety()+35);
					
				}
				if(y>=811) {
					veh.changeDirection(this.getGraphics(), 2);
					veh.sety(veh.gety()+veh.getSpeed()+6);}
					}
			} 
			
		}
	}

	/*********Movement of all the vehicles at the same time**************/
	public void Move() {
		for(int i=0;i<40;i++) {
			Route1 p=roads.get(i);
				 moveRoad(p);	 
		}
			this.repaint();
	}
		
	/****************Calculation of the average speed********************/
		
	public void calculateATW() {
		// The size of the generated sample of vehicles 
		int N=allCars.size();
		float SommeDurees=0;
		for(int t=0;t<N;t++) {
			Vehicule veh=allCars.get(t);
			SommeDurees=SommeDurees+veh.getAttenteCarr();
		}
		float ATW=SommeDurees/N;
		Laps.add(ATW);
	}
	/*******************Control the weather*************************/
		
	public void Sunny() {
		Color c = new Color(255,255,174);
		this.setBackground(c);
	}
	public void Rainy() {
		Color c = new Color(182,203,202);
		this.setBackground(c);
	}
	public void Snowy() {
		Color c = new Color(255,255,255);
		this.setBackground(c);
	}
	public void Windy() {
		Color c = new Color(181,196,176);
		this.setBackground(c);
	}
}
