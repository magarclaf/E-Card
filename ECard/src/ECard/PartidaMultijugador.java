package ECard;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PartidaMultijugador extends JFrame {
	
	private static String numeroJugado="";
	private static String numeroPasadoPorElRival="";
	private static int contadorJugador=0;
	private static int contadorRival=0;
	private final static String espaciosBlanco="                                     ";
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
	private static int ronda=0;//Grande --> Emperador/Esclavo/Emperador/Esclavo
	private static int turno=0;//Medio --> 3 con emperador, 3 con esclavo, ...
	private static int jugada=0;//Pequeño --> Máx. 5 jugadas (VS)
	private static boolean ladoEmperador=true;
	private static boolean seguimos=false;
	Socket con;
	String nombreJugador1;
	String nombreJugador2;
	DataInputStream dis;
	DataOutputStream dos;
	
	
	@SuppressWarnings("deprecation")
	public PartidaMultijugador(Socket s, String nj1, boolean ladoEmp) {
		ladoEmperador=ladoEmp;
		con = s;
		nombreJugador1 = nj1;
		nombreJugador2="";
		try{
		dis = new DataInputStream(con.getInputStream());
		dos = new DataOutputStream(con.getOutputStream());
		dos.writeBytes(nombreJugador1+"/r/n");
		nombreJugador2=dis.readLine();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Desktop\\Kaiji\\zawa.png"));
		setTitle("E-Card Multijugador");
		setType(Type.POPUP);
		setResizable(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Dimension para que los botones tengan el tamaño de sus iconos (las cartas)
		Dimension d = new Dimension(72,96);
		ImageIcon iconCitizen = new ImageIcon(Menu.class.getResource("/res/citizen-scaled.jpg"));
		ImageIcon iconEmperor = new ImageIcon(Menu.class.getResource("/res/emperor-scaled.jpg"));
		ImageIcon iconSlave = new ImageIcon(Menu.class.getResource("/res/slave-scaled.jpg"));

		FlowLayout fl=new FlowLayout();
		fl.setVgap(200);
		getContentPane().setLayout(new BorderLayout());
		
		panelEmperador = new JPanel();
		panelEmperador.setOpaque(false);
		getContentPane().add(panelEmperador,BorderLayout.NORTH);
		emperor = new JButton(iconEmperor);
		emperor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado="1";
				emperor.setVisible(false);
				try {
					dos.writeBytes(numeroJugado);
					numeroPasadoPorElRival=dis.readLine();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				AJugar(numeroPasadoPorElRival);
				estadoPartida();
			}
		});
	    emperor.setPreferredSize(d);
		panelEmperador.add(emperor);
		citizen1 = new JButton(iconCitizen);
		citizen1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado="2";
				citizen1.setVisible(false);
				try {
					dos.writeBytes(numeroJugado);
					numeroPasadoPorElRival=dis.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				AJugar(numeroPasadoPorElRival);
				estadoPartida();
			}
		});
		citizen1.setPreferredSize(d);
		panelEmperador.add(citizen1);
		citizen2 = new JButton(iconCitizen);
		citizen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado="3";
				citizen2.setVisible(false);
				try {
					dos.writeBytes(numeroJugado);
					numeroPasadoPorElRival=dis.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				AJugar(numeroPasadoPorElRival);
				estadoPartida();
			}
		});
		citizen2.setPreferredSize(d);
		panelEmperador.add(citizen2);
		citizen3 = new JButton(iconCitizen);
		citizen3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado="4";
				citizen3.setVisible(false);
				try {
					dos.writeBytes(numeroJugado);
					numeroPasadoPorElRival=dis.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				AJugar(numeroPasadoPorElRival);
				estadoPartida();
			}
		});
		citizen3.setPreferredSize(d);
		panelEmperador.add(citizen3);
		citizen4 = new JButton(iconCitizen);
		citizen4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado="5";
				citizen4.setVisible(false);
				try {
					dos.writeBytes(numeroJugado);
					numeroPasadoPorElRival=dis.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				AJugar(numeroPasadoPorElRival);
				estadoPartida();
			}
		});
		citizen4.setPreferredSize(d);
		panelEmperador.add(citizen4);
		
		panelEsclavo = new JPanel();
		panelEsclavo.setOpaque(false);
		getContentPane().add(panelEsclavo,BorderLayout.SOUTH);
		
		
		slave = new JButton(iconSlave);
		slave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado="10";
				slave.setVisible(false);
				try {
					dos.writeBytes(numeroJugado);
					numeroPasadoPorElRival=dis.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				AJugar(numeroPasadoPorElRival);
				estadoPartida();
			}
		});
		slave.setEnabled(false);
		slave.setPreferredSize(d);
		panelEsclavo.add(slave);
		citizen11 = new JButton(iconCitizen);
		citizen11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado="6";
				citizen11.setVisible(false);
				try {
					dos.writeBytes(numeroJugado);
					numeroPasadoPorElRival=dis.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				AJugar(numeroPasadoPorElRival);
				estadoPartida();
			}
		});
		citizen11.setEnabled(false);
		citizen11.setPreferredSize(d);
		panelEsclavo.add(citizen11);
		citizen22 = new JButton(iconCitizen);
		citizen22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado="7";
				citizen22.setVisible(false);
				try {
					dos.writeBytes(numeroJugado);
					numeroPasadoPorElRival=dis.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				AJugar(numeroPasadoPorElRival);
				estadoPartida();
			}
		});
		citizen22.setEnabled(false);
		citizen22.setPreferredSize(d);
		panelEsclavo.add(citizen22);
		citizen33 = new JButton(iconCitizen);
		citizen33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado="8";
				citizen33.setVisible(false);
				try {
					dos.writeBytes(numeroJugado);
					numeroPasadoPorElRival=dis.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				AJugar(numeroPasadoPorElRival);
				estadoPartida();
			}
		});
		citizen33.setEnabled(false);
		citizen33.setPreferredSize(d);
		panelEsclavo.add(citizen33);
		citizen44 = new JButton(iconCitizen);
		citizen44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroJugado="9";
				citizen44.setVisible(false);
				try {
					dos.writeBytes(numeroJugado);
					numeroPasadoPorElRival=dis.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				AJugar(numeroPasadoPorElRival);
				estadoPartida();
			}
		});
		citizen44.setEnabled(false);
		citizen44.setPreferredSize(d);
		panelEsclavo.add(citizen44);
		
		panelDerecha = new JPanel();
		panelDerecha.setOpaque(false);
		getContentPane().add(panelDerecha,BorderLayout.EAST);
		JLabel Jugador2=new JLabel(nombreJugador2);
		panelDerecha.add(Jugador2);
		
		panelIzquierda = new JPanel();
		panelIzquierda.setOpaque(false);
		getContentPane().add(panelIzquierda,BorderLayout.WEST);
		JLabel Jugador=new JLabel(nombreJugador1);
		panelIzquierda.add(Jugador);
		
		panelCentro = new JPanel();
		panelCentro.setOpaque(false);
		getContentPane().add(panelCentro,BorderLayout.CENTER);
		
		resultado=new JLabel(espaciosBlanco+contadorJugador+"-"+contadorRival);
		panelIzquierda.add(resultado);
		
		if(ladoEmperador) {
			visibilidadLadoEmperador();
		}
		else {
			visibilidadLadoEsclavo();
		}
		
		//Encajona las piezas del JFrame
		pack();

	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
//		finally {
//
//		try {
//			if (s != null) {
//				s.close();
//			}
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
		
	}
	
	
	public static void AJugar(String numeroJugadorvl) {
		int numeroJugadoRival = Integer.parseInt(numeroJugadorvl);
		int numeroJugadoYo = Integer.parseInt(numeroJugado);
		// se juega la partida de un lado
		if (ladoEmperador) {
			// Si uso emperador ---> o pierdo contra esclavo (10) o gano contra ciudadano
			// (6-9)
			if (numeroJugadoYo == 1) {
				if (numeroJugadoRival == 10) {
					contadorRival = contadorRival + 5;
				} else {
					contadorJugador++;
				}

				// Si uso ciudadano ---> o gano al esclavo (10) o empato al ciudadano (6-9)
			} else {
				if (numeroJugadoRival == 10) {
					contadorJugador++;
				} else {
					seguimos = true;
				} 
			}

		} else {
			// Si uso esclavo ---> o gano al emperador (1) o pierdo contra el ciudadano
			// (2-5)
			if (numeroJugadoYo == 10) {
				if (numeroJugadoRival == 1) {
					contadorJugador = contadorJugador + 3;
				} else {
					contadorRival++;
				}
				// Si uso ciudadano ---> o pierdo contra el emperador (1) o empato al ciudadano
				// (2-5)
			} else {
				if (numeroJugadoRival == 1) {
					contadorRival++;
				} else {
					seguimos = true;
				}
			}
		}
		System.out.println("Numero jugado del rival" + numeroJugadoRival);
		// Actualizamos el resultado
		resultado.setText(espaciosBlanco + contadorJugador + "-" + contadorRival);
		// Quitamos el boton que ha usado el rival
		botonUsado(numeroJugadoRival).setVisible(false);			
	}
	
	public static void estadoPartida() {
		jugada++;
		if(!seguimos) {
			if (ladoEmperador) {
				visibilidadLadoEmperador();
			} else {
				visibilidadLadoEsclavo();
			}
			jugada=0;
			turno++;
		}
		if(turno==3) {
			if (ladoEmperador) {
				ladoEmperador = false;
				visibilidadLadoEsclavo();
			} else {
				ladoEmperador = true;
				visibilidadLadoEmperador();
			}
			ronda++;
			turno=0;
		}
		if (ronda == 4) {
			if (contadorJugador > contadorRival) {
				JOptionPane.showMessageDialog(null, "Resultado: " + resultado.getText().replaceAll("\s+","") + " - Ganaste, menos mal...");
				
			} else {
				JOptionPane.showMessageDialog(null, "Resultado: " + resultado.getText().replaceAll("\s+","") + " - No has ganado a la CPU, que basura!");
			}
			contadorJugador=0;contadorRival=0;
			resultado.setText(espaciosBlanco + contadorJugador + "-" + contadorRival);
			ronda = 0;
		}
		seguimos=false;
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
		if((int)(Math.random()*((5-jugada)-1+1)+1) == 1){
		    return 10;
		}
		else
		    return jugada+6;
		
		//return (int)(Math.random()*(10-6+1)+6);
	}
	
	public static int cartaJugadaladoEmperadorCPU() {
		
		if((int)(Math.random()*((5-jugada)-1+1)+1) == 1){
		    return 1;
		}
		else
		    return jugada+2;
		
		//return (int)(Math.random()*(5-1+1)+1);
	}
	
	
	//cada boton tiene un numero asociado (lo pone en la declaracion de las variables)
	public static JButton botonUsado(int numeroAsignado) {
		if (numeroAsignado == 1) {
			return emperor;
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
