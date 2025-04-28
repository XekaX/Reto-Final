package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Principal;
import modelo.Genero;
import modelo.Pelicula;
import modelo.Trabajador;
import modelo.Usuario;
import vista.VentanaLog.BackgroundPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class VentanaTrabajador extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textID;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextField textDuracion;
	private JTextField textCalificacion;
	private JButton btnAñadir;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JComboBox cmbGenero;
	private Usuario usuario;
	private Map<String, Genero> map;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			VentanaTrabajador dialog = new VentanaTrabajador();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * 
	 * @param usuario
	 */
	public VentanaTrabajador(Usuario user) {
		
		setTitle("Tartanga Prime Video - Trabajador");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 450);

		// Fondo con un JPanel personalizado
		BackgroundPanel backgroundPanel = new BackgroundPanel("/imagenes/fondo_tartanga.png");

		setBounds(100, 100, 800, 450);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		backgroundPanel.setLayout(null);
		setContentPane(backgroundPanel);

		this.usuario = user;
		this.map = Principal.recibirMapaGenero();
		setBounds(100, 100, 800, 450);
		getContentPane().setLayout(new BorderLayout());
		backgroundPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		backgroundPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(214, 129, 85, 12);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backgroundPanel.add(lblNewLabel);

		textID = new JTextField();
		textID.setBounds(304, 128, 96, 19);
		backgroundPanel.add(textID);
		textID.setColumns(10);

		textNombre = new JTextField();
		textNombre.setBounds(304, 157, 96, 19);
		backgroundPanel.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(214, 158, 85, 12);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backgroundPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(214, 189, 85, 12);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backgroundPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Duracion");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(214, 218, 85, 12);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backgroundPanel.add(lblNewLabel_3);

		textPrecio = new JTextField();
		textPrecio.setBounds(304, 188, 96, 19);
		backgroundPanel.add(textPrecio);
		textPrecio.setColumns(10);

		textDuracion = new JTextField();
		textDuracion.setBounds(304, 217, 96, 19);
		backgroundPanel.add(textDuracion);
		textDuracion.setColumns(10);

		btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(443, 142, 103, 34);
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAñadir.addActionListener(this);
		backgroundPanel.add(btnAñadir);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(443, 196, 103, 34);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEliminar.addActionListener(this);
		backgroundPanel.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(443, 249, 103, 34);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModificar.addActionListener(this);
		backgroundPanel.add(btnModificar);

		JLabel lblNewLabel_4 = new JLabel("Calificacion");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(214, 249, 85, 12);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backgroundPanel.add(lblNewLabel_4);

		textCalificacion = new JTextField();
		textCalificacion.setBounds(304, 246, 96, 19);
		textCalificacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backgroundPanel.add(textCalificacion);
		textCalificacion.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Genero");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(214, 279, 85, 12);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backgroundPanel.add(lblNewLabel_5);

		cmbGenero = new JComboBox();
		cmbGenero.setBounds(304, 275, 96, 21);
		for (Genero genero : map.values()) {
			cmbGenero.addItem(genero.getCategoria());
		}
		cmbGenero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backgroundPanel.add(cmbGenero);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

	}

	public void llenarElmapa() {

	}

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource().equals(btnAñadir)) {
			alta();
		} else if (evento.getSource().equals(btnEliminar)) {
			baja();
		} else if (evento.getSource().equals(btnModificar)) {
			modificar();
		}
	}

	private void modificar() {
		Pelicula peli = new Pelicula();
		peli.setIdP(textID.getText());
		peli.setNombre(textNombre.getText());
		peli.setPrecio(Float.parseFloat(textPrecio.getText()));
		peli.setDuracion(Integer.parseInt(textDuracion.getText()));
		peli.setCalificacion(Float.parseFloat(textCalificacion.getText()));
		peli.setIdG(cmbGenero.getSelectedItem().toString());
		Principal.modificarPelicula(peli);
		dispose();

	}

	private void baja() {
		Pelicula peli = new Pelicula();
		peli.setIdP(textID.getText());
		Principal.eliminarPelicula(peli);
		dispose();
	}

	private void alta() {
		Pelicula peli = new Pelicula();
		peli.setIdP(textID.getText());
		peli.setNombre(textNombre.getText());
		peli.setPrecio(Float.parseFloat(textPrecio.getText()));
		peli.setDuracion(Integer.parseInt(textDuracion.getText()));
		peli.setCalificacion(Float.parseFloat(textCalificacion.getText()));
		peli.setIdT(usuario.getIdentificacion());
		String seleccionado = cmbGenero.getSelectedItem().toString();
		for (Genero genero : map.values()) {
			if (genero.getCategoria() == seleccionado) {
				peli.setIdG(genero.getIdG());
			}
		}

		Principal.altaPelicula(peli);
		dispose();

	}
}