package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Principal;
import modelo.Trabajador;
import modelo.Tipo;
import modelo.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JTextField;

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
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaAdmin() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(83, 61, 83, 22);
			contentPanel.add(lblNewLabel);
		}

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(83, 93, 73, 22);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Sueldo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(83, 155, 63, 22);
		contentPanel.add(lblNewLabel_2);

		textID = new JTextField();
		textID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textID.setBounds(176, 65, 120, 19);
		contentPanel.add(textID);
		textID.setColumns(10);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre.setBounds(176, 97, 120, 19);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);

		textSueldo = new JTextField();
		textSueldo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textSueldo.setBounds(176, 157, 120, 19);
		contentPanel.add(textSueldo);
		textSueldo.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Contraseña");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(73, 125, 83, 20);
		contentPanel.add(lblNewLabel_3);

		textContraseña = new JTextField();
		textContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textContraseña.setBounds(176, 126, 120, 19);
		contentPanel.add(textContraseña);
		textContraseña.setColumns(10);
		
		btnAlta = new JButton("Alta");
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAlta.setBounds(316, 64, 95, 22);
		btnAlta.addActionListener(this);
		contentPanel.add(btnAlta);
		
	    btnBaja = new JButton("Baja");
		btnBaja.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBaja.setBounds(316, 108, 95, 22);
		btnBaja.addActionListener(this);
		contentPanel.add(btnBaja);
		
	    btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModificar.setBounds(316, 154, 95, 24);
		btnModificar.addActionListener(this);
		contentPanel.add(btnModificar);

	}
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource().equals(btnAlta)) {
			alta();
		} else if (evento.getSource().equals(btnBaja)){
			baja();
		}else if (evento.getSource().equals(btnModificar)){
			modificar();
		}
	}

	private void modificar() {
		Trabajador trab = new Trabajador();
		trab.setIdentificacion(textID.getText());
		trab.setNombre(textNombre.getText());
		trab.setContrasenia(textContraseña.getText());
		trab.setSueldo(Float.parseFloat(textSueldo.getText()));
		Principal.modificarTrabajador(trab);
		dispose();
		
	}

	private void baja() {
		Trabajador trab = new Trabajador();
		trab.setIdentificacion(textID.getText());
		Principal.bajaPropietario(trab);
		dispose();
		
	}

	private void alta() {
		Trabajador trab = new Trabajador();
		trab.setIdentificacion(textID.getText());
		trab.setNombre(textNombre.getText());
		trab.setContrasenia(textContraseña.getText());
		 trab.setSueldo(Float.parseFloat(textSueldo.getText()));
		 trab.setTipo(Tipo.valueOf("TRABAJADOR"));
		Principal.altaTrabajador(trab);
		dispose();		

		
	}
}