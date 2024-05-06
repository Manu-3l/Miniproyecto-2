import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class App2 extends JFrame implements MouseListener{

    //Variables abstractas y normales para el funcionamiento
    Container contenedor;
    int x1, x2, y1, y2;


    public App2(){
        setTitle("Punto 1 del punto 2");
        contenedor = getContentPane();
        FlowLayout layout = new FlowLayout();
        contenedor.setLayout(layout);
        contenedor.addMouseListener(this);
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setVisible(true);
        JOptionPane.showMessageDialog(contenedor, "Funciona solo para hacer una linea recta");
    }

    public static void main(String[] args) throws Exception {
        App2 app2 = new App2();
    }


    //Función basica para realizar el dibujo
    public void drawing(Graphics a, int x, int y, int x2, int y2){
        a.drawLine(x, y, x2, y2);
    }

    //Función no necesaria para el ejercicio, pero si necesaria para la implementación de MouseListener
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    //Función no necesaria para el ejercicio, pero si necesaria para la implementación de MouseListener
    @Override
    public void mouseEntered(MouseEvent e) {
       
    }
    //Función no necesaria para el ejercicio, pero si necesaria para la implementación de MouseListener
    @Override
    public void mouseExited(MouseEvent e) {
        
    }


    //Función para almacenar los datos del origen de la linea
    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    //Función para almacenar el final al soltar la linea
    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        drawing(getGraphics(), x1 + 6, y1 + 32, x2 + 6, y2 + 32);
    }

    
}
