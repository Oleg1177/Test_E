import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MouseWheelEventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Wheel Event Example");
        JTextArea textArea = new JTextArea();
        
        // Добавление обработчика событий прокрутки колесика мыши
        textArea.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                int rotation = e.getWheelRotation();
                
                // Вывод информации о событии
                System.out.println("Units to scroll: " + units);
                System.out.println("Wheel rotation: " + rotation);
                
                // Действия при прокрутке колесика мыши
                if (rotation < 0) {
                    // Вверх
                    textArea.append("Scroll Up\n");
                } else {
                    // Вниз
                    textArea.append("Scroll Down\n");
                }
            }
        });
        
        frame.getContentPane().add(textArea);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
