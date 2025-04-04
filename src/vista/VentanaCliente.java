package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCliente extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnComprar;
	private JButton btnVerPeliculas;
	private JButton btnPeliculasCompradas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaCliente dialog = new VentanaCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaCliente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
	    btnComprar = new JButton("Comprar pelicula");
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnComprar.setBounds(36, 27, 164, 63);
		contentPanel.add(btnComprar);
		btnComprar.addActionListener(this);
		
	    btnVerPeliculas = new JButton("Ver peliculas");
		btnVerPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVerPeliculas.setBounds(222, 27, 164, 63);
		contentPanel.add(btnVerPeliculas);
		btnVerPeliculas.addActionListener(this);
		
	    btnPeliculasCompradas = new JButton("Ver peliculas compradas");
		btnPeliculasCompradas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPeliculasCompradas.setBounds(115, 100, 200, 86);
		contentPanel.add(btnPeliculasCompradas);
		btnPeliculasCompradas.addActionListener(this);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnComprar)) {
			comprarPelicula();
		} else if (e.getSource().equals(btnVerPeliculas)){
			verPeliculas();
		}else if (e.getSource().equals(btnPeliculasCompradas)){
			peliculasCompradas();
		}
		
	}

	private void peliculasCompradas() {
		// TODO Auto-generated method stub
		
	}

	private void verPeliculas() {
		VentanaPeliculas ven = new VentanaPeliculas();
		ven.setVisible(true);
		
	}

	private void comprarPelicula() {
		// TODO Auto-generated method stub
		
	}

}