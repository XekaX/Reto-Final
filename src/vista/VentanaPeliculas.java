package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Principal;
import modelo.Pelicula;
import java.awt.Font;

public class VentanaPeliculas extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablaPelis;
	private JScrollPane jscroll;
	private String pelis;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			VentanaPeliculas dialog = new VentanaPeliculas();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public VentanaPeliculas() {
		presentarTablaPelis();
		setBounds(100, 100, 599, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private void presentarTablaPelis() {
		contentPanel.setLayout(null);
		jscroll = new JScrollPane();
		jscroll.setBounds(39, 77, 412, 90);
		tablaPelis = this.cargarTablaPelis();
		jscroll.setViewportView(tablaPelis);
		contentPanel.add(jscroll);
		
	}

	private JTable cargarTablaPelis() {
		String[] columnasNombre = { "Titulo", "Duracion", "Calificacion", "Precio"};
		Map<String, Pelicula> pelisMap = Principal.listarPeliculas();
		
		 //modelo de la tabla con los datos
	    DefaultTableModel model = new DefaultTableModel(null, columnasNombre);
		
		int i = 0;
	    for (Map.Entry<String, Pelicula> entry : pelisMap.entrySet()) {
	    	 Pelicula peli = entry.getValue();
	        /*Pelicula peli = new Pelicula();
	        pelis[i][0] = peli.getNombre();// Titulo
	        pelis[i][1] = String.valueOf(peli.getDuracion());// Duración
	        pelis[i][2] = String.valueOf(peli.getCalificacion());// Calificación
	        pelis[i][3] = String.valueOf(peli.getPrecio());// Precio
	        i++;*/
	    	 String[] fila = new String[4];
	         fila[0] = peli.getNombre();                       // Titulo
	         fila[1] = String.valueOf(peli.getDuracion());     // Duración
	         fila[2] = String.valueOf(peli.getCalificacion()); // Calificación
	         fila[3] = String.valueOf(peli.getPrecio());       // Precio

	         model.addRow(fila);	    }
	    System.out.println("estas son las pelis desde la ventana peliculas: " + pelis);
	    //creacion de la Jtable con el modelo
	    JTable tablaPelis = new JTable(model);
	
		return tablaPelis;
	}
}
