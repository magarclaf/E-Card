package ECard;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Equipo extends JFrame {
	
	final static String ladoEmperor="lEmperor";
	final static String ladoSlave="lSlave";
	String lado;
	JButton slave;
	JButton emperor;
	JButton citizen1;
	JButton citizen2;
	JButton citizen3;
	JButton citizen4;
	
	public Equipo(String lado) {
		
		this.lado=lado;
		
//		URL urlC;
//		URL urlE;
//		URL urlS;
//		ImageIcon iconCitizen = null;
//		ImageIcon iconSlave = null;
//		ImageIcon iconEmperor = null;
//		try{
//			urlC = new URL("https://github.com/magarclaf/E-Card/blob/master/citizen-scaled.jpg");
//			BufferedImage imgC = ImageIO.read(urlC);
//			urlE = new URL("https://github.com/magarclaf/E-Card/blob/master/emperor-scaled.jpg");
//			BufferedImage imgE = ImageIO.read(urlE);
//			urlS = new URL("https://github.com/magarclaf/E-Card/blob/master/slave-scaled.jpg");
//			BufferedImage imgS = ImageIO.read(urlS);
//			
//			iconCitizen = new ImageIcon(imgC);
//			iconEmperor = new ImageIcon(imgE);
//			iconSlave = new ImageIcon(imgS);
//			
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		 catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		ImageIcon iconCitizen = new ImageIcon("D:\\Users\\mgarc\\git\\E-Card\\citizen-scaled.jpg");
		ImageIcon iconEmperor = new ImageIcon("D:\\Users\\mgarc\\git\\E-Card\\emperor-scaled.jpg");
		ImageIcon iconSlave = new ImageIcon("D:\\Users\\mgarc\\git\\E-Card\\slave-scaled.jpg");
		
		
		slave = new JButton(iconSlave);
		emperor = new JButton(iconEmperor);
		citizen1 = new JButton(iconCitizen);
		citizen2 = new JButton(iconCitizen);
		citizen3 = new JButton(iconCitizen);
		citizen4 = new JButton(iconCitizen);
		
		getContentPane().setLayout(new FlowLayout());
		if(this.lado.equals(ladoEmperor)) {
			getContentPane().add(emperor);
		}else {
				getContentPane().add(slave);
		}
			
		getContentPane().add(citizen1);
		getContentPane().add(citizen2);
		getContentPane().add(citizen3);
		getContentPane().add(citizen4);
	}
	
	public static void main(String[] args) {
		Equipo e1= new Equipo(ladoEmperor);
		Equipo e2= new Equipo(ladoSlave);
		e1.setVisible(true);
		e2.setVisible(true);
	}

}
