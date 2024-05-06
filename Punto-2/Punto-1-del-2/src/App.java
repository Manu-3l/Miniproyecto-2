import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class App extends JFrame implements MouseMotionListener{

    Container contenedor;


    public App(){
        setTitle("Punto 1 del punto 2");
        contenedor = getContentPane();
        contenedor.addMouseMotionListener(this);
        FlowLayout layout = new FlowLayout();
        contenedor.setLayout(layout);        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setVisible(true);

        JOptionPane.showMessageDialog(contenedor, "Funciona solo como canvas");
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
    }


    //Función basica para realizar el dibujo
    public void drawing(Graphics a, int x, int y){
        a.drawOval(x, y, 1, 1);
    }

    //Función para detectar que el 
    public void mouseDragged(MouseEvent e) {
        int a = e.getX();
        int b = e.getY();
        drawing(getGraphics(), a + 6, b + 32);
        
    }

    //Función incluida en el MouseMotionListener, la cual detecta cuando el mouse se mueve sin hacer nada
    //Modificada para que no este tirando una excepción 24/7 en la consola.
    @Override
    public void mouseMoved(MouseEvent e) {
               
    }

    
}
