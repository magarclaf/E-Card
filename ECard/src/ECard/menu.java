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

public class menu extends JFrame {

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
					menu frame = new menu();
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
	public menu() {
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
		
		JButton btnNewButton_2 = new JButton("Crear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelEspera);
				try(ServerSocket server = new ServerSocket(7777)){
					Boolean c = false;
					while(!c) {
						try(Socket s = server.accept(); DataInputStream dis = new DataInputStream(s.getInputStream());
								DataOutputStream dos = new DataOutputStream(s.getOutputStream())){
								c=true;
								PartidaMultijugador pmj = new PartidaMultijugador(s,nombre,true);
								pmj.setVisible(true);
								pmj.toFront();
								dispose();
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_2.setBounds(200, 222, 214, 71);
		hostcliente.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Unirse");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelConexion);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_3.setBounds(200, 337, 214, 71);
		hostcliente.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Crear partida o unirse");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_4.setBounds(101, 67, 442, 84);
		hostcliente.add(lblNewLabel_4);
		
		panelConexion = new JPanel();
		panelConexion.setBackground(new Color(238, 232, 170));
		panelConexion.setBounds(0, 0, 652, 593);
		layeredPanel.add(panelConexion);
		panelConexion.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Introduce la ip a la que quieres conectarte:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(150, 217, 373, 33);
		panelConexion.add(lblNewLabel_6);
		
		textIP = new JTextField();
		textIP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textIP.setBounds(183, 261, 289, 34);
		panelConexion.add(textIP);
		textIP.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Conectar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try(Scanner sc = new Scanner(System.in);
						Socket s = new Socket(textIP.getText(),7777); 
						DataInputStream dis = new DataInputStream(s.getInputStream());
						DataOutputStream dos = new DataOutputStream(s.getOutputStream())){
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
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_5.setBounds(269, 306, 108, 42);
		panelConexion.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Volver");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelMenu);
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_6.setBounds(511, 540, 119, 42);
		panelConexion.add(btnNewButton_6);
		
		panelEspera = new JPanel();
		panelEspera.setBackground(new Color(238, 232, 170));
		panelEspera.setForeground(new Color(0, 0, 0));
		panelEspera.setBounds(0, 0, 652, 593);
		layeredPanel.add(panelEspera);
		panelEspera.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Esperando a otro jugador...");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_5.setBounds(155, 261, 361, 38);
		panelEspera.add(lblNewLabel_5);
		
		JButton btnNewButton_4 = new JButton("Volver");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelMenu);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_4.setBounds(437, 522, 151, 31);
		panelEspera.add(btnNewButton_4);
		
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(238, 232, 170));
		panelMenu.setBounds(0, 0, 652, 593);
		layeredPanel.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("E-CARD");
		lblNewLabel_2_1.setBounds(181, 27, 267, 52);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_2_1.setBackground(new Color(255, 140, 0));
		panelMenu.add(lblNewLabel_2_1);
		
		JButton btUno = new JButton("Un jugador");
		btUno.setBounds(220, 177, 200, 40);
		btUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PartidaUnJugador puj = new PartidaUnJugador();
				puj.setVisible(true);
				puj.toFront();
				dispose();
			}
		});
		btUno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelMenu.add(btUno);
		
		JButton btDos = new JButton("Multijugador");
		btDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(hostcliente);
			}
		});
		btDos.setBounds(220, 250, 200, 40);
		btDos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelMenu.add(btDos);
		
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
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(279, 514, 89, 23);
		panelIntro.add(btnNewButton);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 165, 0));
		
		JLabel lblNewLabel = new JLabel("Introduce tu nombre");
		lblNewLabel.setBounds(243, 449, 164, 23);
		panelIntro.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("E-CARD");
		lblNewLabel_2.setBounds(191, 372, 267, 52);
		panelIntro.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 38));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(123, 25, 400, 336);
		panelIntro.add(lblNewLabel_1);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setIcon(new ImageIcon(menu.class.getResource("/res/emperor.jpg")));
		
		JTextPane textNombre = new JTextPane();
		textNombre.setBounds(243, 480, 164, 23);
		panelIntro.add(textNombre);
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNombre.setBackground(new Color(230, 230, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNombre.getText()!=null) {
					nombre = textNombre.getText();
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
		
		JLabel lblNewLabel_3 = new JLabel("REGLAS E-CARD");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(162, 22, 335, 57);
		panelReglas.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 632, 458);
		panelReglas.add(scrollPane);
		
		JTextPane txtpnAquIrnLas = new JTextPane();
		scrollPane.setViewportView(txtpnAquIrnLas);
		txtpnAquIrnLas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAquIrnLas.setText("\tAquí irán las reglas del juego\r\n\tbla bla bla bla bla\r\n\t\r\nAPARTADO 1:\r\n\tReglas iniciales\r\n\tMás reglas\r\n\t\r\nAPARTADO 2:\r\n\tXDXDXDXDXDXDXDDDDDDDDDDDDDDDDDDDDDDDDD\r\n\t\r\nAPARTADO 3:\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN\r\n\tNEVER GONNA GIVE YOU UP\r\n\tNEVER GONNA LET YOU DOWN");
		
		JButton btnNewButton_1 = new JButton("Menú principal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelMenu);
			}
		});
		btnNewButton_1.setBounds(487, 559, 134, 23);
		panelReglas.add(btnNewButton_1);
		
		switchPanels(panelIntro);
	}
}
