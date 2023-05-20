import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class KeyEventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("KeyEvent Example");
        
        JTextArea textArea = new JTextArea();
        textArea.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                char keyChar = e.getKeyChar();
                
                System.out.println("Key pressed - KeyCode: " + keyCode + ", KeyChar: " + keyChar);
            }
            
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                char keyChar = e.getKeyChar();
                
                System.out.println("Key released - KeyCode: " + keyCode + ", KeyChar: " + keyChar);
            }
            
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                
                System.out.println("Key typed - KeyChar: " + keyChar);
            }
        });
        
        frame.add(textArea);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
