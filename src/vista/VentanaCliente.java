package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Usuario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCliente extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVerPeliculas;
	private JButton btnPeliculasCompradas;
	private Usuario clien;


	public VentanaCliente(Usuario clien) {
		this.clien = clien;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
	    btnVerPeliculas = new JButton("Comprar/ver peliculas");
		btnVerPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVerPeliculas.setBounds(115, 28, 200, 62);
		contentPanel.add(btnVerPeliculas);
		btnVerPeliculas.addActionListener(this);
		
	    btnPeliculasCompradas = new JButton("Ver peliculas compradas");
		btnPeliculasCompradas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPeliculasCompradas.setBounds(115, 122, 200, 67);
		contentPanel.add(btnPeliculasCompradas);
		btnPeliculasCompradas.addActionListener(this);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
         if (e.getSource().equals(btnVerPeliculas)){
			verPeliculas();
		}else if (e.getSource().equals(btnPeliculasCompradas)){
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