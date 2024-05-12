import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {
    
    // Panel lateral izquierdo
    private JPanel leftPanel;
    
    // Panel principal
    private JTextArea mainTextArea;
    
    // Panel de la terminal
    private JTextArea terminalTextArea;
    
    public App() {
        setTitle("Visual Studio Code");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(30, 30, 30)); // Tema oscuro
        setContentPane(mainPanel);
        
        // Barra de menú
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(40, 40, 40)); 
        
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0)); // Cerrar el programa al presionar "Exit"
        fileMenu.setForeground(Color.WHITE);
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        
        // Agregar ActionListener al elemento "New" del menú para iniciar una nueva instancia de la aplicación
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Iniciar una nueva instancia de la aplicación
                new App().setVisible(true);
            }
        });
        
        // Panel lateral izquierdo con botones
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new Dimension(150, getHeight()));
        leftPanel.setBackground(new Color(40, 40, 40)); // Tema oscuro
        JButton button1 = new JButton("Explorer");
        JButton button2 = new JButton("Search");
        JButton button3 = new JButton("Source Control");
        leftPanel.add(button1);
        leftPanel.add(button2);
        leftPanel.add(button3);
        mainPanel.add(leftPanel, BorderLayout.WEST);

        // Panel principal
        mainTextArea = new JTextArea();
        mainTextArea.setBackground(new Color(20, 20, 20)); 
        mainTextArea.setForeground(Color.WHITE); 
        mainTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12)); 
        JScrollPane mainScrollPane = new JScrollPane(mainTextArea);
        mainPanel.add(mainScrollPane, BorderLayout.CENTER);
        
        // Panel de la terminal
        JPanel terminalPanel = new JPanel(new BorderLayout());
        terminalPanel.setBackground(new Color(120, 120, 120)); 
        terminalPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Terminal"));
        terminalTextArea = new JTextArea();
        terminalTextArea.setBackground(new Color(30, 30, 30)); 
        terminalTextArea.setForeground(Color.WHITE);
        terminalTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane terminalScrollPane = new JScrollPane(terminalTextArea);
        terminalPanel.add(terminalScrollPane, BorderLayout.CENTER);
        mainPanel.add(terminalPanel, BorderLayout.SOUTH);
        
        // Ajustar el tamaño del área de texto de la terminal
        terminalTextArea.setPreferredSize(new Dimension(terminalTextArea.getWidth(), 150));
        
        //Cambiar el foco de vuelta al panel principal
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPanel.requestFocusInWindow();
            }
        });
        
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App());
    }
}
