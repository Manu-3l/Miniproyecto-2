import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.NumberFormatException;

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

        }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "En los campos de precio y cantidad, solo es valido agregar numeros. Tampoco se pueden dejar vacios dichos campos", "Error ", 0);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error"+ e.toString());
        }
    }


    public static void modificarDatos(DefaultTableModel tb1, JTable tablaInventario, JTextField campoNombre, JTextField campoDesc, JTextField campoPrecio,  JTextField campoCantidad){
        try{
            String nombre = String.valueOf(campoNombre.getText());
            String descripcion = String.valueOf(campoDesc.getText());
            Double precio = Double.valueOf(campoPrecio.getText());
            Double cantidad = Double.valueOf(campoCantidad.getText());

            tb1.setValueAt(nombre, tablaInventario.getSelectedRow(), 0);
            tb1.setValueAt(descripcion, tablaInventario.getSelectedRow(), 1);
            tb1.setValueAt(precio, tablaInventario.getSelectedRow(), 2);
            tb1.setValueAt(cantidad, tablaInventario.getSelectedRow(), 3);

            campoNombre.setText("");
            campoDesc.setText("");
            campoPrecio.setText("");
            campoCantidad.setText("");
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


    public static void MostrarEstadisticas(DefaultTableModel tb1, DefaultTableModel tb2, JTable tablaInventario1, JTable tablaInventario2){
        try{
        int row = tablaInventario1.getRowCount();

        //Para calcular el precio de todos los productos
        double total = 0;
        for(int indice = 0; indice < row; indice ++){
            Object precio = tablaInventario1.getValueAt(indice, 2);
            Object cantidad = tablaInventario1.getValueAt(indice, 3);

            double precioProducto = (double) precio;
            double cantidadProducto = (double) cantidad;
            double calculo = (precioProducto * cantidadProducto);
            total = total + calculo;
        }

        //Para calcular los 2 productos con mas y los 2 con menos stock
        Object[][] datosStock = new Object[row][2];
            for (int indice = 0; indice < row; indice++) {
                datosStock[indice][0] = tablaInventario1.getValueAt(indice, 0);
                datosStock[indice][1] = tablaInventario1.getValueAt(indice, 3);
            }

            for (int i = 0; i < row - 1; i++) {
                for (int j = 0; j < row - i - 1; j++) {
                    if ((double) datosStock[j][1] < (double) datosStock[j + 1][1]) {
                        Object[] temp = datosStock[j];
                        datosStock[j] = datosStock[j + 1];
                        datosStock[j + 1] = temp;
                    }
                }
            }


        //Para calcular la herramienta más usada
        Object[] herramienta = new Object[row];
        int maxFrecuencia = 0;
        Object datoMasRepetido = null;
        for(int indice = 0; indice < row; indice++){
            herramienta[indice] = tablaInventario2.getValueAt(indice, 2);
        }
        for(int i = 0; i < row; i++){
            Object datoActual = herramienta[i];
            int frecuencia = 0;
            for (int j = 0; j < row; j++) {
                if (herramienta[j].equals(datoActual)) {
                    frecuencia++;
                }
            }
            if(frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                datoMasRepetido = datoActual;
            }
        }
        String mensajePrecio = "El precio total de los productos es: " + total + "\n";
        String mensajeMasStock = "Productos con más stock:\n";
        String mensajeMenosStock = "Productos con menos stock:\n";
        for (int i = 0; i < Math.min(2, row); i++) {
            mensajeMasStock += datosStock[i][0] + ": " + datosStock[i][1] + "\n";
            mensajeMenosStock += datosStock[row - 1 - i][0] + ": " + datosStock[row - 1 - i][1] + "\n";
            }
        String mensajeHerramienta = "Herramienta más usada: " + datoMasRepetido + "  \n";
        String mensajeFinal = mensajePrecio + "\n" + mensajeMasStock + "\n" + mensajeMenosStock + "\n" + mensajeHerramienta + " " + "\n";
        JOptionPane.showMessageDialog(null, mensajeFinal , "Estadisticas", 1);

    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error"+ e.toString());
    }
}
}

