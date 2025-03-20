package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Principal;
import modelo.Cliente;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VentanaRegistro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textDni;
	private JTextField textNombre;
	private JPasswordField textContraseña;
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaRegistro dialog = new VentanaRegistro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaRegistro() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblNewLabel = new JLabel("DNI");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(90, 51, 42, 21);
			contentPanel.add(lblNewLabel);
		
		
			JLabel lblNewLabel_1 = new JLabel("Nombre");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(75, 79, 66, 27);
			contentPanel.add(lblNewLabel_1);
		
		
			JLabel lblNewLabel_2 = new JLabel("Contraseña");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(66, 116, 75, 13);
			contentPanel.add(lblNewLabel_2);
		
		
			textDni = new JTextField();
			textDni.setBounds(152, 53, 114, 19);
			contentPanel.add(textDni);
			textDni.setColumns(10);
		
	
			textNombre = new JTextField();
			textNombre.setBounds(152, 82, 114, 19);
			contentPanel.add(textNombre);
			textNombre.setColumns(10);
		
		
			textContraseña = new JPasswordField();
			textContraseña.setBounds(151, 115, 115, 19);
			contentPanel.add(textContraseña);
			
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnRegistrar.setBounds(152, 154, 114, 27);
			contentPanel.add(btnRegistrar);	
	}
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource().equals(btnRegistrar)) {
			registrar();
			
	}
  }

	private void registrar() {
		Cliente clien = new Cliente();
		clien.setDni(textDni.getText());
		clien.setNombre(textNombre.getText());
		clien.setContrasenia(new String (textContraseña.getPassword()));
		Principal.altaCliente(clien);
		dispose();		
	}
}
