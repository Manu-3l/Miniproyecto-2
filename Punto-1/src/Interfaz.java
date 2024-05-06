import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Interfaz extends JFrame {

    CardLayout cardLayout = new CardLayout();

    public Interfaz(){
        setTitle("Ferretería App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        Componentes();
    }

    private void Componentes(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new java.awt.Color(255, 255, 255));
        this.getContentPane().add(panel1);

        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(null);
        panelLateral.setBackground(new java.awt.Color(80, 40, 230));
        panelLateral.setBounds(0, 0, 200, 598);

        JPanel panelPrincipal = new JPanel(cardLayout);
        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setBounds(201, 0, 598, 598);

        JPanel panelInicio = new JPanel();
        panelInicio.setLayout(null);
        panelInicio.setBackground(new java.awt.Color(220, 220, 255));
        panelInicio.setBounds(201, 0, 598, 598);

        JPanel panelInventario = new JPanel();
        panelInventario.setLayout(null);
        panelInventario.setBackground(new java.awt.Color(220, 220, 255));
        panelInventario.setBounds(201, 0, 598, 598);

        JButton btnInicio = new JButton();
        btnInicio.setBounds(0, 10, 200, 50);
        btnInicio.setBackground(new java.awt.Color(80, 40, 230));
        btnInicio.setText("INICIO");
        btnInicio.setFont(new Font("Times New Roman",Font.BOLD, 20));
        btnInicio.setForeground(new java.awt.Color(220, 220, 255));
        btnInicio.setBorder(null);
        btnInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Panel Inicio");
            }
        });

        JButton btnInventario = new JButton();
        btnInventario.setBounds(0, 225, 200, 50);
        btnInventario.setBackground(new java.awt.Color(80, 40, 230));
        btnInventario.setText("INVENTARIO");
        btnInventario.setFont(new Font("Times New Roman",Font.BOLD, 20));
        btnInventario.setForeground(new java.awt.Color(220, 220, 255));
        btnInventario.setBorder(null);
        btnInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Panel Inventario"); // Mostrar el panel 1
            }
        });

        JButton btnSalir = new JButton();
        btnSalir.setBounds(0, 500, 200, 50);
        btnSalir.setBackground(new java.awt.Color(255, 50, 50));
        btnSalir.setText("SALIR");
        btnSalir.setFont(new Font("Times New Roman",Font.BOLD, 20));
        btnSalir.setForeground(new java.awt.Color(220, 220, 255));
        btnSalir.setBorder(null);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSalirFuncion(e);
            }
        });

        JLabel txtBienvenido = new JLabel();
        txtBienvenido.setText("BIENVENIDO");
        txtBienvenido.setBounds(140, 80, 340, 120);
        txtBienvenido.setFont(new Font("Times New Roman",Font.BOLD,50));

        JLabel txtMensaje1 = new JLabel();
        txtMensaje1.setText("App Ferreteria");
        txtMensaje1.setBounds(220, 140, 160, 90);
        txtMensaje1.setFont(new Font("Times New Roman",Font.PLAIN,26));

        JLabel txtMensaje2 = new JLabel();
        txtMensaje2.setText("PRODUCTOS");
        txtMensaje2.setBounds(220, 30, 160, 90);
        txtMensaje2.setFont(new Font("Times New Roman",Font.PLAIN,26));

        JButton btnAgregarProducto = new JButton();
        btnAgregarProducto.setBounds(160, 450, 80, 50);
        btnAgregarProducto.setBackground(new java.awt.Color(80, 40, 230));
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.setFont(new Font("Times New Roman",Font.BOLD, 12));
        btnAgregarProducto.setForeground(new java.awt.Color(220, 220, 255));
        btnAgregarProducto.setBorder(null);

        JButton btnModificarProducto = new JButton();
        btnModificarProducto.setBounds(260, 450, 80, 50);
        btnModificarProducto.setBackground(new java.awt.Color(80, 40, 230));
        btnModificarProducto.setText("Modificar");
        btnModificarProducto.setFont(new Font("Times New Roman",Font.BOLD, 12));
        btnModificarProducto.setForeground(new java.awt.Color(220, 220, 255));
        btnModificarProducto.setBorder(null);

        JButton btnEliminarProducto = new JButton();
        btnEliminarProducto.setBounds(360, 450, 80, 50);
        btnEliminarProducto.setBackground(new java.awt.Color(80, 40, 230));
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.setFont(new Font("Times New Roman",Font.BOLD, 12));
        btnEliminarProducto.setForeground(new java.awt.Color(220, 220, 255));
        btnEliminarProducto.setBorder(null);

        JTable tablaInventario = new JTable();
        tablaInventario.setBounds(100, 100, 400, 300);

        panel1.add(panelPrincipal);
        panel1.add(panelLateral);
        panelPrincipal.add(panelInicio, "Panel Inicio");
        panelPrincipal.add(panelInventario, "Panel Inventario");
        panelLateral.add(btnInicio);
        panelLateral.add(btnInventario);
        panelLateral.add(btnSalir);
        panelInicio.add(txtBienvenido);
        panelInicio.add(txtMensaje1);
        panelInventario.add(txtMensaje2);
        panelInventario.add(tablaInventario);
        panelInventario.add(btnAgregarProducto);
        panelInventario.add(btnModificarProducto);
        panelInventario.add(btnEliminarProducto);
    }

    private void btnSalirFuncion(ActionEvent e){
        this.dispose();
    }

}