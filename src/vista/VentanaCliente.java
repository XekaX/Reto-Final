package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Usuario;
import vista.VentanaLog.BackgroundPanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class VentanaCliente extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVerPeliculas;
	private JButton btnPeliculasCompradas;
	private Usuario clien;

	public VentanaCliente(Usuario clien) {
		
		setTitle("Tartanga Prime Video - Cliente");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 450);

		// Fondo con un JPanel personalizado
		BackgroundPanel backgroundPanel = new BackgroundPanel("/imagenes/fondo_tartanga.png");

		setBounds(100, 100, 800, 450);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		backgroundPanel.setLayout(null);
		setContentPane(backgroundPanel);

		this.clien = clien;
		setBounds(100, 100, 450, 300);
		backgroundPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		backgroundPanel.setLayout(null);
		backgroundPanel.setLayout(null);

		btnVerPeliculas = new JButton("Comprar/ver peliculas");
		btnVerPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVerPeliculas.setBounds(115, 50, 200, 62);
		backgroundPanel.add(btnVerPeliculas);
		btnVerPeliculas.addActionListener(this);

		btnPeliculasCompradas = new JButton("Ver peliculas compradas");
		btnPeliculasCompradas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPeliculasCompradas.setBounds(115, 122, 200, 67);
		backgroundPanel.add(btnPeliculasCompradas);
		btnPeliculasCompradas.addActionListener(this);

		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 0, 0, 0);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnVerPeliculas)) {
			verPeliculas();
		} else if (e.getSource().equals(btnPeliculasCompradas)) {
			peliculasCompradas();
		}

	}

	private void peliculasCompradas() {
		VentanaPelisCompradas ven = new VentanaPelisCompradas(clien);
		ven.setVisible(true);

	}

	private void verPeliculas() {
		VentanaPeliculas ven = new VentanaPeliculas(clien);
		ven.setVisible(true);

	}
	


}