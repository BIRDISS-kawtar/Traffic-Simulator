package Traffic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Scenario1 extends JPanel {
	
		Image p,p1,p2,p3,p4,p5,p6,p7,p8; 
		// Vehicles with one accident at least 
		protected ArrayList<Vehicule> carsAccidents= new ArrayList<Vehicule>();
		// List of roads 
		protected ArrayList<Route1> roads= new ArrayList<Route1>();
		// List of vehicles
		protected ArrayList<Vehicule> allCars= new ArrayList<Vehicule>();
		protected ArrayList<Vehicule> allCarsH= new ArrayList<Vehicule>();
		protected ArrayList<Vehicule> allCarsV= new ArrayList<Vehicule>();
		// Nouns of vehicles to generate them
		static String[] words= {"carA","carB","carC","carD","carE","carF","carG","carH"};
		// List of speeds
		protected ArrayList<Float> ASpeeds= new ArrayList<Float>();
		
		public void paintComponent(Graphics g ) {
			super.paintComponent(g);
			/**********Horizontal Roads************/
			// Horizontal 1
			int Hcommun=145,Wcommun=Hcommun,wh=450,hh=125;
			Route1 r1=new Route1(0,123,260,Hcommun);
			r1.createCarrefour();
			roads.add(r1);
			Route1 r2=new Route1(r1.getRx()+r1.rwidth,r1.getRy(),wh,Hcommun);
			r2.createCarrefour();
			roads.add(r2);
			Route1 r3=new Route1(r2.getRx()+wh,r1.getRy(),wh,Hcommun);
			roads.add(r3);
			r3.createCarrefour();
			Route1 r4=new Route1(r3.getRx()+wh,r1.getRy(),wh,Hcommun);
			roads.add(r4);
			r4.createCarrefour();
			Route1 rb1=new Route1(r4.getRx()+wh,r1.getRy(),wh,Hcommun);
			roads.add(rb1);
			rb1.createCarrefour();
			r1.drawRoadH2(g,Color.GRAY);
			r2.drawRoadH1(g,Color.GRAY,5);
			r3.drawRoadH1(g,Color.GRAY,5);
			r4.drawRoadH1(g,Color.GRAY,5);
			rb1.drawRoadH1(g,Color.GRAY,5);
			// Horizontal 2
			Route1 r5=new Route1(0,2*r1.getRy()+r1.rheight,r1.rwidth,Hcommun);
			roads.add(r5);
			r5.createCarrefour();
			Route1 r6=new Route1(r5.getRx()+r1.rwidth,r5.getRy(),wh,Hcommun);
			roads.add(r6);
			r6.createCarrefour();
			Route1 r7=new Route1(r6.getRx()+wh,r5.getRy(),wh,Hcommun);
			roads.add(r7);
			r7.createCarrefour();
			Route1 r8=new Route1(r7.getRx()+wh,r5.getRy(),wh,Hcommun);
			roads.add(r8);
			r8.createCarrefour();
			Route1 rb2=new Route1(r8.getRx()+wh,r5.getRy(),wh,Hcommun);
			roads.add(rb2);
			rb2.createCarrefour();
			r5.drawRoadH2(g,Color.GRAY);
			r6.drawRoadH1(g,Color.GRAY,5);
			r7.drawRoadH1(g,Color.GRAY,5);
			r8.drawRoadH1(g,Color.GRAY,5);
			rb2.drawRoadH1(g,Color.GRAY,5);
			// Horizontal 3 
			Route1 r9=new Route1(0,r5.getRy()+r5.rheight+r1.getRy(),r1.rwidth,Hcommun);
			roads.add(r9);
			r9.createCarrefour();
			Route1 r10=new Route1(r9.getRx()+r1.rwidth,r9.getRy(),wh,Hcommun);
			roads.add(r10);
			r10.createCarrefour();
			Route1 r11=new Route1(r10.getRx()+wh,r9.getRy(),wh,Hcommun);
			roads.add(r11);
			r11.createCarrefour();
			Route1 r12=new Route1(r11.getRx()+wh,r9.getRy(),wh,Hcommun);
			roads.add(r12);
			r12.createCarrefour();
			Route1 rb3=new Route1(r12.getRx()+wh,r9.getRy(),wh,Hcommun);
			roads.add(rb3);
			rb3.createCarrefour();
			r9.drawRoadH2(g,Color.GRAY);
			r10.drawRoadH1(g,Color.GRAY,5);
			r11.drawRoadH1(g,Color.GRAY,5);
			r12.drawRoadH1(g,Color.GRAY,5);
			rb3.drawRoadH1(g,Color.GRAY,5);
			// Horizontal 4
			Route1 r13=new Route1(0,r9.getRy()+r9.rheight+r1.getRy(),r1.rwidth,Hcommun);
			roads.add(r13);
			r13.createCarrefour();
			Route1 r14=new Route1(r13.getRx()+r1.rwidth,r13.getRy(),wh,Hcommun);
			roads.add(r14);
			r14.createCarrefour();
			Route1 r15=new Route1(r14.getRx()+wh,r13.getRy(),wh,Hcommun);
			roads.add(r15);
			r15.createCarrefour();
			Route1 r16=new Route1(r15.getRx()+wh,r13.getRy(),wh,Hcommun);
			roads.add(r16);
			r16.createCarrefour();
			Route1 rb4=new Route1(r16.getRx()+wh,r13.getRy(),wh,Hcommun);
			roads.add(rb4);
			rb4.createCarrefour();
			r13.drawRoadH2(g,Color.GRAY);
			r14.drawRoadH1(g,Color.GRAY,5);
			r15.drawRoadH1(g,Color.GRAY,5);
			r16.drawRoadH1(g,Color.GRAY,5);
			rb4.drawRoadH1(g,Color.GRAY,5);
			/********Vertical Roads************/
			// Vertical 1
			Route1 rv1=new Route1(115,0,Wcommun,hh);
			roads.add(rv1);
			rv1.createCarrefourV();
			Route1 rv2=new Route1(115,r1.getRy()+r1.getRh(),Wcommun,hh);
			roads.add(rv2);
			rv2.createCarrefourV();
			Route1 rv3=new Route1(115,r5.getRy()+r5.getRh(),Wcommun,hh);
			roads.add(rv3);
			rv3.createCarrefourV();
			Route1 rvb1=new Route1(115,r11.getRy()+r11.getRh(),Wcommun,hh);
			roads.add(rvb1);
			rvb1.createCarrefourV();
			Route1 rvbon1 =new Route1(115,r15.getRy()+r15.getRh(),Wcommun,hh);
			roads.add(rvbon1);
			rvbon1.createCarrefourV();
			rv1.drawRoadV1(g,2);
			rv2.drawRoadV1(g,2);
			rv3.drawRoadV1(g,2);
			rvb1.drawRoadV1(g,2);
			rvbon1.drawRoadV1(g,2);
			// Vertical 2
			Route1 rv5=new Route1(115+r2.getRw(),0,Wcommun,hh);
			roads.add(rv5);
			rv5.createCarrefourV();
			Route1 rv6=new Route1(115+r2.getRw(),r2.getRy()+r2.getRh(),Wcommun,hh);
			roads.add(rv6);
			rv6.createCarrefourV();
			Route1 rv7=new Route1(115+r2.getRw(),r6.getRy()+r6.getRh(),Wcommun,hh);
			roads.add(rv7);
			rv7.createCarrefourV();
			Route1 rvb2=new Route1(115+r2.getRw(),r12.getRy()+r12.getRh(),Wcommun,hh);
			roads.add(rvb2);
			rvb2.createCarrefourV();
			Route1 rvbon2 =new Route1(115+r2.getRw(),r16.getRy()+r16.getRh(),Wcommun,hh);
			roads.add(rvbon2);
			rvbon2.createCarrefourV();
			rv5.drawRoadV1(g,2);
			rv6.drawRoadV1(g,2);
			rv7.drawRoadV1(g,2);
			rvb2.drawRoadV1(g,2);
			rvbon2.drawRoadV1(g,2);
			// Vertical 3
			Route1 rv9=new Route1(114+r2.getRw()+r3.getRw(),0,Wcommun,hh);
			roads.add(rv9);
			rv9.createCarrefourV();
			Route1 rv10=new Route1(114+r2.getRw()+r3.getRw(),r3.getRy()+r3.getRh(),Wcommun,hh);
			roads.add(rv10);
			rv10.createCarrefourV();
			Route1 rv11=new Route1(114+r2.getRw()+r3.getRw(),r7.getRy()+r7.getRh(),Wcommun,hh);
			roads.add(rv11);
			rv11.createCarrefourV();
			Route1 rvb3=new Route1(114+r2.getRw()+r3.getRw(),r11.getRy()+r11.getRh(),Wcommun,hh);
			roads.add(rvb3);
			rvb3.createCarrefourV();
			Route1 rvbon3 =new Route1(114+r2.getRw()+r3.getRw(),r15.getRy()+r15.getRh(),Wcommun,hh);
			roads.add(rvbon3);
			rvbon3.createCarrefourV();
			rv9.drawRoadV1(g,2);
			rv10.drawRoadV1(g,2);
			rv11.drawRoadV1(g,2);
			rvb3.drawRoadV1(g,2);
			rvbon3.drawRoadV1(g,2);
			// Vertical 4
			Route1 rv12=new Route1(124+r2.getRw()+r3.getRw()+r4.getRw(),0,Wcommun,hh);
			roads.add(rv12);
			rv12.createCarrefourV();
			Route1 rv13=new Route1(124+r2.getRw()+r3.getRw()+r4.getRw(),r4.getRy()+r4.getRh(),Wcommun,hh);
			roads.add(rv13);
			rv13.createCarrefourV();
			Route1 rv14=new Route1(124+r2.getRw()+r3.getRw()+r4.getRw(),r8.getRy()+r8.getRh(),Wcommun,hh);
			roads.add(rv14);
			rv14.createCarrefourV();
			Route1 rvb4=new Route1(124+r2.getRw()+r3.getRw()+r4.getRw(),r10.getRy()+r10.getRh(),Wcommun,hh);
			roads.add(rvb4);
			rvb4.createCarrefourV();
			Route1 rvbon4 =new Route1(124+r2.getRw()+r3.getRw()+r4.getRw(),r13.getRy()+r13.getRh(),Wcommun,hh);
			roads.add(rvbon4);
			rvbon4.createCarrefourV();
			rv12.drawRoadV1(g,2);
			rv13.drawRoadV1(g,2);
			rv14.drawRoadV1(g,2);
			rvb4.drawRoadV1(g,2);
			rvbon4.drawRoadV1(g,2);
			// Images 
			try {
				p= ImageIO.read(new File("images/trees.png"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			try {
				p1= ImageIO.read(new File("images/pic1.png"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			try {
				p2= ImageIO.read(new File("images/pic2.png"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			try {
				p3= ImageIO.read(new File("images/postOffice.png"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			try {
				p4= ImageIO.read(new File("images/bakery.png"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			try {
				p5= ImageIO.read(new File("images/tower.png"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			try {
				p6= ImageIO.read(new File("images/home.png"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			try {
				p7= ImageIO.read(new File("images/building.png"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			try {
				p8= ImageIO.read(new File("images/pic3.png"));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			// Town
			int difference=170;
			int difference1=130;
			g.drawImage(p,280,350-difference+20,null);
			g.drawImage(p2,300,650-difference1+30,null);
			g.drawImage(p,1170,350-difference+20,null);
			g.drawImage(p,700,100-difference,null);
			g.drawImage(p8,740,400-difference1,null);
			g.drawImage(p1,1170,140-difference1,null);
			g.drawImage(p3,290,170-difference,null);
			g.drawImage(p4,1170,670-difference+43,null);
			g.drawImage(p5,0,670-difference+45,null);
			g.drawImage(p6,0,450-difference,null);
			g.drawImage(p7,0,190-difference,null);
			g.drawImage(p,700,610-difference+20,null);
			// List of vehicles 
			for(int i=0;i<roads.size();i++){
				Route1 a= roads.get(i);
				a.carsToRoad(g);
		    }
			/**********Affect identities to roads***********/
			for(int l=0;l<20;l++) {
				Route1 rr=roads.get(l);
				rr.setIdentity(l, "Horizontal Road");
			}
			for(int l=20;l<40;l++) {
				Route1 rr=roads.get(l);
				rr.setIdentity(l, "Vertical Road");
			}
		}
	
		
	
	/**************Vehicles Generation*********************/
	// Generate an integer
	public int genererInt(int borneInf, int borneSup){
		   Random random = new Random();
		   int nb;
		   nb = borneInf+random.nextInt(borneSup-borneInf);
		   return nb;
	}
	public void generateCar1() {
		int c1=genererInt(0,19);
		int c2=genererInt(20,40);
		Route1 ra=roads.get(c1);
		Route1 rb=roads.get(c2);
		int rax=ra.getRx(),ray=ra.getRy(),rah=ra.getRh(),raw=ra.getRw();
		int rbx=rb.getRx(),rby=rb.getRy(),rbh=rb.getRh(),rbw=rb.getRw();
		int x= genererInt(rax+7,rax+raw-260);
		int y1= genererInt(ray+(int)rah/2,ray+rah-24);
		int y2= genererInt(ray,ray+rah/2-34);
		int y= genererInt(rby,rby+rbh-66);
		int x1= genererInt(rbx+(int)rbw/2+20,rbx+rbw-25);
		int x2= genererInt(rbx,rbx+(int)rbw/2-25);
		int index = genererInt(0,8);
		String type=words[index];
		// Direction Left to the right
		if(type == "carA"){
			Vehicule vta = new carA(x,y1);
			boolean b = ra.collisionsHRL(vta.getx(),vta.gety(),vta.getw(),vta);
			while(b == true && ra.carsRtL.size()<=4) {
				x= genererInt(rax+7,rax+raw-260);
				 y1= genererInt(ray+(int)rah/2,ray+rah-24);
				 vta.setx(x);
				 vta.sety(y1);
				 b = ra.collisionsHRL(vta.getx(),vta.gety(),vta.getw(),vta);	
			}
			ra.addCarRL(vta);
			ra.addCar(vta);
			allCars.add(vta);
			allCarsH.add(vta);
			vta.setPRoute(ra);
			int identity= allCars.indexOf(vta);
			vta.setIdentity(identity,"Car A");
			System.out.println("HEY I AM "+vta.getIdentity());
		
		}
		if(type=="carB"){
			Vehicule  vta = new carB(x,y1);
			boolean b = ra.collisionsHRL(vta.getx(),vta.gety(),vta.getw(),vta);
			while(b == true && ra.carsRtL.size()<=4) {
				x= genererInt(rax+7,rax+raw-260);
				 y1= genererInt(ray+(int)rah/2,ray+rah-24);
				 vta.setx(x);
				 vta.sety(y1);
				 b = ra.collisionsHRL(vta.getx(),vta.gety(),vta.getw(),vta);
				 }
			ra.addCarRL(vta);
			ra.addCar(vta);
			allCars.add(vta);
			allCarsH.add(vta);
			vta.setPRoute(ra);
			int identity= allCars.indexOf(vta);
			vta.setIdentity(identity,"Car B");
			System.out.println("HEY I AM "+vta.getIdentity());
		}
		// Direction right to left
		if(type=="carC"){
			Vehicule  vta = new carC(x,y2);
			boolean b = ra.collisionsHLR(vta.getx(),vta.gety(),vta.getw(),vta);
			while(b == true && ra.carsLtR.size()<=4) {
				x= genererInt(rax+7,rax+raw-260);
				 y2= genererInt(ray,ray+rah/2-34);
				 vta.setx(x);
				 vta.sety(y2);
				 b = ra.collisionsHLR(vta.getx(),vta.gety(),vta.getw(),vta);
			}
			ra.addCarLR(vta);
			ra.addCar(vta);
			allCars.add(vta);
			allCarsH.add(vta);
			vta.setPRoute(ra);
			int identity= allCars.indexOf(vta);
			vta.setIdentity(identity,"Car C");
			System.out.println("HEY I AM "+vta.getIdentity());
		}
		if(type=="carD"){
			Vehicule  vta = new carD(x,y2);
			boolean b = ra.collisionsHLR(vta.getx(),vta.gety(),vta.getw(),vta);
			while(b == true && ra.carsLtR.size()<=4) {
				x= genererInt(rax+7,rax+raw-260);
				 y2= genererInt(ray,ray+rah/2-34);
				 vta.setx(x);
				 vta.sety(y2);
				 b = ra.collisionsHLR(vta.getx(),vta.gety(),vta.getw(),vta);
			}
			ra.addCarLR(vta);
			ra.addCar(vta);
			allCars.add(vta);
			allCarsH.add(vta);
			vta.setPRoute(ra);
			int identity= allCars.indexOf(vta);
			vta.setIdentity(identity,"Car D");
			System.out.println("HEY I AM "+vta.getIdentity());
		}
		//Direction Up to down 
		if(type=="carE"){
			Vehicule  vta = new carE(x1,y);
			boolean b = rb.collisionsVDU(vta.getx(),vta.gety(),vta.getw(),vta);
			while(b == true && rb.carsUtD.size()<=4) {
				x1= genererInt(rbx+(int)rbw/2+20,rbx+rbw-25);
				 y= genererInt(rby,rby+rbh-66);
				 vta.setx(x1);
				 vta.sety(y);
				 b = rb.collisionsVDU(vta.getx(),vta.gety(),vta.getw(),vta);
			}
			rb.addCarDU(vta);
			rb.addCar(vta);
			allCars.add(vta);
			allCarsV.add(vta);
			vta.setPRoute(rb);
			int identity= allCars.indexOf(vta);
			vta.setIdentity(identity,"Car E");
			System.out.println("HEY I AM "+vta.getIdentity());
		}
		if(type=="carF"){
			Vehicule  vta = new carF(x1,y);
			boolean b = rb.collisionsVDU(vta.getx(),vta.gety(),vta.getw(),vta);
			while(b == true && rb.carsUtD.size()<=4) {
				x1= genererInt(rbx+(int)rbw/2+20,rbx+rbw-25);
				 y= genererInt(rby,rby+rbh-66);
				 vta.setx(x1);
				 vta.sety(y);
				b = rb.collisionsVDU(vta.getx(),vta.gety(),vta.getw(),vta);
					}
			rb.addCarDU(vta);
			rb.addCar(vta);
			allCars.add(vta);
			allCarsV.add(vta);
			vta.setPRoute(rb);
			int identity= allCars.indexOf(vta);
			vta.setIdentity(identity,"Car F");
			System.out.println("HEY I AM "+vta.getIdentity());
		}
		//Direction Down to Up 
		if(type=="carG"){
			Vehicule  vta = new carG(x2,y);
			boolean b = rb.collisionsVUD(vta.getx(),vta.gety(),vta.getw(),vta);
			while(b == true && rb.carsUtD.size()<=4) {
				x2= genererInt(rbx,(int)rbx+rbw/2-25);
				 y= genererInt(rby,rby+rbh-66);
				 vta.setx(x2);
				 vta.sety(y);
				 b = rb.collisionsVUD(vta.getx(),vta.gety(),vta.getw(),vta);
			}
			rb.addCarUD(vta);
			rb.addCar(vta);
			allCars.add(vta);
			allCarsV.add(vta);
			vta.setPRoute(rb);
			int identity= allCars.indexOf(vta);
			vta.setIdentity(identity,"Car G");
			System.out.println("HEY I AM "+vta.getIdentity());
		}
		if(type=="carH"){
			Vehicule  vta = new carH(x2,y);
			boolean b = rb.collisionsVUD(vta.getx(),vta.gety(),vta.getw(),vta);
			while(b == true && rb.carsUtD.size()<=4) {
				 x2= genererInt(rbx,(int)rbx+rbw/2-25);
				 y= genererInt(rby,rby+rbh-66);
				 vta.setx(x2);
				 vta.sety(y);
				b = rb.collisionsVUD(vta.getx(),vta.gety(),vta.getw(),vta);
			}
			rb.addCarUD(vta);
			rb.addCar(vta);
			allCars.add(vta);
			allCarsV.add(vta);
			vta.setPRoute(rb);
			int identity= allCars.indexOf(vta);
			vta.setIdentity(identity,"Car H");
			System.out.println("HEY I AM "+vta.getIdentity());
			
		}
	}
	// Verification 
	public int inHorV(Vehicule veh) {
		int rt=0;
		for(int y=0;y<roads.size();y++) {
			Route1 r=roads.get(y);
			for(int i=0;i<r.carsDtU.size();i++) {
				Vehicule car=r.carsDtU.get(i);
				if(veh.equals(car)) {
					rt=1;
				}
			}
		}
			
		for(int y=0;y<roads.size();y++) {
			Route1 r=roads.get(y);
			for(int i=0;i<r.carsUtD.size();i++) {
			Vehicule car=r.carsUtD.get(i);
			if(veh.equals(car)) {
				rt=2;
			}
		}}
		for(int y=0;y<roads.size();y++) {
			Route1 r=roads.get(y);
			for(int i=0;i<r.carsLtR.size();i++) {
			Vehicule car=r.carsLtR.get(i);
			if(veh.equals(car)) {
				rt=3;
			}
		}}
		for(int y=0;y<roads.size();y++) {
			Route1 r=roads.get(y);
			for(int i=0;i<r.carsRtL.size();i++) {
			Vehicule car=r.carsRtL.get(i);
			if(veh.equals(car)) {
				rt=4;
			}
		}
		}
		
		return rt;
	}
	public Route1 getPositionByRoad(Vehicule v) {
		int x=v.getx(),y=v.gety(),h=v.geth(),w=v.getw();
		Route1 r=roads.get(0);
		for(int i=0;i<roads.size();i++) {
			 r=roads.get(i);
			int rx=r.getRx(),ry=r.getRy(),rh=r.getRh(),rw=r.getRw();
			if(x>=rx && x+w<rx+rw && y>=ry && y+h<=ry+rh) {
				break;
			}
		}
		return r;
	}
	// Accidents 
	public void createAccident() {
		int index=genererInt(0,allCars.size()-1);	
		Vehicule veho=allCars.get(index);
		int xo=veho.getx(),yo=veho.gety();//RL
		if(inHorV(veho)==4) {
			Vehicule vta= new carC(xo+95,yo);
			allCars.add(vta);
			Route1 ddd=veho.getPRoute();
			ddd.addCarLR(vta);
			ddd.addCar(vta);
			allCars.add(vta);
			allCarsH.add(vta);
			vta.setIdentity(allCars.indexOf(vta),"Car C");
			Route1 dddd=getPositionByRoad(veho);
			ddd.Accidents.add("-- "+vta.getIdentity()+","+dddd.getIdentity());
			ddd.Accidents.add("-- "+veho.getIdentity()+","+dddd.getIdentity());
			veho.setBlock(2);
			vta.setBlock(2);
			veho.Stop();
			vta.Stop();
			
		}
		if(inHorV(veho)==3) {
			//System.out.println("RA LEFT TO LIGHT ");
			Vehicule vta= new carA(xo-75,yo);
			allCars.add(vta);
			Route1 ddd=veho.getPRoute();
			ddd.addCarRL(vta);
			ddd.addCar(vta);
			allCars.add(vta);
			allCarsH.add(vta);
			vta.setIdentity(allCars.indexOf(vta),"Car A");
			Route1 dddd=getPositionByRoad(veho);
			ddd.Accidents.add("-- "+vta.getIdentity()+","+dddd.getIdentity());
			ddd.Accidents.add("-- "+veho.getIdentity()+","+dddd.getIdentity());
			veho.setBlock(2);
			vta.setBlock(2);
			veho.Stop();
			vta.Stop();
			
		}
		if(inHorV(veho)==2) {
			//System.out.println("RA UP TO DOWN ");
			Vehicule vta= new carE(xo,yo+75);
			allCars.add(vta);
			Route1 ddd=veho.getPRoute();
			ddd.addCarDU(vta);
			ddd.addCar(vta);
			allCars.add(vta);
			allCarsV.add(vta);
			vta.setIdentity(allCars.indexOf(vta),"Car E");
			Route1 dddd=getPositionByRoad(veho);
			ddd.Accidents.add("-- "+vta.getIdentity()+","+dddd.getIdentity());
			ddd.Accidents.add("-- "+veho.getIdentity()+","+dddd.getIdentity());
			veho.setBlock(2);
			vta.setBlock(2);
			veho.Stop();
			vta.Stop();
		}
		if(inHorV(veho)==1) {
			Vehicule vta= new carH(xo,yo-75);
			allCars.add(vta);
			Route1 ddd=veho.getPRoute();
			ddd.addCarUD(vta);
			ddd.addCar(vta);
			allCars.add(vta);
			allCarsV.add(vta);
			vta.setIdentity(allCars.indexOf(vta),"Car H");
			Route1 dddd=getPositionByRoad(veho);
			ddd.Accidents.add("-- "+vta.getIdentity()+","+dddd.getIdentity());
			ddd.Accidents.add("-- "+veho.getIdentity()+","+dddd.getIdentity());
			veho.setBlock(2);
			vta.setBlock(2);
			veho.Stop();
			vta.Stop();
		}		
	}
	/***************Movement of the vehicles in function of road*****************/
	public void moveRoad(Route1 p) {
		// Direction Right to Left
		for(int j=0;j<p.carsRtL.size();j++) {
			Vehicule veh=p.carsRtL.get(j);
			int x=veh.getx(),y=veh.gety();
			boolean moveOrNo=veh.getBlock();
			if(moveOrNo==false) {
				 if(x+100>90 && x<=250) {
					// veh.setx(veh.getx()+veh.getSpeed()+37);
					 veh.Accelerate(37);
				 }
				 if(x+100>567 && x<=727) {
					 //veh.setx(veh.getx()+veh.getSpeed()+37);
					 veh.Accelerate(37);
				 }
				 if(x+100>1017 && x<=1117) {
					// veh.setx(veh.getx()+veh.getSpeed()+37);
					 veh.Accelerate(37);
				 }
				 if(x+100>1467 && x<=1627) {
					 //veh.setx(veh.getx()+veh.getSpeed()+37);
					 veh.Accelerate(37);
				 }
				 
				 else {
					  if (p.carrefour1.iValue<10) {
					System.out.println("STOP");
				}

				if (p.carrefour1.iValue>=10 && p.carrefour1.iValue<15) {
					System.out.println("STOP");
				}
				if (p.carrefour1.iValue >= 15 && p.carrefour1.iValue<20) {
					veh.setx(veh.getx()+veh.getSpeed());
				}
				if (p.carrefour1.iValue>=20 && p.carrefour1.iValue<25) {
					veh.setx(veh.getx()+veh.getSpeed());
				} 	
				 }		
		
		}
		}
		// Direction Left to Right
		for(int k=0;k<p.carsLtR.size();k++) {
			 Vehicule veh=p.carsLtR.get(k);
			 int x=veh.getx(),y=veh.gety();
			 boolean moveOrNo1=veh.getBlock();
			 if(moveOrNo1==false) {
				 if(x+100>90 && x<=250) {
					 veh.Accelerate(37);
				 }
				 if(x+100>567 && x<727) {
					 veh.Accelerate(37);
				 }
				 if(x+100>1017 && x<1117) {
					 veh.Accelerate(37);
				 }
				 if(x+100>1467 && x<1627) {
					 veh.Accelerate(37);
				 }
				 else {
					if (p.carrefour2.iValue<10) {
						System.out.println("STOP");
					}
					if (p.carrefour2.iValue>=10 && p.carrefour2.iValue<15) {
						System.out.println("STOP");
					}
					if (p.carrefour2.iValue >= 15 && p.carrefour2.iValue<20) {
						
						veh.setx(veh.getx()+veh.getSpeed());
					}
					if (p.carrefour2.iValue>=20 && p.carrefour2.iValue<25) {
						
						veh.setx(veh.getx()+veh.getSpeed());
					}
				 }
			}
		}
		// Direction Down to Up
		for(int e=0;e<p.carsDtU.size();e++) {
			Vehicule veh=p.carsDtU.get(e);
			int x=veh.getx(),y=veh.gety();
			boolean moveOrNo2=veh.getBlock();
			 if(moveOrNo2==false) {
				 
				 if(y+66>123 && y<123+145) {
					 veh.Accelerate(27);
				 }
				 if(y+66>391 && y<536) {
					 veh.Accelerate(27);
				 }
				 if(y+66>659 && y<804) {
					 //veh.sety(veh.gety()+veh.getSpeed()-27);
					 veh.Accelerate(27);
				 }
				 if(y+66>927 && y<1072) {
					// veh.sety(veh.gety()+veh.getSpeed()-27);
					 veh.Accelerate(27);
				 }
				if (p.carrefour3.iValue2<10) {
					veh.sety(veh.gety()+veh.getSpeed());
				}

				if (p.carrefour3.iValue2>=10 && p.carrefour3.iValue2<15) {
					veh.sety(veh.gety()+veh.getSpeed());
				}
				if (p.carrefour3.iValue2 >= 15 && p.carrefour3.iValue2<20) {
					System.out.println("STOP");
				}
				if (p.carrefour3.iValue2>=20 && p.carrefour3.iValue2<25) {
					System.out.println("STOP");
				}
			}
			 }
			//Direction Up to down 
		for(int u=0;u<p.carsUtD.size();u++) {
			Vehicule veh=p.carsUtD.get(u);
			int x=veh.getx(),y=veh.gety();
			boolean moveOrNo3=veh.getBlock();
			if(moveOrNo3==false) {
				 //this.getGraphics().fillRect(x, y,50,66);
				 if(y+66>123 && y<123+145) {
					 //veh.sety(veh.gety()+veh.getSpeed()+27);
					 veh.Accelerate(27);
				 }
				 if(y+66>391 && y<536) {
					 //veh.sety(veh.gety()+veh.getSpeed()+27);
					 veh.Accelerate(27);
				 }
				 if(y+66>659 && y<804) {
					 //veh.sety(veh.gety()+veh.getSpeed()+27);
					 veh.Accelerate(27);
				 }
				 if(y+66>927 && y<1072) {
					// veh.sety(veh.gety()+veh.getSpeed()+27);
					 veh.Accelerate(27);
				 }
				if (p.carrefour4.iValue2<10) {
					veh.sety(veh.gety()+veh.getSpeed());
				}

				if (p.carrefour4.iValue2>=10 && p.carrefour4.iValue2<15) {
					veh.sety(veh.gety()+veh.getSpeed());
				}
				if (p.carrefour4.iValue2 >= 15 && p.carrefour4.iValue2<20) {
					System.out.println("STOP");
				}
				if (p.carrefour4.iValue2>=20 && p.carrefour4.iValue2<25) {
					System.out.println("STOP");
				}
			}
		} 
 }
	

	/* Permet le mouvement de toutes les vehicules a la fois */
	public void Move() {
		
		for(int i=0;i<40;i++) {
			Route1 p=roads.get(i);
			/* this.getGraphics().fillRect(90,p.getRy(),160,50);
			 this.getGraphics().fillRect(567,p.getRy(),160,50);
			 this.getGraphics().fillRect(1017,p.getRy(),160,50);
			 this.getGraphics().fillRect(1467,p.getRy(),160,50);*/
		
				 moveRoad(p);
				 
		}
			this.repaint();
		}
		
	/**************** Calcul de la vitesse moyenne ********************/
	
	public void calculateAS() {
		// Taille de l'echantillon des vehicules generes
		int N=allCars.size();
		int SommeVitesses=0;
		for(int t=0;t<N;t++) {
			Vehicule veh=allCars.get(t);
			SommeVitesses=SommeVitesses+veh.getSpeed();
		}
		float AS=SommeVitesses/N;
		ASpeeds.add(AS);
	}
	/******************************************************************/
	/* Retourne la liste de tout les carrefours */
	public ArrayList<Lights> getCarr() {
		ArrayList<Lights> send = new ArrayList<Lights>();
		for(int i=0;i<20;i++) {
			Route1 current=roads.get(i);
				 ArrayList<Lights> t=current.getC1();
				 send.add(t.get(0));
				 send.add(t.get(1));
		}
		for(int i=20;i<40;i++) {
			Route1 current=roads.get(i);
			 send.add(current.getC2());
			 send.add(current.getC3());
		}
		
		return send;
	}
	/* Permet le changement des couleurs pour les traffic lights  */
	public void swapEm1(Lights e,Lights f,String d) {
		Graphics g=this.getGraphics();
		if(d=="horizontal") {
			if (e.iValue<10 && f.iValue<10) {
				e.Color = Color.red;
				f.Color = Color.red;
				g.setColor(e.Color);
				g.fillOval(e.cx,e.cy ,e.cd ,e.cd );
				g.fillOval(f.cx,f.cy ,f.cd ,f.cd );
			}

			if (e.iValue>=10 && e.iValue<15 && f.iValue>=10 && f.iValue<15) {
				e.Color = Color.yellow;
				f.Color = e.Color;
				g.setColor(e.Color);
				g.fillOval(e.cx,e.cy ,e.cd ,e.cd );
				g.fillOval(f.cx,f.cy ,f.cd ,f.cd );
			}
			if (e.iValue >= 15 && e.iValue<20 && f.iValue >= 15 && f.iValue<20) {
				e.Color = Color.green;
				f.Color = e.Color;
				g.setColor(e.Color);
				g.fillOval(e.cx,e.cy ,e.cd ,e.cd );
				g.fillOval(f.cx,f.cy ,f.cd ,f.cd );
			}
			if (e.iValue>=20 && e.iValue<25 && f.iValue>=20 && f.iValue<25) {
				e.Color = Color.yellow;
				f.Color = e.Color;
				g.setColor(e.Color);
				g.fillOval(e.cx,e.cy ,e.cd ,e.cd );
				g.fillOval(f.cx,f.cy ,f.cd ,f.cd );
			}
			repaint();
		}
		if(d=="vertical") {
			if (e.iValue2<10 && f.iValue2<10) {
				e.Color = Color.green;
				f.Color = Color.green;
				g.setColor(e.Color);
				g.fillOval(e.cx,e.cy ,e.cd ,e.cd );
				g.fillOval(f.cx,f.cy ,f.cd ,f.cd );
				
			}

			if (e.iValue2>=10 && e.iValue2<15 && f.iValue2>=10 && f.iValue2<15) {
				e.Color = Color.yellow;
				f.Color = e.Color;
				g.setColor(e.Color);
				g.fillOval(e.cx,e.cy ,e.cd ,e.cd );
				g.fillOval(f.cx,f.cy ,f.cd ,f.cd );
			}
			if (e.iValue2 >= 15 && e.iValue2<20 && f.iValue2 >= 15 && f.iValue2<20) {
				e.Color = Color.red;
				f.Color = e.Color;
				g.setColor(e.Color);
				g.fillOval(e.cx,e.cy ,e.cd ,e.cd );
				g.fillOval(f.cx,f.cy ,f.cd ,f.cd );
			
				}
			if (e.iValue2>=20 && e.iValue2<25 && f.iValue2>=20 && f.iValue2<25) {
				e.Color = Color.yellow;
				f.Color = e.Color;
				g.setColor(e.Color);
				g.fillOval(e.cx,e.cy ,e.cd ,e.cd );
				g.fillOval(f.cx,f.cy ,f.cd ,f.cd );
			
			}
			repaint();
			System.out.println(e.iValue2+"et"+f.iValue2);
			
		}	
	}
	
	/*************Control of the Weather******************/
	
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
