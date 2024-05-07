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



public class App extends JFrame implements MouseListener{

    //Declaraciones
    Container contenedor;
    static ArrayList<Coordinates> lineas = new ArrayList<Coordinates>();
    JPanel application = new JPanel();
    int count = 0;

    // creación de la interfaz
    public App(){
        setTitle("Punto 3 del punto 2");
        contenedor = getContentPane();
        FlowLayout layout = new FlowLayout();
        contenedor.setLayout(layout);
        contenedor.addMouseListener(this);
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,300);
        setVisible(true);
        JOptionPane.showMessageDialog(contenedor, "Luego de clickear un minimo de 3 veces, retire el mouse de la pantalla para que se cree el poligono");
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
    }

    //Función para la creación del poligono, va creando lineas hasta que en el ultimo valor mediante el for.
    //Cuando se ha llegado al ultimo valor se crea una ultima linea que conecta con el primer punto y el ultimo. 
    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for(int i = 0; i < lineas.size(); i++){
            if(i > 0 && i < lineas.size()){
                a = lineas.get(i).getX() + 6;
                b = lineas.get(i).getY() + 32;
                c = lineas.get(i - 1).getX() + 6;
                d = lineas.get(i - 1).getY() + 32;
                g.drawLine(a, b, c, d);
            }if(i == lineas.size() - 1){
                a = lineas.get(0).getX() + 6;
                b = lineas.get(0).getY() + 32;
                c = lineas.get(i).getX() + 6;
                d = lineas.get(i).getY() + 32;
                g.drawLine(a, b, c, d);
            }
                
        }
        g.setColor(Color.BLUE);
       

    }      


    //Función para almacenar el valor de X y Y en un Arraylist que nos permite crear el poligono.
    public void mouseClicked(MouseEvent e) {
        Coordinates a = new Coordinates();
        a.setX(e.getX());
        a.setY(e.getY());
        lineas.add(a);
        count++;

    }
    //Función no necesaria para el ejercicio, pero si necesaria para la implementación de MouseListener
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    //Función para llamar a la función necesaria para crear el poligono.
    public void mouseExited(MouseEvent e) {
        if(count >= 3){
            paint(getGraphics());
        }       
        
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
