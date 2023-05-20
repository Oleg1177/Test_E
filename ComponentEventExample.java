import java.awt.*;
import java.awt.event.*;

public class ComponentEventExample {
    public static void main(String[] args) {
        Frame frame = new Frame("Component Event Example");
        frame.setSize(300, 200);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                System.out.println("Component resized");
            }

            public void componentMoved(ComponentEvent e) {
                System.out.println("Component moved");
            }
        });

        frame.setVisible(true);
    }
}
