package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.net.URL;  // Asegúrate de importar esto

import controlador.Principal;
import excepciones.LoginException;
import modelo.*;

public class VentanaLog extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField textUsuario;
    private JButton btnRegistrar;
    private JButton btnComprobar; 
    private JButton btnCancelar;
    private JPasswordField textContraseña;

    public VentanaLog() {
        setTitle("Tartanga Prime Video - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 450);

        // Desactivar el redimensionamiento de la ventana
        setResizable(false);

        // Fondo con un JPanel personalizado
        BackgroundPanel backgroundPanel = new BackgroundPanel("/imagenes/fondo_tartanga.png");

        // Panel transparente para los componentes
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false); // Transparente
        contentPanel.setBounds(170, 54, 450, 300);
        contentPanel.setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblUsuario.setForeground(Color.BLACK);
        lblUsuario.setBounds(96, 36, 76, 23);
        contentPanel.add(lblUsuario);

        JLabel lblContrasena = new JLabel("Contraseña");
        lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblContrasena.setForeground(Color.BLACK);
        lblContrasena.setBounds(83, 69, 100, 23);
        contentPanel.add(lblContrasena);

        textUsuario = new JTextField();
        textUsuario.setBounds(164, 40, 115, 23);
        contentPanel.add(textUsuario);

        textContraseña = new JPasswordField();
        textContraseña.setBounds(164, 73, 115, 19);
        contentPanel.add(textContraseña);

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
        btnCancelar.addActionListener(this);
        contentPanel.add(btnCancelar);

        // Agregar el panel transparente al fondo
        backgroundPanel.setLayout(null);
        backgroundPanel.add(contentPanel);

        // Configurar el JFrame
        setContentPane(backgroundPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource().equals(btnCancelar)) {
            cancelar();
        } else if (evento.getSource().equals(btnComprobar)) {
            comprobar();
        } else if (evento.getSource().equals(btnRegistrar)) {
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
        usuario.setContrasenia(new String(textContraseña.getPassword()));

        try {
            Usuario usu = Principal.login(usuario);
            if (usu instanceof Trabajador) {
                if (((Trabajador) usu).getTipo().equals(Tipo.ADMIN)) {
                    new VentanaAdmin().setVisible(true);
                } else {
                    new VentanaTrabajador(usuario).setVisible(true);
                }
            } else if (usu instanceof Cliente) {
                new VentanaCliente(usu).setVisible(true);
            }
        } catch (LoginException e) {
            e.visualizarMensaje();
        }
    }

    private void cancelar() {
        dispose();
    }

    // Clase personalizada para dibujar la imagen de fondo
    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            try {
                URL url = getClass().getResource(imagePath);
                if (url == null) {
                    System.out.println("El archivo no se encuentra.");
                } else {
                    backgroundImage = new ImageIcon(url).getImage();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al cargar la imagen: " + e.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                // Dibujar la imagen escalada al tamaño del panel
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        }
    }
}