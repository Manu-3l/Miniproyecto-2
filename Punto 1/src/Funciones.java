import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Funciones {

    public static void cerrarVentana(JFrame VentanaPrincipal){
        VentanaPrincipal.dispose();
    }

    public static void agregarDatos(DefaultTableModel tb1, DefaultTableModel tb2, JTextField campoNombre, JTextField campoDesc, JTextField campoPrecio,  JTextField campoCantidad){
        try{
            String nombre = String.valueOf(campoNombre.getText());
            String descripcion = String.valueOf(campoDesc.getText());
            Double precio = Double.valueOf(campoPrecio.getText());
            Double cantidad = Double.valueOf(campoCantidad.getText());
            String material = JOptionPane.showInputDialog("Ingrese el material: ");
            String casoUso = JOptionPane.showInputDialog("Ingrese un caso en el que se usa: ");
            String herramienta = JOptionPane.showInputDialog("Ingrese la herramienta que necesita para usarse: ");
            campoNombre.setText("");
            campoDesc.setText("");
            campoPrecio.setText("");
            campoCantidad.setText("");
            Object[] Datos1 = new Object[]{nombre, descripcion, precio, cantidad};
            Object[] Datos2 = new Object[]{material, casoUso, herramienta};
            tb1.addRow(Datos1);
            tb2.addRow(Datos2);
            JOptionPane.showMessageDialog(null, "Producto agregado con exito", "Aviso",1);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error"+ e.toString());
        }
    }


    public static void modificarDatos(DefaultTableModel tb1, JTable tablaInventario, JTextField campoNombre, JTextField campoDesc, JTextField campoPrecio,  JTextField campoCantidad){
        try{
            tb1.setValueAt(campoNombre.getText(), tablaInventario.getSelectedRow(), 0);
            tb1.setValueAt(campoDesc.getText(), tablaInventario.getSelectedRow(), 1);
            tb1.setValueAt(campoPrecio.getText(), tablaInventario.getSelectedRow(), 2);
            tb1.setValueAt(campoCantidad.getText(), tablaInventario.getSelectedRow(), 3);
            JOptionPane.showMessageDialog(null, "Producto modificado con exito", "Aviso",1);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error"+ e.toString());
        }
    }


    public static void seleccionarDatos(JTable tablaInventario1, JTextField campoNombre, JTextField campoDesc, JTextField campoPrecio,  JTextField campoCantidad){
        try{

            int row = tablaInventario1.getSelectedRow();

                Object nombre = tablaInventario1.getValueAt(row, 0);
                Object desc = tablaInventario1.getValueAt(row, 1);
                Object precio = tablaInventario1.getValueAt(row, 2);
                Object cantidad = tablaInventario1.getValueAt(row, 3);

                campoNombre.setText(nombre.toString());
                campoDesc.setText(desc.toString());
                campoPrecio.setText(precio.toString());
                campoCantidad.setText(cantidad.toString());

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error"+ e.toString());
        }
    }


    public static void eliminarDatos(DefaultTableModel tb1, DefaultTableModel tb2, JTable tablaInventario1, JTable tablaInventario2, JTextField campoNombre, JTextField campoDesc, JTextField campoCantidad, JTextField campoPrecio){
        try{

            int row = tablaInventario1.getSelectedRow();

            tb1.removeRow(row);
            tb2.removeRow(row);

            campoNombre.setText("");
            campoDesc.setText("");
            campoPrecio.setText("");
            campoCantidad.setText("");

            JOptionPane.showMessageDialog(null, "Producto eliminado con exito", "Aviso",1);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error"+ e.toString());
        }
    }


    public static void mostrarDatos(DefaultTableModel tb1,DefaultTableModel tb2, JTable tablaInventario1){
    try{    
        int row = tablaInventario1.getSelectedRow();

            Object nombre = tb1.getValueAt(row, 0);
            Object desc = tb1.getValueAt(row, 1);
            Object precio = tb1.getValueAt(row, 2);
            Object cantidad = tb1.getValueAt(row, 3);
            Object material = tb2.getValueAt(row, 0);
            Object casoUso = tb2.getValueAt(row, 1);
            Object herramienta = tb2.getValueAt(row, 2);

        String nombreProducto = "Nombre del producto: " + nombre;
        String descProducto = "Descripción: " + desc;
        String precioProducto = "Precio: " + precio;
        String cantidadProducto = "Cantidad en Stock: " + cantidad;
        String materialProducto = "Material: " + material;
        String casoUsoProducto = "Casos en los que se usa: " + casoUso;
        String herramientaProducto = "Herramienta que necesita: " + herramienta;
        String producto = "PRODUCTO #" + (row + 1);

        JFrame ventanaDatos = new JFrame();
        ventanaDatos.setTitle("Datos del producto");
        ventanaDatos.setSize(400, 400);
        ventanaDatos.setLocationRelativeTo(null);
        ventanaDatos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaDatos.setVisible(true);
        ventanaDatos.setResizable(false);

        JPanel panelDatos = new JPanel();
        panelDatos.setBounds(0, 0, 400, 400);
        panelDatos.setLayout(null);

        JLabel txtProducto = new JLabel();
        txtProducto.setText(producto);
        txtProducto.setBounds(140,0,200,70);
        txtProducto.setFont(new Font("Times New Roman",Font.BOLD,18));

        JLabel txtNombre = new JLabel();
        txtNombre.setText(nombreProducto);
        txtNombre.setBounds(20,30,300,70);

        JLabel txtDesc = new JLabel();
        txtDesc.setText(descProducto);
        txtDesc.setBounds(20,60,300,70);

        JLabel txtPrecio = new JLabel();
        txtPrecio.setText(precioProducto);
        txtPrecio.setBounds(20,90,300,70);

        JLabel txtCantidad = new JLabel();
        txtCantidad.setText(cantidadProducto);
        txtCantidad.setBounds(20,120,300,70);
        
        JLabel txtMaterial = new JLabel();
        txtMaterial.setText(materialProducto);
        txtMaterial.setBounds(20,150,300,70);

        JLabel txtEjemplosUso = new JLabel();
        txtEjemplosUso.setText(casoUsoProducto);
        txtEjemplosUso.setBounds(20,180,300,70);

        JLabel txtHerramienta = new JLabel();
        txtHerramienta.setText(herramientaProducto);
        txtHerramienta.setBounds(20,210,300,70);


        ventanaDatos.getContentPane().add(panelDatos);
        panelDatos.add(txtProducto);
        panelDatos.add(txtNombre);
        panelDatos.add(txtDesc);
        panelDatos.add(txtPrecio);
        panelDatos.add(txtCantidad);
        panelDatos.add(txtMaterial);
        panelDatos.add(txtEjemplosUso);
        panelDatos.add(txtHerramienta);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error"+ e.toString());
        }
    }


}

