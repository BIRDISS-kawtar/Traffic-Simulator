package Traffic;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import  java.lang.Thread;

import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Environnement extends JFrame implements ActionListener,Runnable{

	private static final long serialVersionUID = 1L;
	Image s;
	//Booleans for simulation control
	boolean End=false;
	boolean con = false;
	boolean Again=false;
	boolean inmove = false;
	static boolean trrn=false;
	// JPanel separators
	private JSplitPane split,split1,split2,split3;
	// Scrollers
	JScrollPane dd= new JScrollPane();
	// Timer
	long rest,duration,time;
	Chrono timer=new Chrono();
	// Roads
	static Scenario1 scen= new Scenario1();
	static Scenario2 scen2= new Scenario2();
	// Colors of buttons and fonts 
	Color Font=new Color(52,66,131);
	Color Font1=new Color(200,58,55);
	// Buttons
	JButton stop= new JButton("STOP");
	JButton play= new JButton("PLAY");
	JButton pause= new JButton("PAUSE");
	JButton gen= new JButton("GENERATE A CAR");
	JButton acc=new JButton("CREATE AN ACCIDENT");
	// JPanel container
	protected JPanel pan= new JPanel();
	// Dropdown lists 
	String[] scenarios= {"Nothing","Roundabout","Cross-Roads"};
	String[] wet= {"Nothing","Sunny","Rainy","Windy","Snowy"};
	private JComboBox combo = new JComboBox(scenarios);
	private JComboBox combo1 = new JComboBox(wet);
	private JLabel label = new JLabel("                        Road Network");
	private JLabel label1 = new JLabel("                           Weather");
	private JLabel label2=new JLabel("           The Simulation lasts: 0 min"); 
	private JLabel label4=new JLabel("Click PAUSE befor launch a new simulation");
	JSlider slide = new JSlider();
	// Sound
	Clip cl1,cl2,cl3,cl4;
	// The window
	JFrame frame;
	public Environnement(){
		// Audios in wav format
		try{
			File music= new File("Audios/SunnyDay.wav");
			AudioInputStream audioInput= AudioSystem.getAudioInputStream(music);
			cl1= AudioSystem.getClip();
			cl1.open(audioInput);
			File music2= new File("Audios/RainFalling.wav");//2
			AudioInputStream audioInput2= AudioSystem.getAudioInputStream(music2);
			cl2= AudioSystem.getClip();
			cl2.open(audioInput2);
			File music3= new File("Audios/snowSound.wav");//3
			AudioInputStream audioInput3= AudioSystem.getAudioInputStream(music3);
			cl3= AudioSystem.getClip();
			cl3.open(audioInput3);
			File music4= new File("Audios/windySound.wav");//4
			AudioInputStream audioInput4= AudioSystem.getAudioInputStream(music4);
			cl4= AudioSystem.getClip();
			cl4.open(audioInput4);
		}catch(Exception e) {
			e.printStackTrace();
		}
		// Components of the environment
		try{
			s = ImageIO.read(new File("images/caution.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		ImageIcon imic=new ImageIcon(s);
		JLabel label3=new JLabel(imic);
		frame = new JFrame("TRAFFIC SIMULATION - ENVIRONMENT");
		frame.setLayout( new BorderLayout() );
		JSplitPane splitPane = new JSplitPane();
		frame.add( splitPane, BorderLayout.CENTER );
		pan.setPreferredSize( new Dimension(2000, 1200 ) );
		pan.setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane( pan );
		splitPane.setLeftComponent( scrollPane );
		JPanel pan2 = new JPanel();
		pan2.setBackground(Color.white);
		pan2.setLayout(new GridLayout(7,1));
		pan2.add(stop);
		stop.setBackground(Font);
		stop.setForeground(Color.WHITE);
		stop.setBorder(BorderFactory.createBevelBorder(0));
		stop.addActionListener(this);
		pan2.add(play);
		play.setBackground(Font);
		play.setForeground(Color.WHITE);
		play.setBorder(BorderFactory.createBevelBorder(0));
		play.addActionListener(this);
		pan2.add(pause);
		pause.setBackground(Font);
		pause.setForeground(Color.WHITE);
		pause.setBorder(BorderFactory.createBevelBorder(0));
		pause.addActionListener(this);
		pan2.add(gen);
		gen.setBackground(Font);
		gen.setForeground(Color.WHITE);
		gen.setBorder(BorderFactory.createBevelBorder(0));
		pan2.add(gen);
		gen.addActionListener(this);
		ImageIcon funny = new ImageIcon("images/funny.gif");
		JLabel label11= new JLabel("", funny, JLabel.CENTER);
		pan2.add(label11);
		pan2.add(acc);
		acc.setBackground(Font);
		acc.setForeground(Color.WHITE);
		acc.setBorder(BorderFactory.createBevelBorder(0));
		pan2.add(acc);
		acc.addActionListener(this);
		pan2.add(label);
		label.setForeground(Font1);
		label1.setForeground(Font1);
		label2.setForeground(Font1);
		label4.setForeground(Font1);
		pan2.add(combo);
		combo.setBackground(Color.WHITE);
		pan2.add(label1);
		pan2.add(combo1);
		combo1.setBackground(Color.WHITE);
		pan2.add(label2);
		pan2.add(slide);
		slide.setBackground(Color.WHITE);
		pan2.add(label3);
		pan2.add(label4);
		combo.addItemListener(new ItemState());
		combo.setPreferredSize(new Dimension(5,3));
		combo.setForeground(Color.DARK_GRAY);
		combo.setBorder(BorderFactory.createBevelBorder(0));
		combo.setFont(new Font("calibri", Font.BITMASK, 13));
		combo1.setFont(new Font("calibri", Font.BITMASK, 13));
		label.setFont(new Font("Cooper Black", Font.BITMASK, 14));
		label1.setFont(new Font("Cooper Black", Font.BITMASK,14));
		label2.setFont(new Font("Cooper Black", Font.BITMASK,14));
		label4.setFont(new Font("Cooper Black", Font.BITMASK,14));
		play.setFont(new Font("Cooper Black", Font.BITMASK,14));
		stop.setFont(new Font("Cooper Black", Font.BITMASK,14));
		pause.setFont(new Font("Cooper Black", Font.BITMASK,14));
		gen.setFont(new Font("Cooper Black", Font.BITMASK,14));
		acc.setFont(new Font("Cooper Black", Font.BITMASK,14));
		combo1.addItemListener(new ItemState());
		combo1.setPreferredSize(new Dimension(5,3));
		combo1.setForeground(Color.DARK_GRAY);
		combo1.setBorder(BorderFactory.createBevelBorder(0));
		slide.setMaximum(60);
		slide.setMinimum(0);
		slide.setValue(0);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.setMinorTickSpacing(1);
		slide.setMajorTickSpacing(10);
	    slide.addChangeListener(new ChangeListener(){
		    public void stateChanged(ChangeEvent event){
			   label2.setText("          The Simulation lasts: " + ((JSlider)event.getSource()).getValue()+"min");
			}
		});  
        //pan2.setPreferredSize(new Dimension(700, 500));
        splitPane.setRightComponent( pan2 );
        splitPane.setDividerLocation(2000);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.repaint();
		
	}
	
	/****************Generate a thread method***************************/
	public Thread generateT() {
		Thread gg=new Thread(this);
		return gg;
	}
	/*****************Button Action Listener**********************/
	@Override
	public void actionPerformed(ActionEvent e) {
		// Play Button
		if(e.getSource().equals(play)) {
			// Case1 = First launch of the thread 
			if(inmove== false && con==false && trrn==false) {
				rest=slide.getValue()*60000;
				time=0;
				inmove = true;trrn=true;
				Thread t=generateT();
				t.start();
			}         
			// Case2 = Every thread except the first one 
			if(inmove== false && con==true && End==false && trrn==false && Again==true) {
				rest=slide.getValue()*60000;
				time=0;
				inmove = true;
				Again=false;
				trrn=true;
				Thread tGenerated=generateT();
				tGenerated.start();
			}
			if(inmove== false && con==true && End==false && trrn==false && Again==false) {
				System.out.println(timer.ret(time,rest)[0]+"gggg" +timer.ret(time,rest)[1]);
				time=timer.ret(time,rest)[0];
				rest=timer.ret(time,rest)[1]-timer.ret(time,rest)[0];
				inmove = true;
				Again=false;
				trrn=true;
				Thread tGenerated=generateT();
				tGenerated.start();
			}
     	}
		// Stop Button 
		if(e.getSource().equals(stop)) {
			if(inmove== true && trrn==true) {
				inmove = false;
				trrn=false;
				con = true;
				End=true;
				
			}
		}
		// Pause Button 
		if(e.getSource().equals(pause)) {
			if(inmove== true && trrn==true) {
				inmove = false;
				trrn=false;
				con = true;
				End = false;
			
			 }
		}
		// Vehicules generation 
		if(e.getSource().equals(gen)) {
			String l = combo.getSelectedItem().toString();
			// Cross-Roads
			if(l=="Cross-Roads") {
				scen.generateCar1();
			}
			// Roundabouts
			if(l=="Roundabout") {
				int cercle=scen2.genererInt(0,4);
				scen2.generateCar2(cercle);
			}
		}
		// Accidents simulation
		if(e.getSource().equals(acc)) {
			String l = combo.getSelectedItem().toString();
			// Cross-Roads
			if(l=="Cross-Roads") {
				System.out.println("ACCIDENT  1");
				scen.createAccident();
			}
			// Roundabouts
			if(l=="Roundabout") {
				System.out.println("ACCIDENT   2"+ acc.getHeight() + "ffff"+acc.getWidth());
				scen2.createAccident();
			}
		}
	}
	/*****************Audios*********************/
	// Launch Audios
	public void loadSound1() {
		try{
			cl1.start();
			cl1.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void loadSound2() {
		try{
			cl2.start();
			cl2.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void loadSound3() {
		try{
			cl3.start();
			cl3.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void loadSound4() {
		try{
			cl4.start();
			cl4.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}	
	}
	// Stop clips after changement 
	public void stop(int n) {
		if(n==1) {
			cl2.stop();
			cl3.stop();
			cl4.stop();
		}
		if(n==2) {
			cl1.stop();
			cl3.stop();
			cl4.stop();
		}
		if(n==3) {
			cl1.stop();
			cl3.stop();
			cl4.stop();
		}
		if(n==4) {
			cl2.stop();
			cl3.stop();
			cl1.stop();
		}
	}
	/******************JComboBox Action Listener******************/
	class ItemState implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			String ele = combo.getSelectedItem().toString();
			String ele1 = combo.getSelectedItem().toString();
			if(e.getItem().equals("Cross-Roads")) {
				    pan.removeAll();
					pan.add(scen, BorderLayout.CENTER); 
			}  
			if(e.getItem().equals("Roundabout")) {
				    pan.removeAll();
					pan.add(scen2, BorderLayout.CENTER); 
			} 
			if(e.getItem().equals("Sunny") && ele=="Cross-Roads") {	  
				 scen.Sunny();
				 stop(1);
				 loadSound1();	 
			}
			if(e.getItem().equals("Rainy") && ele=="Cross-Roads") {
				  scen.Rainy();
				  stop(2);
				  loadSound2(); 
			}
			if(e.getItem().equals("Snowy") && ele=="Cross-Roads") {
				  scen.Snowy();
				  stop(3);
				  loadSound3();	  
			}
			if(e.getItem().equals("Windy") && ele=="Cross-Roads") {
				  scen.Windy();
				  stop(4);
				  loadSound4();
			}
			if(e.getItem().equals("Sunny") && ele=="Roundabout") {		  
				 scen2.Sunny();
				 stop(1);
				 loadSound1();	 
			}
			if(e.getItem().equals("Rainy") && ele=="Roundabout") {
			     scen2.Rainy();
			     stop(2);
			     loadSound2(); 
			}
			if(e.getItem().equals("Snowy") && ele=="Roundabout") {
				 scen2.Snowy();
				 stop(3);
				 loadSound3();  
			}
			if(e.getItem().equals("Windy") && ele=="Roundabout") {
				 scen2.Windy();
				 stop(4);
				 loadSound4();
			}
		}
	}
	/****************Threads Management**********************/
	public void run(){
		
		String l = combo.getSelectedItem().toString();
		timer.start();
		// Cross-Roads
		if(l=="Cross-Roads") {
				while(inmove==true && trrn==true && time<=rest){
					ArrayList<Lights> r= scen.getCarr();
					// P.S= it's not the best solution but the only one that works until now for me 
					Lights c1=r.get(0),c2=r.get(1),c3=r.get(2),c4=r.get(3)
							 ,c5=r.get(4),c6=r.get(5),c7=r.get(6),c8=r.get(7)
							 ,c9=r.get(8),c10=r.get(9),c11=r.get(10),c12=r.get(11)
							 ,c13=r.get(12),c14=r.get(13),c15=r.get(14),c16=r.get(15)
							,c17=r.get(16),c18=r.get(17),c19=r.get(18),c20=r.get(19)
							,c21=r.get(20),c22=r.get(21),c23=r.get(22),c24=r.get(23)
							,c25=r.get(24),c26=r.get(25),c27=r.get(26),c28=r.get(27),c29=r.get(28),c30=r.get(29)
							,c31=r.get(30),c32=r.get(31),c33=r.get(32),c34=r.get(33),c35=r.get(34),c36=r.get(35)
							,c37=r.get(36),c38=r.get(37),c39=r.get(38),c40=r.get(39);
							
					Lights cv1=r.get(40),cv2=r.get(41),cv3=r.get(42),cv4=r.get(43),cv5=r.get(44),cv6=r.get(45),
							cv7=r.get(46),cv8=r.get(47),cv9=r.get(48),cv10=r.get(49),cv11=r.get(50),cv12=r.get(51)
							,cv13=r.get(52),cv14=r.get(53),cv15=r.get(54),cv16=r.get(55),cv17=r.get(56),cv18=r.get(57)
							,cv19=r.get(58),cv20=r.get(59),cv21=r.get(60),cv22=r.get(61),cv23=r.get(62),cv24=r.get(63),cv25=r.get(64),cv26=r.get(65)
							,cv27=r.get(66),cv28=r.get(67),cv29=r.get(68),cv30=r.get(69),cv31=r.get(70),cv32=r.get(71)
							,cv33=r.get(72),cv34=r.get(73),cv35=r.get(74),cv36=r.get(75),cv37=r.get(76),cv38=r.get(77),cv39=r.get(78),cv40=r.get(79);
								
					scen.swapEm1(cv1, cv2,"vertical");
					scen.swapEm1(cv3, cv4,"vertical");
					scen.swapEm1(cv5, cv6,"vertical");
					scen.swapEm1(cv7, cv8,"vertical");
					scen.swapEm1(cv9, cv10,"vertical");
					scen.swapEm1(cv11, cv12,"vertical");
					scen.swapEm1(cv13, cv14,"vertical");
					scen.swapEm1(cv15, cv16,"vertical");
					scen.swapEm1(cv17, cv18,"vertical");
					scen.swapEm1(cv19, cv20,"vertical");
					scen.swapEm1(cv21, cv22,"vertical");
					scen.swapEm1(cv23, cv24,"vertical");
					scen.swapEm1(cv25, cv26,"vertical");
					scen.swapEm1(cv27, cv28,"vertical");
					scen.swapEm1(cv29, cv30,"vertical");
					scen.swapEm1(cv31, cv32,"vertical");
					scen.swapEm1(cv33, cv34,"vertical");
					scen.swapEm1(cv35, cv36,"vertical");
					scen.swapEm1(cv37, cv38,"vertical");
					scen.swapEm1(cv39, cv40,"vertical");
					for(int j=0;j<40;j++) {
						if (r.get(j).iValue == 25) {
							r.get(j).iValue = -1;
						}
						r.get(j).iValue = r.get(j).iValue + 1;
					}
					for(int j=40;j<80;j++) {
						if (r.get(j).iValue2 == 25) {
							r.get(j).iValue2 = -1;
						}
						r.get(j).iValue2 = r.get(j).iValue2 + 1;
					}
					scen.swapEm1(c1,c3,"horizontal");
					scen.swapEm1(c2, c4,"horizontal");
					scen.swapEm1(c5,c7,"horizontal");
					scen.swapEm1(c6, c8,"horizontal");
					scen.swapEm1(c9,c11,"horizontal");
					scen.swapEm1(c10, c12,"horizontal");
					scen.swapEm1(c13,c15,"horizontal");
					scen.swapEm1(c14, c16,"horizontal");
					scen.swapEm1(c17,c19,"horizontal");
					scen.swapEm1(c18, c20,"horizontal");
					scen.swapEm1(c21,c23,"horizontal");
					scen.swapEm1(c22, c24,"horizontal");
					scen.swapEm1(c25,c27,"horizontal");
					scen.swapEm1(c26, c28,"horizontal");
					scen.swapEm1(c29,c31,"horizontal");
					scen.swapEm1(c30, c32,"horizontal");
					scen.swapEm1(c33,c35,"horizontal");
					scen.swapEm1(c34, c36,"horizontal");
					scen.swapEm1(c37,c39,"horizontal");
					scen.swapEm1(c38, c40,"horizontal");
					try {
						Thread.sleep(1100);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					scen.Move();
					scen.calculateAS();
					this.repaint();
					try {
						Thread.sleep(1100);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					timer.check();
					timer.stop();
					time=timer.getMilliSec2();
					timer.printMilliSec2();
					if(time>rest) {
						Again=true;
					}		
				}
				String s="The results of this simulation are: \n "+"Indentities of cars having accidents with their location: \n";
				int NA=0;
				for(int i=0;i<40;i++) {
					Route1  rrr= scen.roads.get(i);
					NA=NA+rrr.Accidents.size();
					for(int j=0;j<rrr.Accidents.size();j++) {
						s=s+(rrr.Accidents.get(j)+"\n");
					}
				}
				int N =scen.allCars.size();
				s=s+"* The size of the sample or The number of vehicules = "+N+"\n";
				s=s+"* The number of Accidents = "+NA/2+"\n";
				s=s+"* Average speeds in terms of time : "+"\n";
				int j=1;
				for(int i=0;i<scen.ASpeeds.size();i++) {
					float Sp=scen.ASpeeds.get(i);
					if(i==j*(10)) {
						s=s+Sp+"- \n";
						j++;
					}
					if(i==scen.ASpeeds.size()-1) {
						s=s+Sp+"\n";
					}
					else {
						s=s+Sp+"-";
					}
				}
				s=s+"\n";
				s=s+"Ps: You can remark that the appearence of an accident decreases \n"+"the average speed and creates traffic jam ";
				JTextArea textArea = new JTextArea("Insert your Text here");
				JScrollPane scrollPaneee = new JScrollPane(textArea);  
				textArea.setLineWrap(true);  
				textArea.setWrapStyleWord(true); 
				textArea.setText(s);
				textArea.setEditable(false);
				scrollPaneee.setPreferredSize( new Dimension( 500, 500 ) );
				JOptionPane.showMessageDialog(null, scrollPaneee, "ANALYSIS",JOptionPane.YES_NO_OPTION);
				pan.removeAll();
		}
		// Roundabouts
		if(l=="Roundabout") {			
			while(inmove==true && trrn==true && time<=rest){
				scen2.Move();
				scen2.calculateATW();
				this.repaint();
				try {
					Thread.sleep(1100);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				timer.check();
				timer.stop();
				time=timer.getMilliSec2();
				timer.printMilliSec2();
				if(time>rest) {
					Again=true;
				}		
		}
		String s="The results of this simulation are: \n "+"Indentities of cars having accidents with their location: \n";
		int NA=0;
		for(int i=0;i<40;i++) {
			Route1  rrr= scen2.roads.get(i);
			NA=NA+rrr.Accidents.size();
			for(int j=0;j<rrr.Accidents.size();j++) {
				s=s+(rrr.Accidents.get(j)+"\n");
			}
		}
		int N =scen2.allCars.size();
		s=s+"* The size of the sample or The number of vehicules = "+N+"\n";
		s=s+"* The number of Accidents = "+NA/2+"\n";
		s=s+"* Average waiting average time laps in terms of time : "+"\n";
		int j=1;
		for(int i=0;i<scen2.Laps.size();i++) {
			float Sp=scen2.Laps.get(i);
			if(i==j*(10)) {
				s=s+Sp+"- \n";
				j++;
			}
			if(i==scen2.Laps.size()-1) {
				s=s+Sp+"\n";
			}
			else {
				s=s+Sp+"-";
			}
		}
		s=s+"\n";
		s=s+"Ps: You can remark that the appearence of an accident increases \n"+"the average waiting lap time and creates traffic jam and brings about troubles";
		JTextArea textArea = new JTextArea("Insert your Text here");
		JScrollPane scrollPaneee = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		textArea.setText(s);
		textArea.setEditable(false);
		scrollPaneee.setPreferredSize( new Dimension( 500, 500 ) );
		JOptionPane.showMessageDialog(null, scrollPaneee, "ANALYSIS",JOptionPane.YES_NO_OPTION);
			pan.removeAll();
		}
		}
	}