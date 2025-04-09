package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Principal;
import excepciones.LoginException;
import modelo.Trabajador;
import modelo.Cliente;
import modelo.Tipo;
import modelo.Usuario;

public class VentanaLog extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JButton btnRegistrar;
	private JButton btnComprobar;
	private JButton btnCancelar;
	private JPasswordField textContraseña;
	

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLog frame = new VentanaLog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLog() {
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(96, 36, 76, 23);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(83, 69, 76, 23);
		contentPanel.add(lblNewLabel_1);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(164, 40, 115, 23);
		contentPanel.add(textUsuario);
		textUsuario.setColumns(10);
		
	    btnComprobar = new JButton("Comprobar");
		btnComprobar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnComprobar.setBounds(83, 125, 115, 29);
		btnComprobar.addActionListener(this);
		contentPanel.add(btnComprobar);
		
		btnRegistrar = new JButton("Registrarse");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistrar.setBounds(219, 125, 115, 29);
		btnRegistrar.addActionListener(this);
		contentPanel.add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.setBounds(153, 164, 115, 29);
		contentPanel.add(btnCancelar);
		
		textContraseña = new JPasswordField();
		textContraseña.setBounds(164, 73, 115, 19);
		contentPanel.add(textContraseña);
		btnCancelar.addActionListener(this);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

	}
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource().equals(btnCancelar)) {
			cancelar();
		}else if (evento.getSource().equals(btnComprobar)){
			comprobar();
		}else if (evento.getSource().equals(btnRegistrar)) {
			registrarse();
		}
		
	}
	private void registrarse() {
		VentanaRegistro dialog = new VentanaRegistro();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);	
		
	}
	
	private void comprobar() {
		Usuario usuario = new Usuario();
		usuario.setIdentificacion(textUsuario.getText());	
		usuario.setContrasenia(new String (textContraseña.getPassword()));
		
		try {
			Usuario usu = Principal.login(usuario);	
			if (usu instanceof Trabajador) {
				if (((Trabajador) usu).getTipo().equals(Tipo.ADMIN)) {
					
					VentanaAdmin ven = new VentanaAdmin();
					ven.setVisible(true);
				}else {
					VentanaTrabajador ven = new VentanaTrabajador(usuario);
					ven.setVisible(true);
				}
			} else if (usu instanceof Cliente)  {
				 VentanaCliente ven = new VentanaCliente(usu);
				 ven.setVisible(true);
			}
			
		} catch (LoginException e) {
			e.visualizarMensaje();
		}	
	}
	private void cancelar() {
		dispose();
		
	}

}
