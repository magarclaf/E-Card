package ECard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPanel;
	private JPanel panelMenu;
	private JPanel panelIntro;
	private JPanel panelReglas;
	private JPanel hostcliente;
	private JPanel panelEspera;
	private JPanel panelConexion;
	
	private JLabel lbWelcome;
	
	private String nombre;
	private JTextField textIP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void switchPanels(JPanel jp) {
		layeredPanel.removeAll();
		layeredPanel.add(jp);
		layeredPanel.repaint();
		layeredPanel.revalidate();
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		nombre = "Jugador";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPanel = new JLayeredPane();
		layeredPanel.setBackground(new Color(255, 228, 181));
		layeredPanel.setForeground(Color.WHITE);
		layeredPanel.setBounds(0, 0, 652, 593);
		contentPane.add(layeredPanel);
		layeredPanel.setLayout(null);
		
		hostcliente = new JPanel();
		hostcliente.setBackground(new Color(255, 228, 181));
		hostcliente.setBounds(0, 0, 652, 593);
		layeredPanel.add(hostcliente);
		hostcliente.setLayout(null);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelEspera);
				try(ServerSocket server = new ServerSocket(7777)){
//					Boolean c = false;
//					while(!c) {
//						try{
								Socket s = server.accept();
								//c=true;
								PartidaMultijugador pmj = new PartidaMultijugador(s,nombre,true);
								pmj.setVisible(true);
								pmj.toFront();
								dispose();
//						}catch (IOException e1) {
//							e1.printStackTrace();
//						}
//					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnCrear.setBounds(200, 222, 214, 71);
		hostcliente.add(btnCrear);
		
		JButton btnUnirse = new JButton("Unirse");
		btnUnirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelConexion);
			}
		});
		btnUnirse.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnUnirse.setBounds(200, 337, 214, 71);
		hostcliente.add(btnUnirse);
		
		JLabel lblCrearOUnirse = new JLabel("Crear partida o unirse");
		lblCrearOUnirse.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblCrearOUnirse.setBounds(101, 67, 442, 84);
		hostcliente.add(lblCrearOUnirse);
		
		panelConexion = new JPanel();
		panelConexion.setBackground(new Color(238, 232, 170));
		panelConexion.setBounds(0, 0, 652, 593);
		layeredPanel.add(panelConexion);
		panelConexion.setLayout(null);
		
		JLabel lblIntroduceIP = new JLabel("Introduce la ip a la que quieres conectarte:");
		lblIntroduceIP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIntroduceIP.setBounds(150, 217, 373, 33);
		panelConexion.add(lblIntroduceIP);
		
		textIP = new JTextField();
		textIP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textIP.setBounds(183, 261, 289, 34);
		panelConexion.add(textIP);
		textIP.setColumns(10);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Socket s = new Socket(textIP.getText(),7777);
					PartidaMultijugador pmj = new PartidaMultijugador(s,nombre,false);
					pmj.setVisible(true);
					pmj.toFront();
					dispose();
					
				} catch (UnknownHostException e1) {
					JOptionPane.showMessageDialog(null,"Conexión no válida");
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnConectar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConectar.setBounds(269, 306, 108, 42);
		panelConexion.add(btnConectar);
		
		JButton btnVolver1 = new JButton("Volver");
		btnVolver1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelMenu);
			}
		});
		btnVolver1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver1.setBounds(511, 540, 119, 42);
		panelConexion.add(btnVolver1);
		
		panelEspera = new JPanel();
		panelEspera.setBackground(new Color(238, 232, 170));
		panelEspera.setForeground(new Color(0, 0, 0));
		panelEspera.setBounds(0, 0, 652, 593);
		layeredPanel.add(panelEspera);
		panelEspera.setLayout(null);
		
		JLabel lblEsperando = new JLabel("Esperando a otro jugador...");
		lblEsperando.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEsperando.setBounds(155, 261, 361, 38);
		panelEspera.add(lblEsperando);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelMenu);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(437, 522, 151, 31);
		panelEspera.add(btnVolver);
		
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(238, 232, 170));
		panelMenu.setBounds(0, 0, 652, 593);
		layeredPanel.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblECard = new JLabel("E-CARD");
		lblECard.setBounds(181, 27, 267, 52);
		lblECard.setHorizontalAlignment(SwingConstants.CENTER);
		lblECard.setForeground(Color.BLACK);
		lblECard.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblECard.setBackground(new Color(255, 140, 0));
		panelMenu.add(lblECard);
		
		JButton btUnJugador = new JButton("Un jugador");
		btUnJugador.setBounds(220, 177, 200, 40);
		btUnJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PartidaUnJugador puj = new PartidaUnJugador();
				puj.setVisible(true);
				puj.toFront();
				dispose();
			}
		});
		btUnJugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelMenu.add(btUnJugador);
		
		JButton btMultijugador = new JButton("Multijugador");
		btMultijugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(hostcliente);
			}
		});
		btMultijugador.setBounds(220, 250, 200, 40);
		btMultijugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelMenu.add(btMultijugador);
		
		JButton btReglas = new JButton("Reglas");
		btReglas.setBounds(220, 322, 200, 40);
		btReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelReglas);
			}
		});
		btReglas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelMenu.add(btReglas);
		
		JButton btHistorial = new JButton("Historial");
		btHistorial.setBounds(220, 392, 200, 40);
		btHistorial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelMenu.add(btHistorial);
		
		JButton btSalir = new JButton("Salir");
		btSalir.setBounds(491, 554, 151, 28);
		btSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelMenu.add(btSalir);
		
		lbWelcome = new JLabel("Bienvenido " + nombre);
		lbWelcome.setBounds(220, 110, 196, 28);
		lbWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelMenu.add(lbWelcome);
		
		panelIntro = new JPanel();
		panelIntro.setBackground(new Color(245, 222, 179));
		panelIntro.setBounds(0, 0, 652, 593);
		layeredPanel.add(panelIntro);
		panelIntro.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(279, 514, 89, 23);
		panelIntro.add(btnAceptar);
		btnAceptar.setForeground(new Color(0, 0, 0));
		btnAceptar.setBackground(new Color(255, 165, 0));
		
		JLabel lblIntroduceNombre = new JLabel("Introduce tu nombre");
		lblIntroduceNombre.setBounds(243, 449, 164, 23);
		panelIntro.add(lblIntroduceNombre);
		lblIntroduceNombre.setBackground(new Color(255, 255, 255));
		lblIntroduceNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTitulo = new JLabel("E-CARD");
		lblTitulo.setBounds(191, 372, 267, 52);
		panelIntro.add(lblTitulo);
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 38));
		
		JLabel lblEmperadorInicio = new JLabel("");
		lblEmperadorInicio.setBounds(123, 25, 400, 336);
		panelIntro.add(lblEmperadorInicio);
		lblEmperadorInicio.setVerticalAlignment(SwingConstants.TOP);
		lblEmperadorInicio.setIcon(new ImageIcon(Menu.class.getResource("/res/emperor.jpg")));
		
		JTextPane textNombre = new JTextPane();
		textNombre.setBounds(243, 480, 164, 23);
		panelIntro.add(textNombre);
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNombre.setBackground(new Color(230, 230, 250));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNombre.getText()!=null) {
					nombre = textNombre.getText()+"\r\n";
				}
				lbWelcome.setText("Bienvenido " + nombre);
				switchPanels(panelMenu);
			}
		});
		
		panelReglas = new JPanel();
		panelReglas.setBackground(new Color(255, 250, 205));
		panelReglas.setBounds(0, 0, 652, 593);
		layeredPanel.add(panelReglas);
		panelReglas.setLayout(null);
		
		JLabel lblPantallaReglas = new JLabel("REGLAS E-CARD");
		lblPantallaReglas.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblPantallaReglas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPantallaReglas.setBounds(162, 22, 335, 57);
		panelReglas.add(lblPantallaReglas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 632, 458);
		panelReglas.add(scrollPane);
		
		JTextPane txtReglas = new JTextPane();
		scrollPane.setViewportView(txtReglas);
		txtReglas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//txtpnAquIrnLas.setText("\tAquí irán las reglas del juego\r\n\tbla bla bla bla bla\r\n\t\r\nAPARTADO 1:\r\n\tReglas iniciales\r\n\tMás reglas\r\n\t\r\nAPARTADO 2:\r\n\tXDXDXDXDXDXDXDDDDDDDDDDDDDDDDDDDDDDDDD\r\n\t\r\nAPARTADO 3:\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN");
		txtReglas.setText("Juego de cartas para dos jugadores.\r\n\t\r\n\nTIPOS DE CARTAS:\r\n\n3 tipos de cartas: Emperador, Ciudadano y Esclavo.\r\n\t\n"
				+ "El Emperador esta en lo mas alto de la sociedad por lo que derrotará a los Ciudadanos, pero perderá contra el Esclavo.\r\n\t\n"
				+ "Los Ciudadanos necesitan el dinero del Emperador por lo que perderán contra él, pero derrotarán al Esclavo, el cual se sitúa en lo más bajo de la sociedad.\r\n\t\n"
				+ "El Esclavo perderá contra los Ciudadanos, pero ganará al Emperador puesto que el Esclavo no tiene acceso a dinero y no tiene nada que perder.\r\n\n\nMAZOS Y RONDAS:\r\n\t\n"
				+ "Dos mazos: Lado Emperador (1 Emperador + 4 Ciudadanos) y Lado Esclavo (1 Esclavo + 4 Ciudadanos).\r\n\t\n"
				+ "Como es mucho más dificil ganar en el Lado Esclavo, la victoria valdrá 5 veces más.\r\n\t\n"
				+ "Los lados no son fijos, se irán rotando a lo largo de la partida.\r\n\t\n"
				+ "En la partida, cada jugador jugara 2 veces en el Lado Emperador y otras 2 en el Lado Esclavo (4 turnos).\r\n\t\n"
				+ "Se hacen 3 rondas en cada lado y se cambia al otro así hasta terminar (12 rondas en total).\r\n\t\r\n\t\r\n"
				+ "\nPOSIBLES JUGADAS:\r\n\nEn cada jugada, se pondra un carta de tu mazo mientras tu rival pondra otra del suyo, una carta determinada se puede usar una única vez por ronda.\r\n\t\n"
				+ "Se realizaran los enfretamientos de las cartas puestas y se distribuiran los puntos de la siguiente manera:\r\n\t\n"
				+ "Emperador vs Ciudadano: +1 para el jugador en el Lado Emperador.\r\n\t\n"
				+ "Emperador vs Esclavo: +5 para el jugador en el Lado Esclavo.\r\n\t\n"
				+ "Esclavo vs Ciudadano: +1 para el jugador en el Lado Emperador.\r\n\t\n"
				+ "Ciudadano vs Ciudadano: Continua la partida hasta que se de una de las tres jugadas de arriba y se eliminan los ciudadanos usados de ambos mazos (+0).\r\n\t");

		JButton btnMenuPrincipal = new JButton("Menú principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelMenu);
			}
		});
		btnMenuPrincipal.setBounds(487, 559, 134, 23);
		panelReglas.add(btnMenuPrincipal);
		
		switchPanels(panelIntro);
	}
}
