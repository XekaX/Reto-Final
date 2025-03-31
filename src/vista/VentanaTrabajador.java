package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Principal;
import modelo.Pelicula;
import modelo.Trabajador;
import modelo.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaTrabajador extends JDialog implements ActionListener{

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
	 * @param usuario 
	 */
	public VentanaTrabajador(Usuario user) {
		this.usuario = user;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(129, 54, 16, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblNewLabel);

		textID = new JTextField();
		textID.setBounds(155, 56, 96, 19);
		contentPanel.add(textID);
		textID.setColumns(10);

		textNombre = new JTextField();
		textNombre.setBounds(155, 85, 96, 19);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(95, 83, 70, 12);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(112, 115, 45, 13);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Duracion");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(95, 144, 70, 12);
		contentPanel.add(lblNewLabel_3);

		textPrecio = new JTextField();
		textPrecio.setBounds(155, 114, 96, 19);
		contentPanel.add(textPrecio);
		textPrecio.setColumns(10);

		textDuracion = new JTextField();
		textDuracion.setBounds(155, 143, 96, 19);
		contentPanel.add(textDuracion);
		textDuracion.setColumns(10);

	    btnAñadir = new JButton("Añadir");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAñadir.setBounds(271, 54, 103, 34);
		btnAñadir.addActionListener(this);
		contentPanel.add(btnAñadir);

	    btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEliminar.setBounds(271, 104, 103, 34);
		btnEliminar.addActionListener(this);
		contentPanel.add(btnEliminar);

	    btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModificar.setBounds(271, 157, 103, 34);
		btnModificar.addActionListener(this);
		contentPanel.add(btnModificar);

		JLabel lblNewLabel_4 = new JLabel("Calificacion");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(79, 172, 95, 12);
		contentPanel.add(lblNewLabel_4);

		textCalificacion = new JTextField();
		textCalificacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCalificacion.setBounds(155, 171, 96, 19);
		contentPanel.add(textCalificacion);
		textCalificacion.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Genero");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(89, 203, 56, 19);
		contentPanel.add(lblNewLabel_5);
		
	    cmbGenero = new JComboBox();
		cmbGenero.setModel(new DefaultComboBoxModel(new String[] {"Accion", "Comedia", "Drama ", "Terror"}));
		cmbGenero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbGenero.setBounds(154, 200, 96, 21);
		contentPanel.add(cmbGenero);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

	}
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource().equals(btnAñadir)) {
			alta();
		} else if (evento.getSource().equals(btnEliminar)){
			baja();
		}else if (evento.getSource().equals(btnModificar)){
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
		System.out.println("El getItemCount es: " + cmbGenero.getItemCount());
		String seleccionado = cmbGenero.getSelectedItem().toString();
		String IdG = seleccionado.split(",")[0].trim(); 
		Principal.altaPelicula(peli);
		dispose();	
		
	}
}