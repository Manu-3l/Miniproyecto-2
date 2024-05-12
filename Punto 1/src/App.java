import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

@SuppressWarnings("unused")
public class App {
    public static void main(String[] args) throws Exception {

        // Este fragmento de codigo es el que se usa para la implementación de los Look And Feel.
        // Por motivos de diseño, preferimos no añadirlo a este punto
        /*try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (Exception e){
            e.printStackTrace();
        }
        */
        
        Interfaz ferreteriaGUI = new Interfaz();
    }
}
