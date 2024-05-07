import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Interfaz extends JFrame {

    public Interfaz(){
        setTitle("Ferretería App");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        Componentes();
    }

    private void Componentes(){
        JPanel panelBG = new JPanel();
        panelBG.setLayout(null);
        panelBG.setBackground(new java.awt.Color(255, 255, 255));

        CardLayout cardLayout = new CardLayout();

        JPanel panelPrincipal = new JPanel(cardLayout);
        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setBounds(201, 0, 998, 698);

        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(null);
        panelLateral.setBackground(new java.awt.Color(80, 40, 230));
        panelLateral.setBounds(1, 0, 198, 668);

        JPanel panelInicio = new JPanel();
        panelInicio.setLayout(null);
        panelInicio.setBackground(new java.awt.Color(220, 220, 255));
        panelInicio.setBounds(201, 0, 598, 668);

        JPanel panelInventario = new JPanel();
        panelInventario.setLayout(null);
        panelInventario.setBackground(new java.awt.Color(220, 220, 255));
        panelInventario.setBounds(201, 0, 598, 668);


        //Botones - Panel lateral
        JButton btnInicio = new JButton();
        btnInicio.setBounds(0, 160, 198, 50);
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
        btnInventario.setBounds(0, 260, 198, 50);
        btnInventario.setBackground(new java.awt.Color(80, 40, 230));
        btnInventario.setText("INVENTARIO");
        btnInventario.setFont(new Font("Times New Roman",Font.BOLD, 20));
        btnInventario.setForeground(new java.awt.Color(220, 220, 255));
        btnInventario.setBorder(null);
        btnInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Panel Inventario");
            }
        });

        JButton btnSalir = new JButton();
        btnSalir.setBounds(0, 600, 198, 50);
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


        //Etiquetas - Barra Lateral
        JLabel txtMenu = new JLabel();
        txtMenu.setText("MENU");
        txtMenu.setBounds(20, 30, 160, 50);
        txtMenu.setFont(new Font("Times New Roman",Font.BOLD,50));

        JLabel txtSeparador = new JLabel();
        txtSeparador.setText("----------------------------");
        txtSeparador.setBounds(0, 80, 198, 50);
        txtSeparador.setFont(new Font("Times New Roman",Font.BOLD,20));


        //Etiquetas - Panel Inicio
        JLabel txtBienvenido = new JLabel();
        txtBienvenido.setText("BIENVENIDO");
        txtBienvenido.setBounds(230, 80, 340, 120);
        txtBienvenido.setFont(new Font("Times New Roman",Font.BOLD,50));

        JLabel txtMensaje1 = new JLabel();
        txtMensaje1.setText("App Ferreteria");
        txtMensaje1.setBounds(320, 140, 160, 90);
        txtMensaje1.setFont(new Font("Times New Roman",Font.PLAIN,26));

        ImageIcon imagen1 = new ImageIcon("images/Logo1.png");
        JLabel labelImagen1 = new JLabel(imagen1);
        labelImagen1.setLocation(220, 180);


        //Etiquetas - Panel Inventario
        JLabel txtProductos = new JLabel();
        txtProductos.setText("PRODUCTOS");
        txtProductos.setBounds(170, 0, 160, 90);
        txtProductos.setFont(new Font("Times New Roman",Font.PLAIN,26));

        JLabel txtCampoNombre = new JLabel();
        txtCampoNombre.setText("Nombre:");
        txtCampoNombre.setBounds(470, 90, 100, 30);
        txtCampoNombre.setFont(new Font("Times New Roman",Font.PLAIN,16));

        JLabel txtCampoDesc = new JLabel();
        txtCampoDesc.setText("Descripcion:");
        txtCampoDesc.setBounds(470, 150, 100, 30);
        txtCampoDesc.setFont(new Font("Times New Roman",Font.PLAIN,16));

        JLabel txtCampoPrecio = new JLabel();
        txtCampoPrecio.setText("Precio:");
        txtCampoPrecio.setBounds(470, 210, 100, 30);
        txtCampoPrecio.setFont(new Font("Times New Roman",Font.PLAIN,16));

        JLabel txtCampoCantidad = new JLabel();
        txtCampoCantidad.setText("Cantidad:");
        txtCampoCantidad.setBounds(470, 270, 100, 30);
        txtCampoCantidad.setFont(new Font("Times New Roman",Font.PLAIN,16));


        //Campos de texto - Panel Inventario
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(570, 90, 170, 30);

        JTextField campoDesc = new JTextField();
        campoDesc.setBounds(570, 150, 170, 30);

        JTextField campoPrecio = new JTextField();
        campoPrecio.setBounds(570, 210, 170, 30);

        JTextField campoCantidad = new JTextField();
        campoCantidad.setBounds(570, 270, 170, 30);


        //Tabla para Inventario
        String columnas[] = {"Nombre", "Descripcion", "Precio", "Cantidad"};
        DefaultTableModel tb1 = new DefaultTableModel();
        tb1.setColumnIdentifiers(columnas);
        JTable tablaInventario = new JTable();
        JScrollPane contenedorTb = new JScrollPane();
        tablaInventario.setModel(tb1);
        tablaInventario.setBounds(50, 70, 400, 520);
        tablaInventario.getTableHeader().setResizingAllowed(false);
        contenedorTb.setBounds(50, 70, 400, 520);
        contenedorTb.setViewportView(tablaInventario);


        //Botones - Panel Inventario
        JButton btnAgregarProducto = new JButton();
        btnAgregarProducto.setBounds(470, 540, 80, 50);
        btnAgregarProducto.setBackground(new java.awt.Color(80, 40, 230));
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.setFont(new Font("Times New Roman",Font.BOLD, 12));
        btnAgregarProducto.setForeground(new java.awt.Color(220, 220, 255));
        btnAgregarProducto.setBorder(null);
        btnAgregarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String Nombre = String.valueOf(campoNombre.getText());
                String Descripcion = String.valueOf(campoDesc.getText());
                Double Precio = Double.valueOf(campoPrecio.getText());
                Double Cantidad = Double.valueOf(campoCantidad.getText());
                campoNombre.setText("");
                campoDesc.setText("");
                campoPrecio.setText("");
                campoCantidad.setText("");

                tb1.addRow(new Object[]{Nombre, Descripcion, Precio, Cantidad});
            }
        });

        JButton btnModificarProducto = new JButton();
        btnModificarProducto.setBounds(570, 540, 80, 50);
        btnModificarProducto.setBackground(new java.awt.Color(80, 40, 230));
        btnModificarProducto.setText("Modificar");
        btnModificarProducto.setFont(new Font("Times New Roman",Font.BOLD, 12));
        btnModificarProducto.setForeground(new java.awt.Color(220, 220, 255));
        btnModificarProducto.setBorder(null);
        btnModificarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                tb1.setValueAt(campoNombre.getText(), tablaInventario.getSelectedRow(), 0);
                tb1.setValueAt(campoDesc.getText(), tablaInventario.getSelectedRow(), 1);
                tb1.setValueAt(campoPrecio.getText(), tablaInventario.getSelectedRow(), 2);
                tb1.setValueAt(campoCantidad.getText(), tablaInventario.getSelectedRow(), 3);
            }
        });

        JButton btnEliminarProducto = new JButton();
        btnEliminarProducto.setBounds(670, 540, 80, 50);
        btnEliminarProducto.setBackground(new java.awt.Color(80, 40, 230));
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.setFont(new Font("Times New Roman",Font.BOLD, 12));
        btnEliminarProducto.setForeground(new java.awt.Color(220, 220, 255));
        btnEliminarProducto.setBorder(null);
        btnEliminarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                tb1.removeRow(tablaInventario.getSelectedRow());
            }
        });


        //Añadir componentes a la ventana
        this.getContentPane().add(panelBG);
        panelBG.add(panelPrincipal);
        panelBG.add(panelLateral);
        panelLateral.add(txtMenu);
        panelLateral.add(txtSeparador);
        panelLateral.add(btnInicio);
        panelLateral.add(btnInventario);
        panelLateral.add(btnSalir);
        panelPrincipal.add(panelInicio, "Panel Inicio");
        panelPrincipal.add(panelInventario, "Panel Inventario");
        panelInicio.add(txtBienvenido);
        panelInicio.add(txtMensaje1);
        panelInicio.add(labelImagen1);
        panelInventario.add(txtProductos);
        panelInventario.add(contenedorTb);
        panelInventario.add(txtCampoNombre);
        panelInventario.add(txtCampoDesc);
        panelInventario.add(txtCampoPrecio);
        panelInventario.add(txtCampoCantidad);
        panelInventario.add(campoNombre);
        panelInventario.add(campoDesc);
        panelInventario.add(campoPrecio);
        panelInventario.add(campoCantidad);
        panelInventario.add(btnAgregarProducto);
        panelInventario.add(btnModificarProducto);
        panelInventario.add(btnEliminarProducto);
    }

    private void btnSalirFuncion(ActionEvent e){
        this.dispose();
    }

}