import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;


public class App extends JFrame implements MouseListener{


    //Declaraciones
    Container contenedor;
    static ArrayList<RainLine> lineas = new ArrayList<RainLine>();
    Random rand = new Random();
    JPanel application = new JPanel();
    int count = 0;

    //Inicio de la interfaz
    public App(){
        setTitle("Punto 2 del punto 2");
        contenedor = getContentPane();
        FlowLayout layout = new FlowLayout();
        contenedor.setLayout(layout);
        contenedor.addMouseListener(this);
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
    }

    //función para empezar a pintar las lineas
    public void paint(Graphics g, int x1, int y1, int x2, int y2){
        //Creación de los color con valores aleatorios
        Color color1 = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
        g.setColor(color1);
        g.drawLine(x1, y1, x2, y2);
    }      


    //Metodo al clickear en el Frame, al presionar dos veces en el Frame se llama a la función Paint
    public void mouseClicked(MouseEvent e) {
        int x1, y1, x2, y2;
        RainLine a = new RainLine();
        a.setX(e.getX());
        a.setY(e.getY());
        lineas.add(a);
        int b = count - 1;
        if(count>0 && count%2 != 0){
            x1 = lineas.get(count).getX();
            y1 = lineas.get(count).getY();
            x2 = lineas.get(b).getX();
            y2 = lineas.get(b).getY();
            paint(getGraphics(),x1 + 6, y1 + 32, x2 + 6, y2 + 32);
        }
        count++;


    }
    //Función no necesaria para el ejercicio, pero si necesaria para la implementación de MouseListener
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    //Función no necesaria para el ejercicio, pero si necesaria para la implementación de MouseListener
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    //Función no necesaria para el ejercicio, pero si necesaria para la implementación de MouseListener
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    //Función no necesaria para el ejercicio, pero si necesaria para la implementación de MouseListener
    @Override
    public void mouseReleased(MouseEvent e) {
       
    } 

   }
