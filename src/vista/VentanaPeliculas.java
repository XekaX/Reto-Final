package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
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
import modelo.Cliente;
import modelo.Compra;
import modelo.Pelicula;
import modelo.Usuario;

import java.awt.Font;

public class VentanaPeliculas extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablaPelis; // Usamos tablaPelis en lugar de table
	private JScrollPane jscroll;
	private String pelis;
	private float precio;
	private float calificacion;
	private int duracion;
	private JButton btnComprar;
	private Usuario clien;

	public VentanaPeliculas(Usuario clien) {
		this.clien = clien;
		presentarTablaPelis();
		setBounds(100, 100, 599, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnComprar.setBounds(55, 244, 107, 40);
		contentPanel.add(btnComprar);
		btnComprar.addActionListener(this);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String comando = e.getActionCommand();
//		if ("Comprar".equals(comando)) {
//			int filaSeleccionada = tablaPelis.getSelectedRow();
//			if (filaSeleccionada != -1) {
//				String titulo = tablaPelis.getValueAt(filaSeleccionada, 0).toString();
//				String precio = tablaPelis.getValueAt(filaSeleccionada, 3).toString();
//				JOptionPane.showMessageDialog(this, "Has comprado la película: " + titulo + " por $" + precio);
//
//				// Aquí podés agregar lógica real de compra: guardar compra, actualizar stock,
//				// etc.
//			} else {
//				JOptionPane.showMessageDialog(this, "Selecciona una película antes de comprar.");
//
//			}
//
//		}
//	}

	private void comprar() {
		int filaSeleccionada = tablaPelis.getSelectedRow();
		if (filaSeleccionada != -1) {
			Compra comp = new Compra();
			comp.setDni(clien.getIdentificacion());
			comp.setIdP(tablaPelis.getValueAt(tablaPelis.getSelectedRow(), 4).toString());	
			comp.setFechaCompra(LocalDate.now());
			Principal.comprar(comp);
			String titulo = tablaPelis.getValueAt(filaSeleccionada, 0).toString();
			String precio = tablaPelis.getValueAt(filaSeleccionada, 3).toString();
			JOptionPane.showMessageDialog(this, "Has comprado la película: " + titulo + " por $" + precio);
			presentarTablaPelis();
			// Aquí podés agregar lógica real de compra: guardar compra, actualizar stock,
			// etc.
		} else {
			JOptionPane.showMessageDialog(this, "Selecciona una película antes de comprar.");
		}

	}

	private void presentarTablaPelis() {
		contentPanel.setLayout(null);
		jscroll = new JScrollPane();
		jscroll.setBounds(0, 0, 585, 213);
		tablaPelis = this.cargarTablaPelis(); // Aquí inicializas tablaPelis
		jscroll.setViewportView(tablaPelis);
		contentPanel.add(jscroll);
		tablaPelis.getColumnModel().getColumn(4).setMinWidth(0);
		tablaPelis.getColumnModel().getColumn(4).setMaxWidth(0);
		tablaPelis.getColumnModel().getColumn(4).setWidth(0);


		// Agregar MouseListener después de la inicialización
//		tablaPelis.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (e.getClickCount() == 2) {
//					int row = tablaPelis.getSelectedRow(); // Usar tablaPelis
//					if (row != -1) {
//						// Aquí los valores están en las columnas 0, 1, 2, 3,
//						String nombre = tablaPelis.getModel().getValueAt(row, 0).toString();
//						duracion = Integer.parseInt(tablaPelis.getModel().getValueAt(row, 1).toString());
//						calificacion = Float.parseFloat(tablaPelis.getModel().getValueAt(row, 2).toString());
//						precio = Float.parseFloat(tablaPelis.getModel().getValueAt(row, 3).toString());
//
//						VentanaPelisCompradas ventanaCliente = new VentanaPelisCompradas();
//						ventanaCliente.añadirPeliculaComprada(nombre, duracion, calificacion, precio);
//
//					}
//				}
//			}
//		});
	}

	private JTable cargarTablaPelis() {
		String[] columnasNombre = { "Titulo", "Duracion", "Calificacion", "Precio","ID"};
		Map<String, Pelicula> pelisMap = Principal.listarPeliculas(clien);

		// Crear el modelo de la tabla
		DefaultTableModel model = new DefaultTableModel(null, columnasNombre);

		// Llenar el modelo con los datos de las películas
		for (Map.Entry<String, Pelicula> entry : pelisMap.entrySet()) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnComprar)) {
			comprar();
	}
  }
}
