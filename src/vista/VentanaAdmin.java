package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Principal;
import modelo.Trabajador;
import modelo.Tipo;
import modelo.Usuario;
import vista.VentanaLog.BackgroundPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.time.LocalDate;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaAdmin extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textID;
	private JTextField textNombre;
	private JTextField textSueldo;
	private JTextField textContraseña;
	private JButton btnAlta;
	private JButton btnBaja;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaAdmin dialog = new VentanaAdmin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaAdmin() {
		
		setTitle("Tartanga Prime Video - Admin");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 450);


		// Fondo con un JPanel personalizado
		BackgroundPanel backgroundPanel = new BackgroundPanel("/imagenes/fondo_tartanga.png");

		setBounds(100, 100, 800, 450);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		backgroundPanel.setLayout(null);
		setContentPane(backgroundPanel);

		JLabel lblNewLabel = new JLabel(" ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(256, 144, 63, 22);
		backgroundPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(246, 173, 73, 22);
		backgroundPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Sueldo");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(256, 231, 63, 22);
		backgroundPanel.add(lblNewLabel_2);

		textID = new JTextField();
		textID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textID.setBounds(329, 146, 120, 19);
		backgroundPanel.add(textID);
		textID.setColumns(10);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre.setBounds(329, 175, 120, 19);
		backgroundPanel.add(textNombre);
		textNombre.setColumns(10);

		textSueldo = new JTextField();
		textSueldo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textSueldo.setBounds(329, 233, 120, 19);
		backgroundPanel.add(textSueldo);
		textSueldo.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Contraseña");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(236, 205, 83, 20);
		backgroundPanel.add(lblNewLabel_3);

		textContraseña = new JTextField();
		textContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textContraseña.setBounds(329, 204, 120, 19);
		backgroundPanel.add(textContraseña);
		textContraseña.setColumns(10);

		btnAlta = new JButton("Alta");
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAlta.setBounds(489, 231, 95, 22);
		btnAlta.addActionListener(this);
		backgroundPanel.add(btnAlta);

		btnBaja = new JButton("Baja");
		btnBaja.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBaja.setBounds(489, 144, 95, 22);
		btnBaja.addActionListener(this);
		backgroundPanel.add(btnBaja);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModificar.setBounds(489, 185, 95, 24);
		btnModificar.addActionListener(this);
		backgroundPanel.add(btnModificar);

	}

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource().equals(btnAlta)) {
			alta();
		} else if (evento.getSource().equals(btnBaja)) {
			baja();
		} else if (evento.getSource().equals(btnModificar)) {
			modificar();
		}
	}

	private void modificar() {
	    String id = textID.getText();
	    if (!Principal.existeTrabajador(id)) {
	        javax.swing.JOptionPane.showMessageDialog(this, "Error: No existe un trabajador con ese ID para modificar.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
	        return;  // Salimos directamente
	    }

	    // Si existe, entonces sí pedimos el resto de datos y modificamos
	    Trabajador trab = new Trabajador();
	    trab.setIdentificacion(id);
	    trab.setNombre(textNombre.getText());
	    trab.setContrasenia(textContraseña.getText());
	    trab.setSueldo(Float.parseFloat(textSueldo.getText()));

	    boolean exito = Principal.modificarTrabajador(trab);
	    if (exito) {
	        dispose();
	    } else {
	        javax.swing.JOptionPane.showMessageDialog(this, "Error inesperado al modificar el trabajador.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
	    }
	}



	private void baja() {
	    Trabajador trab = new Trabajador();
	    trab.setIdentificacion(textID.getText());
	    
	    boolean exito = Principal.bajaPropietario(trab);
	    if (exito) {
	        dispose();
	    } else {
	        javax.swing.JOptionPane.showMessageDialog(this, "Error: No existe un trabajador con ese ID.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
	    }
	}


	private void alta() {
	    Trabajador trab = new Trabajador();
	    trab.setIdentificacion(textID.getText());
	    trab.setNombre(textNombre.getText());
	    trab.setContrasenia(textContraseña.getText());
	    trab.setSueldo(Float.parseFloat(textSueldo.getText()));
	    trab.setTipo(Tipo.valueOf("TRABAJADOR"));
	    
	    boolean exito = Principal.altaTrabajador(trab);
	    
	    if (exito) {
	        javax.swing.JOptionPane.showMessageDialog(this, "Trabajador " + trab.getNombre() + " añadido correctamente.");
	        dispose();  // Cerrar ventana solo si ha ido bien
	    } else {
	        javax.swing.JOptionPane.showMessageDialog(this, "Error al añadir el trabajador.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
	    }
	}


}