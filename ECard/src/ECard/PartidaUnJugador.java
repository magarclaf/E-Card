package ECard;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PartidaUnJugador extends JFrame {
	
	private static int numeroJugado=0;
	private static int contadorJugador=0;
	private static int contadorCPU=0;
	private final static String espaciosBlanco="                                     ";
	private final static String ladoEmperor="lEmperor";
	private final static String ladoSlave="lSlave";
	private static JButton emperor;//Numero 1
	private static JButton citizen1;//Numero 2
	private static JButton citizen2;//Numero 3
	private static JButton citizen3;//Numero 4
	private static JButton citizen4;//Numero 5
	private static JButton citizen11;//Numero 6
	private static JButton citizen22;//Numero 7
	private static JButton citizen33;//Numero 8
	private static JButton citizen44;//Numero 9
	private static JButton slave;//Numero 10
	private JPanel panelEsclavo;
	private JPanel panelEmperador;
	private JPanel panelDerecha;
	private static JPanel panelIzquierda;
	private JPanel panelCentro;
	private static JLabel resultado;
	
	public PartidaUnJugador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Desktop\\Kaiji\\zawa.png"));
		setTitle("E-Card Un Jugador");
		setType(Type.POPUP);
		setResizable(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
//		this.lado=lado;
		
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
		
		//Codigo para poner el background a la ventana
//		BufferedImage img = null;
//		try {
//		    img = ImageIO.read(new File("D:\\Desktop\\Weeb\\fondos\\las-quintillizas.jpg"));
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
//		Image dimg = img.getScaledInstance(800, 508, Image.SCALE_DEFAULT);
//		ImageIcon imageIcon = new ImageIcon(dimg);
//		JLabel fondo=new JLabel(imageIcon);
//		setContentPane(fondo);
		
		//Dimension para que los botones tengan el tamaño de sus iconos (las cartas)
		Dimension d = new Dimension(72,96);
		ImageIcon iconCitizen = new ImageIcon("D:\\Users\\mgarc\\git\\E-Card\\citizen-scaled.jpg");
		ImageIcon iconEmperor = new ImageIcon("D:\\Users\\mgarc\\git\\E-Card\\emperor-scaled.jpg");
		ImageIcon iconSlave = new ImageIcon("D:\\Users\\mgarc\\git\\E-Card\\slave-scaled.jpg");

		FlowLayout fl=new FlowLayout();
		fl.setVgap(200);
		getContentPane().setLayout(new BorderLayout());
		
		panelEmperador = new JPanel();
		panelEmperador.setOpaque(false);
		getContentPane().add(panelEmperador,BorderLayout.NORTH);
		emperor = new JButton(iconEmperor);
		emperor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado=1;
				emperor.setVisible(false);
			}
		});
	    emperor.setPreferredSize(d);
		panelEmperador.add(emperor);
		citizen1 = new JButton(iconCitizen);
		citizen1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado=2;
				citizen1.setVisible(false);
			}
		});
		citizen1.setPreferredSize(d);
		panelEmperador.add(citizen1);
		citizen2 = new JButton(iconCitizen);
		citizen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado=3;
				citizen2.setVisible(false);
			}
		});
		citizen2.setPreferredSize(d);
		panelEmperador.add(citizen2);
		citizen3 = new JButton(iconCitizen);
		citizen3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado=4;
				citizen3.setVisible(false);
			}
		});
		citizen3.setPreferredSize(d);
		panelEmperador.add(citizen3);
		citizen4 = new JButton(iconCitizen);
		citizen4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado=5;
				citizen4.setVisible(false);
			}
		});
		citizen4.setPreferredSize(d);
		panelEmperador.add(citizen4);
		
		panelEsclavo = new JPanel();
		panelEsclavo.setOpaque(false);
		getContentPane().add(panelEsclavo,BorderLayout.SOUTH);
		
		
		slave = new JButton(iconSlave);
		slave.setEnabled(false);
		slave.setPreferredSize(d);
		panelEsclavo.add(slave);
		citizen11 = new JButton(iconCitizen);
		citizen11.setEnabled(false);
		citizen11.setPreferredSize(d);
		panelEsclavo.add(citizen11);
		citizen22 = new JButton(iconCitizen);
		citizen22.setEnabled(false);
		citizen22.setPreferredSize(d);
		panelEsclavo.add(citizen22);
		citizen33 = new JButton(iconCitizen);
		citizen33.setEnabled(false);
		citizen33.setPreferredSize(d);
		panelEsclavo.add(citizen33);
		citizen44 = new JButton(iconCitizen);
		citizen44.setEnabled(false);
		citizen44.setPreferredSize(d);
		panelEsclavo.add(citizen44);
		
		panelDerecha = new JPanel();
		panelDerecha.setOpaque(false);
		getContentPane().add(panelDerecha,BorderLayout.EAST);
		JLabel CPU=new JLabel("CPU");
		panelDerecha.add(CPU);
		
		panelIzquierda = new JPanel();
		panelIzquierda.setOpaque(false);
		getContentPane().add(panelIzquierda,BorderLayout.WEST);
		JLabel Jugador=new JLabel("JUGADOR");
		panelIzquierda.add(Jugador);
		
		panelCentro = new JPanel();
		panelCentro.setOpaque(false);
		getContentPane().add(panelCentro,BorderLayout.CENTER);
		
		resultado=new JLabel(espaciosBlanco+contadorJugador+"-"+contadorCPU);
		panelIzquierda.add(resultado);
		
		//Encajona las piezas del JFrame
		pack();
		
		AJugar();
	}
	
	//main que invoca al constructor y lo muestra
	public static void main(String[] args) {
		PartidaUnJugador e = new PartidaUnJugador();
		e.setVisible(true);
		
	}
	
	
	public static void AJugar() {
		int ronda = 0;
		int turno = 0;
		int numeroJugadoCPU = 0;
		boolean ladoEmperador = true;
		boolean seguimos = false;
		// 4 turnos distintos
		while (turno < 4) {
			// 3 rondas seguidas en el mismo lado
			while (ronda < 3) {
				//La CPU eligira un numero según el lado en el que se encuentre
				if (ladoEmperador) {
					numeroJugadoCPU = cartaJugadaladoEsclavoCPU();
				} else {
					numeroJugadoCPU = cartaJugadaladoEmperadorCPU();
				}

				// se juega la partida de un lado
				if (ladoEmperador) {
					// Si uso emperador ---> o pierdo contra esclavo (10) o gano contra ciudadano (6-9)
					if (numeroJugado == 1) {
						if (numeroJugadoCPU == 10) {
							contadorCPU = contadorCPU + 4;
						} else {
							contadorJugador++;
						}

						// Si uso ciudadano ---> o gano al esclavo (10) o empato al ciudadano (6-9)
					} else {
						if (numeroJugadoCPU == 10) {
							contadorJugador++;
						} else {
							seguimos = true;
						}
					}

				} else {
					// Si uso esclavo ---> o gano al emperador (1) o pierdo contra el ciudadano (2-5)
					if (numeroJugado == 10) {
						if (numeroJugadoCPU == 1) {
							contadorJugador = contadorJugador + 4;
						} else {
							contadorCPU++;
						}
						// Si uso ciudadano ---> o pierdo contra el emperador (1) o empato al ciudadano (2-5)
					} else {
						if (numeroJugadoCPU == 1) {
							contadorCPU++;
						} else {
							seguimos = true;
						}
					}
				}
				//Actualizamos el resultado
				resultado.setText(espaciosBlanco+contadorJugador+"-"+contadorCPU);
				//Quitamos el boton que ha usado la maquina
				botonUsado(numeroJugadoCPU).setVisible(false);
				//si seguimos no avanzamos de ronda, si ya tenemos resultado volvemos las cosas como estaban y empezamos nueva ronda
				if (seguimos) {
					seguimos = false;
				} else {
					if (ladoEmperador) {
						visibilidadLadoEmperador();
					} else {
						visibilidadLadoEsclavo();
					}
					ronda++;
				}

			}
			//al terminar las 3 rondas del turno correspondiente cambiamos de lado dandole la visibilidad correspondiente
			if (ladoEmperador) {
				ladoEmperador = false;
				visibilidadLadoEsclavo();
			} else {
				ladoEmperador = true;
				visibilidadLadoEmperador();
			}
			turno++;
		}
	}
	
	//Da visibilidad al lado Emperador e inutiliza el otro lado
	public static void visibilidadLadoEmperador() {
		ponerCartasVisibles();
		slave.setEnabled(false);
		emperor.setEnabled(true);
		citizen1.setEnabled(true);
		citizen2.setEnabled(true);
		citizen3.setEnabled(true);
		citizen4.setEnabled(true);
		citizen11.setEnabled(false);
		citizen22.setEnabled(false);
		citizen33.setEnabled(false);
		citizen44.setEnabled(false);
	}
	
	//Da visibilidad al lado Esclavo e inutiliza el otro lado
	public static void visibilidadLadoEsclavo() {
		ponerCartasVisibles();
		slave.setEnabled(true);
		emperor.setEnabled(false);
		citizen1.setEnabled(false);
		citizen2.setEnabled(false);
		citizen3.setEnabled(false);
		citizen4.setEnabled(false);
		citizen11.setEnabled(true);
		citizen22.setEnabled(true);
		citizen33.setEnabled(true);
		citizen44.setEnabled(true);
	}
	
	//Pone todas las cartas visibles
	public static void ponerCartasVisibles() {
		slave.setVisible(true);
		emperor.setVisible(true);
		citizen1.setVisible(true);
		citizen2.setVisible(true);
		citizen3.setVisible(true);
		citizen4.setVisible(true);
		citizen11.setVisible(true);
		citizen22.setVisible(true);
		citizen33.setVisible(true);
		citizen44.setVisible(true);
	}
	
	//Metodos para conseguir un numero random asociado a una de las cartas 
	//del lado que le toca jugar a la CPU
	public static int cartaJugadaladoEsclavoCPU() {
		 return (int)(Math.random()*(10-6+1)+6);
	}
	
	public static int cartaJugadaladoEmperadorCPU() {
		return (int)(Math.random()*(5-1+1)+1);
	}
	
	
	//cada boton tiene un numero asociado (lo pone en la declaracion de las variables)
	public static JButton botonUsado(int numeroAsignado) {
		if (numeroAsignado == 1) {
			return slave;
		}
		if (numeroAsignado == 2) {
			return citizen1;
		}
		if (numeroAsignado == 3) {
			return citizen2;
		}
		if (numeroAsignado == 4) {
			return citizen3;
		}
		if (numeroAsignado == 5) {
			return citizen4;
		}
		if (numeroAsignado == 6) {
			return citizen11;
		}
		if (numeroAsignado == 7) {
			return citizen22;
		}
		if (numeroAsignado == 8) {
			return citizen33;
		}
		if (numeroAsignado == 9) {
			return citizen44;
		}
		if (numeroAsignado == 10) {
			return slave;
		}
		return null;
	}

}
