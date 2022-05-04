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

/******************* LOADING ****************/
public class Loading extends JFrame {
	
	
	static JFrame frame = new JFrame(" TRAFFIC SIMULATION - LOADING...");
	boolean next=true;
	static Clip clip;
	public Loading(){
		JPanel pan = new JPanel();
	    frame.add(pan,BorderLayout.CENTER);
	    pan.setLayout(new GridLayout(1,1));
	    ImageIcon loading = new ImageIcon("images/loading.gif");
	    JLabel label= new JLabel("", loading, JLabel.CENTER);
	    pan.add(label);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setVisible(true);
	    Color color= new Color(189,217,232);
		pan.setBackground(color);
		
		/*************Adding audio to the loading************/
		try{
			File music= new File("Audios/carstartgarage.wav");
			AudioInputStream audioInput= AudioSystem.getAudioInputStream(music);
			clip= AudioSystem.getClip();
			clip.open(audioInput);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		/*************Display the loading for one minute ************/
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(next==true) {
			frame.dispose();
			clip.stop();
		}
		new Menu();

	}
	public static void main(String[] args) throws Exception{
		new Loading();
	}
		
}