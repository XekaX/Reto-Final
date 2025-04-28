package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Principal;
import excepciones.DniException;
import modelo.Cliente;
import vista.VentanaLog.BackgroundPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class VentanaRegistro extends JDialog implements ActionListener {

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
		
		setTitle("Tartanga Prime Video - Registro");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 450);

		// Fondo con un JPanel personalizado
		BackgroundPanel backgroundPanel = new BackgroundPanel("/imagenes/fondo_tartanga.png");

		setBounds(100, 100, 800, 450);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		backgroundPanel.setLayout(null);
		setContentPane(backgroundPanel);

		setBounds(100, 100, 800, 450);
		backgroundPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		backgroundPanel.setLayout(null);
		backgroundPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(233, 110, 75, 21);
		backgroundPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(233, 141, 75, 27);
		backgroundPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(233, 178, 75, 13);
		backgroundPanel.add(lblNewLabel_2);

		textDni = new JTextField();
		textDni.setBounds(319, 115, 114, 19);
		backgroundPanel.add(textDni);
		textDni.setColumns(10);

		textNombre = new JTextField();
		textNombre.setBounds(319, 143, 114, 19);
		backgroundPanel.add(textNombre);
		textNombre.setColumns(10);

		textContraseña = new JPasswordField();
		textContraseña.setBounds(318, 177, 115, 19);
		backgroundPanel.add(textContraseña);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistrar.setBounds(318, 227, 114, 27);
		btnRegistrar.addActionListener(this);
		backgroundPanel.add(btnRegistrar);
	}

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource().equals(btnRegistrar)) {
			try {
				registrar();
			} catch (DniException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void registrar() throws DniException {
		Cliente clien = new Cliente();
		clien.setIdentificacion(textDni.getText());
		clien.setNombre(textNombre.getText());
		clien.setContrasenia(new String(textContraseña.getPassword()));
		Principal.altaCliente(clien);
		dispose();
	}

	public static boolean validarDni(String dni) {
		String dniRegex = "\\d[8][A-H]-NP-TV-Z]";
		if (!dni.matches(dniRegex)) {
			return false;

		}
		String numeroDni = dni.substring(0, 8);
		char letraDni = dni.charAt(8);
		String letras = "TRWAGMYFPDXBNIZSQVHLCKE";
		int numero = Integer.parseInt(numeroDni);
		char letraCalculada = letras.charAt(numero % 23);

		return letraDni == letraCalculada;
	}
}
