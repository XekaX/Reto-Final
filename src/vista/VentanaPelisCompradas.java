package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Principal;
import modelo.Pelicula;
import modelo.Usuario;

public class VentanaPelisCompradas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablaPelisCompradas;
	private DefaultTableModel model;
	private JTable tablaPelis;
	private JScrollPane jscroll;
	private Usuario clien;

	/**
	 * Launch the application.
	 *
	 * /** Create the dialog.
	 */
	public VentanaPelisCompradas(Usuario clien) {
		
		setTitle("Tartanga Prime Video - Pelis Compradas");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 450);
        
		this.clien = clien;
		presentarTablaPelis();
		setBounds(100, 100, 599, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	private void presentarTablaPelis() {
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);
		jscroll = new JScrollPane();
		jscroll.setBounds(0, 0, 585, 213);
		tablaPelis = this.cargarTablaPelis(); // Aquí inicializas tablaPelis
		jscroll.setViewportView(tablaPelis);
		contentPanel.add(jscroll);
		tablaPelis.getColumnModel().getColumn(4).setMinWidth(0);
		tablaPelis.getColumnModel().getColumn(4).setMaxWidth(0);
		tablaPelis.getColumnModel().getColumn(4).setWidth(0);
	}
	
	
	private JTable cargarTablaPelis() {
		String[] columnasNombre = { "Titulo", "Duracion", "Calificacion", "Precio","ID"};
		Map<String, Pelicula> pelisCompradasMap = Principal.listarPeliculasCompradas(clien);
		
		DefaultTableModel model = new DefaultTableModel(null, columnasNombre);

		// Llenar el modelo con los datos de las películas
		for (Map.Entry<String, Pelicula> entry : pelisCompradasMap.entrySet()) {
			Pelicula peli = entry.getValue();
			String[] fila = new String[5];
			fila[0] = peli.getNombre(); // Titulo
			fila[1] = String.valueOf(peli.getDuracion()); // Duración
			fila[2] = String.valueOf(peli.getCalificacion()); // Calificación
			fila[3] = String.valueOf(peli.getPrecio()); // Precio
			fila[4] = String.valueOf(peli.getIdP()); //Id de la pelicula
			model.addRow(fila);
		}
		
		
		// Crear la tabla con el modelo
		return new JTable(model);
	}
}
