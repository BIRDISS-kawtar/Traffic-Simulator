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

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Menu extends JFrame implements ActionListener{
	
	JPanel container= new JPanel();
	JButton exit=new JButton("EXIT");
	JButton description=new JButton("INFORMATIONS ABOUT");
	JButton rem=new JButton("REMARKS");
	JButton Start=new JButton("LET'S START");;
	static JFrame frame = new JFrame("TRAFFIC SIMULATION - MENU");
	Image img;
	
	/************* The menu ***************/
	public Menu(){
		
	    container.setLayout(null);
	    // Start Button 
	    ImageIcon loading = new ImageIcon("images/Start.gif");
	    JLabel label= new JLabel("", loading, JLabel.CENTER);
	    Start.add(label);
	    Start.setBounds(150,400, 200, 100);
	    container.add(Start);
	    frame.add(container);
	    Start.setBackground(Color.BLACK);
	    Start.addActionListener(this);
	    // Informations Button
	     ImageIcon info = new ImageIcon("images/info.gif");
	    JLabel label1= new JLabel("",info, JLabel.CENTER);
	    description.add(label1);
	    description.setBounds(400, 400, 200, 100);
	    container.add(description);
	    description.setBackground(Color.BLACK);
	    description.addActionListener(this);
	    // Alert Button
	    ImageIcon alert = new ImageIcon("images/alert.gif");
	    JLabel label2= new JLabel("",alert, JLabel.CENTER);
	    rem.add(label2);
	    rem.setBounds(150, 550, 200, 100);
	    container.add(rem);
	    rem.setBackground(Color.BLACK);
	    rem.addActionListener(this);
	    // Exit Button
	    ImageIcon exitt = new ImageIcon("images/exit.gif");
	    JLabel label3= new JLabel("",exitt, JLabel.CENTER);
	    exit.add(label3);
	    exit.setBounds(400, 550, 200, 100);
	    container.add(exit);
	    exit.setBackground(Color.BLACK);
	    exit.addActionListener(this);
	    container.setBackground(Color.WHITE);
	    // Background images
	    ImageIcon img = new ImageIcon("images/back2.png");
	    JLabel back= new JLabel("", img, JLabel.CENTER);
	    back.setBounds(288,30,1600,870);
	    container.add(back);
	    ImageIcon imfont = new ImageIcon("images/traffic-.png");
	    JLabel label4= new JLabel("", imfont, JLabel.CENTER);
	    label4.setBounds(0,0,500,136);
	    container.add(label4);
	    ImageIcon imfont1 = new ImageIcon("images/simultion.png");
	    JLabel label5= new JLabel("", imfont1, JLabel.CENTER);
	    label5.setBounds(430,130,1000,338);
	    container.add(label5);
	    
	    
	    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    frame.setVisible( true );
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    
	}
	/****************Action listener on buttons******************/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(Start)) {
			new Environnement();
			frame.dispose();
		}
		if(e.getSource().equals(exit)) {
			System.exit(0);
		}
		if(e.getSource().equals(description)) {
			JOptionPane.showMessageDialog(null,"Dear user, this application will give the chance to experience many"+"\n"+"traffic scenarios, control it and visualize it. This is the opportunity "+"\n"+"for you to discover and understand the general behavior of a vehicle and its interaction with other vehicles."+"\n"+"Therefore you will be able to conceive statistically the circulation flow in a " +"\n"+ 
					"road network.");
		}
		if(e.getSource().equals(rem)) {
			JOptionPane.showMessageDialog(null,"1. PLEASE PRESS MAXIMAZE TO SEE ALL THE MENU "
					+"\n"+"2. MAKE AN ACTION ( MOVING THE SCROLLS FOR EXAMPLE) IF THE DISPLAY OF AN OBJECT IS DISTRBUED"+"\n"+"3. TO GENERETE CARS DO NOT CLICK THE BUTTON SEVERAL TIME"+
					"\n"+"BETWEEN TO SUCCESSIVE SIMULATIONS WE REMOVE ALL THE PREVIOUS DISPLAY BUT YOU NEED TO MOVE THE SCROLLS TO REMARKE THE MODIFICATION ");
		}
	}
}
