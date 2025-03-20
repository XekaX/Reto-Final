package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnAdmin;
	private JButton btnTrabajador;
	private JButton btnCliente;

	/**
	 * Launch the application.
	 *
	 * public static void main(String[] args) { try { VentanaPrincipal dialog = new
	 * VentanaPrincipal();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * /** Create the dialog.
	 */
	public VentanaPrincipal() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

	    btnAdmin = new JButton("Administrador");
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdmin.setBounds(10, 68, 136, 63);
		btnAdmin.addActionListener(this);
		contentPanel.add(btnAdmin);

	    btnTrabajador = new JButton("Trabajador");
		btnTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTrabajador.setBounds(156, 68, 136, 63);
		btnTrabajador.addActionListener(this);
		contentPanel.add(btnTrabajador);

	    btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCliente.setBounds(300, 68, 136, 63);
		btnCliente.addActionListener(this);
		contentPanel.add(btnCliente);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource().equals(btnAdmin)) {
			VentanaLog dialog = new VentanaLog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
	}
		if (evento.getSource().equals(btnTrabajador)) {
			VentanaLog dialog = new VentanaLog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);	
		}
		
		if (evento.getSource().equals(btnCliente)) {
			VentanaLog dialog = new VentanaLog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);	
		}
  }
}
