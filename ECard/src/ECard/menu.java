package ECard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;

public class menu extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPanel;
	private JPanel panelMenu;
	private JPanel panelIntro;
	private JPanel panelReglas;
	
	private JLabel lbWelcome;
	
	private String nombre;

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

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPanel = new JLayeredPane();
		layeredPanel.setBackground(new Color(255, 228, 181));
		layeredPanel.setForeground(Color.WHITE);
		layeredPanel.setBounds(0, 0, 652, 593);
		contentPane.add(layeredPanel);
		layeredPanel.setLayout(null);
		
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
		
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(238, 232, 170));
		panelMenu.setBounds(0, 0, 652, 593);
		layeredPanel.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("E-CARD");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_2_1.setBackground(new Color(255, 140, 0));
		lblNewLabel_2_1.setBounds(181, 27, 267, 52);
		panelMenu.add(lblNewLabel_2_1);
		
		JButton btUno = new JButton("Un jugador");
		btUno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btUno.setBounds(220, 177, 200, 40);
		panelMenu.add(btUno);
		
		JButton btDos = new JButton("Multijugador");
		btDos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btDos.setBounds(220, 250, 200, 40);
		panelMenu.add(btDos);
		
		JButton btReglas = new JButton("Reglas");
		btReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelReglas);
			}
		});
		btReglas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btReglas.setBounds(220, 322, 200, 40);
		panelMenu.add(btReglas);
		
		JButton btHistorial = new JButton("Historial");
		btHistorial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btHistorial.setBounds(220, 392, 200, 40);
		panelMenu.add(btHistorial);
		
		JButton btSalir = new JButton("Salir");
		btSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btSalir.setBounds(491, 554, 151, 28);
		panelMenu.add(btSalir);
		
		lbWelcome = new JLabel("Bienvenido " + nombre);
		lbWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbWelcome.setBounds(220, 110, 196, 28);
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
		
		switchPanels(panelIntro);
	}
}
